package br.com.events.location.infrastructure.controller.v1;

import br.com.events.location.data.inbound.Address;
import br.com.events.location.data.inbound.City;
import br.com.events.location.data.inbound.Country;
import br.com.events.location.data.inbound.State;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * This interface dictates which endpoints will be needed for implementation and holds which one's Swagger
 * documentation
 *
 * @author Gabriel Guimarães de Almeida
 */
@Api(tags = "Location Controller")
public interface LocationController {

    @ApiOperation(value = "Get all countries available")
    ResponseEntity<List<Country>> getAllCountries();

    @ApiOperation(value = "Get all states of a country by its iso2")
    ResponseEntity<List<State>> getAllStatesByCountryIso2(String countryIso);

    @ApiOperation(value = "Get all cities of a state by its iso2 and it's country iso2")
    ResponseEntity<List<City>> getAllCitiesByStateAndCountryIso2(String countryIso, String stateIso);

    @ApiOperation(value = "Get all cities of a state by its iso2 and it's country iso2")
    ResponseEntity<Void> validateIfAddressExists(Address address);
}
