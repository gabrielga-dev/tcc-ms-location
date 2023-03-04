package br.com.events.location.application.service;

import br.com.events.location.application.service.exception.AddressNotFoundException;
import br.com.events.location.application.service.exception.CommunicationToCountryStateCityServerException;
import br.com.events.location.data.inbound.Address;
import br.com.events.location.data.inbound.City;
import br.com.events.location.data.inbound.Country;
import br.com.events.location.data.inbound.State;
import br.com.events.location.infrastructure.feign.countryStateCity.CountryStateCityFeignClient;
import br.com.events.location.infrastructure.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final CountryStateCityFeignClient countryStateCityFeignClient;

    @Override
    public List<Country> getAllCountries() {
        try {
            return countryStateCityFeignClient.getCountries().getBody();
        } catch (Exception e) {
            log.error("Error communicating to country state city: {}", e.getMessage());
            e.printStackTrace();
            throw new CommunicationToCountryStateCityServerException();
        }
    }

    @Override
    public List<State> getAllStatesByCountryIso2(String countryIso2) {
        try {
            return countryStateCityFeignClient.getStatesByCountryIso2(countryIso2).getBody();
        } catch (Exception e) {
            log.error("Error communicating to country state city: {}", e.getMessage());
            e.printStackTrace();
            throw new CommunicationToCountryStateCityServerException();
        }
    }

    @Override
    public List<City> getAllCitiesByStateIso2(String countryIso, String stateIso) {
        try {
            return countryStateCityFeignClient.getCitiesByStateAndCountryIso2(countryIso, stateIso).getBody();
        } catch (Exception e) {
            log.error("Error communicating to country state city: {}", e.getMessage());
            e.printStackTrace();
            throw new CommunicationToCountryStateCityServerException();
        }
    }

    @Override
    public void validateIfAddressExists(Address address) {
        try {
            var citiesResponse = countryStateCityFeignClient.getCitiesByStateAndCountryIso2(
                    address.getCountryIso(), address.getStateIso()
            );
            var cities = Objects.requireNonNull(citiesResponse.getBody());

            cities.stream().filter(
                            feignCity -> Objects.equals(address.getCityId(), feignCity.getId())
                    ).findFirst()
                    .orElseThrow(
                        AddressNotFoundException::new
                    );
        } catch (NullPointerException npe) {
            log.error("Error communicating to country state city");
            npe.printStackTrace();
            throw new CommunicationToCountryStateCityServerException();
        }
    }
}
