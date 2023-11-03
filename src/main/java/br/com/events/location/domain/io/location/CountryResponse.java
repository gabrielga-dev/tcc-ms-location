package br.com.events.location.domain.io.location;

import br.com.events.location.domain.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryResponse {

    private Long id;
    private String name;
    private String iso2;

    public CountryResponse(Country country){
        this.id = country.getId();
        this.name = country.getName();
        this.iso2 = country.getIso2();
    }
}
