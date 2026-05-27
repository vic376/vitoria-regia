package com.nicoladelli.PixelCart.infrastructure.web.controller.cliente;

import com.nicoladelli.PixelCart.application.dto.request.PedidoRequestDTO;
import com.nicoladelli.PixelCart.application.dto.response.PedidoResponseDTO;
import com.nicoladelli.PixelCart.domain.model.Pedido;
import com.nicoladelli.PixelCart.domain.model.Produto;
import com.nicoladelli.PixelCart.domain.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> save (@RequestBody PedidoRequestDTO requestDTO){
        var pedido = service.save(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> findById (@PathVariable Long id) {
        var pedido = service.findById(id);
        return ResponseEntity.ok(pedido);
    }

}



