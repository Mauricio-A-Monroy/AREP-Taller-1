# Taller 1

## Descripción
En este taller se explora la arquitectura de aplicaciones distribuidas, con un enfoque en servidores web y el protocolo HTTP. Se desarrollará un servidor web en Java sin el uso de frameworks como Spark o Spring, capaz de manejar múltiples solicitudes secuenciales y servir archivos locales (HTML, CSS, JS, imágenes). Además, se implementará una aplicación web con comunicación asíncrona con servicios REST en el backend.

## Getting Started
Estas instrucciones te ayudarán a obtener una copia del proyecto en tu máquina local para desarrollo y pruebas.

### Prerrequisitos
- Java 8 o superior
- Apache Maven

### Instalación
1. Clonar este repositorio:
   ```sh
   git clone https://github.com/Mauricio-A-Monroy/AREP-Taller-1.git
   cd Taller1
   ```
2. Crear el proyecto de Maven:
   ```sh
   mvn archetype:generate -DgroupId=edu.escuelaing.app -DartifactId=HTTPServer -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
   ```
3. Compilar el proyecto:
   ```sh
   mvn package
   ```
4. Ejecutar el servidor:
   ```sh
   java -jar target/HTTPServer-1.0-SNAPSHOT.jar
   ```

## Arquitectura

![Blank diagram](https://github.com/user-attachments/assets/bf3a469d-f8f1-43b0-8e0e-bfee2e327092)



## Uso
Después de ejecutar el servidor, abre un navegador y accede a `http://localhost:35000` para probar la aplicación web incluida.

## Pruebas
*Pendiente de agregar pruebas automatizadas.*

## Despliegue
Para desplegar este servidor en un entorno en vivo, puedes empaquetarlo en un contenedor Docker o configurar un servicio en la nube.

## Tecnologías utilizadas
- **Java** - Lenguaje principal del servidor web.
- **HTML, CSS, JavaScript** - Aplicación web cliente.
- **Maven** - Gestión de dependencias y compilación.

## Contribuyendo
Este proyecto es de código abierto. Para contribuir, por favor sigue los lineamientos en `CONTRIBUTING.md`.

## Versionado
Se utiliza SemVer para el versionado. Las versiones disponibles pueden encontrarse en los tags del repositorio.

## Autor
**Mauricio Alejandro Monroy Jiménez**

## Licencia
Este proyecto está bajo la licencia MIT - ver `LICENSE.md` para más detalles.

## Agradecimientos
Agradezco al profesor por su ayuda y guía en el desarrollo de este taller.

