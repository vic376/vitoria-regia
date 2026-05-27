package com.nicoladelli.PixelCart.application.mapper;

import com.nicoladelli.PixelCart.application.dto.request.ProdutoRequestDTO;
import com.nicoladelli.PixelCart.application.dto.response.ProdutoResponseDTO;
import com.nicoladelli.PixelCart.domain.model.Produto;

public class ProdutoMapper {

    public static ProdutoResponseDTO toDTO(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getEstoque(),
                produto.getCategoria(),
                produto.getImagem_url()
        );
    }

    public static Produto toModel(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setEstoque(dto.estoque());
        produto.setCategoria(dto.categoria());
        produto.setImagem_url(dto.imagem_url());
        return produto;
    }

}