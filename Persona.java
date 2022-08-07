//Integrantes//
// Emir Johan Mena Velasquez
// Victor Alfonso Angulo Camacho
// Yeferson Cordoba
// Marco Yamid Betancourt Valencia
// Jose Daniel Guerra Guerra
// Fernando Clavijo Aguilar

public class Persona {
    // Atributos de una persona
    private String nombre;
    private int edad;
    private String direccion;
    private  long cedula;
    private String celular;

    // Metodo para crear una persona
    // New Persona()
    public Persona(String nombre, int edad, String direccion, long cedula, String celular) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.cedula = cedula;
        this.celular = celular;
    }



    // Muestra la informacion basica de una persona, este se le heredara a clases hijas
    public void mostrarInformacionPersona() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Cedula: " + this.getCedula());
        System.out.println("Celular: " + this.getCelular());
        System.out.println("Direccion: " + this.getDireccion());

    }

    // Retorna el nombre de |la persona
    public String getNombre() {
        return nombre;
    }

    // Retorna la de edad de |la persona
    public int getEdad() {
        return edad;
    }

    //// Retorna la direccion de |la persona
    public String getDireccion() {
        return direccion;
    }

    // Retorna la cedula de |la persona
    public long getCedula() {
        return cedula;
    }

    // Retorna el celular  de |la persona
    public String getCelular() {
        return celular;
    }


}
