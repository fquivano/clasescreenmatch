/*package com.clasealuracursos.clasescreenmatch;

import com.clasealuracursos.clasescreenmatch.principal.Principal;
import com.clasealuracursos.clasescreenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClasescreenmatchApplicationConsola implements CommandLineRunner {

	@Autowired
	private SerieRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ClasescreenmatchApplicationConsola.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	Principal principal=new Principal(repository);
	principal.muestraElMenu();

	}
}*/

