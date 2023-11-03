package br.com.events.location.adapter.feign.country_state_city;

import br.com.events.location.adapter.feign.config.CountryStateCityFeignClientConfiguration;
import br.com.events.location.domain.io.location.CityResponse;
import br.com.events.location.domain.io.location.CountryResponse;
import br.com.events.location.domain.io.location.StateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * This interface communicates with this <a href="https://countrystatecity.in/docs/">API</a>
 *
 * @author Gabriel Guimarães de Almeida
 */
@FeignClient(
    name = "country-state-city",
    url = "${feign.client.country.state.city.url}",
    configuration = CountryStateCityFeignClientConfiguration.class
)
public interface CountryStateCityFeignClient {

    @GetMapping("/countries")
    ResponseEntity<List<CountryResponse>> getCountries();

    @GetMapping("/countries/{countryIso}/states")
    ResponseEntity<List<StateResponse>> getStatesByCountryIso2(
        @PathVariable("countryIso") String countryIso
    );

    @GetMapping("/countries/{countryIso}/states/{stateIso}/cities")
    ResponseEntity<List<CityResponse>> getCitiesByStateAndCountryIso2(
        @PathVariable("countryIso") String countryIso,
        @PathVariable("stateIso") String stateIso
    );
}
