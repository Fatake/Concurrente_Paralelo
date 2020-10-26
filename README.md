# Concurrente y Paralelo

Serie de programas creados en python, java y c para el aprendizaje de concurrencia y paralelismo


## Tabla de contenidos

1. [Actividad4](https://github.com/Fatake/Concurrente_Paralelo/tree/master/Activida4 "Actividad4")
2. [Actividad6](https://github.com/Fatake/Concurrente_Paralelo/tree/master/Actividad6 "Actividad6")


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
#### Actividad 6

**Objetivo**

Aplicar los conceptos de semáforos, monitores o pasos de mensajes para resolver un problema de carácter concurrente
**Instrucciones**

* Video https://www.youtube.com/watch?v=ZEitds5Nnx4
* Revisar el video https://www.youtube.com/watch?v=riGl1djNpfg
* Revisar el tema de tuberías del libro Java 2: curso de programación
* De la página 714 a la 718 https://elibro-net.proxydgb.buap.mx/es/ereader/bibliotecasbuap/59727?page=742

* Crear la simulación de un entorno concurrente del siguiente escenario con su correspondiente análisis:
 
Proceso de inscripción primavera 2021: en ese caso se modelará cuando la Secretaría Académica solicita a los profesores inscribirse a las materias(archivo), inicialmente el archivo solo tiene materias y los profesores las solicitan, cuidando que no se asigne la misma materia a dos profesores distintos, posteriormente la Secretaría publica los horarios para que los alumnos se puedan inscribir, por lo que los alumnos sólo podrán ver las materias hasta que los profesores tomen las mismas, considerar que un curso puede ser solicitado por muchos alumnos pero tiene una capacidad finita. Si el curso (nrc) ya no tiene capacidad tendrá opción de inscribirse en otro nrc. No es necesario modelar toda la población de profesores y estudiantil sólo con al menos 5 profesores y 5 alumnos y el número de nrc que consideren.

