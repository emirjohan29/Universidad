//Integrantes//
// Emir Johan Mena Velasquez
// Victor Alfonso Angulo Camacho
// Yeferson Cordoba
// Marco Yamid Betancourt Valencia
// Jose Daniel Guerra Guerra
// Fernando Clavijo Aguilar

public class Estudiante extends  Persona {
    // Atributos de una persona
    // El estudiante hereda tambien los abributos de Persona
    private int codigoEstudiante;
    private int codigoCarrera;
    private  String nombreCarrera;
    
    // Metodo constructor, sirve para crear un objecto tipo Estudiante (para crear un estudiantes)
    public Estudiante(String nombre, int edad, String direccion, long cedula, String celular, int codigoEstudiante, int codigoCarrera, String nombreCarrera) {
        super(nombre, edad, direccion, cedula, celular);
        this.codigoEstudiante = codigoEstudiante;
        this.codigoCarrera = codigoCarrera;
        this.nombreCarrera = nombreCarrera;
    }

    // Muestra el nombre y el codigo del estudiante
    public  void mostrarInformacionBasica() {
        System.out.println("Codigo Estudiante:" + this.getCodigoEstudiante());
        System.out.println("Nombre : " + this.getNombre());
        System.out.println("----------------------------------------------");

    }

    // Muestra toda la informacion de un estudiante, incluso la basica
    public void mostrarInformacionEstudiante() {
        
        // Este metodo es heredado de la clase Persona
        this.mostrarInformacionPersona();
        System.out.println("Codigo Estudiante: " + this.getCodigoEstudiante());
        System.out.println("CodigoCarrera: " + this.getCodigoCarrera());
        System.out.println("Carrera: " + this.getNombreCarrera());
        System.out.println("------------------------------------------------------");
    }

    // Nos da el codigo del estudiante
    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }
    // Nos da el codigo de la carrera que inscrito el estudiante
    public int getCodigoCarrera() {
        return codigoCarrera;
    }
    // Nos da el nombre de la carrera que este inscrito el estudiante
    public String getNombreCarrera() {
        return nombreCarrera;
    }
}
