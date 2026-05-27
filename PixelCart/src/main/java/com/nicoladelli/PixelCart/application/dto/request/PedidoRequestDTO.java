package com.nicoladelli.PixelCart.application.dto.request;

import com.nicoladelli.PixelCart.domain.model.MetodoPagamento;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PedidoRequestDTO(

        @NotNull
        List<ItemPedidoRequestDTO> itens,

        @NotNull(message = "O Método de pagamento não pode ser nulo")
        MetodoPagamento metodoPagamento

) {


}
