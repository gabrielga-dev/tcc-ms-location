package br.com.events.location.adapter.exception.badRequest;

import br.com.events.location.adapter.exception.BusinessException;
import org.springframework.http.HttpStatus;

/**
 * This exception will be extended by any other exception that needs to return a 401 http status
 *
 * @author Gabriel Guimarães de Almeida
 */
public class UnauthorizedRequestException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public UnauthorizedRequestException(
        final String message, final String description
    ) {
        super(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(), message, description);
    }
}
