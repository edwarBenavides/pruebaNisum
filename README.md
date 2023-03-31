# prueba Nisum
prueba tectica para NISUM con java
#

# A TENER EN CUENTA SOBRE LOS REQUISITOS DE ENTREGA

● Diagrama de la solución, se encuentra al inicio de este repositorio como una imagen de tipo PNG. <br>
● Entrega en un repositorio público (github o bitbucket) con el código fuente y script de creación de BD.<br>
  el script de creacion de DB no es necesario dado que la solucion crea automaticamente las tablas y sus relaciones cada vez que la aplicacion es desplegada<br>
● Utilizar Jwt, se utilizo JWt para crear el token y persistirlo el metodo que genera el toquen puede visualizarce en el directorio "Configuration", luego abriendo la clase "JwtUtilConfiguration" en donde encontrara el metodo "generateJwtToken"

# Para probar la solucion debe:

NOTA: antes de continuar con los pasos verifique que en su equipo tenga instalado Git, Java JDK verison 8, Maven, un editor o IDE configurado y las variables de entorno de JAVA

1. Clonar el repositorio Git:
    abra una terminal o línea de comandos y use el comando git clone para clonar el repositorio.
    git clone https://github.com/edwarBenavides/pruebaNisum.git
    
2. Cargue el repositorio en su editor o IDE preferido por ejemplo Visual Studio Code, Eclipse o IntelliJ IDE. Como ejemplo utilizare IntelliJ IDE

  a) Primero hacemos clic en file > open
  ![image](https://user-images.githubusercontent.com/112735965/228991151-fc32e38e-1863-4e13-a1ce-a407430227ae.png)
  
  b) segundo nos dirigimos al directorio o carpeta en donde descargamos el repositorio y seleccionamos el directorio llamado "pruebaNisum", seleccionamos el boton "OK"
  y esperamos a que maven descargue las dependencias necesarias para el proyecto
![image](https://user-images.githubusercontent.com/112735965/228991375-5406850c-fa03-4d7f-be40-b17f54769dfb.png)

  c) Una vez terminada la descarga de dependencias puede correr el proyecto o los test del mismo asi:
    
para correr los test puede hacer clic y desplegar el directorio "src", luego hacer clic en el directorio "test" para que se despliegen otros directorios en donde en contrara un directorio de nombre java, haga click derecho sobre el directorio de nombre "java" y seleccione la opcion "Run all test"

![image](https://user-images.githubusercontent.com/112735965/228993558-d0eab5ed-19f1-4eec-b79d-afb8d3700e79.png)

    
En la parte inferior observara una consola en donde visualizara todos los test ejecutados correctamente, como se observa en la siguiente imagen

![image](https://user-images.githubusercontent.com/112735965/228992724-45e261cb-b804-43a0-943d-cd26a90c12a1.png)

  Para correr el proyecto y probar la funcionalidad usted debe puede hacer clic y desplegar el directorio "src", luego hacer clic y despleglar el directorio "main", hacer clic y despleglar el directorio "java", hacer clic y despleglar el directorio "com.pruebaNisum.pruebaNisum" y finalmente hacer clic derecho sobre el archivo de nombre "PruebaNisumApplication" y seleccionar la opcion "Run PruebaNisumApplication"
  
  ![image](https://user-images.githubusercontent.com/112735965/228993359-822ac338-22d6-43df-94d8-dc8b73a098b9.png)
  

3. Para probar la funcionalidad usted puede ingresar a la url de swagger http://localhost:8080/api/swagger-ui.html 
alli encontrata los endpoints funcionales y la manera de probarlos con unos cuantos clics

![image](https://user-images.githubusercontent.com/112735965/228993985-5c2225cb-5393-4e69-987a-708fc45c3fb2.png)

A manera de prueba utilizare el endpoint de tipo post para registrar un nuevo usuario haciendo clic sobre el se desplegara la siguiente ventana

![image](https://user-images.githubusercontent.com/112735965/228994211-f142f844-c6ce-40b6-a62f-11303cb7a6a6.png)

en la ventana desplegada utilice el siguiente json y de clic en el boton azul de nombre "Execute"

{
  "email": "prueba@gmail.com",
  "name": "edwar",
  "password": "4333222@hwF",
  "phones": [
    {
      "citycode": "4",
      "countrycode": "4",
      "number": "3112221100"
    }
  ]
}

NOTA: tenga en cuenta que para registrar un nuevo usuario tenga en cuenta que se está validando el formato del correo y la propiedad password debe contener: minúsculas, mayúsculas, números, un carácter especial y debe ser mayor de 8 caracteres y menor a 20

![image](https://user-images.githubusercontent.com/112735965/228994553-ad39174b-2a70-4c8c-9bb0-7ba95388e313.png)

luego de presionar el boton azul de nombre "Execute" puede hacer scroll y desplazarce hacia abajo en donde encontrara el resultado de la prueba asi:

![image](https://user-images.githubusercontent.com/112735965/228994713-b44ffe05-ac7f-43a1-a3ab-354eea35708a.png)

# Ademas de la anterior opcion para probar las funcionalidades usted puede:
Utilizar un cliente HTTP como Postman para que realice las peticiones en los siguientes endpoints <br>
a) http://localhost:8080/api/user/registerUser -> endpoint de tipo POST para registrar un nuevo usuario<br>
b) http://localhost:8080/api/user/allUsers -> endpoint de tipo GET para listar todos los usuarios creados<br>
c) http://localhost:8080/api/user/(REMPLACE_POR_UN_ID) -> endpoint de tipo GET para consultar un usuario creado por el id



