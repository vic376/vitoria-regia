package com.nicoladelli.PixelCart.application.mapper;

import com.nicoladelli.PixelCart.application.dto.request.PedidoRequestDTO;
import com.nicoladelli.PixelCart.application.dto.response.ItemPedidoResponseDTO;
import com.nicoladelli.PixelCart.application.dto.response.PedidoResponseDTO;
import com.nicoladelli.PixelCart.domain.model.Pedido;

import java.util.List;

public class PedidoMapper {

    public static PedidoResponseDTO toDTO (Pedido pedido){
        List<ItemPedidoResponseDTO> itens = pedido.getItens()
                .stream()
                .map(item -> new ItemPedidoResponseDTO(
                        item.getProduto().getNome(),
                        item.getQuantidade(),
                        item.getPreco_unit()
                ))
                .toList();
        return new PedidoResponseDTO(
          pedido.getId(),
          pedido.getNumero_pedido(),
          pedido.getTotal(),
          pedido.getStatusPedido(),
          pedido.getMetodoPagamento(),
          pedido.getCriacaoPedido(),
        itens
        );
    }

    public static Pedido toModel (PedidoRequestDTO dto){
        Pedido pedido = new Pedido();
        pedido.setMetodoPagamento(dto.metodoPagamento());
        return pedido;
    }
}
