package com.example.blog_api.controller;

import com.example.blog_api.model.Artigo;
import com.example.blog_api.service.ArtigoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/artigos")
public class ArtigoController {
    @Autowired
    private ArtigoService artigoService;

    @PostMapping
    public ResponseEntity<Artigo> publicarArtigo(@Valid @RequestBody Artigo artigo) {
        artigo = artigoService.novoArtigo(artigo);

        return ResponseEntity.ok().body(artigo);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Artigo>> buscarArtigoPorId(@PathVariable Long id) {
        Optional<Artigo> artigo = artigoService.buscarArtigoPorId(id);

        return ResponseEntity.ok(artigo);
    }

    @GetMapping
    public ResponseEntity<List<Artigo>> listarArtigos() {
        List<Artigo> artigos = artigoService.listarArtigos();
        return ResponseEntity.ok().body(artigos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artigo> atualizarArtigo(@PathVariable Long id, @Valid @RequestBody Artigo artigoExistente) {
        Optional<Artigo> novoArtigo = artigoService.buscarArtigoPorId(id);

        if (novoArtigo.isPresent()) {
            Artigo artigoAtualizado = artigoService.atualizarArtigo(artigoExistente, id).get();
            return ResponseEntity.ok(artigoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarArtigo(@PathVariable Long id) {
        try {
            artigoService.deletarArtigo(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
