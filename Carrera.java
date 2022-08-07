//Integrantes//
// Emir Johan Mena Velasquez
// Victor Alfonso Angulo Camacho
// Yeferson Cordoba
// Marco Yamid Betancourt Valencia
// Jose Daniel Guerra Guerra
// Fernando Clavijo Aguilar

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombreCarrera;
    private int codigoCarrera;
    // Una carrera tiene un listado de materias y un listado de estudiantes incriptos a ella
    private List<Materia> materiasDeCarrera;
    private  List<Estudiante> estudiantesMatriculados = new ArrayList<Estudiante>();

    // Constructor de un objecto carrera, para crear un carrera y guardarla en mi universidad
    public Carrera(String nombreCarrera, int codigoCarrera, List<Materia> materiasDeCarrera) {
        this.nombreCarrera = nombreCarrera;
        this.codigoCarrera = codigoCarrera;
        this.materiasDeCarrera = materiasDeCarrera;
    }
    
    
    // Muestra toda la informacion de la carrera, incluyendo sus materias

   public void mostrarInformacionCarrera() {
       System.out.println("-------------INICIO CARRERA------------------------");
       System.out.println("Nombre de la Carrera: " + this.getNombreCarrera());
       System.out.println("Codigo de la Carrera: " + this.getCodigoCarrera());
       System.out.println(" --------  Materias de la carrera ------------");
       this.materiasDeCarrera.forEach(m -> {
           m.mostrarInformacionMateria();
       });
       System.out.println("-------------FINAL CARRERA-----------------------------");
   }

   // Muestra el nombre y el codigo de una carrera
   public void mostrarInformacionBasica() {
       System.out.println("Nombre de la Carrera: " + this.getNombreCarrera());
       System.out.println("Codigo de la Carrera: " + this.getCodigoCarrera());
       System.out.println("--------------------------------------------------------------");
   }

   // Recibe un objecto estudiante para inscrirbirlo en esta carrera
   public void agregarEstudiante(Estudiante nuevoEstudiante){
        this.estudiantesMatriculados.add(nuevoEstudiante);
   }


   // Cuantos estudiantes hay en esta carrera
   public void MostrarNumerosDeEstudiantes() {
       System.out.println("----------------------------------------------------");
       System.out.println("Nombre de la carrera : " + this.getNombreCarrera());
       System.out.println("Estudantes Matriculados: " + this.estudiantesMatriculados.size());
       System.out.println("----------------------------------------------------");

   }

   // Muestra todas las materias que tenga un carrera
   public  void mostrarMaterias() {
       System.out.println("------------INICIO LISTA DE MATERIAS------------------------");
       System.out.println("Nombre de la carrera : " + this.getNombreCarrera());
       this.materiasDeCarrera.forEach(m -> {
           m.mostrarInformacionMateria();
       });
       System.out.println("--------------FINAL LISTA DE MATERIAS----------------------------");
   }


   // Muestra todos los estudiantes matriculados en esta carrera
   public  void mostrarEstudiantes() {

       System.out.println("Carrera : " + this.getNombreCarrera());
       if ( this.estudiantesMatriculados.size() == 0 ) System.out.println( this.nombreCarrera + "No tiene estudiantes");
       else {
           this.estudiantesMatriculados.forEach(e -> {
               e.mostrarInformacionBasica();
           });
       }
   }
    // Nos da el nombre de la carrera
    public String getNombreCarrera() {
        return nombreCarrera;
    }
     // Nos da el codigo de la carrera
    public int getCodigoCarrera() {
        return codigoCarrera;
    }
}
