package io.django.crypt_carte.controller;

import io.django.crypt_carte.dto.CarteBancaireDTO;
import io.django.crypt_carte.services.CarteBancaireService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carte-bancaire")
public class CarteBancaireController {

    private final CarteBancaireService carteBancaireService;

    public CarteBancaireController(CarteBancaireService carteBancaireService) {
        this.carteBancaireService = carteBancaireService;
    }

    @GetMapping
    @Operation(summary = "Get all carte bancaires")
    public ResponseEntity<List<CarteBancaireDTO>> getCarteBancaires() {
        return ResponseEntity.ok(carteBancaireService.getCarteBancaires());
    }

    @PostMapping
    @Operation(summary = "Create a new carte bancaire")
    public ResponseEntity<CarteBancaireDTO> createCarteBancaire(@Valid @RequestBody CarteBancaireDTO carteBancaireDTO) {
        return ResponseEntity.ok(carteBancaireService.createCarteBancaire(carteBancaireDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a carte bancaire")
    public ResponseEntity<CarteBancaireDTO> updateCarteBancaire(@Valid @RequestBody CarteBancaireDTO carteBancaireDTO, @PathVariable Long id) {
        return ResponseEntity.ok(carteBancaireService.updateCarteBancaire(carteBancaireDTO, id));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a carte bancaire by id")
    public ResponseEntity<CarteBancaireDTO> getCarteBancaire(@PathVariable Long id) {
        return ResponseEntity.ok(carteBancaireService.getCarteBancaire(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a carte bancaire by id")
    public ResponseEntity<Void> deleteCarteBancaire(@PathVariable Long id) {
        carteBancaireService.deleteCarteBancaire(id);
        return ResponseEntity.ok().build();
    }
}
