package br.com.events.location.adapter.exception;

import br.com.events.location.adapter.exception.badRequest.UnauthorizedRequestException;

/**
 * This exception is called when a request with no api-ey is received
 *
 * @author Gabriel Guimarães de Almeida
 */
public class NoTokenReceivedException extends UnauthorizedRequestException {

    public NoTokenReceivedException() {
        super(
            "Usuário nao autenticado!",
            "Por favor, se autentique antes de tentar realizar esta ação!"
        );
    }
}
