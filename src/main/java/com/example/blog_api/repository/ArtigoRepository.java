package com.example.blog_api.repository;

import com.example.blog_api.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<Long, Artigo> {

}
