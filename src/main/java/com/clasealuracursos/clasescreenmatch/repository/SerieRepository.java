package com.clasealuracursos.clasescreenmatch.repository;

import com.clasealuracursos.clasescreenmatch.dto.EpisodioDTO;
import com.clasealuracursos.clasescreenmatch.model.Categoria;
import com.clasealuracursos.clasescreenmatch.model.Episodio;
import com.clasealuracursos.clasescreenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie,Long> {
   Optional<Serie> findByTituloContainsIgnoreCase(String nombreSerie);

   List<Serie> findTop5ByOrderByEvaluacionDesc();
   List<Serie>findByGenero(Categoria categoria);
  // List<Serie>findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalTemporadas,)

    @Query("select s from Serie s where s.totalDeTemporadas <= :totalTemporadas and s.evaluacion >= :evaluacion")
    List<Serie> seriesPorTemporadaYEvaluacion(int totalTemporadas, Double evaluacion);


    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:nombreEpisodio%")
    List<Episodio> episodiosPorNombre(String nombreEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.evaluacion DESC LIMIT 5")
    List<Episodio> top5Episodios(Serie serie);


    @Query("SELECT s FROM Serie s "+"JOIN s.episodios e "+" GROUP BY s "+" ORDER BY MAX(e.fechaDeLanzamiento) DESC LIMIT 5")
   List<Serie> lanzamientosMasRecientes();

    @Query("select e from Serie s JOIN s.episodios e where s.id=:id and e.temporada=:numeroTemporada")
    List<Episodio> obtenerTemporadasPorNumero(Long id, Long numeroTemporada);



    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s=:serie ORDER BY e.evaluacion DESC LIMIT 5")
    List<Episodio> topEpisodioPorSerie(Serie serie);


}
