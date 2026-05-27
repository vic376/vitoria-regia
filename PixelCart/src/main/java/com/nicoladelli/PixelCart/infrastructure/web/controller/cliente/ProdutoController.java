package com.nicoladelli.PixelCart.infrastructure.web.controller.cliente;

import com.nicoladelli.PixelCart.application.dto.response.ProdutoResponseDTO;
import com.nicoladelli.PixelCart.domain.model.Produto;
import com.nicoladelli.PixelCart.domain.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> findAll(
            @RequestParam(required = false) String nome) {

        if (nome != null) {
             return ResponseEntity.ok(service.findByNome(nome));
        }
        return ResponseEntity.ok(service.findAll());
    }
}
