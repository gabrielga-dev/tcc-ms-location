package br.com.events.location.application.service.exception;

import br.com.events.location.infrastructure.exception.badRequest.BadRequestException;

public class AddressNotFoundException extends BadRequestException {

    public AddressNotFoundException() {
        super("Endereço inválido!", "O endereço enviado está inválido!");
    }
}
