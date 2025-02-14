package io.django.crypt_carte.mapper;

import io.django.crypt_carte.dto.CarteBancaireDTO;
import io.django.crypt_carte.entites.CarteBancaire;


public interface CarteBancaireMapper {



    CarteBancaireDTO carteBancaireToCarteBancaireDTO(CarteBancaire carteBancaire);

    CarteBancaire carteBancaireDTOToCarteBancaire(CarteBancaireDTO carteBancaireDTO);

    void updateFromDto(CarteBancaireDTO dto, CarteBancaire entity);
}
