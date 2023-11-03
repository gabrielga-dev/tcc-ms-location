package br.com.events.location.business.use_case.country;

import br.com.events.location.adapter.repository.CountryRepository;
import br.com.events.location.domain.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCountryUseCase {

    private final CountryRepository countryRepository;

    public List<Country> findAll(){
        return countryRepository.findAll();
    }

    public Optional<Country> byIso2(String countryIso2){
        return countryRepository.findByIso2(countryIso2);
    }
}
