# POO-2024-Proyecto-equipo-3-grupo-2
# Proyecto grupal - Empresa de envíos
## Tabla de contenidos
- [Idea del proyecto](#idea-del-proyecto)
    - [Problema](#problema)
    - [Solución](#solucion)
- [Funcionalidades](#funcionalidades)
    - [Tres interacciones](#tres-interacciones)
        - [Función-Enviar Productos](#funcion-enviar-productos)
        - [Función-Calcular Costos](#funcion-calcular-costos)
        - [Función-Controlar tiempos Envio](#funcion-calcular-tiempos-envio)
    - [Interacción clases](interacciones-de-clases)
    - [Impacto clases y objetos](#impacto-clases-y-objetos)
    - [progresión objetivo final](#progresion-objetivo-final)
-[Diagrama de interacción](#diagrama-de-interaccion)
-[Diagrama de clase UML](#diagrama-de-clase-uml)

## Idea del proyecto

### Problema:
Problema de administración, distribución, orden y envío de paquetes en una empresa de servicio a domicilio. ¿Dónde se almacenan los productos?, ¿Qué productos pueden ser incluidos en un mismo paquete, según su peso, volumen y lugar de envío?, ¿Cuánto espacio tienen disponibles las bodegas?, ¿Qué tamaño tienen los paquetes individuales?, ¿A dónde se envían?, ¿Cuál es el peso del paquete?, ¿Qué medio de transporte es necesario?, ¿Cuál es el precio estimado de envío?, y ¿Cómo controlar la puntualidad en el proceso?

### Solución
Se definen en un programa los actores dentro del ecosistema de una empresa de servicio de Paqueteria: **Comprador**, **Vendedor**, **Producto**, **Paquete**, **orden** **Domiciliario** (Subclases -> Persona, Automovil, Camion, Motocicleta, Bicicleta, Avion),  **Mapa**, **Organizador** (Subclases -> Distribuidor_Productos, Distribuidor_Paquetes, Distribuidor_Vendedores), **Empresa** (Subclases -> Empresa_Principal, Empresa_Local), **Bodega**, **Fecha**, <br>Las instancias de la clase Empresa_Principal envían Domiciliarios para recoger los Productos de los Vendedores para su posterior transporte a los Compradores, estos productos están relacionados con una instancia de clases Vendedor, que indica la fecha de entrega del producto a la empresa y la ubicacion de su bodega en el mapa, para su recolección y distribución la Empresa_Principal interactúa con las instancias de organizadores Distribuidor_Productos que, dado el peso y volumen de cada producto, crean instancias de paquetes en que guardar el o los productos, o los guardan en instancias de paquetes existentes, que serán seleccionados para guardarse en una bodega por los Organizadores Distribuidor_Paquetes. <br>La clase mapa será necesaria para determinar la cercanía (con un sistema de coordenadas de 2 dimensiones) y favorabilidad para la creación de paquetes y su distribución a las bodegas más cercanas a su destino, siempre y cuando tanto la direccion de el vendedor y el comprador se encuentre en el mismo pais (Pertenecientes a Empresas_Locales). Dado el peso y el volumen final de un paquete (Y su estado), este será dado a una instancia de Domiciliario, que entregará el paquete a la bodega más cercana a sus destinos, dónde el paquete será separado y distribuído en sus productos respectivos para su envío final a su destinatario. Cada Domiciliario interactuará con las bodegas, Compradores, paquetes y productos independientes, determinando cuando un producto a llegado a su destino.

## Funcionalidades
Las Funcionalidades iniciales planteadas para el programa son: **Enviar Productos**, **Calcular Costos** y **Controlar Tiempos de Envío**.

### Tres interacciones
#### Función-Enviar Productos:
**Solicitud**: Es la principal interacción, esta es dada de los Compradores a los Vendedores, Los Vendedores solicitan a los Organizdores Distribuidor_Vendedores crear Paquetes con los Productos, que luego solicitan envío por una Empresa_Principal, la Empresa_Principal solicita a los organizadores Distribuidor_Productos, que a su vez solicitan a los domicilarios y al Mapa de su ubicación, capacidad y espacio para realizar el envió, estas solicitudes se intercambían hasta que son seleccionadas las Bodegas en las que serán almacenados, los domiciliaros que realizarán los envíos, hasta finalmente llegar al Comprador, al que el domiciliario realizará una solicitud de confirmación de llegada del pedido. <br>**Distribucion de tareas**: Todos los objetos interactúan entre sí, intercambiando información de sus respectivos atributos y estados para determinar su disposición y capacidad, cada organizador Distribuidor_Productos interpreta los datos en las bodegas para crear paquetes o añadir productos a paquetes existentes,las bodegas son múltiples y en distintas ubicaciones que están dadas por su instancia de Empresa_Local, Cuando un paquete está listo para envío o pasa su tiempo limite en bodega, Son tomados por los Organizadores Distribuidor_Paquetes y dados a Domiciliarios para envío a los vendedores o nuevas bodegas. Los Domiciliarios tienen las tareas de entregar los paquetes, confirmar los envíos exitosos, y destruir los productos que han sido envíados exitosamente. <br>**Confimación**: Cada objeto interactuará de manera diferente de acuerdo al estado de su capacidad, las bodegas se llenan, los vendedores se quedan sin productos, los Domiciliarios son limitados, por tanto, cada objeto puede o no puede llevar a cabo las solicitudes, en este caso, habrá tiempo de espera, y hasta que el objeto requerido no confirme su capacidad para la tarea solicitada, no podrá llevarse a cabo la cadena de interacciones para el envío de los paquetes y productos. Las confirmaciónes serán dadas por los organizadores que interactuarán con las instancias de los objetos a los que están conectados, cuando no se llegué una confirmación, se hará una cola de productos pendientes para envío. Existe la posibilidad de crear una nueva instancia requerida si se cumplen las condiciones, que serán menejadas por la empresa, que dependerán de los productos vendidos. 
#### Función-Calcular Costos
**Calculo ganancia neta**: Es la primera interacción, se da de los Compradores a los Vendedores, y de los Vendedores a la Empresa_Principal, La cantidad de dinero por compra de producto se calcula y se añade a la cartera de los Vendedores (los Compradores no tienen cartera), Los vendedores dan dinero a la Empresa_Principal para que esta recoja sus productos y los envíe.<br>**Calculo Gastos**Calcula el precio de envío de cada producto, los vendedores gastan dinero por peso de paquete transportado, la distancia a recorrer y el Tipo de Domiciliario que lo recoge, Este es añadido a la cartera de la Empresa_Principal, la Empresa_Principal gasta dinero en el uso de sus Domiciliarios, Se calculan los costos en función del tipo de Domiciliario y la distancia recorrida con el paquete, Los envíos cancelados son cobrados por la Empresa_Principal al Vendedor asociado con el producto al ser devueltos. Todas las clases tienen una misma fecha asociada, cada mes existen costos calculados por la cantidad de organizadores, bodegas y Domiciliarios de las Empresas_Locales asociadas a la Empresa_Principal, así como los Vendedores restauran su Stock, dónde se calcula el costo de cada cupo para la creación de las instancias de Productos<br>**Determinar Bancarrota-Crecimiento**La ultima interacción hace uso de la cantidad de dinero en cartera, y las solicitudes dadas por los Vendedores, Organizadores, para Destruir o Crear nuevas instancias de Organizadores, Bodegas y/o Domiciliarios. La Empresa puede caer en Bancarrota, o puede crecer, dependiendo de la cantidad de ganancia o perdidas, una vez su cartera alcanza los negativos, se destruye. Los Vendedores pueden aceptar las solicitudes de prodcutos que han agotado si tienen suficiente dinero en cartera. 
#### Función-Controlar Tiempos Envio
**Determinar Inserción a Paquetes**: Es la primera interacción, Las instancias de Organizadores Distribuidor_Productos pueden añadir nuevos productos a paquetes existentes mientras se encuentren en la bodega o no estén vacios. Las solicitudes de Envío de productos de los Vendedores a Compradores que se realizen durante este tiempo que sean de productos que puedan ser almacenados en una instancia existente de Paquete tendrán un costo disminuido. **Determinar Tiempo límite**: Incialmente, Los Organizadores Distribuidor_Paquetes calcularán el tiempo de llegada de acuerdo a la ubicación en el mapa del paquete, el Domiciliario seleccionado para el envío del paquete, y la cantidad de Bodegas a las que se moverá el paquete. Las bodegas que contengan paquetes que se están aproximando a la fecha limite solicitarán a los Organizadores Distribuidor_Paquetes que podrán: Destruír el Paquete y distribuir los productos en nuevos Paquetes, Solicitar un nuevo Domiciliario para envíar el Paquete con perdidas, Cancelar el envío. Dependiendo de la interacción, se calculará un nuevo tiempo estimado para la Entrega.<br>**Distribución a Bodegas y Compradores**: Los Compradores crean instancias de productos que son descontadas de los cupos del Vendedor, dado un tiempo el Vendedor solicita a la Empresa_Principal a la que está asociado el envío de los Productos, los Productos son Organizados en Paquetes por Organizadores Distribuidor_Productos del Vendedor, que son transportandos a una Bodega cercana a la ubicación del Comprador, En todo este proceso se calcula el tiempo de llegada a la Bodega en función de la cantidad de Paquetes, que determinan el Domicilario requerido para el transporte (Junto con la distancia), y que calcula la llegada a la Bodega, dónde se junta con otros Paquetes de otros vendedores, y se estima, en función de la facilidad para transportar aquellos paquetes y Productos con ubicaciones en el mapa cercanos. El tiempo se calcula en función de la cantidad de viajes que tiene que hacer un Domiciliario, el tipo de Domiciliario, y la Distancia a recorrer. 

## Interacción clases
- La clase **Empresa Principal** tiene acceso a todos los atributos de las empresas locales y está relacionada con los vendedores, tiene Organizadores Distribuidor_Productos y Organizadores Distribuidor_Paquetes, la clase **Empresa Local** tiene bodegas y Domiciliarios propios definidos por su ubicación en el mapa. <br>La empresa principal puede:<br>Recibir solicitudes de envío a Compradores de los vendedores<br>Enviar domiciliarios para la recolección de Paquetes para guardar en Bodegas<br>Recibir dinero de los vendedores (Una vez hecho un pedido por un Comprador)<br>Recibir solicitudes de sus organizadores para crear nuevas instancias de Domiciliarios y Bodegas<br>Enviar solicitudes a sus Organizadores para el manejo de los Paquetes y Productos<br>Retornar productos cuyo envío sea cancelado por los Compradores a solicitud de los vendedores.<br>Destruir Empresas Locales y Organizadores<br>Solicitar la destrucción de una Bodega de una Empresa Local y Domiciliarios<br>Las empresas locales pueden:<br>Crear nuevas instancias de bodegas y domiciliarios<br>Enviar solicitudes a sus Organizadores para el manejo de los productos<br>Recibir solicitudes de la empresa principal para recoger paquetes de Compradores y hacer un retorno a los vendedores<br>Solicitar a los organizadores creadores de paquetes<br>Recibir paquetes de domiciliarios<br>Solicitar organizadores separadores de paquetes<br>Solicitar a organizadores Distribuidor_Paquetes<br>Modificar los atributos de sus bodegas asociadas<br>Asociar nuevas bodegas con ubicaciones en el mapa a solicitud de la empresa principal<br>Destruír Bodegas y Domiciliarios propios<br>Crear nuevas Instancias de Organizadores<br>
- La clase **Vendedor** tiene una ubicacion en el mapa, empresa asociada, cantidad de productos (Cupos para la creación de nuevas instancias) y Organizadores Distribuidor_Vendedores.<br>Los vendedores pueden:<br>Crear una cantidad limitada de instancias de productos a solitud de un Comprador (Productos delicados, normales y peligrosos están separados)<br>Solicitar envío de sus productos a una empresa<br>Recibir pagos de los Compradores<br>Descontar dinero de sus carteras mensualmente<br>Crear nuevos cupos para la creación de objetos a solicitud de un Comprador (Si no hay capacidad del vendedor para cumplir con la solicitud de productos de vendedor)<br>Recibir solicitudes de devolución de los Compradores.<br>Recibir Paquetes con Productos devueltos<br>Destruír Productos y aumentar los cupos del tipo de producto disponible<br>
- La clase **Producto** tiene una ubicación en el Mapa, un Vendedor, Comprador, Empresa, Paquete, Tiempo de entrega y Domiciliario asociados. <br>Los productos pueden:<br> Destruirse al llegar al Comprador<br> Ser creados por un vendedor<br>Cambiar de paquete<br> Cambiar de ubicación en el mapa<br>Cambiar de estado (en espera, en movimiento y quieto)<br>Cambiar su tiempo de llegada estimada<br>
- La clase Domicilario tiene una ubicación en el Mapa, una Empresa_Local, Bodegas (Posición actual y destino), Paquetes, Organizadores Distribuidor_Paquetes y Compradores asociados.<br>Los domiciliarios pueden:<br>Recibir peticiones de organizadores para un envío<br>Rechazar envíos de organizdores en función de su estado (No-Disponible, Disponible)<br>Cambiar la ubicación en el mapa de Paquetes y Productos<br>Destruir Productos y Paquetes cuando estos estén vacíos y lleguen a sus Compradores<br>Vaciar Paquetes de sus Productos<br>
- La clase **Organizador**, los **Distribuidor_Productos**  Tendrán Organizadores Distribuidor_Paquetes asociados, Una cantidad limitada de Productos que pueden organizar por día y Una Empresa_Local asociada. Los **Distribuidor_Paquetes** tendrán acceso a todas las instancias de Domiciliarios y Bodegas disponibles, Tendrán una Empresa_Local asociada, una cantidad límitada de Paquetes que pueden organizar por día. Los **Distribuidor_Vendedores** tendrán un Vendedor asociado, una Empresa_Principal asociada. <br>Los Distribuidor_Productos podrán:<br>Crear nuevas Instancias de Paquetes en Bodegas<br>Añadir Productos a Instancias existentes de Paquetes<br>Interpretar las ubicaciones Destinos de los Productos para organizar Paquetes<br>Destruír Paquetes Vacíos<br>Extraer Productos de los Paquetes existentes<br>Solicitar la distribución de un Paquete a un Distribuidor_Paquetes si lo llenan<br>Programar una Fecha máxima para le envío de un Paquete incompleto<br>Los Distribuidor_Paquetes podrán:<br>Asociar Paquetes con un Domiciliario dependiendo de sus carácteristicas<br>Cambiar un Domiciliario Asociado de un Paquete<br>Solicitar el envío de un Paquete<br>Asociar una Bodega de Destino a un Paquete<br>Los Distribuidor_Vendedores pueden:<br>Crear Paquetes<br>Insertar los Productos de su Vendedor en los Paquetes<br>Entregar los Paquetes a los Domiciliarios que los recogen<br>Recibir Productos y Paquetes Devueltos<br>Mantener Paquetes en Espera<br><br>*Todos los Organizadores Cobran a la Empresa_Principal mensualmente, menos los Distribuidor_Vendedores que cobran a su vendedor*<br>
- La clase **Comprador**, tiene Productos asociados y una ubicación en el Mapa.<br>El Comprador puede:<br>Solicitar Productos a Compradores<br>Cancelar un Pedido<br>Confirmar la entrega de un Producto<br>
- La clase **Paquete** tiene un Domiciliario y Bodega (Actual y destino) asociado, contiene Productos, tiene una ubicación en el Mapa actual y destino y un Tiempo de entrega Asociado.<br>La Clase Producto Puede:<br>Cambiar su Bodega asociada<br>Cambiar de estado (Disponible, Lleno)<br>Cambiar de tipo (Delicado, Normal, Peligroso)<br>Destruirse<br>
- La clase **Bodega** tiene una Empresa_Local, una Empresa_Principal, Paquetes, Organizadores y Domiciliarios asociados. La bodega tiene un límite a la cantidad de Paquetes que puede contener al mismo tiempo.<br>Una Bodega Puede<br>Cambiar de estado (Disponible, Llena)<br>recibir Paquetes<br>Destruirse<br>Cobrar a la Empresa_Principal mensualmente<br>
- La clase **Domiciliario** en general, tiene una Empresa_Local, Bodegas y Paquetes Asociados. <br>Un domiciliario Puede:<br>Recibir Paquetes (Varían según el tipo)<br>Entregar Productos<br>Extraer Productos de un Paquete<br>Entregar Paquetes<br>Realizar viajes<br>Cobrar a la Empresa_Principal mensualmente<br>Destruirse<br>
- La clase **Mapa** maneja las ubicaciones de todas las instancias con las que está relacionado.<br>El Mapa puede:<br>Dar una ubicacion<br>Calcular distancias<br>
- La clase **Tiempo** maneja la fecha y el tiempo de los objetos con los que está relacionado.<br>El Tiempo puede:<br>Cambiar constantemente<br>Funcionar como controlador para los métodos de los objetos con los que está relacionado<br>

## Impacto clases y objetos
Las 3 funcionalides interactúan entre sí para los calculos del costo, el tiempo de envío y la llegada de los productos. Las clases Paquete, Bodega, Organizador y Domiciliario tienen estados, que dependen de la clase tiempo y de los límites dados por su capacidad de contención de otros objetos, Las clases Vendedor y Empresa (con sus subclases) interactúan con los objetos de las demás clases y determinan su capacidad de continuar, principalmente dependen de las instancias de Comprador para manetener dinero en sus carteras, el dinero se mueve constantemente y depende del tiempo, cuando no hay dinero los vendedores no pueden satisfacer a los Compradores y las empresas son Destruidas (Caen en bancarrota). <br>

## progresión objetivo final
El programa simula un ecosistema entre Vendedores, Empresas de envío y Compradores. Este ecosistema simulado se mueve para satisfacer los pedidos de los Compradores, En forma de productos a envíar, y cuando no hay compradores, los objetos se destruyen. 

## Diagrama de interacción
