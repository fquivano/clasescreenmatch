package com.clasealuracursos.clasescreenmatch;

import com.clasealuracursos.clasescreenmatch.model.DatosEpisodio;
import com.clasealuracursos.clasescreenmatch.model.DatosSerie;
import com.clasealuracursos.clasescreenmatch.model.DatosTemporadas;
import com.clasealuracursos.clasescreenmatch.principal.EjemploStreams;
import com.clasealuracursos.clasescreenmatch.principal.Principal;
import com.clasealuracursos.clasescreenmatch.repository.SerieRepository;
import com.clasealuracursos.clasescreenmatch.service.ConsumoAPI;
import com.clasealuracursos.clasescreenmatch.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ClasescreenmatchApplication {


	public static void main(String[] args) {
		SpringApplication.run(ClasescreenmatchApplication.class, args);
	}

	}
