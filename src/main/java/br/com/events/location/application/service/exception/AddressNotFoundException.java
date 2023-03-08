package br.com.events.location.application.service.exception;

import br.com.events.location.infrastructure.exception.badRequest.BadRequestException;

/**
 * This exception is thrown when someone tries to check an address, and it fails
 *
 * @author Gabriel Guimarães de Almeida
 */
public class AddressNotFoundException extends BadRequestException {

    public AddressNotFoundException() {
        super("Endereço inválido!", "O endereço enviado está inválido!");
    }
}
