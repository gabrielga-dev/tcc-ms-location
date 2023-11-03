package br.com.events.location.domain.io.location;

import br.com.events.location.domain.entity.State;
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
public class StateResponse {

    private Long id;
    private String name;
    private String iso2;

    public StateResponse(State state){
        this.id = state.getId();
        this.name = state.getName();
        this.iso2 = state.getIso2();
    }
}
