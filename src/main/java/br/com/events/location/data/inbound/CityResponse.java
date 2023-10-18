package br.com.events.location.data.inbound;

import br.com.events.location.data.entity.City;
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
public class CityResponse {

    private Long id;
    private String name;

    public CityResponse(City city){
        this.id = city.getId();
        this.name = city.getName();
    }
}
