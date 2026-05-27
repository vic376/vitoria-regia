package com.nicoladelli.PixelCart.domain.service;

import com.nicoladelli.PixelCart.application.dto.request.UsuarioRequestDTO;
import com.nicoladelli.PixelCart.application.dto.response.UsuarioResponseDTO;
import com.nicoladelli.PixelCart.application.mapper.UsuarioMapper;
import com.nicoladelli.PixelCart.domain.model.Usuario;
import com.nicoladelli.PixelCart.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioResponseDTO save (UsuarioRequestDTO requestDTO){
        var usuario = UsuarioMapper.toModel(requestDTO);
        var usuarioSalvo = repository.save(usuario);
        return UsuarioMapper.toDTO(usuarioSalvo);

    }

    public void disable(Long id) {
        var usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
                 usuario.setAtivo(false);
                    repository.save(usuario);
    }

    public UsuarioResponseDTO update(Long id, UsuarioRequestDTO dto) {
        var usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
                 usuario.setNome(dto.nome());
                 usuario.setEmail(dto.email());
                 usuario.setCpf(dto.cpf());
                 usuario.setSenha(dto.senha());
                 usuario.setEndereco(dto.endereco());
               var usuarioSalvo = repository.save(usuario);
               return UsuarioMapper.toDTO(usuarioSalvo);
    }



}
