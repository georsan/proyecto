package jdmorantesv.ips_authorization.service.impl;

import jdmorantesv.ips_authorization.exception.ResourceNotFoundException;
import jdmorantesv.ips_authorization.model.Address;
import jdmorantesv.ips_authorization.model.City;
import jdmorantesv.ips_authorization.repository.IAddressRepository;
import jdmorantesv.ips_authorization.request.AddressRequest;
import jdmorantesv.ips_authorization.service.interfaces.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private final IAddressRepository addressRepository;
    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Integer id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            return address.get();
        }else{
            throw new ResourceNotFoundException("Address with id " + id + " not found");
        }
    }

    @Override
    public Address addAddress(AddressRequest addressRequest) {
        Address address = new Address();
        address.setAddress(addressRequest.getAddress());
        address.setIdCity(addressRequest.getIdCity());
        addressRepository.save(address);
        return address;
    }

    @Override
    public Address updateAddress(AddressRequest addressRequest, Integer addressId) {
        // Buscar el departamento por ID
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            // Actualizar los campos necesarios
            address.setAddress(addressRequest.getAddress());
            address.setIdCity(addressRequest.getIdCity());
            // Guardar los cambios
            addressRepository.save(address);
            return address;
        } else {
            // Manejar el caso donde el departamento no existe
            throw new ResourceNotFoundException("City not found with id: " + addressId);
        }
    }

    @Override
    public Boolean deleteAddress(Integer id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            addressRepository.delete(optionalAddress.get());
            return true;
        }else {
            throw new ResourceNotFoundException("City not found with id: " + id);
        }
    }
}
