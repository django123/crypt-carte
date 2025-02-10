package io.django.crypt_carte.mapper;

import io.django.crypt_carte.dto.CarteBancaireDTO;
import io.django.crypt_carte.entites.CarteBancaire;
import org.springframework.stereotype.Component;

@Component
public class CarteBancaireMapperImpl implements CarteBancaireMapper {
    @Override
    public CarteBancaireDTO carteBancaireToCarteBancaireDTO(CarteBancaire carteBancaire) {
        if (carteBancaire == null) {
            return null;
        }
        CarteBancaireDTO carteBancaireDTO = new CarteBancaireDTO();
        carteBancaireDTO.setId(carteBancaire.getId());
        carteBancaireDTO.setNumeroCarte(carteBancaire.getNumeroCarte());
        carteBancaireDTO.setCvv(carteBancaire.getCvv());
        carteBancaireDTO.setDateExpiration(carteBancaire.getDateExpiration());
        return carteBancaireDTO;

    }

    @Override
    public CarteBancaire carteBancaireDTOToCarteBancaire(CarteBancaireDTO carteBancaireDTO) {
        if (carteBancaireDTO == null) {
            return null;
        }
        CarteBancaire carteBancaire = new CarteBancaire();
        carteBancaire.setId(carteBancaireDTO.getId());
        carteBancaire.setNumeroCarte(carteBancaireDTO.getNumeroCarte());
        carteBancaire.setCvv(carteBancaireDTO.getCvv());
        carteBancaire.setDateExpiration(carteBancaireDTO.getDateExpiration());
        return carteBancaire;
    }
}
