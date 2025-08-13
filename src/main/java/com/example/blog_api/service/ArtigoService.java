package com.example.blog_api.service;


import com.example.blog_api.model.Artigo;
import com.example.blog_api.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArtigoService {
    @Autowired
    private ArtigoRepository artigoRepository;

    public Artigo novoArtigo(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    public Optional<Artigo> buscarArtigoPorId(Long id){
        return artigoRepository.findById(id);
    }

    public List<Artigo> listarArtigos() {
        return artigoRepository.findAll();
    }

    public void deletarArtigo(Long id) {
        if (!artigoRepository.existsById(id)){
            throw new NoSuchElementException("Artigo com ID " + id + " não encontrado. Não foi possível deletar.");
        }
        artigoRepository.deleteById(id);
    }
}
