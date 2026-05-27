package com.nicoladelli.PixelCart.application.dto.response;

import com.nicoladelli.PixelCart.domain.model.MetodoPagamento;
import com.nicoladelli.PixelCart.domain.model.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponseDTO(

        Long id,
        String numero_pedido,
        BigDecimal total,
        StatusPedido statusPedido,
        MetodoPagamento metodoPagamento,
        LocalDateTime criacaoPedido,
        List<ItemPedidoResponseDTO> itens
) {
}


