# ChatRMI

Para usar este programa en el servidor se necesitan los archivos **Driver.java**, **Interfaz.java**, **Servidor.java** 
e **InterfazCliente.java** (los otros archivos se pueden ignorar); en los clientes se necesitan todos los demás archivos que no son los de arriba
y el de **InterfazCliente.java**, se compilan todos los que se llaman **Interfaz...java**, todos los **Driver...java**, y las **Ventanas...java**,
 además de **Selector.java**, luego de que se compiló eso se ejecuta el comando **rmiregistry 3000** en todas las máquinas (el puerto 3000 lo elegí yo, se puede cambiar en el código y aquí)
 , se abre otra ventana de terminal y en el servidor se ejecuta **java Driver** y se supone que ya sirve el servidor, en los clientes se ejecuta **java Selector**
 y se supone que debería funcionar el programa.
 
 **NOTA** 
 Por la experiencia que tuve realizando este programa, me di cuenta que la línea java.net.InetAddress.getLocalHost().getHostAddress() según la configuración que tengan regresa la IP de otra interfaz
 de red que tengan en su equipo, por lo tanto a veces no sirve el programa por ese problema, les recomiendo que investiguen la IP local de su 
 máquina y la hardcodeen en todas las líneas que son java.net.InetAddress.getLocalHost().getHostAddress() por su ip como en la línea 19 
 de **DriverClienteCliente.java** y que le agreguen la bandera -Djava.rmi.server.hostname=xxx.xxx.xxx.xxx a **java Driver** o a **java Selector**,
 es decir por ejemplo **java -Djava.rmi.server.hostname=192.168.1.74 Selector**
 
 Prueba funcionando https://www.youtube.com/watch?v=ZDDg57iz8wc
