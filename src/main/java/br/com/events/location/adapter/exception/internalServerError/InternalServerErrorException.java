package br.com.events.location.adapter.exception.internalServerError;

import br.com.events.location.adapter.exception.BusinessException;
import org.springframework.http.HttpStatus;

/**
 * This exception will be extended by any other exception that needs to return a 500 http status
 *
 * @author Gabriel Guimarães de Almeida
 */
public class InternalServerErrorException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public InternalServerErrorException(
            final String message, final String description
    ) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, description);
    }
}
