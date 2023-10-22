package br.com.events.location.application.service;

import br.com.events.location.application.service.exception.CityNotFound;
import br.com.events.location.application.service.exception.CommunicationToCountryStateCityServerException;
import br.com.events.location.data.inbound.Address;
import br.com.events.location.data.inbound.CityResponse;
import br.com.events.location.data.inbound.CountryResponse;
import br.com.events.location.data.inbound.StateResponse;
import br.com.events.location.data.repository.CityRepository;
import br.com.events.location.data.repository.CountryRepository;
import br.com.events.location.data.repository.StateRepository;
import br.com.events.location.infrastructure.feign.countryStateCity.CountryStateCityFeignClient;
import br.com.events.location.infrastructure.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final CountryStateCityFeignClient countryStateCityFeignClient;
    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    @Override
    public List<CountryResponse> getAllCountries() {
        return countryRepository.findAll().stream().map(CountryResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<StateResponse> getAllStatesByCountryIso2(String countryIso2) {
        return countryRepository.findByIso2(countryIso2)
                .orElseThrow(CommunicationToCountryStateCityServerException::new)
                .getStates()
                .stream()
                .map(StateResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityResponse> getAllCitiesByStateIso2(String countryIso, String stateIso) {
        var country = countryRepository.findByIso2(countryIso)
                .orElseThrow(CommunicationToCountryStateCityServerException::new);
        var state = stateRepository.findByIso2(stateIso)
                .orElseThrow(CommunicationToCountryStateCityServerException::new);
        if (!Objects.equals(state.getCountry().getIso2(), country.getIso2())) {
            throw new CommunicationToCountryStateCityServerException();
        }
        return state.getCities().stream().map(CityResponse::new).collect(Collectors.toList());
    }

    @Override
    public CityResponse getCityByIdAndStateAndCountryIso(String countryIso, String stateIso, Long cityId) {
        return getAllCitiesByStateIso2(countryIso, stateIso).stream()
                .filter(city -> Objects.equals(city.getId(), cityId))
                .findFirst()
                .orElseThrow(
                        CityNotFound::new
                );
    }

    @Override
    public void validateIfAddressExists(Address address) {
        var citiesResponse = cityRepository.checkAddress(
                address.getCountryIso(), address.getStateIso(), address.getCityId()
        ).orElseThrow(CommunicationToCountryStateCityServerException::new);
    }
}
