package com.nicoladelli.PixelCart.infrastructure.web.controller.cliente;

import com.nicoladelli.PixelCart.application.dto.request.UsuarioRequestDTO;
import com.nicoladelli.PixelCart.application.dto.response.UsuarioResponseDTO;
import com.nicoladelli.PixelCart.domain.model.Usuario;
import com.nicoladelli.PixelCart.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> save (@RequestBody UsuarioRequestDTO requestDTO){
       var usuario = service.save(requestDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> disable (@PathVariable Long id){
        service.disable(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update (@PathVariable Long id, @RequestBody UsuarioRequestDTO dto){
       var usuario = service.update(id, dto);
       return ResponseEntity.ok(usuario);
    }

}
