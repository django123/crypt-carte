package io.django.crypt_carte.services;

import io.django.crypt_carte.dto.CarteBancaireDTO;
import io.django.crypt_carte.entites.CarteBancaire;
import io.django.crypt_carte.mapper.CarteBancaireMapper;
import io.django.crypt_carte.repository.CarteBancaireRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteBancaireService {

    private final EncryptionService encryptionService;
    private final CarteBancaireRepository carteBancaireRepository;
    private final CarteBancaireMapper carteBancaireMapper;

    public CarteBancaireService(EncryptionService encryptionService, CarteBancaireRepository carteBancaireRepository, CarteBancaireMapper carteBancaireMapper) {
        this.encryptionService = encryptionService;
        this.carteBancaireRepository = carteBancaireRepository;
        this.carteBancaireMapper = carteBancaireMapper;
    }

    public CarteBancaireDTO createCarteBancaire(CarteBancaireDTO carteBancaireDTO) {
        CarteBancaire carteBancaire = carteBancaireMapper.carteBancaireDTOToCarteBancaire(carteBancaireDTO);
        carteBancaire.setNumeroCarte(encryptionService.encrypt(carteBancaire.getNumeroCarte()));
       CarteBancaire savedCarteBancaire = carteBancaireRepository.save(carteBancaire);
        return toDtoWithDecryption(savedCarteBancaire);
    }

    public CarteBancaireDTO updateCarteBancaire(CarteBancaireDTO carteBancaireDTO, Long id) {
     Optional<CarteBancaire> carteBancaire = carteBancaireRepository.findById(id);
        if(carteBancaire.isPresent()){
            CarteBancaire carte = carteBancaire.get();
            // Chiffrement du nouveau numéro de carte avant sauvegarde
            if (carteBancaireDTO.getNumeroCarte() != null && !carteBancaireDTO.getNumeroCarte().isEmpty()) {
                carte.setNumeroCarte(encryptionService.encrypt(carteBancaireDTO.getNumeroCarte()));
            }

            CarteBancaire updatedCarte = carteBancaireRepository.save(carte);
            return toDtoWithDecryption(updatedCarte);
        } else {
            throw new RuntimeException("Carte non trouvée avec l'ID : " + id);
        }
    }

    public List<CarteBancaireDTO> getCarteBancaires() {
        return carteBancaireRepository.findAll()
                .stream()
                .map(this::toDtoWithDecryption)
                .toList();
    }

    public CarteBancaireDTO getCarteBancaire(Long id) {
        CarteBancaire carteBancaire = carteBancaireRepository.findById(id).orElseThrow();
        return toDtoWithDecryption(carteBancaire);

    }

    public void deleteCarteBancaire(Long id) {
        carteBancaireRepository.deleteById(id);
    }

    private CarteBancaireDTO toDtoWithDecryption(CarteBancaire carteBancaire) {
        CarteBancaireDTO carteBancaireDTO = carteBancaireMapper.carteBancaireToCarteBancaireDTO(carteBancaire);
        carteBancaireDTO.setNumeroCarte(encryptionService.decrypt(carteBancaireDTO.getNumeroCarte()));
        return carteBancaireDTO;
    }


}
