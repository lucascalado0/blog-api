package com.example.blog_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;



@Getter
@Setter
@Entity(name = "artigo")
@Table(name = "artigos")
public class Artigo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @Column(nullable = false, length = 5000)
    @NotBlank
    private String conteudo;

    @Column(nullable = false)
    private LocalDateTime dataPublicacao;

    @Column
    private LocalDateTime dataAtualizacao;

    @Column(nullable = false)
    @NotBlank
    private String autor;

    public Artigo(String titulo, String conteudo, LocalDateTime dataPublicacao, String autor) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Artigo {" +
                "Titulo = '" + titulo + '\'' +
                ",\nConteudo = '" + conteudo + '\'' +
                ",\nData de Publicação = " + dataPublicacao +
                ",\nAutor = '" + autor + '\'' +
                '}';
    }
}
