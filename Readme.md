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
- Petición GET para obtener index.html accediendo al recurso /:

![image](https://github.com/user-attachments/assets/41c1067c-b93b-43d8-992e-34f6139548de)

- Petición GET para obtener index.html accediendo al recurso /index.html:

![image](https://github.com/user-attachments/assets/1a444b07-6623-478b-a4ba-e15f57cf99d8)

- Petición GET para obtener App.html accediendo al recurso /app/app.html:

![image](https://github.com/user-attachments/assets/84ab950a-745e-40d4-8fb9-c959a742a16d)

- Petición POST para agregar nombre a la tabla:

![image](https://github.com/user-attachments/assets/df2680e7-cdd7-46f5-8ff1-2b5f7f7b3a94)

- Petición PUT para modificar nombre de la tabla:

![image](https://github.com/user-attachments/assets/fdf79eb5-0694-4490-93ad-b4ad810dc03f)

- Petición DELETE para eliminar nombre de la tabla:

![image](https://github.com/user-attachments/assets/78d1b3a6-9273-43f7-8d8f-c8efab9955c7)



### Pruebas Automatizadas
El proyecto incluye pruebas con JUnit para verificar el correcto funcionamiento del servidor y la API REST. Para ejecutarlas:
```sh
mvn test
```

## Tecnologías Utilizadas
- **Java** - Lenguaje principal del servidor web.
- **HTML, CSS, JavaScript** - Aplicación web cliente.
- **Maven** - Gestión de dependencias y compilación.

## Contribuyendo
Este proyecto es de código abierto. Para contribuir, por favor sigue los lineamientos en `CONTRIBUTING.md`.

## Autor
**Mauricio Alejandro Monroy Jiménez**

## Agradecimientos
Agradecimiento especial al profesor por su guía y apoyo en el desarrollo de este taller.






