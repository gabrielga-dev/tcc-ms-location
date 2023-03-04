package br.com.events.location.data.inbound;

import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * This class holds every needed information for create a new event
 *
 * @author Gabriel Guimarães de Almeida
 */
@Getter
@Setter
@Builder
public class Address {

    @ApiParam("City's id")
    @NotNull(message = "O id da cidade é obrigatório")
    private Long cityId;

    @ApiParam("State's iso2")
    @NotNull(message = "O iso2 do estado é obrigatório")
    @NotEmpty(message = "O iso2 do estado é obrigatório")
    private String stateIso;

    @ApiParam("Country's iso2")
    @NotNull(message = "O iso do país é obrigatório")
    @NotEmpty(message = "O iso do país é obrigatório")
    private String countryIso;
}
