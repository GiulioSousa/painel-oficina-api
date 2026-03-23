package com.oficina.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oficina.dto.ItemRequestDTO;
import com.oficina.dto.ItemResponseDTO;
import com.oficina.service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/veiculo/{veiculoId}")
    public ResponseEntity<ItemResponseDTO> adicionarItem(
            @PathVariable Long veiculoId,
            @Valid @RequestBody ItemRequestDTO dto) {

        ItemResponseDTO response = itemService.adicionarItem(veiculoId, dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/veiculo/{veiculoId}")
    public ResponseEntity<List<ItemResponseDTO>> listarPorVeiculo(
            @PathVariable Long veiculoId) {

        List<ItemResponseDTO> lista = itemService.listarPorVeiculo(veiculoId);

        return ResponseEntity.ok(lista);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemResponseDTO> atualizarItem(
            @PathVariable Long id,
            @Valid @RequestBody ItemRequestDTO dto) {

        ItemResponseDTO response = itemService.atualizarItem(id, dto);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ItemResponseDTO> atualizarStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        ItemResponseDTO response = itemService.atualizarStatus(id, status);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirItem(@PathVariable Long id) {

        itemService.excluirItem(id);

        return ResponseEntity.noContent().build();
    }
}
