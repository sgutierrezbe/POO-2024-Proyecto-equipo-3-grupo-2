# POO-2024-Proyecto-equipo-3-grupo-2
# Proyecto grupal - Empresa de envíos
## Tabla de contenidos
- [Idea del proyecto](#idea-del-proyecto)
    - [Problema](#problema)
    - [Solución](#solucion)
- [Funcionalidades](#funcionalidades)
    - [Función Recibir solicitudes](#funcion-recibir-solicitudes)
    - [Función Manejar excepciones](#funcion-manejar-excepciones)
    - [Función Atender la solicitud](#funcion-atender-la-solicitud)
    - [Función calcular costos y tiempos](#funcion-calcular-costos-y-envios)
    - [Función Manejo clientes frecuentes](#funcion-manejo-clientes-frecuentes)
- [Impacto clases y objetos](#impacto-clases-y-objetos)
- [Diagrama de interacción](#diagrama-de-interaccion)
- [Diagrama de clase UML](#diagrama-de-clase-uml)

## Idea del proyecto
El proyecto es una simulación de un programa para la compra de servicios y productos por un usuario.<br>El Usuario debe realizar su ingreso dando su nombre, identificación y edad, luego debe elegir entre las opciones para comprar un producto o un servicio. El programa calcula los costos, los tiempos de servicio y retira el dinero. Así mismo se encarga automáticamente de la recolección de devoluciones y cancelaciones de servicios.

### Problema
Problema de entrega y calculo de costos de productos y servicios. ¿Cuánto cuestan los serivicos para una determinada persona?, ¿Puede la persona acceder a los servicios?, ¿Cómo se maneja la devolución de un producto?, ¿Qué hacer en casos de excepciones?, ¿Es el usuario un cliente común?<br>

### Solución
Se crea un programa para el manejo de todas las veriables y operaciones compuestas por varios factores para determinar los costos y retirar los servicios terminados a su debido momento.<br>El programa funciona automáticamente, procesa las solicitudes de los clientes y ofrece descuentos a clientes frecuentes.<br>El programa se encarga de los procesos complejos de interacciones entre las clases para el procesamiento de las distintas solicitudes y el tipo de cliente: Las opciones varían según la edad del cliente y sus datos personales: El programa recuerda los datos asociados a un cliente.<br>El programa evita el fraude, no pueden existir clientes con la misma ID y diferente nombre. <br>Los servicios a menores de edad solo pueden ser comprados por un adulto responsable. <br>Los productos y servicios se acaban, el programa tiene un tiempo de control, retira los servicios culminados o cancelados. El programa puede hacer uso del presupuesto para comprar nuevos productos.<br>El programa actúa cuando un cliente no paga o tiene comportamiento fraudulento.<br>
## Funcionalidades
Las 5 Funcionalides del programa son:<br> **1 => Recibir solicitudes**<br>**2 => Manejar Excepciones**<br>**3=> Atender la solicitud**<br>**4 => Calcular costos y tiempos**<br>**5 => Manejo clientes frecuentes**

### Función Recibir solicitudes
La primera funcionalidad que es el núcleo del programa y la única con interacción constante con el usuario.<br>
El programa está orientado a recibir un único usuario a la vez, sin embargo puede interactuar con varios usuarios. Las opciones desplegadas están o no disponibles dependiendo de la cantidad de esta opción disponible, o si ya está siendo solicitada por otro usuario.<br>
#### **Primera Interacción: Preguntar**: 
![diagrama preguntar](diagramas_funciones/funcionalidad_1/preguntar.png)
<!-- <img src="diagramas_funciones/funcionalidad_1/preguntar.png" alt="diagrama preguntar"/> -->
Gira en torno al usuario, es la primera parte y es el registro o inicio de sesión, es CRUD, solo lee la información proporcionada por el usuario y llama a la función **Manejar Excepciones** en caso de ser necesario (Casos necesarios son marcados con rojo).<br> #Añadir las clases que interactúan, describir los métodos planteados.
#### **Segunda Interacción: Tiempo de ejecución**
![diagrama tiempo de ejecución](diagramas_funciones/funcionalidad_1/tiempos.png)
Gira en torno al usuario, está conectada principalmente con la función **calcular costos y tiempos**, A la cual llama cuando es necesario. Presenta al usuario con las opciones y crea el carro de compras, separa servicios y productos, guarda el tiempo de servicio contratado. 
## Impacto clases y objetos
Las 3 funcionalides interactúan entre sí para los calculos del costo, el tiempo de envío y la llegada de los productos. Las clases Paquete, Bodega, Organizador y Domiciliario tienen estados, que dependen de la clase tiempo y de los límites dados por su capacidad de contención de otros objetos, Las clases Vendedor y Empresa (con sus subclases) interactúan con los objetos de las demás clases y determinan su capacidad de continuar, principalmente dependen de las instancias de Comprador para manetener dinero en sus carteras, el dinero se mueve constantemente y depende del tiempo, cuando no hay dinero los vendedores no pueden satisfacer a los Compradores y las empresas son Destruidas (Caen en bancarrota). <br>


## Diagrama de interacción
