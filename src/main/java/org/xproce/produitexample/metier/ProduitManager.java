package org.xproce.produitexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.xproce.produitexample.dao.entities.Produit;
import org.xproce.produitexample.dao.repositories.ProduitRepository;

import java.util.List;

@Service
public class ProduitManager implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Page<Produit> getAllProduits(int page, int taille) {
        return produitRepository.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Page<Produit> searchProduits(String keyword, int page, int taille) {
        return produitRepository.findByDesignationContains(keyword, PageRequest.of(page, taille));
    }

    @Override
    public List<Produit> getByKeyword(String keyword) {
        return null;
    }

    @Override
    public Produit getProduitById(Integer id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public boolean deleteProduit(Integer id) {
        Produit produit = produitRepository.findById(id).get();
        if (produit != null) {
            produitRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }
}
