package br.com.events.location.adapter.repository;

import br.com.events.location.domain.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    @Query("SELECT state FROM State state INNER JOIN Country country ON state.country.id = country.id " +
            "WHERE state.iso2=:stateIso2 AND country.iso2=:countryIso2")
    Optional<State> findByIso2AndCountryIso2(
            @Param("stateIso2") String stateIso2,
            @Param("countryIso2") String countryIso2
    );
}
