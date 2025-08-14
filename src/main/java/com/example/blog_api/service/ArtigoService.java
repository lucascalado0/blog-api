package com.example.blog_api.service;


import com.example.blog_api.model.Artigo;
import com.example.blog_api.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArtigoService {
    @Autowired
    private ArtigoRepository artigoRepository;

    public Artigo novoArtigo(Artigo artigo) {
        artigo.setDataPublicacao(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

        return artigoRepository.save(artigo);
    }

    public Optional<Artigo> buscarArtigoPorId(Long id) {
        return artigoRepository.findById(id);
    }

    public List<Artigo> listarArtigos() {
        return artigoRepository.findAll();
    }

    public Optional<Artigo> atualizarArtigo(Artigo dadosNovosArtigo, Long id) {
        Optional<Artigo> artigoExistente = artigoRepository.findById(id);

        if (artigoExistente.isPresent()) {
            Artigo artigoAtualizado = artigoExistente.get();

            artigoAtualizado.setTitulo(dadosNovosArtigo.getTitulo());
            artigoAtualizado.setConteudo(dadosNovosArtigo.getConteudo());
            artigoAtualizado.setDataAtualizacao(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

            return Optional.of(artigoRepository.save(artigoAtualizado));
        } else {
            throw new NoSuchElementException("Artigo com ID " + id + " não encontrado. Não foi possível atualizar.");
        }
    }

    public void deletarArtigo(Long id) {
        if (!artigoRepository.existsById(id)) {
            throw new NoSuchElementException("Artigo com ID " + id + " não encontrado. Não foi possível deletar.");
        }
        artigoRepository.deleteById(id);
    }
}
