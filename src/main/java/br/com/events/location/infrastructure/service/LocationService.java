package br.com.events.location.infrastructure.service;

import br.com.events.location.data.inbound.Address;
import br.com.events.location.data.inbound.City;
import br.com.events.location.data.inbound.Country;
import br.com.events.location.data.inbound.State;

import java.util.List;

public interface LocationService {

    List<Country> getAllCountries();

    List<State> getAllStatesByCountryIso2(String countryIso2);

    List<City> getAllCitiesByStateIso2(String countryIso, String stateIso);

    void validateIfAddressExists(Address address);
}
