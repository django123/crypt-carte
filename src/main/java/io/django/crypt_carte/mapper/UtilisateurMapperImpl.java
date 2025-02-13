package io.django.crypt_carte.mapper;

import io.django.crypt_carte.dto.utilisateur.request.UtilisateurRequest;
import io.django.crypt_carte.dto.utilisateur.response.UtilisateurResponse;
import io.django.crypt_carte.entites.Utilisateur;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurMapperImpl implements UtilisateurMapper {


    @Override
    public UtilisateurResponse toResponse(Utilisateur entity) {
        if (entity == null) {
            return null;
        }
        UtilisateurResponse utilisateurResponse = new UtilisateurResponse();
        utilisateurResponse.setId(entity.getId());
        utilisateurResponse.setNom(entity.getNom());
        utilisateurResponse.setPrenom(entity.getPrenom());
        utilisateurResponse.setEmail(entity.getEmail());
        utilisateurResponse.setPassword(entity.getPassword());
        utilisateurResponse.setTelephone(entity.getTelephone());
        utilisateurResponse.setAdresse(entity.getAdresse());
        utilisateurResponse.setVille(entity.getVille());
        utilisateurResponse.setCodePostal(entity.getCodePostal());
        utilisateurResponse.setPays(entity.getPays());
        utilisateurResponse.setDateCreation(entity.getDateCreation());
        return utilisateurResponse;
    }


    @Override
    public Utilisateur toEntity(UtilisateurRequest dto) {
        if (dto == null) {
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setPassword(dto.getPassword());
        utilisateur.setTelephone(dto.getTelephone());
        utilisateur.setAdresse(dto.getAdresse());
        utilisateur.setVille(dto.getVille());
        utilisateur.setCodePostal(dto.getCodePostal());
        utilisateur.setPays(dto.getPays());
        utilisateur.setDateCreation(dto.getDateCreation());
        return utilisateur;
    }

    @Override
    public void updateFromDto(UtilisateurRequest dto, Utilisateur entity) {
        if (dto == null || entity == null) {
             throw new IllegalArgumentException("Les paramètres dto et entity ne doivent pas être nuls.");
        }

        if (dto.getNom() != null){
            entity.setNom(dto.getNom());
        }
        if (dto.getEmail() != null){
            entity.setEmail(dto.getEmail());
        }
        if (dto.getPrenom() != null){
            entity.setPrenom(dto.getPrenom());
        }
        if (dto.getPays() != null){
            entity.setPays(dto.getPays());
        }
        if (dto.getAdresse() != null){
            entity.setAdresse(dto.getAdresse());
        }
        if (dto.getVille() != null){
            entity.setVille(dto.getVille());
        }
        if (dto.getTelephone() != null){
            entity.setTelephone(dto.getTelephone());
        }
        if (dto.getPassword() != null){
            entity.setPassword(dto.getPassword());
        }
        if (dto.getCodePostal() != null){
            entity.setCodePostal(dto.getCodePostal());
        }
        if (dto.getDateCreation() != null){
            entity.setDateCreation(dto.getDateCreation());
        }

    }
}
