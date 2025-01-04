package com.clasealuracursos.clasescreenmatch.principal;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.clasealuracursos.clasescreenmatch.model.DatosEpisodio;
import com.clasealuracursos.clasescreenmatch.model.DatosSerie;
import com.clasealuracursos.clasescreenmatch.model.DatosTemporadas;
import com.clasealuracursos.clasescreenmatch.model.Episodio;
import com.clasealuracursos.clasescreenmatch.service.ConsumoAPI;
import com.clasealuracursos.clasescreenmatch.service.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado= new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE="https://omdbapi.com/?t=";
    private final String API_KEY ="&apikey=3909b9e4";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraElMenu(){
        System.out.println("Por fafvor escribe el nombre de la serie que deseas buscar");
        //Busca los datos generales de las series
        var nombreSerie = teclado.nextLine();
       var json=consumoAPI.obtenerDatos(URL_BASE+nombreSerie.replace(" ","+")+API_KEY );
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        //Busca los datos de todas las temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i=1; i<= datos.totalDeTemporadas(); i++){
            json=consumoAPI.obtenerDatos(URL_BASE+nombreSerie.replace(" ", "+")+"&Season="+i+API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }
        //temporadas.forEach(System.out::println);

        //Mostrar solo el titulo de los episodios para las temporadas
        for (int i = 0; i < datos.totalDeTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporada=temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++) {
                System.out.println(episodiosTemporada.get(j).titulo());

            }
        }
        //Mejoria usando funciones Lambda
        //temporadas.forEach(t ->t.episodios().forEach(e -> System.out.println(e.titulo())));

        //Convertir todas las inormaciones a una lista del tipo DatosEpisoio
        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t-> t.episodios().stream())
                .collect(Collectors.toList());

        //top 5 episodios
        /*System.out.println("Top 5 episodios");
        datosEpisodios.stream()
                .filter(e->!e.evaluacion().equalsIgnoreCase("N/A"))
                .peek(e-> System.out.println("Primer filtro (N/A"+e))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .peek(e-> System.out.println("Segundo ordenacion (M>m"+e))
                .limit(5)
                .map(e->e.titulo().toUpperCase())
                .peek(e-> System.out.println("Tercer filtro  Mayuscula (m>M)"+e))
                .limit(5)
                .forEach(System.out::println);*/

        //convirtiendo los datos a una lista del tipo episodio
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t ->t.episodios().stream()
                        .map(d->new Episodio(t.numero(),d)))
                .collect(Collectors.toList());
        //episodios.forEach(System.out::println);

        //Busqueda de episodios a partir de x año
    /*    System.out.println("por favor indica el año a partir del cual deseas ver los episodios");
        var fecha = teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha,1,1);*/

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
     /*   episodios.stream()
                .filter(e->e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e-> System.out.println(
                    "Temporada"+ e.getTemporada()+
                            "Episodio"+e.getTitulo()+
                            "Fecha de lanzamiento"+e.getFechaDeLanzamiento().format(dtf)
                ));*/

        //busca espisodio por un pedazo de titulo
      /*  System.out.println("Por favor escriba el titulo del episodio que desa ver");
        var pedazoTitulo = teclado.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
                .findFirst();
        if(episodioBuscado.isPresent()){
            System.out.println("Episodio encontrado");
            System.out.println("Los datos sn:" + episodioBuscado.get());
        }else{
            System.out.println("Episodio no encontrado");
        }*/

        Map<Integer, Double> evaluacionesPorTemporada=episodios.stream()
                .filter(e-> e.getEvaluacion()>0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada, Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println(evaluacionesPorTemporada);

        DoubleSummaryStatistics est=episodios.stream()
                .filter(e->e.getEvaluacion()>0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println("La media de las evaluaciones: "+est.getAverage());
        System.out.println("Episodio Mejor evaluado: "+est.getMax());
        System.out.println("Episodio peo evaludado: "+ est.getMin());
    }
}
