package jdmorantesv.ips_authorization.service.interfaces;

import jdmorantesv.ips_authorization.model.City;
import jdmorantesv.ips_authorization.model.City;
import jdmorantesv.ips_authorization.request.CityRequest;
import jdmorantesv.ips_authorization.request.CityRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICityService {
    public List<City> getAllCitys();

    public City getCityById(Integer id);

    public City addCity(CityRequest cityRequest);

    public City updateCity(CityRequest cityRequest, Integer id);

    public Boolean deleteCity(Integer id);
}
