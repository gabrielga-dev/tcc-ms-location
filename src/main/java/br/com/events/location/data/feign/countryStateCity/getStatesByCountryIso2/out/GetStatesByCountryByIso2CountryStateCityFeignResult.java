package br.com.events.location.data.feign.countryStateCity.getStatesByCountryIso2.out;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * This class holds every returned information at the <a
 * href="https://countrystatecity.in/docs/api/states-by-country/">country state city API</a>
 *
 * @author Gabriel Guiamrães de Almeida
 */
@Getter
@Setter
@Builder
public class GetStatesByCountryByIso2CountryStateCityFeignResult {

    private Long id;
    private String name;
    private String iso2;
}
