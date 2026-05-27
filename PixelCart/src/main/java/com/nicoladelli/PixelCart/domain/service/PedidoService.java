package com.nicoladelli.PixelCart.domain.service;

import com.nicoladelli.PixelCart.application.dto.request.PedidoRequestDTO;
import com.nicoladelli.PixelCart.application.dto.response.PedidoResponseDTO;
import com.nicoladelli.PixelCart.application.mapper.PedidoMapper;
import com.nicoladelli.PixelCart.domain.model.Pedido;
import com.nicoladelli.PixelCart.infrastructure.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PedidoService {

    private final PedidoRepository repository;


    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public PedidoResponseDTO save (PedidoRequestDTO requestDTO){
        var pedido = PedidoMapper.toModel(requestDTO);
        var pedidoSalvo = repository.save(pedido);
        return PedidoMapper.toDTO(pedidoSalvo);

    }
    public List<PedidoResponseDTO> findAll (){
        List<Pedido> pedidos = repository.findAll();
        return pedidos.stream()
                .map(PedidoMapper::toDTO)
                .collect(Collectors.toList());

    }

    public PedidoResponseDTO findById (Long id){
        var pedido = repository.findById(id)

                .orElseThrow(() -> new RuntimeException("Erro ao listar pedidos!"));
        return PedidoMapper.toDTO(pedido);
    }
    
}
