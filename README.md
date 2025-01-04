# clasescreenmatch
trabajajando con lambdas, streams y Spring Framework

![image](https://github.com/user-attachments/assets/3eed26f2-25d6-4db1-94b5-388741128880) 

Al digitar la serie de su interes, mostrara los datos de esta serie.

![image](https://github.com/user-attachments/assets/1339a9f2-3489-4173-ab3b-ba787795d986)

y las estadisticas de esta:
![image](https://github.com/user-attachments/assets/e37d55b5-1fc1-4280-a406-da32d7401207)


tambien encontrara todo el recorrido creado en la clase AluraLatam, con el codigo comentado por si se requiere.



ScreenMatch

ScreenMatch es una aplicación desarrollada en Java que utiliza el framework Spring y aprovecha características modernas de Java como expresiones lambda y streams. La aplicación tiene como objetivo gestionar información relacionada con episodios, temporadas y otras entidades del mundo del entretenimiento.



<h1>
Tecnologías Utilizadas
</h1>

Java 17: Lenguaje de programación principal de la aplicación.

Spring Framework: Para la configuración y el manejo del contexto de la aplicación.

Lambdas y Streams: Para realizar operaciones funcionales sobre colecciones y mejorar la legibilidad del código.




<h1>Características Principales</h1>

Gestión de episodios y temporadas:

Creación y manejo de episodios con propiedades como número de episodio, evaluación, título y fecha de lanzamiento.

Uso de streams para procesar colecciones de episodios de forma eficiente.

Procesamiento funcional con streams y lambdas:

Uso de filtros, mapeos y otras operaciones para transformar y extraer datos de listas.

Simplificación del código mediante expresiones lambda.

Integración con Spring:

Configuración de la aplicación usando el contexto de Spring.

Modularidad y escalabilidad gracias a la arquitectura de Spring.




<h1>Requisitos Previos</h1>

JDK 17 o superior.

Maven para la gestión de dependencias.

Instalación y Ejecución

Clona el repositorio:

git clone <URL_DEL_REPOSITORIO>

Navega al directorio del proyecto:

cd screenMatch

Compila y ejecuta la aplicación:

mvn spring-boot:run




<h1>Ejemplo de Código</h1>




Uso de Streams y Lambdas

List<Episodio> episodios = listaDeEpisodios.stream()
    .filter(e -> e.getEvaluacion() > 7.0)
    .sorted(Comparator.comparing(Episodio::getFechaDeLanzamiento))
    .collect(Collectors.toList());




Uso de Spring Framework

@SpringBootApplication
public class ScreenMatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScreenMatchApplication.class, args);
    }
}




Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras algún problema o tienes ideas para mejorar la aplicación, no dudes en abrir un issue o un pull request.
