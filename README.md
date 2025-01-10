# clasescreenmatch
trabajajando con lambdas, streams y Spring Framework

![image](https://github.com/user-attachments/assets/3eed26f2-25d6-4db1-94b5-388741128880) 

Al digitar la serie de su interes, mostrara los datos de esta serie.

![image](https://github.com/user-attachments/assets/1339a9f2-3489-4173-ab3b-ba787795d986)

y las estadisticas de esta:
![image](https://github.com/user-attachments/assets/e37d55b5-1fc1-4280-a406-da32d7401207)

Se agregaron las siguientes funcionalidades:

![image](https://github.com/user-attachments/assets/a83f03e8-bb0c-4a04-866b-d01fea70a8c2)


ScreenMatch

ScreenMatch es una aplicación desarrollada en Java que utiliza el framework Spring y aprovecha características modernas de Java como expresiones lambda y streams. La aplicación tiene como objetivo gestionar información relacionada con episodios, temporadas y otras entidades del mundo del entretenimiento.

opcion 1:

![image](https://github.com/user-attachments/assets/61f45233-1ce6-4b7f-afab-ffb5f5dca393)

opcion 2:
![image](https://github.com/user-attachments/assets/07a200cc-817e-41db-aa67-707a5486310f)

![image](https://github.com/user-attachments/assets/d3618010-2602-4c6e-a704-afd19994671f)

opcion 3:
muestra las series buscadas
![image](https://github.com/user-attachments/assets/6c47f8a8-4ed4-4830-9448-cf16d712d170)


opcion 4.

![image](https://github.com/user-attachments/assets/14ab0b61-c54a-4ff3-8565-23ac1e9b84ca)


opcion 5:

![image](https://github.com/user-attachments/assets/3826c713-2290-440c-862b-bd8520a13791)


opcion 6:
![image](https://github.com/user-attachments/assets/d7f88e40-c61d-4dc3-92ad-7b3290cf2dcb)


opcion 7:

![image](https://github.com/user-attachments/assets/f3f33555-2b2d-46a8-a4c8-a7d700a50b04)

opcion 8:
![image](https://github.com/user-attachments/assets/4f6d73cc-38d3-4779-beec-69a957f46b43)

![image](https://github.com/user-attachments/assets/03584e2d-b949-41e4-a98d-48526106322d)

opcion 9:

![image](https://github.com/user-attachments/assets/c158189e-924f-4f20-82a6-3686dee73dcf)















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
