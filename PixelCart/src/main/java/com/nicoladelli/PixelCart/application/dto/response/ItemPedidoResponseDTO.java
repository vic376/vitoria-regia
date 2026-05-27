package com.nicoladelli.PixelCart.application.dto.response;

import java.math.BigDecimal;

public record ItemPedidoResponseDTO(

        String nomeProduto,
        int quantidade,
        BigDecimal precoUnitario
) {
}
