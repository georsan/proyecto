package jdmorantesv.ips_authorization.contoller;

import jdmorantesv.ips_authorization.model.City;
import jdmorantesv.ips_authorization.model.Department;
import jdmorantesv.ips_authorization.request.CityRequest;
import jdmorantesv.ips_authorization.request.DepartmentRequest;
import jdmorantesv.ips_authorization.service.impl.CityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {
    private final CityServiceImpl cityService;

    @GetMapping("{id}")
    public ResponseEntity<City> getCity(@PathVariable Integer id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @GetMapping()
    public ResponseEntity<List<City>> getAllCitys() {
        return ResponseEntity.ok(cityService.getAllCitys());
    }

    @PostMapping("create")
    public ResponseEntity<City> createCity(@RequestBody CityRequest cityRequest) {
        return ResponseEntity.ok(cityService.addCity(cityRequest));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<City> editCity(@PathVariable Integer id, @RequestBody CityRequest cityRequest) {
        return ResponseEntity.ok(cityService.updateCity(cityRequest, id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteCity(@PathVariable Integer id) {
        return ResponseEntity.ok(cityService.deleteCity(id));
    }
}
