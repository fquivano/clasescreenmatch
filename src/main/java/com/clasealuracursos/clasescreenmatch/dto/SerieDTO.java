package com.clasealuracursos.clasescreenmatch.dto;

import com.clasealuracursos.clasescreenmatch.model.Categoria;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record SerieDTO(
Long id,
 String titulo,
 Integer totalDeTemporadas,
 Double evaluacion,
 String poster,
 Categoria genero,
 String actores,
 String sinopsis) {

}
