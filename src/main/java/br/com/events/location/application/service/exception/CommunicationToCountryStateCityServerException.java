package br.com.events.location.application.service.exception;

import br.com.events.location.infrastructure.exception.internalServerError.InternalServerErrorException;

/**
 * This exception is thrown when there is an error while communicating to this <a href="https://countrystatecity.in/docs/">API</a>
 *
 * @author Gabriel Guimarães de Almeida
 */
public class CommunicationToCountryStateCityServerException extends InternalServerErrorException {

    public CommunicationToCountryStateCityServerException() {
        super(
                "Erro em nossos servidores!",
                "Estamos enfrentando uma instabilidade nos servidores de localização. Aguarde um momento!"
        );
    }
}
