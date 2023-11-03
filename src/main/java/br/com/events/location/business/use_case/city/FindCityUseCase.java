package br.com.events.location.business.use_case.city;

import br.com.events.location.adapter.repository.CityRepository;
import br.com.events.location.domain.entity.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCityUseCase {

    private final CityRepository cityRepository;

    public boolean checkAddress(String countryIso, String stateIso, Long cityId){
        return this.byIdAndStateAndCountryIso(countryIso, stateIso, cityId).isPresent();
    }

    public Optional<City> byIdAndStateAndCountryIso(String countryIso, String stateIso, Long cityId){
        return  cityRepository.checkAddress(countryIso, stateIso, cityId);
    }
}
