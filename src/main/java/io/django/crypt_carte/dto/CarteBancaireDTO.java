package io.django.crypt_carte.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarteBancaireDTO{
    private Long id;
    private String numeroCarte;
    private String cvv;
    private String dateExpiration;
}
