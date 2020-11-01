# Concurrente y Paralelo

Serie de programas creados en python, java y c para el aprendizaje de concurrencia y paralelismo


## Tabla de contenidos

1. [Actividad4](https://github.com/Fatake/Concurrente_Paralelo/tree/master/Activida4 "Actividad4")
2. [Actividad6](https://github.com/Fatake/Concurrente_Paralelo/tree/master/Actividad6 "Actividad6")
3. [Actividad7](https://github.com/Fatake/Concurrente_Paralelo/tree/master/Actividad7 "Actividad7")

## Descripción Actividades

#### Actividad 4

**Objetivo**

Realizar un conjunto de hilos en Java

**Instrucciones**

* Modificar el archivo MisHilos.java(archivo independiente)
* Con el arreglo de alumnos de la actividad previa, dentro del main realizar el envio de cada alumno a un hilo y mostrar su información.
* Cargar el archivo MiHilo.java y ejecutarlo(se encuentra como archivo independiente)
* Crear la clase Alumno con atributos: nombre, apellido paterno, apellido materno, matricula, rol(programador,líder,tester,diseñador).
* Crear un arreglo de alumnos del tamaño del número de integrantes del equipo con los datos de cada miembro del equipo
* Modificar el archivo para que en lugar de escribir Hola Mundo escriba los datos  de los integrantes de equipo desde el arreglo.
* Cargar el archivo MiHilo.java y ejecutarlo(se encuentra como archivo independiente)

---

#### Actividad 6

**Objetivo**

Realizar actividades en hilos para un fin común

**Instrucciones**

* Revisar el capítulo Hilos del libro de Joyanes pagina 697, pueden revisar todo el capítulo desde la página 669 o sólo el apartado que requerimos 690 hasta antes de tuberías.
* Con base en los archivos vistos en clase generar lo siguiente
  * Crear una clase Test que cree un arreglo de objetos geométricos:  cuadrado(elaboración libre) considerando tamaño y color para cada objeto(deben ser de diferente tamaño y color)
  * Crear dentro de la clase Test un hilo  que genere un objeto de la clase alfombra(esta clase almacenara los  objetos geométricos que se insertarán para cubrir toda el área de la misma) y creará hilos independiente para los siguientes hilos
    * Hilos asociados a cada objeto geométrico, calculadores de área que  se sumará en el padre.
    * Hilos que guarden en un archivo los datos de cada objeto geométrico, su coordenada en la alfombra, su color y su tamaño y el nombre del hilo que lo proceso
  * Al final el hilo padre debe mostrar el área obtenida como la suma del área de todas las figuras geométricas

---

#### Actividad 7

**Objetivo**

Aplicar las condiciones de Bernstein al proceso concurrente de la Actividad 6 Hilos Cooperando

**Instrucciones**

* Revisar las diapositivas Condiciones de Bernstein.pdf

Revisar el video [https://www.youtube.com/watch?v=riGl1djNpfg](https://www.youtube.com/watch?v=riGl1djNpfg)

* Aplicar las condiciones de Bernstein al proceso de cooperación de los hilos de la actividad 6
* Elaborar un documento donde se indique como se aplicaría
