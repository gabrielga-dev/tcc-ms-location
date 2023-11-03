package br.com.events.location.business.service.location;

import br.com.events.location.domain.io.address.Address;
import br.com.events.location.domain.io.location.CityResponse;
import br.com.events.location.domain.io.location.CountryResponse;
import br.com.events.location.domain.io.location.StateResponse;

import java.util.List;

public interface LocationService {

    List<CountryResponse> getAllCountries();

    List<StateResponse> getAllStatesByCountryIso2(String countryIso2);

    List<CityResponse> getAllCitiesByStateIso2(String countryIso, String stateIso);

    CityResponse getCityByIdAndStateAndCountryIso(String countryIso, String stateIso, Long cityId);

    void validateIfAddressExists(Address address);
}
