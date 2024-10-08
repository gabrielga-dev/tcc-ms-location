package br.com.events.location.adapter.controller.v1.location.doc;

import br.com.events.location.domain.io.location.CityResponse;
import br.com.events.location.domain.io.location.StateResponse;
import br.com.events.location.domain.io.address.Address;
import br.com.events.location.domain.io.location.CountryResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    ResponseEntity<List<CountryResponse>> getAllCountries();

    @ApiOperation(value = "Get all states of a country by its iso2")
    ResponseEntity<List<StateResponse>> getAllStatesByCountryIso2(
            @ApiParam("Country's iso2") String countryIso
    );

    @ApiOperation(value = "Get all cities of a state by its iso2 and it's country iso2")
    ResponseEntity<List<CityResponse>> getAllCitiesByStateAndCountryIso2(
            @ApiParam("Country's iso2") String countryIso,
            @ApiParam("State's iso2") String stateIso
    );

    @ApiOperation(value = "Get a city by its id and its state and country iso2")
    ResponseEntity<CityResponse> getCityByIdAndStateAndCountryIso(
            @ApiParam("Country's iso2") String countryIso,
            @ApiParam("State's iso2") String stateIso,
            @ApiParam("City's id") Long cityId
    );

    @ApiOperation(value = "Get all cities of a state by its iso2 and it's country iso2")
    ResponseEntity<Void> validateIfAddressExists(Address address);
}
