package com.nicoladelli.PixelCart.infrastructure.web.controller.admin;

import com.nicoladelli.PixelCart.application.dto.request.ProdutoRequestDTO;
import com.nicoladelli.PixelCart.application.dto.response.ProdutoResponseDTO;
import com.nicoladelli.PixelCart.domain.model.Produto;
import com.nicoladelli.PixelCart.domain.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/produtos")
@RequiredArgsConstructor
public class ProdutoAdminController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> save(@RequestBody ProdutoRequestDTO produto){
        var produtoSalvar = service.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvar);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> findAll (){
        var produtos = service.findAll();
        return ResponseEntity.ok(produtos);
    }

}
