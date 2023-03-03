package br.com.events.location.application.controller.v1;

import br.com.events.location.data.inbound.City;
import br.com.events.location.data.inbound.Country;
import br.com.events.location.data.inbound.State;
import br.com.events.location.infrastructure.controller.v1.LocationController;
import br.com.events.location.infrastructure.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class implements every needed endpoint that is related to locations
 *
 * @author Gabriel Guimarães de Almeida
 */
@RestController
@RequestMapping("/v1/location")
@RequiredArgsConstructor
public class LocationControllerImpl implements LocationController {

    private final LocationService locationService;

    @Override
    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getAllCountries() {
        return ResponseEntity.ok(locationService.getAllCountries());
    }

    @Override
    @GetMapping("/country/{countryIso}/states")
    public ResponseEntity<List<State>> getAllStatesByCountryIso2(
            @PathVariable("countryIso") String countryIso
    ) {
        return ResponseEntity.ok(locationService.getAllStatesByCountryIso2(countryIso));
    }

    @Override
    @GetMapping("/country/{countryIso}/state/{stateIso}/cities")
    public ResponseEntity<List<City>> getAllCitiesByStateAndCountryIso2(
            @PathVariable("countryIso") String countryIso,
            @PathVariable("stateIso") String stateIso
    ) {
        return ResponseEntity.ok(locationService.getAllCitiesByStateIso2(countryIso, stateIso));
    }
}
