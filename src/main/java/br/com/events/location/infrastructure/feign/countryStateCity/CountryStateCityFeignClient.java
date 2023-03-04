package br.com.events.location.infrastructure.feign.countryStateCity;

import br.com.events.location.application.config.feign.CountryStateCityFeignClientConfiguration;
import br.com.events.location.data.inbound.City;
import br.com.events.location.data.inbound.Country;
import br.com.events.location.data.inbound.State;
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
    ResponseEntity<List<Country>> getCountries();

    @GetMapping("/countries/{countryIso}/states")
    ResponseEntity<List<State>> getStatesByCountryIso2(
        @PathVariable("countryIso") String countryIso
    );

    @GetMapping("/countries/{countryIso}/states/{stateIso}/cities")
    ResponseEntity<List<City>> getCitiesByStateAndCountryIso2(
        @PathVariable("countryIso") String countryIso,
        @PathVariable("stateIso") String stateIso
    );
}
