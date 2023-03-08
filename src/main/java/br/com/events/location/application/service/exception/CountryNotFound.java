package br.com.events.location.application.service.exception;

import br.com.events.location.infrastructure.exception.badRequest.BadRequestException;

/**
 * This exception is thrown when someone tries to search a country at this <a href="https://countrystatecity.in/docs/">API</a>
 * and it does not exist
 *
 * @author Gabriel Guimarães de Almeida
 */
public class CountryNotFound extends BadRequestException {

    public CountryNotFound() {
        super("País não encontrado!", "O país em questão não foi encontrado.");
    }
}
