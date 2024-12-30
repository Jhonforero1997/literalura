package com.alura.literalura.repository;

import com.alura.literalura.model.Libro;
import com.alura.literalura.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTituloIgnoreCase(String titulo);

    List<Libro> findByIdioma(Language idioma); // Cambio a Language
}

