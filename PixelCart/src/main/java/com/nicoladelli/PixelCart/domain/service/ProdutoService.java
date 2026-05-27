package com.nicoladelli.PixelCart.domain.service;

import com.nicoladelli.PixelCart.application.dto.request.ProdutoRequestDTO;
import com.nicoladelli.PixelCart.application.dto.response.ProdutoResponseDTO;
import com.nicoladelli.PixelCart.application.mapper.ProdutoMapper;
import com.nicoladelli.PixelCart.domain.model.Produto;
import com.nicoladelli.PixelCart.infrastructure.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoResponseDTO save (ProdutoRequestDTO requestDTO){
        var produto = ProdutoMapper.toModel(requestDTO);
        var produtoSalvo = repository.save(produto);
        return ProdutoMapper.toDTO(produtoSalvo);
    }

    public void delete (Long id){
            repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado!"));
                repository.deleteById(id);
    }

    public List<ProdutoResponseDTO> findAll(){
        List<Produto> produto = repository.findAll();
        return produto.stream()
                .map(ProdutoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<ProdutoResponseDTO> findByNome (String nome){
        return repository.findByNome(nome)
                .stream()
                .map(ProdutoMapper::toDTO)

                .collect(Collectors.toList());
    }


}
