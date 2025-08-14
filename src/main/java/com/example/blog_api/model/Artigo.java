package com.example.blog_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "data_publicacao")
    private LocalDateTime dataPublicacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(nullable = false)
    @NotBlank
    private String autor;

    @Override
    public String toString() {
        return "Artigo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", autor='" + autor + '\'' +
                '}';
    }
}
