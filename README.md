# PlanetsProject

# README

## Universe App
### Jaqueline Castillo, Iván Gutiérrez

## Descripción del Proyecto

Esta aplicación es un proyecto final desarrollado en Kotlin para Android, que presenta información detallada sobre los planetas del sistema solar. Está diseñada con una arquitectura robusta y moderna, siguiendo las mejores prácticas de Clean Architecture y utilizando Jetpack Compose para una interfaz de usuario intuitiva y dinámica. La aplicación consume datos de una API llamada "PlanetsAPI".

## Funcionalidad de la Aplicación

### Pantalla Principal

En la pantalla principal, se muestra una lista visualmente atractiva de los planetas del sistema solar, cada uno acompañado de una imagen representativa. Esta lista se obtiene mediante una llamada a la API "PlanetsAPI" que proporciona datos en tiempo real sobre cada planeta. La interfaz es intuitiva, permitiendo a los usuarios explorar fácilmente la información básica de cada planeta.

### Interacción

Al hacer clic en cualquier planeta de la lista, los usuarios son llevados a una pantalla de detalles dedicada. Esta navegación es fluida y utiliza transiciones animadas que mejoran la experiencia del usuario.

### Pantalla de Detalle del Planeta

En la pantalla de detalle, se presenta información exhaustiva sobre el planeta seleccionado. Los datos mostrados incluyen:

- Nombre del planeta
- Imagen del planeta
- Tipo de planeta
- Masa
- Diámetro
- Cantidad de lunas
- Distancia al Sol
- Días de traslación

Esta información es recuperada desde la API y presentada de una manera clara y organizada, utilizando Jetpack Compose para una interfaz moderna y responsiva.

## Implementación de Clean Architecture

La aplicación sigue la estructura de Clean Architecture, lo que facilita su mantenimiento y escalabilidad. La implementación se divide en las siguientes capas:

1. **Data Layer**: Maneja las fuentes de datos, en este caso, las llamadas a la API "PlanetsAPI". Aquí se implementan los repositorios que obtienen los datos y los transforman en entidades del dominio.
2. **Domain Layer**: Contiene las entidades del dominio y los casos de uso. Los casos de uso encapsulan la lógica de negocio, asegurando que la aplicación sigue las reglas de negocio definidas.
3. **Presentation Layer**: Maneja la interfaz de usuario y la lógica de presentación. Aquí se utilizan ViewModels que interactúan con los casos de uso para obtener los datos y exponerlos a la interfaz de usuario.

### Interfaz de Usuario

La interfaz de usuario se ha desarrollado utilizando Jetpack Compose, aprovechando sus capacidades declarativas y su facilidad para crear interfaces de usuario reactivas. La interfaz es intuitiva y cuenta con imágenes de alta calidad, proporcionando una experiencia de usuario moderna y agradable. Las animaciones y transiciones entre pantallas son suaves, lo que mejora la interacción y el engagement del usuario con la aplicación.

## Instalación

### Prerrequisitos

- Android Studio instalado en su última versión.
- SDK de Android 21 o superior.

### Pasos para la Instalación

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/JaquelineCastSx/PlanetsProject

## Uso de la Aplicación

### Abrir el proyecto en Android Studio
Para abrir el proyecto en Android Studio, siga estos pasos:

1. Abra Android Studio.
2. Haga clic en "File" en la barra de menú.
3. Seleccione "Open" y navegue hasta la ubicación del proyecto en su sistema.
4. Seleccione el directorio del proyecto y haga clic en "Open".

### Sincronizar el proyecto con Gradle
Una vez que haya abierto el proyecto en Android Studio, siga estos pasos para sincronizarlo con Gradle:

1. En la barra de herramientas superior, haga clic en "Sync Project with Gradle Files" (el ícono de dos flechas circulares opuestas).
2. Espere a que Android Studio sincronice el proyecto con los archivos Gradle.

### Ejecutar la aplicación en un dispositivo físico o emulador
Para ejecutar la aplicación en un dispositivo físico o emulador, siga estos pasos:

1. En la barra de herramientas superior, haga clic en el botón de ejecución verde (icono de reproducción) o presione Shift + F10.
2. Si está utilizando un dispositivo físico, asegúrese de que esté conectado a su computadora y tenga la depuración USB habilitada.
3. Seleccione el dispositivo en el que desea ejecutar la aplicación y haga clic en "OK".
4. Espere a que Android Studio compile y ejecute la aplicación en el dispositivo seleccionado.

### Configuración de la API
La aplicación está configurada para consumir datos de la API "PlanetsAPI". Asegúrese de que las URLs de los endpoints estén correctamente configuradas en el archivo de configuración.

### Uso de la Aplicación

#### Pantalla Principal
La pantalla principal muestra una lista de planetas con sus imágenes. Al hacer clic en cualquier planeta, se navega a la pantalla de detalle.

#### Pantalla de Detalle
En la pantalla de detalle, se muestra información completa sobre el planeta seleccionado, incluyendo su nombre, imagen, tipo, masa, diámetro, cantidad de lunas, distancia al Sol y días de traslación.

### Publicación en Play Store

#### Prerrequisitos
- Cuenta de desarrollador de Google Play.
- APK firmado.

#### Pasos para Publicar

1. **Crear un APK firmado**:
   - En Android Studio, vaya a `Build > Generate Signed Bundle / APK`.
   - Seleccione APK y siga los pasos para firmar su aplicación.

2. **Crear un Nuevo Proyecto en Google Play Console**:
   - Inicie sesión en Google Play Console.
   - Cree un nuevo proyecto y complete la información requerida.

3. **Subir el APK**:
   - En la sección de lanzamiento de aplicaciones, cargue el APK firmado.
   - Complete la información de la tienda (descripción, capturas de pantalla, íconos, etc.).

4. **Revisar y Publicar**:
   - Revise todos los detalles y envíe la aplicación para revisión.
   - Una vez aprobada, su aplicación estará disponible en Google Play Store.