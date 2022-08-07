//Integrantes//
// Emir Johan Mena Velasquez
// Victor Alfonso Angulo Camacho
// Yeferson Cordoba
// Marco Yamid Betancourt Valencia
// Jose Daniel Guerra Guerra
// Fernando Clavijo Aguilar

import java.util.List;

public class Profesor extends Persona {
    // El profesor hereda los atributos o informacion de una Persona por que este hereda de ella
    private int codigoProfesor;
    // Lista de materias que puede dictar un profesor
    private List<Materia> materiasDictadas;

    // Para crear un profesosr (o una instancio o objecto tipo profesor)
    public Profesor(String nombre, int edad, String direccion, long cedula, String celular, int codigoProfesor, List<Materia> materiasDictadas) {
        super(nombre, edad, direccion, cedula, celular);
        this.codigoProfesor = codigoProfesor;
        this.materiasDictadas = materiasDictadas;
    }
    // Muestra el nombre y el cidigo del profesor
    public void mostrarInformacionBasica() {
        System.out.println("Nombre del profesor: " + this.getNombre());
        System.out.println("Codigo profesor: " +this.getCodigoProfesor() );
    }

    // Muestra toda las informacion del profesor, la heredada, propia y sus materias
    public void mostrarInformacionProfesor() {
        this.mostrarInformacionPersona();
        System.out.println("Codigo profesor: " +this.getCodigoProfesor() );
        this.mostrarMateriasDictadas();
        System.out.println("---------------------------------------------------");
    }
    // Muestra todas las meterias que se le asignaron al profesor al momento de crearlo
    public void mostrarMateriasDictadas() {
        System.out.println("Materias dictadas por: " + this.getNombre());
        materiasDictadas.forEach(m -> {
            m.mostrarInformacionMateria();
        });
        System.out.println("-------------------------------------------------");
    }
    // Para obtener el codigo del profesor
    public int getCodigoProfesor() {
        return codigoProfesor;
    }
}
