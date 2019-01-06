package com.example.demo.resource;

import com.example.demo.domain.City;
import com.example.demo.domain.State;
import com.example.demo.dto.CityDTO;
import com.example.demo.dto.StateDTO;
import com.example.demo.service.CityService;
import com.example.demo.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by loliveira on 02/12/18.
 */
@RestController
@RequestMapping("/state")
public class StateResource {

    @Autowired
    private StateService stateService;

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<StateDTO>> findAll() {
        List<State> list = stateService.findAll();
        return ResponseEntity.ok().body(list.stream().map(l -> new StateDTO(l)).collect(Collectors.toList()));
    }

    @GetMapping("/{state_id}/cities")
    public ResponseEntity<List<CityDTO>> findCities(@PathVariable Integer state_id) {
        List<City> list = cityService.findCities(state_id);
        return ResponseEntity.ok().body(list.stream().map(l -> new CityDTO(l)).collect(Collectors.toList()));
    }
}
