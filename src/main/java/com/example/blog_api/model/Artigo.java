package com.example.blog_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity(name = "artigo")
@Table(name = "artigos")
public class Artigo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 5000)
    private String conteudo;

    @Column(nullable = false)
    private LocalDateTime dataPublicacao;

    @Column(nullable = false)
    private String autor;

    DateTimeFormatter horaFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public String toString() {
        return "Artigo {" +
                "Titulo = '" + titulo + '\'' +
                ",\nConteudo = '" + conteudo + '\'' +
                ",\nData de Publicação = " + dataPublicacao.format(horaFormatada) +
                ",\nAutor = '" + autor + '\'' +
                '}';
    }
}
