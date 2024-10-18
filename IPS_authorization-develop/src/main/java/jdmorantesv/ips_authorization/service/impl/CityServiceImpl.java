package jdmorantesv.ips_authorization.service.impl;

import jdmorantesv.ips_authorization.exception.ResourceNotFoundException;
import jdmorantesv.ips_authorization.model.City;
import jdmorantesv.ips_authorization.model.Department;
import jdmorantesv.ips_authorization.repository.ICityRepository;
import jdmorantesv.ips_authorization.request.CityRequest;
import jdmorantesv.ips_authorization.service.interfaces.ICityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements ICityService {
    @Autowired
    private final ICityRepository cityRepository;


    @Override
    public List<City> getAllCitys() {return cityRepository.findAll();}

    @Override
    public City getCityById(Integer id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isPresent()) {
            return city.get();
        }else{
            throw new ResourceNotFoundException("City with id " + id + " not found");
        }
    }

    @Override
    public City addCity(CityRequest cityRequest) {
        City city = new City();
        city.setName(cityRequest.getName());
        city.setIdDepartment(cityRequest.getIdDepartment());
        cityRepository.save(city);
        return city;
    }

    @Override
    public City updateCity(CityRequest cityRequest, Integer cityId) {
        // Buscar el departamento por ID
        Optional<City> optionalCity = cityRepository.findById(cityId);
        if (optionalCity.isPresent()) {
            City city = optionalCity.get();
            // Actualizar los campos necesarios
            city.setName(cityRequest.getName());
            city.setIdDepartment(cityRequest.getIdDepartment());
            // Guardar los cambios
            cityRepository.save(city);
            return city;
        } else {
            // Manejar el caso donde el departamento no existe
            throw new ResourceNotFoundException("City not found with id: " + cityId);
        }
    }

    @Override
    public Boolean deleteCity(Integer id) {
        Optional<City> optionalCity = cityRepository.findById(id);
        if (optionalCity.isPresent()) {
            cityRepository.delete(optionalCity.get());
            return true;
        }else {
            throw new ResourceNotFoundException("City not found with id: " + id);
        }
    }
}
