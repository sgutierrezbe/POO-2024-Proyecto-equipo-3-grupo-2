# POO-2024-Proyecto-equipo-3-grupo-2
# Proyecto grupal - Empresa de envíos
## Tabla de contenidos
- [Idea del proyecto](#idea-del-proyecto)
    - [Problema](#problema)
    - [Solución](#solucion)
- [Funcionalidades](#funcionalidades)
    - [Funcionalidad 1: Recibir solicitudes](#funcionalidad-1-recibir-solicitudes)
        - [Ingreso de Usuario](#ingreso-de-usuario)
        - [Mostrar Productos y Servicios](#mostrar-productos-y-servicios)
        - [Cerrar Sesión/Finalizar programa](#cerrar-sesiónfinalizar-programa)
    - [Funcionalidad 2: Manejo de excepciones](#funcionalidad-2-manejo-de-excepciones)
        - [Excepciones de Autenticación](#excepciones-de-autenticación)
        - [Excepciones de Transacción](#excepciones-de-transacción)
        - [Excepciones Generales](#excepciones-generales)
    - [Funcionalidad 3: Atender la solicitud](#funcionalidad-3-atender-la-solicitud)
        - [Actualización de Datos](#actualización-de-datos)
        - [Preparación y Envíos Productos/Servicios](#preparación-y-envío-productosservicios)
        - [Devoluciones de Productos/Servicios](#devoluciones-de-productosservicios)
    - [Funcionalidad 4: Costos y Tiempos](#funcionalidad-4-costos-y-tiempos)
        - [Simulación de Tiempo y Control de Inventario](#simulación-de-tiempo-y-control-de-inventario)
        - [Cálculo de Costos y Confirmaciones de Pago](#cálculo-de-costos-y-confirmaciones-de-pago)
        - [Gestión de Envios y Cancelaciones](#gestión-de-envíos-y-cancelaciones)
    - [Funcionalidad 5: Manejo de Clientes Frecuentes](#funcionalidad-5-manejo-de-clientes-frecuentes)
        - [Identificación de Clientes Frecuentes](#identificación-de-clientes-frecuentes)
        - [Aplicación de Descuentos](#aplicación-de-descuentos)
        - [Ofertas Especiales](#ofertas-especiales)
- [Impacto clases y objetos](#impacto-clases-y-objetos)
    - [Clases y descripción](#clases-y-descripción)
        - [Usuario](#usuario)
        - [InterfazConsola](#interfazconsola)
        - [ValidacionDatos](#validaciondatos)
        - [BaseDatosTemporal](#basedatostemporal)
        - [ManejoExcepciones](#manejoexcepciones)
        - [Inventario](#inventario)
        - [Servicio](#servicio)
        - [Producto](#producto)
        - [Tiempo](#tiempo)
        - [CalculoCostos](#calculocostos)
        - [HistorialCompras](#historialcompras)
        - [Descuento](#descuento)
        - [CarritoCompras](#carritocompras)
        - [Notificacion](#notificacion)
        - [Proveedor](#proveedor)
- [Diagrama de interacción](#diagrama-de-interaccion)
- [Diagrama de clase UML](#diagrama-de-clase-uml)

## Idea del proyecto
El proyecto es una simulación de un programa para la compra de servicios y productos por un usuario.<br>El Usuario debe realizar su ingreso dando su nombre, identificación y edad, luego debe elegir entre las opciones para comprar un producto o un servicio. El programa calcula los costos, los tiempos de servicio y retira el dinero. Así mismo se encarga automáticamente de la recolección de devoluciones y cancelaciones de servicios.

### Problema
Problema de entrega y calculo de costos de productos y servicios. ¿Cuánto cuestan los serivicos para una determinada persona?, ¿Puede la persona acceder a los servicios?, ¿Cómo se maneja la devolución de un producto?, ¿Qué hacer en casos de excepciones?, ¿Es el usuario un cliente común?<br>

### Solución
Se crea un programa para el manejo de todas las veriables y operaciones compuestas por varios factores para determinar los costos y retirar los servicios terminados a su debido momento.<br>El programa funciona automáticamente, procesa las solicitudes de los clientes y ofrece descuentos a clientes frecuentes.<br>El programa se encarga de los procesos complejos de interacciones entre las clases para el procesamiento de las distintas solicitudes y el tipo de cliente: Las opciones varían según la edad del cliente y sus datos personales: El programa recuerda los datos asociados a un cliente.<br>El programa evita el fraude, no pueden existir clientes con la misma ID y diferente nombre. <br>Los servicios a menores de edad solo pueden ser comprados por un adulto responsable. <br>Los productos y servicios se acaban, el programa tiene un tiempo de control, retira los servicios culminados o cancelados. El programa puede hacer uso del presupuesto para comprar nuevos productos.<br>El programa actúa cuando un cliente no paga o tiene comportamiento fraudulento.<br>
## Funcionalidades
Las 5 Funcionalides del programa son:<br> **1 => Recibir solicitudes**<br>**2 => Manejo de Excepciones**<br>**3=> Atender la solicitud**<br>**4 => Calcular costos y tiempos**<br>**5 => Manejo clientes frecuentes**

### Funcionalidad 1: Recibir Solicitudes
La primera funcionalidad es el núcleo del programa y la única interactuando directamente con el usuario.<br>El programa está orientado a recibir un único usuario a la vez, dada su naturaleza multi-usuario, los perfiles y los pedidos son simulados (o realizados) en la inicialización del programa. Durante la ejecución el usuario que ingresa los datos puede ingresar en una de las cuentas ya inicializadas, o crear una nueva.
#### Tres Interacciones =>
##### Ingreso de Usuario:
![diagrama preguntar](diagramas_funcionalidades/funcionalidad_1/preguntar.png)
**Objetos Involucrados:** Usuario, InterfazConsola, ValidacionDatos, BaseDatosTemporal.<br>
-> Se pregunta al usuario si desea ingresar o iniciar sesión. El objeto InterfazConsola se encarga de imprimir el mensaje y capturar la respuesta, Usuario almacena la información ingresada y ValidacionDatos verifica la validez de los datos. <br>
-> Si el usuario opta por iniciar sesión, InterfazConsola solicita identificación y contraseña, Usuario recupera los datos y ValidacionDatos verifica que coincidan con los registros.<br>
-> Si el usuario decide registrarse, InterfazConsola solicita datos personales (nombre, identificación, edad, género, etc), Usuario almacena estos datos y BaseDatosTemporal guarda esta información temporalmente (En la memoria RAM, los datos se borran al cerrarse el programa).
##### Mostrar Productos y Servicios:
![diagrama tiempo de ejecución](diagramas_funcionalidades/funcionalidad_1/tiempos.png)
**Objetos Involucrados:** Usuario, InterfazConsola, BaseDatosTemporal, Tiempo, Producto, Servicio, Notificacion.
-> El objeto InterfazConsola muestra al usuario los productos y servicios disponibles por consola, permitiendo al usuario comprar o contratar tantos como pueda. El usuario llena un carro de compras que más tarde pagará para confirmar el pedido. El objeto BaseDatosTemporal determina la disponibilidad y cantidad de los objetos para pasarlos a InterfazConsola, el objeto Tiempo determina el tiempo contratado para los Servicios.<br>
-> El objeto Notificación es almacenado en InterfazConsola por cada Entrega o servicio que el Usuario ha recibido, IOnterfazConsola puede imprimir las Notificaciones a comando de Usuario.
##### Cerrar Sesión/Finalizar programa:
**Objetos Involucrados:** Usuario, InterfazConsola, BaseDatosTemporal, Tiempo, Inventario, Notificacion.<br>
-> Se pregunta al usario si desea cerrar sesión, se cierra sesión.<br>
-> (El tiempo transcurre aún sin sesión iniciada) Se almacena en Usuario las notificaciones dadas por InterfazConsola para cualquier evento (Más adelante explicado), Llegada de producto, devolución Exitosa, espera de renovación de servicio, cancelación de servicio, etc. Inventario coordina con InterfazConsola la creación de notificaciones para actalizaciones.  <br>
-> Finalizar el programa.
![diagrama finalizar](diagramas_funcionalidades/funcionalidad_1/finalizar.jpg)

### Funcionalidad 2: Manejo de Excepciones
Esta funcionalidad determina excepciones como aquellas acciones que realiza el usuario que no se encuentran dentro del ciclo normal del programa, asegurando la continuidad y estabilidad del mismo.<br>No es CRUD, existe transformación de datos necesaria para el manejo de ciertas excepciones, procesos complejos necesarios para determinar excepciones e interacciones multiples entre clases.
#### Tres Interacciones =>
##### Excepciones de Autenticación:
**Objetos Involucrados:** Usuario, InterfazConsola, ManejoExcepciones, ValidacionDatos, BaseDatosTemporal.<br>
-> Si la edad del usuario es menor de 18, ManejoExcepciones es llamado para manejar la situación, imprimiendo un mensaje a través de InterfazConsola. Se llaman los métodos correspondientes para menejar la excepción.<br>
-> En caso de que el usuario ingrese una contraseña incorrecta, ManejoExcepciones maneja el error, solicitando una nueva entrada a través de InterfazConsola.<br>
-> Si se ingresa una identificación que ya existe, ManejoExcepciones alerta al usuario y solicita una nueva entrada, verificando los datos con BaseDatosTemporal.
##### Excepciones de Transacción:
**Objetos Involucrados:** Usuario, InterfazConsola, ManejoExcepciones, Producto, Servicio, Inventario, Proveedor, Tiempo.<br>
-> Si un producto es determinado como Defectuoso, ManejoExcepciones se encarga de gestionar la devolución o reemplazo (Existen características especiales en este proceso para los usarios "Cliente frecuente"), coordinando con Proveedor y actualizando Inventario.<br>
-> Si un servicio es determinado como "Incompleto", ManejoExcepciones gestiona la correción del servicio o el reembolso (Existen características especiales en este procesos para los usuarios "Cliente frecuente"), actualizando Servicio y Tiempo.<br>
-> Si un proveedor se queda sin stock, ManejoExcepciones coordina con Proveedor para la reposición y notifica al usuario a través de InterfazConsola.
##### Excepciones Generales:
**Objetos Involucrados:** Usuario, BaseDatosTemporal, ManejoExcepciones, Tiempo, InterfazConsola, ValidacionDatos.<br>
-> Si el usuario ingresa datos inválidos o fuera de los parámetros esperados, ManejoExcepciones solicita una nueva entrada a través de InterfazConsola.<br>
-> Si ocurren errores comunes tales como: Formato incorrecto en un Input, Datos superando el límite permitido, Omición de un campo obligatorio, Datos imposibles (Ejm: Fecha de nacimiento en el futuro), Errores de accesibilidad. ManejoExcepciones coordina con InterfazConsola para reintentar el ingreso. 

### Funcionalidad 3: Atender la Solicitud
Esta funcionalidad es el "background", es la funcionalidad que se encarga de procesar todas las solicitudes que el cliente ha realizado, interactuando principalmente con la funcioalidad 1. Algunos de sus procesos caen en el alcance de la funcionalidad 2, cuando ocurren excepciones durante el procesamiento de solicitudes, y es necesario salir del flujo normal del programa. <br>No es CRUD, existe transformación de datos. 
#### Tres Interacciones =>
##### Actualización de Datos:
**Objetos Involucrados:** Usuario, InterfazConsola, BaseDatosTemporal, ValidacionDatos<br>
-> El usuario ingresa un comando (Presente en InterfazConsola, Configuacion de cuenta) para actualizar sus datos. InterfazConsola captura el comando, Usuario actualiza los datos y BaseDatosTemporal guarda los cambios.<br>
-> Si es cambio de contraseña, InterfazConsola captura el comando, Usuario actualiza la contraseña y ValidacionDatos verifica la seguridad de la nueva contraseña. (si no cumple, recurre)<br>
-> ValidacionDatos asegura que los datos sean validos, (si no, entra en el alcance de ManejarExcepciones) Usuario actualiza los datos y BaseDatosTemporal guarda los cambios.
##### Preparación y Envío Productos/Servicios:
**Objetos Involucrados:** Usuario, Inventario, Producto, Servicio, Proveedor, Tiempo, InterfazConsola.
-> El usuario confirma el pedido (Se ha realizado el pago), Proveedor confirma el pago, InterfazConsola captura la confirmación, Inventario verifica la disponibilidad y Proveedor perapara los productos/Servicios.<br>
-> Tiempo gestiona el tiempo de envío (Automaticamente) y Proveedor se actualiza al llegar el producto o servicio, Usuario captura el Producto o Servicio.<br>
-> Para un servicio, Tiempo registra la duración del servicio y Proveedor activa el servicio correspondiente, InterazConsola informa al usuario. <br>
-> Tiempo determina el tiempo restante de un servicio, InterfazConsola informa al usuario, usuario renueva o no el servicio, Servicio se renueva o se detiene, Proveedor caputra el pago o retiene el servicio.
##### Devoluciones de Productos/Servicios:
**Objetos Involucrados:** Usuario, Inventario, Producto, Servicio, Proveedor, BaseDatosTemporal, Tiempo, InterfazConsola.<br>
-> El usuario solicita la devolución de un producto o servicio (A traves de InterfazConsola / Perfil / Servicios/Productos), InterfazConsola catpura y transmite la solicitud<br>
-> Inventario y Proveedor gestionan la recolección del producto o cancelación del servicio, Tiempo registra el proceso.

### Funcionalidad 4: Costos y Tiempos
Es la funcionalidad que describe el proceso en que se calculan los costos y se mueve el tiempo de simulación del programa. Esta directamente relacionada con todas las demás funcionalidades, pues sus efectos en el programa se reflejan en los productos, clientes, usuarios y la interfaz, que son clases que se encuentran en todas las funcionalidades. <br>No es CRUD, existe transformación de datos, determinado por el paso del tiempo y el calculo de costos. 
#### Tres Interacciones =>
##### Simulación de Tiempo y Control de Inventario:
**Objetos Involucrados:** Tiempo, Servicio, Producto, Inventario, InterfazConsola, Proveedor.<br>
-> Tiempo Simula el paso del tiempo, afectando la disponibilidad de productos y servicios.<br>
-> Proveedors se encarga de reponer el Stock cuando sea necesario,  Inventario captura y actualiza la disponibilidad de productos y servicios, InterfazConsola notifica al usuario.
##### Cálculo de Costos y Confirmaciones de Pago:
**Objetos Involucrados:** Usuario, Servicio, CalculoCostos, InterfazConsola, BaseDatosTemporal, Tiempo.<br>
-> CalculoCostos calcula el costo de los servicios y productos en función del historial del usuario (Sobre un precio base establecido por Proveedor sobre su producto o servicio). <br>
-> CalculoCostos calcula el costo de los servicios y productos en función del tiempo (Existen valores de Inflación, Impuestos, etc. Que cambian en el tiempo).<br>
-> InterfazConsola imprime en consola el costo total y solicita Pago, Usuario realiza el pago (El balance del usuario es un atributo, actualizable con sus propios métodos), Proveedor confirma el pago, BaseDatosTemporal guarda la información de la transacción.
##### Gestión de Envíos y Cancelaciones:
**Objetos Involucrados:** Usuario, Servicio, Producto, Inventario, InterfazConsola, Tiempo, Proveedor, ManejoExcepciones, BaseDatosTemporal.<br>
-> InterfazConsola notifica al usuario sobre el envío de productos y servicios contratados. Tiempo gestiona el Tiempo del envío y Proveedor recibe una calificación. (Usuario la otorga al momento de confirmar la entrega)<br>
-> Si un usuario cancela un servicio o devuelve un producto, InterfazConsola captura la solicitud, ManejoExcepciones verifica la válidez de la solicitud, Proveedor y Tiempo gestionan la cancelación, Inventario actualiza la disponibilidad del producto o servicio (Si es producto -> Proveedor elimina el defectuoso, y crea uno nuevo), BaseDatosTemporal guarda el intercambio, y Usuario recibe o no una devolución. 

### Funcionalidad 5: Manejo de Clientes Frecuentes
Es una característica especial del programa, creada con el propósito de promover el uso constante del programa por los clientes, en lugar de utilizar variedad de programas con las mismas funciones, otorgando beneficios para estos usuarios. Interactúa con la funcionalidad 1, mortando los beneficios y descuentos a los usarios, Manejo de excepciones se asegura de no existir errores en la identificación y aplicación de los beneficios. <br>No es CRUD, tiene interacciones con el resto de las clases y objetos del programa, cambiando y transformando distintos Datos, determinados por métodos de la clase Descuento. Afecta y es afectado, no es una simple lectura y creación de descuentos, se tienen en cuenta los aspectos creados en el ambiente simulado de otras clases, impidiendo descuentos excesivos o situaciones poco realistas que pongan en riesgo a los proveedores. 
#### Tres Interacciones =>
##### Identificación de Clientes Frecuentes:
**Objetos Involucrados:** Usuario, HistorialCompras, InterfazConsola, BaseDatosTemporal.<br>
-> HistorialCompras identifica a los clientes frecuentes basado en sus compras, Usuario almacena esta información e InterfazConsola notifica.<br>
-> Usuario almacena la información sobre la frecuencia de las compras (Incluyendo información como proveedor -> Esto afecta el calculo de descuentos) y la cantidad comprada, BaseDatosTemporal almacena los datos.
##### Aplicación de Descuentos:
**Objetos Involucrados:** Usuario, Descuento, BaseDatosTemporal, InterfazConsoloa, CalculoCostos, Producto, Servicio.<br>
-> Descuento calcula y aplica descuentos a clientes frecuentes, CalculoCostos calcula los ingresos a Proveedor, BaseDatosTemporal guarda la información actualizada de precios.<br>
-> BaseDatosTemporal guarda la transacción, si existe una devolución, Descuento genera excepciones coordinando con ManejoExcepciones, InterfazConsola notifica al Usuario.
##### Ofertas Especiales:
**Objetos Involucrados:** Usuario, Descuento, InterfazConsola, Producto, Servicio, Proveedor, Tiempo<br>
-> Descuento genera promociones y servicios exclusivos para los clientes frecuentes, Proveedor controla y maneja estos descuentos, denominados Eventos, Proveedor coordina con Tiempo la duración del descuento. (Devoluciones en eventos son consideradas excepciones, y manejados diferente para clientes frecuentes), InterfazConsola imprime en consola los eventos. 

## Impacto clases y objetos
Las 5 funcionalides interactúan entre sí, la primera funcionalidad entra en contacto con el cliente, la tercera funcionalidad maneja y cumple con las solicitudes del usuario (Siendo el Backend, o aquellos procesos que el usuario no ve), la segunda funcionalidad se encarga de asegurar que el programa se ejecute sin problemas en caso de ocurrir alguna situación que no está directamente en el ciclo normal del programa, manejando excepciones esperadas e inesperadas, la quinta funcionalidad es una carácterisitca del programa que identifica aquellos clientes frecuentes y les otorga diversos beneficios, por último, la funcionalidad 4 simula un tiempo de ejecución, del que dependen las otras funcionalidades para algunos de sus métodos. Así mismo, el tiempo afecta a los clientes. <br>
### Clases y Descripción:
#### Usuario: 
-> Almacena los datos personales del usuario, como nombre, identificación, edad, género, y el historial de compras y servicios.<br>
-> Usuario existe dentro de InterfazConsola, como Perfil, desde donde puede acceder a sus atributos, y verificar sus productos y compras. Desde esta interfaz puede solicitar devoluciones o cancelaciones.
#### InterfazConsola
-> Se encarga de imprimir mensajes en la consola y capturar la entrada del usuario. Es el puente de comunicación entre el programa y el usuario.<br>
-> Es una clase pública, todas las solicitudes de impresión en consola pasan por InterfazConsola.
#### ValidacionDatos
-> Verifica la validez de los datos ingresados por el usuario, como la identificación y la contraseña, y maneja el proceso de autenticación de usuarios. Asegura que los datos cumplen con los requisitos del sistema.<br>
-> Es una clase con atributos de clase, existe dentro de usuario.
#### BaseDatosTemporal
-> Almacena temporalmente los datos de los usuarios, productos, y servicios en la memoria RAM. Los datos se pierden cuando se cierra el programa.<br>
-> Transforma datos, transacciones y números, se actualiza durante la duración del programa, almacena los datos relevantes en diccionarios y listados.
#### ManejoExcepciones
-> Gestiona situaciones inesperadas o errores en el programa, como usuarios menores de edad, contraseñas incorrectas, o identificaciones duplicadas.<br>
-> Existe independienteme, es llamada automaticamente cuando se presenta una "excepción" y maneja el error por si misma, una vez realizado, retorna al flujo normal del programa.
#### Inventario
-> Administra la disponibilidad y cantidad de productos y servicios. Verifica el inventario durante las compras y actualiza el estado del inventario en base a las transacciones realizadas.
-> Existe dentro de base de datos, esta relacionada con Proveedor, contiene objetos de Producto y Servicio. Lleva a cabo interacciones CRUD básicas.
#### Servicio
-> Representa un servicio que puede ser contratado por el usuario. Almacena información sobre el tipo de servicio, duración, costo, y estado actual.<br>
-> Existe dentro de inventario, puede ser creado y modificado por Proveedor. Exiten múltiples servicios distintos. 
#### Producto
-> Representa un producto que puede ser comprado por el usuario. Almacena información sobre el tipo de producto, cantidad disponible, y costo.<br>
-> Existe dentro de inventario, puede ser creado y modificado por Proveedor. Está relacionado con un Proveedor, se relaciona con un usuario. 
#### Tiempo
-> Simula el paso del tiempo en el programa. Afecta la disponibilidad de servicios, calcula los costos en función del tiempo y permite avanzar, acelerar, y ralentizar el tiempo.<br>
-> Es automático y privado. Interactúa con todas las clases.
#### CalculoCostos
-> Calcula los costos de los servicios basados en el tiempo transcurrido y el historial del usuario. Actualiza los precios en función de estos cálculos.<br>
-> Es una clase sin objetos, sus métodos están directamente hechos para determinar los valores de los costos y que será impreso en pantalla. Interactúa con Proovedor y confirma las transacciones y pagos. 
#### HistorialCompras
-> Almacena el historial de compras de los usuarios. Identifica a los clientes frecuentes basándose en sus hábitos de compra y servicios contratados.<br>
-> Es un atrinuto de Cliente, existe dentro de BaseDatosTemporal, afecta CalculoCostos.
#### Descuento
-> Calcula y aplica descuentos a los clientes frecuentes, y genera promociones y servicios exclusivos para estos clientes. Almacena las políticas de descuentos y los beneficios aplicables.<br>
-> Existe en Proveedor, afecta los servicios y productos asociados con este. Tiene en cuenta el balance, e interactua con ManejoExcepciones para no crear situaciones desventajosas para el Proveedor o Usuario. 
#### CarritoCompras
-> Almacena temporalmente los productos y servicios seleccionados por el usuario antes de la compra final. Permite al usuario revisar y confirmar su pedido.<br>
-> Afecta a inventario y BaseDatosTemporal, pertenece a Usuario, es impreso en consola por InterfazConsola.
#### Notificacion
-> Maneja la comunicación de notificaciones importantes al usuario, como confirmaciones de pedidos, actualizaciones de estado de servicios y ofertas especiales.<br>
-> Es un atributo de Usuario, está directamente relacionada con InterfazConsola. El Usuario accede a sus notificaciones a través de InterfazConsola,  
#### Proveedor
-> Representa a un proveedor que ofrece productos y servicios a los usuarios. Almacena información sobre los productos y servicios que ofrece, su disponibilidad, y es afectado por el tiempo.

## Diagrama de interacción
