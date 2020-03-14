                                                     # PRUEBA JUNIOR DEVELOPER
aqui se subira la prueba de junior developer

# INFORMACION ADICIONAL: para consumir las peticiones que tiene para ofrecer este programa se ofrecen 6 links

Agregar Articulo (POST)(inserta en el body en formato JSON el Articulo)
http://localhost:8080/articles/

Editar Articulo (PUT)(inserta en el body en formato JSON el Articulo)
http://localhost:8080/articles/id

Eliminar Articulo (DELETE)
http://localhost:8080/articles/id

Lista de articulos por autor(GET)
http://localhost:8080/articles/author=ingresaElAutorAqui

Lista de articulos por periodo (GET)
http://localhost:8080/articles/minperiod=yyyy:MM:dd/maxperiod=yyyy:MM:dd

Lista de articulos por Palabra Clave (GET)
http://localhost:8080/articles/keyword=ingresaLaPalabraClaveAqui


## pequeño indice

- introduccion
- base de datos
- pequeña descripcion del patron utilizado
- notas propias respecto al programa


## introduccion

el programa se trata de proporcionar con servicios RESTful informacion sobre los articulos que se ven la Aplicacion del cliente

el objetivo, o lo unico que se pide en este examen es que la API les pueda devolver:

- Poder crear, editar y borrar Articulos a necesidad.
- Listar todos los articulos disponibles en base al autor
- Listar todos los articulos en base a un periodo de tiempo
- Listar todos los articulos en base a una palabra clave


## Base de Datos

se creo una base de datos en el servidor MySQL llamada 'testrest'. la BBDD, tiene las siguientes tablas:


![Captura](https://user-images.githubusercontent.com/59231896/76350516-4a7c1c00-62e2-11ea-8400-cad33a6b1565.JPG)


NOTA: tanto como usuario o perfiles no entran dentro de las peticiones del programa, sin embargo como estuve haciendo el proyecto 
utilizando la platafomra de Spring Boot con Spring Security, pense que seria buena idea crearlos (aunque luego los descartara)

NOTA 2: el autor pudo haber sido un atributo simple de la tabla de Articulos pero al haber creado un usuario, pero lo relacione al 
'usuario' que estuviese conectado en ese momento.

dejare el archivo .sql en este repositorio para que puedas agregarlo a tu BBDD y probar en caso que sea necesario.

[testrestDataBase.txt](https://github.com/ORCA-Soft-MiguelAngel/PruebaJuniorDeveloper/files/4333343/testrestDataBase.txt)

## Pequeña Descripcion del patron

se uso PARTE del patron clasico MVC para la realizacion de este proyecto,(la vista no esta por que es solo una Restful API) donde:

- en el paquete de 'com.miguel.app.RestArticleProvider.model' se encuentran todas las entidades relacionadas con la base de datos.
- en el paquete de 'com.miguel.app.RestArticleProvider.repository' se encuentran los repositorios JPA para la implementacion de 
  los metodos CRUD y personalizados para conseguir informacion desde nuestra Base de Datos
- en el paquete de 'com.miguel.app.RestArticleProvider.service' se encuentran nuestras interfaces de servicio, que se inyectaran en el
  controlador para su implementacion
- en el paquete de 'com.miguel.app.RestArticleProvider.controller' se encuentra el RestContoller, que maneja nuestra capa de negocio.
- en el paquete de 'com.miguel.app.RestArticleProvider.security' se encuentra todo lo relacionado con Spring security.


nota: proximamente pondre el diagrama UML para que se vea mas claro todo.


## Notas propias respecto al programa

- Apesar de utilizar Spring Security, para mayor facilidad de probar el programa simplemente deshabilite el login y desprotegi las
  url que mapean a los controladores
- Todas las peticiones GET que se pidan a este REST solo pueden ser captadas por una URL? osea, si no puede ser enviado por un formulario
  o algo... al no saber la naturaleza del app del cliente me vi obligado a trabajar las peticiones por url excepto el metodo del controlador
  que implemento el POST REQUEST, porque asumi que provendria de un formulario.
- no sabia si la palabra clave se trataba de cualquier cadena de texto que pudiera contener los detalles del articulo o simplemente eran
  tags. me fui por el camino de los tags
