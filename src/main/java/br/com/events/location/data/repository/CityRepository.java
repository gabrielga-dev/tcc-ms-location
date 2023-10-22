package br.com.events.location.data.repository;

import br.com.events.location.data.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT city " +
            "FROM City city LEFT JOIN State state ON city.state.id = state.id " +
            "LEFT JOIN Country country ON state.country.id = country.id " +
            "WHERE (city.id = :cityId) AND (state.iso2 = :stateIso) AND (country.iso2 = :countryIso)")
    Optional<City> checkAddress(
            @Param("countryIso") String countryIso,
            @Param("stateIso") String stateIso,
            @Param("cityId") Long cityId
    );
}
