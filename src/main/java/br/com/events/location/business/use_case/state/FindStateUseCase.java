package br.com.events.location.business.use_case.state;

import br.com.events.location.adapter.repository.StateRepository;
import br.com.events.location.domain.entity.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindStateUseCase {

    private final StateRepository stateRepository;

    public Optional<State> byCountryAndStateIso2(String countryIso2, String stateIso2){
        return stateRepository.findByIso2AndCountry_Iso2(stateIso2, countryIso2);
    }
}
