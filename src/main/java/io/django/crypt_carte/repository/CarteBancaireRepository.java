package io.django.crypt_carte.repository;

import io.django.crypt_carte.entites.CarteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteBancaireRepository extends JpaRepository<CarteBancaire, Long> {
}
