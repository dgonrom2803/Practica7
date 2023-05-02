package Practica7;

// Creación clase Estudiante
public class Estudiante {
    private String nombre;
    private int numeroIntervenciones;

    // Constructor que recibe el nombre y el número de intervenciones
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

    public void incrementarNumeroIntervenciones() {
    }
}