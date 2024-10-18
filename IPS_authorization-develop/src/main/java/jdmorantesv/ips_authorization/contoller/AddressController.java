package jdmorantesv.ips_authorization.contoller;

import jdmorantesv.ips_authorization.model.Address;
import jdmorantesv.ips_authorization.request.AddressRequest;
import jdmorantesv.ips_authorization.service.impl.AddressServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressServiceImpl addressService;

    @GetMapping("{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Address>> getAllAddress() {
        return ResponseEntity.ok(addressService.getAllAddress());
    }

    @PostMapping("create")
    public ResponseEntity<Address> createAddress(@RequestBody AddressRequest addressRequest) {
        return ResponseEntity.ok(addressService.addAddress(addressRequest));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Address> editAddress(@PathVariable Integer id, @RequestBody AddressRequest addressRequest) {
        return ResponseEntity.ok(addressService.updateAddress(addressRequest, id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.deleteAddress(id));
    }
}
