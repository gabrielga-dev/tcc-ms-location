package br.com.events.location.infrastructure.exception.badRequest;

import br.com.events.location.infrastructure.exception.BusinessException;
import org.springframework.http.HttpStatus;

/**
 * This exception will be extended by any other exception that needs to return a 400 http status
 *
 * @author Gabriel Guimarães de Almeida
 */
public class ForbiddenRequestException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public ForbiddenRequestException(
        final String message, final String description
    ) {
        super(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value(), message, description);
    }
}
