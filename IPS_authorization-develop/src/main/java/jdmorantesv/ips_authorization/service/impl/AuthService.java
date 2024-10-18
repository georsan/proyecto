package jdmorantesv.ips_authorization.service.impl;

import jdmorantesv.ips_authorization.model.Role;
import jdmorantesv.ips_authorization.model.User;
import jdmorantesv.ips_authorization.repository.IUserRepository;
import jdmorantesv.ips_authorization.request.AuthResponse;
import jdmorantesv.ips_authorization.request.LoginRequest;
import jdmorantesv.ips_authorization.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IUserRepository userRepository;
    private final JwtService jwrService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(request.getUsername()));

        String token = jwtService.getToken(user);
        String tokenHash = jwtService.hashToken(token);

        user.setTokenHash(tokenHash);
        userRepository.save(user);  // Actualiza el usuario con el hash del token

        return AuthResponse.builder()
                .token(token)
                .build();
    }
    public AuthResponse register(RegisterRequest request)
    {
        System.out.println(request);
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .age(request.getAge())
                .created_at(new Date())
                .id_address(Long.valueOf(request.getId_address()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwrService.getToken(user))
                .build();
    }
}

