import java.util.Random;

// Creación clase Estudiante
public class Estudiante {
    private String nombre;
    private int numeroIntervenciones;

    // Constructor que recibe el nombre y el número de intervenciones
    public Estudiante(){}
    public Estudiante(String nombre, int numeroIntervenciones) {
        this.nombre = nombre;
        this.numeroIntervenciones = numeroIntervenciones;
    }

    // Métodos getters y setters para acceder y modificar atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroIntervenciones() {
        return numeroIntervenciones;
    }

    public void setNumeroIntervenciones(int numeroIntervenciones) {
        this.numeroIntervenciones = numeroIntervenciones;
    }

    public void agregarIntervencion() {
        this.numeroIntervenciones++;
    }
    public String toString() {
        return "Estudiante " + this.nombre + " con " + this.numeroIntervenciones + " intervenciones";
    }
    public static Estudiante seleccionarEstudiante(Estudiante[] estudiantes) {
        int menorIntervenciones = estudiantes[0].getNumeroIntervenciones();
        for (int i = 1; i < estudiantes.length; i++) {
            if (estudiantes[i].getNumeroIntervenciones() < menorIntervenciones) {
                menorIntervenciones = estudiantes[i].getNumeroIntervenciones();
            }
        }

        Estudiante[] candidatos = new Estudiante[estudiantes.length];
        int cantidadCandidatos = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].getNumeroIntervenciones() == menorIntervenciones) {
                candidatos[cantidadCandidatos] = estudiantes[i];
                cantidadCandidatos++;
            }
        }

        Random rand = new Random();
        Estudiante seleccionado = candidatos[rand.nextInt(cantidadCandidatos)];
        seleccionado.agregarIntervencion();
        return seleccionado;
    }


}
