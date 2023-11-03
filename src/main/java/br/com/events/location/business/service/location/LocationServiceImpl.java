package br.com.events.location.business.service.location;

import br.com.events.location.business.exception.AddressNotFoundException;
import br.com.events.location.business.exception.CityNotFound;
import br.com.events.location.business.exception.CountryNotFound;
import br.com.events.location.business.exception.StateNotFound;
import br.com.events.location.business.use_case.city.FindCityUseCase;
import br.com.events.location.business.use_case.country.FindCountryUseCase;
import br.com.events.location.business.use_case.state.FindStateUseCase;
import br.com.events.location.domain.io.address.Address;
import br.com.events.location.domain.io.location.CityResponse;
import br.com.events.location.domain.io.location.CountryResponse;
import br.com.events.location.domain.io.location.StateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final FindCountryUseCase findCountryUseCase;
    private final FindStateUseCase findStateUseCase;
    private final FindCityUseCase findCityUseCase;

    @Override
    public List<CountryResponse> getAllCountries() {
        return findCountryUseCase.findAll()
                .stream()
                .map(CountryResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<StateResponse> getAllStatesByCountryIso2(String countryIso2) {
        return findCountryUseCase.byIso2(countryIso2)
                .orElseThrow(CountryNotFound::new)
                .getStates()
                .stream()
                .map(StateResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityResponse> getAllCitiesByStateIso2(String countryIso, String stateIso) {
        var state = findStateUseCase.byCountryAndStateIso2(stateIso, countryIso)
                .orElseThrow(StateNotFound::new);

        return state.getCities()
                .stream()
                .map(CityResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public CityResponse getCityByIdAndStateAndCountryIso(String countryIso, String stateIso, Long cityId) {
        var city = findCityUseCase.byIdAndStateAndCountryIso(countryIso, stateIso, cityId)
                .orElseThrow(CityNotFound::new);

        return new CityResponse(city);
    }

    @Override
    public void validateIfAddressExists(Address address) {
        var addressExists = findCityUseCase.checkAddress(
                address.getCountryIso(),
                address.getStateIso(),
                address.getCityId()
        );

        if (!addressExists) {
            throw new AddressNotFoundException();
        }
    }
}
