//Integrantes//
// Emir Johan Mena Velasquez
// Victor Alfonso Angulo Camacho
// Yeferson Cordoba
// Marco Yamid Betancourt Valencia
// Jose Daniel Guerra Guerra
// Fernando Clavijo Aguilar

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Universidad {
    Scanner teclado = new Scanner(System.in);

    // Sirven para generar codigos unicos para las materia, carreras, los profesores, y los estudiantes
    int codigoMateria = 1;
    int codigosProfesores = 100;
    int codigosEstudiantes = 300;
    int codigosCarreras = 500;




    // 4 Listas para guardar las materias , los profesores, los estudiantes y las carreras
    List<Materia> Materias = new ArrayList<>();
    List<Estudiante> Estudiantes = new ArrayList<>();
    List<Profesor> Profesores = new ArrayList<>();
    List<Carrera> Carreras = new ArrayList<>();


    // Para crear una universidad
    public Universidad() {

        // Agregando materias iniciales
        Materias.add(new Materia("Calculo",codigoMateria++ ));
        Materias.add(new Materia("Programacion", codigoMateria++));
        Materias.add(new Materia("Redes", codigoMateria++));
        Materias.add(new Materia("Bases de datos", codigoMateria++));
        Materias.add(new Materia("Geometria", codigoMateria++));
        Materias.add(new Materia("Sociales", codigoMateria++));
        Materias.add(new Materia("Politica", codigoMateria++));
        Materias.add(new Materia("Relaciones publicas", codigoMateria++));
        Materias.add(new Materia("Inlges", codigoMateria++));
        Materias.add(new Materia("Historia", codigoMateria++));
        Materias.add(new Materia("Electiva WEB", codigoMateria++));
        Materias.add(new Materia("Pre calculo", codigoMateria++));



        // Carreras iniciales en el sistema
        List<Materia> materiasIngSistemas = List.of(
                this.getMateriaPorCodigo(2),
                this.getMateriaPorCodigo(3),
                this.getMateriaPorCodigo(4),
                this.getMateriaPorCodigo(9)
        );
        List<Materia> materiasCienciasSociales = List.of(
                this.getMateriaPorCodigo(8),
                this.getMateriaPorCodigo(7),
                this.getMateriaPorCodigo(5),
                this.getMateriaPorCodigo(6),
                this.getMateriaPorCodigo(10)
        );

        Carreras.add(new Carrera("ING SISTEMAS", codigosCarreras++,materiasIngSistemas));
        Carreras.add(new Carrera("CIENCIAS SOCIALES", codigosCarreras++,materiasCienciasSociales));

    }

    // Este metodo pide datos para crear un objecto materia y luego a gregarlo a mi lista de materias
    public void agregarMateria() {
        System.out.println("ESTAS AGREGANDO UNA NUEVA MATERIA");
        System.out.println("Nombre de la materia");
        String nombre = teclado.nextLine();
        this.Materias.add(new Materia(nombre,codigoMateria++));
    }



    public  void agregarEstudiante() {
        System.out.println("Estas agregando un nuevo ESTUDIANTE");
        System.out.println("Ingrese el NOMBRE del nuevo ESTUDIANTE");
        String nombre = teclado.nextLine();

        System.out.println("Ingrese la EDAD de " + nombre);
        int edad = teclado.nextInt();
        teclado.nextLine();


        System.out.println("Ingrese la DIRECCION de " + nombre);
        String direccion = teclado.nextLine();

        System.out.println("Ingrese la CEDULA de " + nombre);
        long cedula = teclado.nextLong();
        teclado.nextLine();

        System.out.println("Ingrese el numero CELULAR de " + nombre);
        String celular = teclado.nextLine();

        System.out.println("Selecionando carrera para " + nombre);

        // Muestra todas las correras en la universidad
        Carreras.forEach( c -> c.mostrarInformacionBasica());

        System.out.println("Ingrese el CODIGO de la carrera que desea");
        int codigo = teclado.nextInt();
        teclado.nextLine();

        // Con el codigo de carrera ingresado, valido si esa carrera existe en la universidad, y luego al nuevo estudante,
        // lo matriculo en ella, y lo guardo en mi lista de estudiantes
        boolean existeCarrera = Carreras.stream().anyMatch(c -> c.getCodigoCarrera() == codigo);
        if ( existeCarrera == true ){
            Carrera carretaBuscada = (Carrera) Carreras.stream().filter(c -> c.getCodigoCarrera() == codigo).toArray()[0];

            Estudiante nuevoEstudiante = new Estudiante(nombre,edad,direccion,cedula,celular,codigosEstudiantes++,codigo,carretaBuscada.getNombreCarrera());
            carretaBuscada.agregarEstudiante(nuevoEstudiante);
            this.Estudiantes.add(nuevoEstudiante);
            System.out.println("ESTUDIANTE AGREGADO CORRECTAMENTE");
        }
        else {
            System.out.println("No existe esa carrera en el sistema");
        }

    }

    // Pide la informacion basica para un profesor y luego guradarlo en mi lista de profesores
    public  void agregarProfesores() {
        System.out.println("Estas agregando un nuevo profesor");
        System.out.println("Ingrese el NOMBRE del nuevo profesor");
        String nombre = teclado.nextLine();

        System.out.println("Ingrese la EDAD de " + nombre);
        int edad = teclado.nextInt();
        teclado.nextLine();


        System.out.println("Ingrese la DIRECCION de " + nombre);
        String direccion = teclado.nextLine();

        System.out.println("Ingrese la CEDULA de " + nombre);
        long cedula = teclado.nextLong();
        teclado.nextLine();


        System.out.println("Ingrese el numero CELULAR de " + nombre);
        String celular = teclado.nextLine();

        // Le pido al usuario que selecione varias materias, las cuales se le agregaran como asignaturas que este profesores puede disctar
        List<Materia> materiasSelecionadas = this.SeleccinarMaterias(nombre);

        Profesor nuevoProfesor = new Profesor(nombre,edad,direccion,cedula,celular,codigosProfesores++,materiasSelecionadas);
        Profesores.add(nuevoProfesor);
        System.out.println("PROFESOR AGREGADO CORECTAMENTE");
    }

    
    // Este metodo sirve para agregar una carrera a la universidad 
    public  void agregarCarrera() {
        System.out.println("ESTAS AGREGANDO UNA NUEVA CARRERA");

        System.out.println("Ingrese el nombre de la nueva carrera");
        String nombre =  teclado.nextLine();
        // Crea una lista de materias para esta carrera que se este guardando
        List<Materia> materias = this.SeleccinarMaterias(nombre);

        //  Crea un objecto de la clase Carrera y lo guarda en mi lista de carreras
        Carrera nuevaCarrera = new Carrera(nombre, codigosCarreras++,materias);

        this.Carreras.add(nuevaCarrera);
        System.out.println("La carrera " + nombre + " se agrego correctamente");
    }

    // Sirve para consultar los datos de un estudiante
    public void consultarDatosEstudiante() {
        System.out.println("CONSULTANDO DATOS DE ESTUDIANTE");
        this.Estudiantes.forEach(e -> e.mostrarInformacionBasica());
        System.out.println("¿ Ingrese el codigo del estudiante para ver mas informacion");
        int codigo = teclado.nextInt();
        boolean existe = this.Estudiantes.stream().anyMatch(e -> e.getCodigoEstudiante() == codigo);
        if (!existe) System.out.println("EL codigo ingresado no corresponde a un estudante, intentelo de nuevo");
        else {
            Estudiante estudiante = (Estudiante) this.Estudiantes.stream()
                    .filter(e -> e.getCodigoEstudiante() == codigo)
                    .toArray()[0];
            estudiante.mostrarInformacionEstudiante();
        }
    }

    // Sirve para consultarDatos de un profesor
    public  void consultarDatosProfesor() {
        System.out.println("CONSULTANDO DATOS DE PROFESOR");
        this.Profesores.forEach(e -> e.mostrarInformacionBasica());
        System.out.println("¿ Ingrese el codigo del profesor para ver mas informacion");
        int codigo = teclado.nextInt();
        boolean existe = this.Profesores.stream().anyMatch(e -> e.getCodigoProfesor() == codigo);
        if (!existe) System.out.println("EL codigo ingresado no corresponde a un profesor, intentelo de nuevo");
        else {
            Profesor profesor = (Profesor) this.Profesores.stream()
                    .filter(e -> e.getCodigoProfesor() == codigo)
                    .toArray()[0];
            profesor.mostrarInformacionProfesor();
        }
    }

    //   Sirve para mostrar todos los profesores
    public void mostrarTodosLosProfesores() {
        this.Profesores.forEach(p -> p.mostrarInformacionBasica() );
    }

    // Sirve para mostrar todos los estudiantes
    public  void mostrarTodosLosEstudiantes() {
        this.Estudiantes.forEach(e -> e.mostrarInformacionBasica());
    }

    // Con este metodo seleciono materias para asignarlas a un profesor o una carrera
    public List<Materia> SeleccinarMaterias(String n ) {
        System.out.println("Estas creando una lista de materias para " + n );
        List<Materia> materiasSelecionadas = new ArrayList<Materia>();
        boolean agregarMateria = true;
        while (agregarMateria){
            System.out.println("LISTA DE MATERIAS DISPONIBLES PARA AGREGAR");
            Materias.forEach(m -> {
                int codigo = m.getCodigo();
                boolean estaAgregada = materiasSelecionadas.stream()
                        .anyMatch(materia -> materia.getCodigo() == codigo);
                if (!estaAgregada) m.mostrarInformacionMateria();
            });
            System.out.println("Ingrese el codigo de la materia que desea selecionar");
            int codigo = teclado.nextInt();
            teclado.nextLine();

           boolean agregada =  materiasSelecionadas.stream()
                    .anyMatch(m -> m.getCodigo() == codigo);
           if ( agregada) System.out.println("Esta materia ya esta agregada");
           else {
              Materia mat = (Materia) Materias.stream().filter(m -> m.getCodigo() == codigo)
                       .toArray()[0];
              materiasSelecionadas.add(mat);
               System.out.println("La materia : " + mat.getNombre() + "has sido selecionada");
           }


            System.out.println("¿ Desea seguir agregando ?");
            System.out.println("1 :  No, no desea seguir agregando");
            System.out.println("2:  Si, deseo seguir agregando");
            System.out.println("Otra cosa: Seguir guardando");
            String r = teclado.next();
            teclado.nextLine();

            if ( r.equals("1")) {
                agregarMateria = false;
                break;
            }

        }
        return  materiasSelecionadas;

    };

    // Reicibe o le ingresamos un codigo y nos de vuelve o nos entrega una materia que coincida con ese codigo
    public Materia getMateriaPorCodigo(int codigo) {
       Materia materiaBuscada = (Materia) this.Materias.stream().filter(m -> m.getCodigo() == codigo).toArray()[0];
       return  materiaBuscada;
    }
}
