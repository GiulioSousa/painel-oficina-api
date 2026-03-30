package com.oficina.dto;

import com.oficina.entity.ItemTipo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ItemRequestDTO {

    @NotNull(message = "Tipo do item é obrigatório")
    private ItemTipo tipo;

    @NotBlank(message = "Descrição do item é obrigatória")
    @Size(max = 150, message = "A descrição deve ter no máximo 150 caracteres")
    private String descricao;

    public ItemTipo getTipo() {
        return tipo;
    }

    public void setTipo(ItemTipo tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
