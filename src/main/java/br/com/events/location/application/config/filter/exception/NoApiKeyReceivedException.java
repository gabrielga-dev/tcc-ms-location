package br.com.events.location.application.config.filter.exception;

import br.com.events.location.infrastructure.exception.badRequest.BadRequestException;

/**
 * This exception is called when a request with no api-ey is received
 *
 * @author Gabriel Guimarães de Almeida
 */
public class NoApiKeyReceivedException extends BadRequestException {

    public NoApiKeyReceivedException() {
        super(
            "Consumidor nao identificado!",
            "Não pudemos identificar qual é o consumidor do serviço. Identifique-o e tente novamente!"
        );
    }
}
