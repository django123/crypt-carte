package io.django.crypt_carte.controller;

import io.django.crypt_carte.dto.CarteBancaireDTO;
import io.django.crypt_carte.services.CarteBancaireService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carte-bancaire")
@CrossOrigin(origins = "*")

public class CarteBancaireController {

    private final CarteBancaireService carteBancaireService;
    private static final Logger LOG = LoggerFactory.getLogger(CarteBancaireController.class);

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
        LOG.info("Carte créée avec succès");
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
