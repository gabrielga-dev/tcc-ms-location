package br.com.events.location.business.exception;

import br.com.events.location.adapter.exception.badRequest.BadRequestException;

/**
 * This exception is thrown when someone tries to search a city at this <a href="https://countrystatecity.in/docs/">API</a>
 * and it does not exist
 *
 * @author Gabriel Guimarães de Almeida
 */
public class CityNotFound extends BadRequestException {

    public CityNotFound() {
        super("Cidade não encontrada!", "A cidade em questão não foi encontrada.");
    }
}
