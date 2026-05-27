package com.nicoladelli.PixelCart.infrastructure.web.controller.admin;

import com.nicoladelli.PixelCart.application.dto.response.PedidoResponseDTO;
import com.nicoladelli.PixelCart.domain.model.Pedido;
import com.nicoladelli.PixelCart.domain.model.Produto;
import com.nicoladelli.PixelCart.domain.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/pedidos")
@RequiredArgsConstructor
public class PedidoAdminController {

    private final PedidoService service;

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> findAll (){
        List<PedidoResponseDTO> pedidos = service.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> findById (@PathVariable Long id) {
        var pedido = service.findById(id);
        return ResponseEntity.ok(pedido);

    }



}
