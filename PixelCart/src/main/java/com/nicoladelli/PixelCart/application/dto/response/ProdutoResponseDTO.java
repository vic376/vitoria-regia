package com.nicoladelli.PixelCart.application.dto.response;

import java.math.BigDecimal;

public record ProdutoResponseDTO(

        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        int estoque,
        String categoria,
        String imagem_url
) {
}
