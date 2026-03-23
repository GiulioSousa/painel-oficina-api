package com.oficina.service;

import java.util.List;

import com.oficina.dto.ItemRequestDTO;
import com.oficina.dto.ItemResponseDTO;

public interface ItemService {

    ItemResponseDTO adicionarItem(Long veiculoId, ItemRequestDTO dto);

    List<ItemResponseDTO> listarPorVeiculo(Long veiculoId);

    ItemResponseDTO atualizarItem(Long itemId, ItemRequestDTO dto);

    ItemResponseDTO atualizarStatus(Long itemId, String status);

    void excluirItem(Long itemId);
}
