package com.nicoladelli.PixelCart.application.dto.response;

public record UsuarioResponseDTO(

        Long id,
        String nome,
        String email,
        String cpf,
        String endereco
) {
}
