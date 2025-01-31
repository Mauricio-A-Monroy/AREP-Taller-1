# Taller 1 - Servidor Web en Java

## Descripción
Este proyecto implementa un servidor web en Java sin el uso de frameworks como Spark o Spring. El servidor es capaz de manejar múltiples solicitudes de manera secuencial, servir archivos estáticos (HTML, CSS, JS, imágenes) y proporcionar una API REST para la gestión de datos. Además, se explora la arquitectura de aplicaciones distribuidas, con un enfoque en servidores web y el protocolo HTTP.

## Características
- Servidor HTTP básico escrito en Java.
- Soporte para archivos estáticos (HTML, CSS, JS, imágenes).
- Implementación de un servicio REST simple.
- Comunicación asíncrona entre frontend y backend.
- Uso de Maven para la gestión de dependencias.

## Getting Started
Estas instrucciones te ayudarán a obtener una copia del proyecto en tu máquina local para desarrollo y pruebas.

### Prerrequisitos
- Java 8 o superior
- Apache Maven

### Instalación
Clonar el repositorio:
```sh
git clone https://github.com/Mauricio-A-Monroy/AREP-Taller-1.git
cd Taller1
```

Crear el proyecto de Maven:
```sh
mvn archetype:generate -DgroupId=edu.escuelaing.app -DartifactId=HTTPServer -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

Compilar el proyecto:
```sh
mvn package
```

Ejecutar el servidor:
```sh
java -jar target/HTTPServer-1.0-SNAPSHOT.jar
```

## Arquitectura y Diseño
### Estructura del Proyecto
```
Taller1/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── edu/
│   │   │       └── escuelaing/
│   │   │           └── app/
│   │   │               └── HttpServer.java          # Servidor HTTP principal
│   │   └── resources/
│   │       └── static/                              # Archivos estáticos
│   │           ├── index.html                       # Página de inicio
│   │           ├── IndexStyles.css                  # Estilos CSS
│   │           ├── Pwelcome.jpeg                    # Imagen de bienvenida
│   │           └── app/                             # Archivos de la aplicación REST
│   │               ├── App.html                     # Interfaz REST
│   │               └── AppStyles.css                # Estilos CSS de la app
│   ├── test/
│   │   └── java/
│   │       └── edu/
│   │           └── escuelaing/
│   │               └── app/
│   │                   └── HttpServerTest.java      # Pruebas del servidor
│── pom.xml                                          # Configuración de Maven
│── README.md                                        # Documentación
```

### Funcionamiento del Servidor
#### Manejo de solicitudes HTTP:
- El servidor escucha en el puerto 35000 y acepta conexiones de clientes.
- Procesa la solicitud HTTP, identifica el tipo de petición (GET, POST, PUT, DELETE) y responde en consecuencia.
- Si la petición es para un archivo estático, lo busca en `src/main/resources/static/` y lo sirve con el tipo MIME adecuado.

#### Manejo de solicitudes REST:
- `GET /app/rest-service` → Devuelve la lista de nombres almacenados.
- `POST /app/rest-service?name=NuevoNombre` → Agrega un nuevo nombre.
- `PUT /app/rest-service?id=1&newName=NombreModificado` → Modifica un nombre existente.
- `DELETE /app/rest-service?id=1` → Elimina un nombre.

### Diagrama de arquitectura

![Blank diagram](https://github.com/user-attachments/assets/bf3a469d-f8f1-43b0-8e0e-bfee2e327092)

### Uso
Después de ejecutar el servidor, abre un navegador y accede a `http://localhost:35000` para probar la aplicación web incluida.

#### Interacción con la Aplicación Web
- `index.html` es la página de inicio que da acceso a `app.html`.
- `app.html` es la interfaz de usuario de la aplicación REST.
- El código JavaScript en `app.html` se comunica con el backend usando `fetch()`.

## Pruebas
### Pruebas Manuales
Puedes realizar pruebas manuales con `curl`:
```sh
curl -X GET http://localhost:35000/app/rest-service
curl -X POST "http://localhost:35000/app/rest-service?name=Mauricio"
curl -X PUT "http://localhost:35000/app/rest-service?id=1&newName=Juan"
curl -X DELETE "http://localhost:35000/app/rest-service?id=1"
```

### Pruebas Automatizadas
El proyecto incluye pruebas con JUnit para verificar el correcto funcionamiento del servidor y la API REST. Para ejecutarlas:
```sh
mvn test
```

## Despliegue
Para desplegar este servidor en un entorno en vivo, puedes empaquetarlo en un contenedor Docker o configurar un servicio en la nube.

## Tecnologías Utilizadas
- **Java** - Lenguaje principal del servidor web.
- **HTML, CSS, JavaScript** - Aplicación web cliente.
- **Maven** - Gestión de dependencias y compilación.

## Contribuyendo
Este proyecto es de código abierto. Para contribuir, por favor sigue los lineamientos en `CONTRIBUTING.md`.

## Versionado
Se utiliza **SemVer** para el versionado. Las versiones disponibles pueden encontrarse en los tags del repositorio.

## Autor
**Mauricio Alejandro Monroy Jiménez**

## Licencia
Este proyecto está bajo la **licencia MIT**. Para más detalles, consulta el archivo `LICENSE.md`.

## Agradecimientos
Agradecimiento especial al profesor por su guía y apoyo en el desarrollo de este taller.






