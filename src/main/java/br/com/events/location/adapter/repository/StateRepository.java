package br.com.events.location.adapter.repository;

import br.com.events.location.domain.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    Optional<State> findByIso2(String iso2);

    Optional<State> findByIso2AndCountry_Iso2(String stateIso2, String countryIso2);
}
