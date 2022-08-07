//Integrantes//
// Emir Johan Mena Velasquez
// Victor Alfonso Angulo Camacho
// Yeferson Cordoba
// Marco Yamid Betancourt Valencia
// Jose Daniel Guerra Guerra
// Fernando Clavijo Aguilar

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crea un universidad y la llamo admin, con esto ejecutar todos los
        //funcionamientos que declare en la universidad
        Universidad admin = new Universidad();

        boolean usarSistemas = true;
        int respuesta;

        while (usarSistemas) {

            try {
                System.out.println("-----BIENVENIDO AL MENU DE LA APLICACION --------");
                System.out.println("1 : REGISTRO DE ESTUDIANTES");
                System.out.println("2 : REGISTRO DE PROFESORES");
                System.out.println("3 : REGISTRO DE CARRERAS PROFESIONALES");
                System.out.println("4 : REGISTRO DE MATERIAS");
                System.out.println("5 : CONSULTAR CUANTOS ESTUDIANTES HAY POR CARRERA");
                System.out.println("6 : CONSULTAR MATERIAS POR CARRERA");
                System.out.println("7 : CONSULTAR DATOS DE ESTUDIANTE");
                System.out.println("8 : CONSULTAR DATOS DE PROFESORES");
                System.out.println("9 : CONSULTAR TODOS LOS ESTUDIANTES");
                System.out.println("10: CONSULTAR TODOS LOS PROFESORES");
                System.out.println("11: SALIR DE SISTEMA");
                System.out.println("¿ QUE DESEA HACER ?");

                respuesta = Integer.parseInt(admin.teclado.nextLine());


                switch (respuesta){
                    case 1:
                        admin.agregarEstudiante();
                        break;
                    case 2:
                        admin.agregarProfesores();
                        break;
                    case 3:
                        admin.agregarCarrera();
                        break;
                    case 4 :
                        admin.agregarMateria();
                        break;
                    case 5:
                        admin.Carreras.forEach(Carrera::MostrarNumerosDeEstudiantes);
                        break;
                    case 6:
                        admin.Carreras.forEach(Carrera::mostrarMaterias);
                        break;
                    case 7:
                        admin.consultarDatosEstudiante();
                        break;
                    case 8:
                        admin.consultarDatosProfesor();
                        break;
                    case 9:
                        admin.mostrarTodosLosEstudiantes();
                        break;
                    case 10:
                        admin.mostrarTodosLosProfesores();
                        break;
                    case 11:
                        usarSistemas = false;
                        System.out.println("GRACIAS POR USAR NUESTRO SISTEMA");
                        break;
                    default:
                        System.out.println("opcion no valida, intentelo de nuevo con una de las opciones menciandas");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ha ocurrido un error durante la execucion del programa, asegurese de ingresar correstamente los datos tanto para consulta como para cargue de informacion");
            }

        }


    }
}
