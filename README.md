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
Problema de entrega y calculo de costos de productos y servicios. ¿Cuánto cuestan los serivicos para una determinada persona?, ¿Puede la persona acceder a los servicios?, ¿Cómo se maneja la devolución de un producto?, ¿Qué hacer en casos de excepciones?, ¿Es el usuario un cliente común?<br>El problema de la comunicación entre usuarios y vendedores, la necesidad de una herramienta para llegar a usuarios más allá de los un pequeño punto local y expandirse, La necesidad de una herramienta capaz de controlar o ayudarnos a percibir nuestros gastos y ayudar con la automatización de contratación de servicios necesarios, también son problemas que se toman en nuestro programa.

### Solución
Se crea un programa para el manejo de todas las variables y operaciones compuestas por varios factores para determinar los costos y retirar los servicios terminados a su debido momento.<br>El programa funciona automáticamente, procesa las solicitudes de los clientes y ofrece descuentos a clientes frecuentes.<br>El programa se encarga de los procesos complejos de interacciones entre las clases para el procesamiento de las distintas solicitudes y el tipo de cliente: Las opciones varían según la edad del cliente y sus datos personales: El programa recuerda los datos asociados a un cliente.<br>El programa evita el fraude, no pueden existir clientes con la misma ID y diferente nombre. <br>Los servicios a menores de edad solo pueden ser comprados por un adulto responsable. <br>Los productos y servicios se acaban, el programa tiene un tiempo de control, retira los servicios culminados o cancelados. El programa puede hacer uso del presupuesto para comprar nuevos productos.<br>El programa actúa cuando un cliente no paga o tiene comportamiento fraudulento.<br>
## Funcionalidades
Las 5 Funcionalides del programa son:<br> **1 => Recibir solicitudes**<br>**2 => Manejo de Excepciones**<br>**3=> Atender la solicitud**<br>**4 => Calcular costos y tiempos**<br>**5 => Manejo clientes frecuentes**

### Funcionalidad 1: Ingreso
La primera funcionalidad es la entrada al programa.<br>
Dentro del programa es la encargada del proceso de inicio de sesión o registro, compra de servicios y/o productos, contacto con los vendedores, devoluciones, actualización de datos personales, transacciones y actualización de balance, descuentos y ofertas especiales, subscripciones y membresías.<br>La primera Funcionalidad afecta todas las funcionalidades:<br>
- La segunda funcionalidad depende de una cuenta para poder ser un vendedor, el balance y las transacciones son un proceso importante durante la venta de los productos desde el punto de un vendedor, la cantidad de productos comprados por cliente y las preferencias establecidas por los mismos.<br>Así mismo, las membresías y subscripciones que el vendedor tiene determina su capacidad de suibir de nivel y le permite ofrecer servicios y productos a usuarios más lejanos (Esto depende del balance, calificación e historial de ventas)<br>
- La tercera funcionalidad es un paso directo después de la primera, es el proceso de la entrega de los productos o servicios, depende de si estos fueron o no comprados, en caso de que no, los domiciliarios y vendedores dentro del programa tendrán consecuencias negativas, tales como la posibilidad de bancarrota. <br>
En caso de haber productos y/o servicios comprados, estos se calculan, incluidos con la frecuencia de estas compras, para determinar la posibilidad de ingresar al usuario en un programa de fidelización.<br> Así mismo, la distancia y cantidad de productos o servicios contratados (Si son servicios que requieren de un producto asociado, ejemplo el alquiler de un vehículo), afectan el costo de los domiciliarios, el tiempo de entrega, y la cantidad de prodcutos a transportar (Afectando a su vez, el medio de transporte en que será llevado el producto). 
- La cuarta funcionalidad entra directamente después de la primera y/o la tercera, en cualquiera de los dos casos el usuario puede dar una calificación a vendedores y/o domiciliarios, estos afectan el desempeño de los servicios, la velocidad de las entregas, el dinero devuelto en un reembolso, la posibilidad de aparecer en el "feed" de recomendados para los demás "clientes".<br>
- La quinta funcionalidad, hace uso del balance, la configuración de preferencias del usuario, la cantidad de compras, los servicios y la cantidad de servicios recontratados para determinar como gestionar el presupuesto, que vendedores cercanos pueden interesar para la compra de productos reduciendo costos de envío, el uso de promociones, membresías y subscripciones para acceder a beneficios especiales y ahorrar.
#### Tres Interacciones =>
##### Comprar/Contratar:
**Objetos Involucrados:** ---.<br>
-> Se ingresa al programa, por defecto, el usuario es un tipo de usuario especial "invitado"; Cuando un invitado está en el progrma, puede: Ver los productos, realizar busquedas con filtros y consultar los precios de los servicios, así como los vendedores. Un invitado no puede comprar, y no tiene acceso a servicios y productos enfocados a mayores de edad. <br>
-> Si un invitado lo desea, puede iniciar sesión en una "cuenta" (Un objeto inicializado en el main del programa, preexistente) o puede registrarse; El registro es un proceso simple dónde se toman los siguientes datos obligatorios: Nombre, edad, ubicación, contraseña, clave de recuperación, número de identificación y género.<br>Son opcionales: Preferencias, balance, tarjeta de credito, tarjeta de debito.<br>
-> Una vez con una cuenta, el usuario puede buscar productos o servicios:<br>Existe una busqueda normal, busqueda avanzada y recomendados.<br>
La busqueda normal puede accederse desde la "interfaz", dónde el usuario da la orden y puede buscar palabras claves tales como: vendedor, tipo de producto, precio, servicio, tipo de servicio.<br>
La busqueda avanzada permite varios filtros a la vez, incluyendo los anteriores, incluye ordenar de mayor a menor precio, de mayor a menor calificación, según la cercanía al lugar, más vendidos, ubicación específica (País, Ciudad, etc). Las instrucciones son claras y son dadas al usuario cada vez que utilizará el filtro, ejemplo: Usar "o" si desea que el producto/servicio buscado tenga una o ambas características, usar "&" si desea que el producto/servicio tenga ambar características, usar "-no" si desea que el producto/servicio no tenga la característica, etc.<br>
Las recomendaciones muestran al usuario los productos/servicios más probables a que quiera comprar/contratar (Según sus compras previas, y si no tiene, según su popularidad y calificación).<br>
-> Una vez realizadas las busquedas, el usuario añade a un carro todos los productos/servicios que desea, cuando este completa el carro, pasa al proceso de pago, dado que no existe manera de confirmar que el dinero exista, se pregunta por un número de tarjeta de débito o crédito en caso de no tener una asociada a su cuenta (Recordar, era un campo opcional) y si es "válida" el pago será exitoso. Si tiene una tarjeta asociada no es necesario. También es posible tener dinero dentro del programa, que es el "balance", este se transfiere en un proceso similar al pago, simplemente dando un número de tarjeta "válido" y un monto, que se transfiere al usuario. Si el usuario tiene un balance, el dinero de su compra se descuenta de este.<br>
-> Sí el usuario tiene un balance, y tiene un servicio contratado con auto-renovación, llegado el tiempo de finalización del servicio, se descontará automáticamente del balance el consto de la renovación del servicio.<br>
-> Los productos son confirmados al llegar. <br>
-> El usuario puede cerrar sesión, en cuyo caso el programa NO SE CIERRA, si no que vuelve al estado de "invitado", los productos comprados aún serán enviados y serán confirmados automaticamente a su llegada.<br>
-> Una vez cerrada sesión, el usuario puede iniciar sesión en otra "cuenta" o en la misma, en caso de olvidar la contraseña, se debe utilizar la clave de recuperación. (Si no se tiene la clave ni contraseña, es imposible iniciar sesión)<br>
##### Descuentos y membresías:<br>
**Objetos Involucrados:**---<br>
-> El usuario puede elegir, una vez tiene una cuenta, si desea o no suscribirse a un vendedor en específico, una subscripción le permite al usuario:<br>
- Recibir notificaciones de nuevos productos del vendedor<br>
- Recibir notificaciones de nuevos servicios del vendedor<br>
- Recibir notificaciones de eventos, ofertas especiales, descuentos y promociones del vendedor<br>
-> El usuario puede comprar una membresía, si el vendedor ofrece servicios, que se puede o no renovar automáticamente y que tiene beneficios establecidos por el vendedor según su nivel, lo más común será:<br>
- Membresía nivel 1: Acceso a descuentos especiales con el vendedor o marcas del vendedor, alta prioridad, garantía por fallas y daños.<br>
- Membresía nivel 2: Mismos beneficios que el nivel 1, regalos, tickets de permisos especiales<br>
- Membresía nivel 3: Mismos beneficios que el nivel 2, servicios adicionales, acceso temprano a nuevos servicios y productos del vendedor<br>
-> Se hace automáticamente que un usuario puede ser catalogado como un "cliente frecuente" o "cliente indeseado", respecto a uno o varios vendedores, según la cantidad de compras que realice, si se nota que un usuario compra más a un vendedor al que no está subscrito, se catalogará como un cliente frecuente y se le enviarán notificaciones de los productos y/o servicios mas comprados/contratados por el usuario cuando se encuentren disponibles (no de todos, a diferencia de la subscripción), así mismo, el vendedor podrá configurar eventos y ofertas especiales para los clientes frecuentes. (Ejemplo, mayor reducción de precios de productos perecederos).<br>
Si el cliente realiza múltiples devoluciones, o da muchas malas calificaciones (característica de la funcionalidad 4), puede ser catalogado como un "cliente indeseado", los vendedores entonces podrán rechazar pedidos de este tipo de clientes (En caso de haber recibido múltiples devoluciones de un producto, o quejas de un servicio), así mismo un usuario catalogado como "cliente indeseado" por muchos vendedores, podrá ver su cuenta suspendida (En caso de tener un balance en la cuenta, este podrá retirarse), así como sus calificaciones tendrán minima repercucíón (Característica de la funcionalidad 4).<br>
##### Devoluciones, cancelaciones y reembolsos:<br>
**Objetos Involucrados:** ---<br>
-> Si el usuario acaba de recibir un producto, puede solicitar una devolución del mismo en un tiempo limite después de la entrega.<br>
-> Las devoluciones pueden no ser aceptadas, de acuerdo a la calificación del vendedor, si esta es muy alta, puede ser rechazada una devolución al considerarse inválida (Una simulación de una solicitud de devolución inválida, dado que no existen vendedores o compradores humanos, se implementa como una probabilidad en el proceso que depende de la calificación del vendedor)<br>
-> Si es un producto perecedero, puede darse el caso que el tiempo que tardó en llegar el producto haya sido suficiente para que caduque, en cuyo caso se realiza un nuevo envío sin costos adicionales. En caso de tener una membresía, pueden existir adiciones especiales como disculpas<br>
-> Si es la cancelación de un servicio, si el servicio requiere un producto asociado (Ejemplo: Alquiler de un auto), el usuario tendrá que informar del estado del producto en el tiempo de la solicitud de cancelación, y en caso de existir un cálculo de costos por el tiempo estimado de uso, el usuario puede recibir una parte del costo del serivicio pagado. Si el usuario daña el producto en el tiempo que se tarda en recoger el producto, podrá enfrentar cargos adicionales. (La posibilidad de daño es arbitraria durante la prueba del programa, se puede elegir si al usar el producto del servicio este se daña)<br>
-> Si se cancela un servicio sin producto asociado, el servicio será válido hasta la fecha de restauración. <br>
-> Si un vendedor cae en bancarrota o desaparece, cualquier producto que estuviese en proceso de envío podrá ser devuelto (Si el vendedor lo decide), en cuyo caso se retornará el costo del mismo en el monto del usuario y se le notificará. En caso de ser un servicio, se retirarán los productos si tiene (Si hay daños, dado que el vendedor ya no existirá no habrán cargos adicionales), o no podrá ser accedido si no tiene productos, incluso si no ha llegado la fecha de renovación, en cuyo caso se devolverá una parte del costo del servicio (Según la cantidad de días restantes).<br>
-> Los objetos devueltos tendrán una etiqueta, en caso de no ser perecederos, y podrán ser encontrados en promociones y/o eventos de los vendedores.<br>
### Funcionalidad 2: Vender
Esta funcionalidad puede venir después de la primera, dado que requiere la creación de una cuenta.<br>
El usuario podrá decidir vender productos, cuando un usuario es vendedor, puede elegir entre distintos tipos: vendedor casual y total. Los vendedores son cuentas de usuarios que están directamente conectadas al programa y deben pagarle, para cubrir el costo de domiciliarios, impuestos y publicidad (En forma de notificaciones a los usuarios por subscripciones, eventos, etc).<br>
Los vendedores tienen niveles, que se determinan por su cantidad de ventas, sus clientes subscritos y su balance. <br>
Esta funcionalidad describe la solución del programa para vender productos y/o ofrecer servicios, se puede aumentar el alcance como vendedor subiendo ventas y obteniendo mayor balance. La segunda funcionalidad afecta y se ve afectada por las otras funcionalidades:<br>
- La primera funcionalidad, una vez creada una nueva cuenta de tipo vendedor, sus productos podrán ser encontrados desde otras "cuentas" de usuario, dónde se podrán comprar y solicitar.<br>
- La tercera funcionalidad utiliza la ubicación del vendedor, el nivel, y la cantidad de productos (Así como si son o no perecederos) en espera de envío, para establecer la prioridad de envío de los mismos. <br>
- la cuarta funcionalidad es actualizada, y se ofrece la capacidad de calificar (privadamente) a los usuarios comunes que han comprado productos o contratado servicios, permitiendo acceso a nuevas características de la funcionalidad 3.<br>
- La quinta funcionalidad cambia, e incluye dentro de sus características la administración de ganancias, programación de eventos, ofertas especiales, metas y cantidad de subscriptores. <br>
#### Tres Interacciones =>
##### Convertirse en vendedor:<br>
**Objetos Involucrados:** ---<br>
-> El usuario puede elegir volverse un vendedor, para ello entrará en la configuración de cuenta, y elegirá ser un vendedor, aparecerán 2 opciones: Vendor casual y vendedor total.<br> El usuario elige entonces una de las opciones, en cada caso:<br>
- Vendedor casual: el usuario podrá seguir usando su "cuenta" para comprar productos, acceder a subscripciones, etc. Adicionalmente, podrá realizar ventas de productos o prestar un servicio. En caso de querer vender un producto, tendrá que elegir su tipo, nombre, si es o no perecedero y su precio. El vendedor casual podrá realizar promociones y eventos.<br>
- Vendedor total: El usuario perderá la capacidad de comprar cosas con su cuenta, en su lugar, podrá acceder a los niveles, dónde podrá expandirse y llegar a mercados internacionales. El vendedor total solo permanecerá como tal siempre y cuando pueda pagar los costos de hosteo, publicidad y ventas mínimas (Que varían según el nivel).
-> El usuario vendedor podrá hacer uso de un atributo inventario, que le permitirá guardar los productos que tiene a la venta. <br>
-> 
##### ---:
**Objetos Involucrados:** ---<br>
##### ---:
**Objetos Involucrados:** ---<br>

### Funcionalidad 3: Envío
---
#### Tres Interacciones =>
##### Cálculo de costos:
**Objetos Involucrados:** ---.<br>
##### ---:
**Objetos Involucrados:** ---.<br>
##### ---:
**Objetos Involucrados:** ---<br>
### Funcionalidad 4: Calificaciones y puntos
---
#### Tres Interacciones =>
##### ---:
**Objetos Involucrados:** ---.<br>
##### ---:
**Objetos Involucrados:** ---. <br>
##### ---:
**Objetos Involucrados:** ---.<br>

### Funcionalidad 5: Finanzas y presupuesto personal

#### Tres Interacciones =>
##### ---: 
**Objetos Involucrados:** ---.<br>

##### ---:
**Objetos Involucrados:** ---.<br>

##### ---:
**Objetos Involucrados:** ---<br>
 

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
