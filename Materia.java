//Integrantes//
// Emir Johan Mena Velasquez
// Victor Alfonso Angulo Camacho
// Yeferson Cordoba
// Marco Yamid Betancourt Valencia
// Jose Daniel Guerra Guerra
// Fernando Clavijo Aguilar

public class Materia {
    // Atrubustos de una materia
    private String nombre;
    private  int codigo;

    // Para crear una materia
    public Materia(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    // Muestra  toda la informacion de una materia
    public void mostrarInformacionMateria() {
        System.out.println("-----------------------------------------");
        System.out.println("Codigo de materia: " + this.getCodigo());
        System.out.println("Nombre de la materia: " + this.getNombre());
        System.out.println("-------------FIN MATERIA----------");
    }

    // Nos da el nombre de la materia
    public String getNombre() {
        return nombre;
    }

    // Nos da el codigo de la carrera
    public int getCodigo() {
        return codigo;
    }
}
