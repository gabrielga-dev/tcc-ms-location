package br.com.events.location.infrastructure.service;

import br.com.events.location.data.inbound.Address;
import br.com.events.location.data.inbound.CityResponse;
import br.com.events.location.data.inbound.CountryResponse;
import br.com.events.location.data.inbound.StateResponse;

import java.util.List;

public interface LocationService {

    List<CountryResponse> getAllCountries();

    List<StateResponse> getAllStatesByCountryIso2(String countryIso2);

    List<CityResponse> getAllCitiesByStateIso2(String countryIso, String stateIso);

    CityResponse getCityByIdAndStateAndCountryIso(String countryIso, String stateIso, Long cityId);

    void validateIfAddressExists(Address address);
}
