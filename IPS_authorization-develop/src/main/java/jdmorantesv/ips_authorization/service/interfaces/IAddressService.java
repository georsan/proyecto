package jdmorantesv.ips_authorization.service.interfaces;

import jdmorantesv.ips_authorization.model.Address;
import jdmorantesv.ips_authorization.request.AddressRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddressService {
    public List<Address> getAllAddress();

    public Address getAddressById(Integer id);

    public Address addAddress(AddressRequest addressRequest);

    public Address updateAddress(AddressRequest addressRequest, Integer addressId);

    public Boolean deleteAddress(Integer id);
}
