![Logo](img/ZWX.png)
### Proyecto realizado por Zihao Wang
Programa capaz de gestionar los empleados de una empresa sin interfaz
### Requisitos
1. Tener instalado **JDK 17**(Recomendado) o superior
2. Tener alguna **IDE** instalada de la **misma version** que el JDK para evitar problemas. Es necesario ya que es un programa que se ejecuta por consola
3. Tener un **servidor abierto con el puerto 3306 y password vacio** o poner los datos vuestros en el archivo de **persistence.xml** situado en **Other Sources/src/main/resources/META-INF**
4. Tener una **base de datos** (O importar la que tiene este proyecto) creada en nuestro servidor con **nombre empleados** o modificar el nombre de la base de datos en el archivo de **persistence.xml** situado en **Other Sources/src/main/resources/META-INF** (Evitar bases de datos que tenga ya una tabla empleados ya que puede dar problemas y si no existe la tabla , se crea automaticamente)
### Instalacion
1. Descargar proyecto
2. Sacar fuera la base de datos
3. Importar
    * En Netbeans
        1. Comprimirlo en **ZIP**
        2. Abrir Netbeans y en la parte esquina superior izquierda **File/Import Project/From ZIP**
        3. Browse , seleccionamos nuestro **ZIP** y open
    * En Eclipse
        1. Abrir Eclipse y en la parte esquina superior izquierda **File/Import/Maven/Existing Maven Projects**
        2. Le damos a **next/Browse** y seleccionamos el proyecto descargado y a **finish**
    * En IntelliJ
        1. Abrir InteliJ y en la parte esquina superior izquierda **File/Open** y localizaremos el proyecto descargado, lo seleccionamos y le damos al boton **OK**
### Funcionalidades
Vamos a tener un menu con el cual podremos selecionar lo que queramos hacer introduciendo los siguientes numeros

0. Para salir del programa
1. Para **Crear** un nuevo empleado
2. Para **Editar** un empleado
3. Para **Eliminar** un empleado por **ID**
4. Para **Buscar** por **ID**
5. Para **Buscar** por **cargo**
6. Para Mostrar **todos** los empleados

### Editar
1. Nos mostrara un listado de empleados y podremos seleccionar cual editar
2. Nos aparecera el **menu de editar** para poder seleccionar lo que queremos editar del empleado
3. Cuando terminemos de editar usaremos **0 para salir** del menu y los cambios se guardan y ejecutan . Volveremos al **menu principal**

