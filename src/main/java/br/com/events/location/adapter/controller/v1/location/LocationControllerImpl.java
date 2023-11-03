package br.com.events.location.adapter.controller.v1.location;

import br.com.events.location.adapter.controller.v1.location.doc.LocationController;
import br.com.events.location.business.service.location.LocationService;
import br.com.events.location.domain.io.address.Address;
import br.com.events.location.domain.io.location.CityResponse;
import br.com.events.location.domain.io.location.CountryResponse;
import br.com.events.location.domain.io.location.StateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public ResponseEntity<List<CountryResponse>> getAllCountries() {
        return ResponseEntity.ok(locationService.getAllCountries());
    }

    @Override
    @GetMapping("/country/{countryIso}/states")
    public ResponseEntity<List<StateResponse>> getAllStatesByCountryIso2(
            @PathVariable("countryIso") String countryIso
    ) {
        return ResponseEntity.ok(locationService.getAllStatesByCountryIso2(countryIso));
    }

    @Override
    @GetMapping("/country/{countryIso}/state/{stateIso}/cities")
    public ResponseEntity<List<CityResponse>> getAllCitiesByStateAndCountryIso2(
            @PathVariable("countryIso") String countryIso,
            @PathVariable("stateIso") String stateIso
    ) {
        return ResponseEntity.ok(locationService.getAllCitiesByStateIso2(countryIso, stateIso));
    }

    @Override
    @GetMapping("/country/{countryIso}/state/{stateIso}/city/{cityId}")
    public ResponseEntity<CityResponse> getCityByIdAndStateAndCountryIso(
            @PathVariable("countryIso") String countryIso,
            @PathVariable("stateIso") String stateIso,
            @PathVariable("cityId") Long cityId
    ) {
        return ResponseEntity.ok(locationService.getCityByIdAndStateAndCountryIso(countryIso, stateIso, cityId));
    }

    @Override
    @GetMapping("/check-address")
    public ResponseEntity<Void> validateIfAddressExists(@Valid Address address) {
        locationService.validateIfAddressExists(address);
        return ResponseEntity.noContent().build();
    }
}
