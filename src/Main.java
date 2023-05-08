public class Main extends Estudiante {
    public static void main(String[] args) {
        Estudiante[] estudiantes = new Estudiante[15];
        estudiantes[0] = new Estudiante("Juan María", 0);
        estudiantes[1] = new Estudiante("Víctor", 0);
        estudiantes[2] = new Estudiante("Jorge", 0);
        estudiantes[3] = new Estudiante("Adrián",0);
        estudiantes[4] = new Estudiante("Daniel Alfonso",0);
        estudiantes[5] = new Estudiante("Jonathan",0);
        estudiantes[6] = new Estudiante("Diego",0);
        estudiantes[7] = new Estudiante("Juan Manuel Herrera",0);
        estudiantes[8] = new Estudiante("Juan Manuel Saborido",0);
        estudiantes[9] = new Estudiante("Pablo",0);
        estudiantes[10] = new Estudiante("David",0);
        estudiantes[11] = new Estudiante("Antonio",0);
        estudiantes[12] = new Estudiante("Julián",0);
        estudiantes[13] = new Estudiante("Ricardo",0);
        estudiantes[14] = new Estudiante("Pepe",0);

        Estudiante seleccionado = Estudiante.seleccionarEstudiante(estudiantes);
        System.out.println("Seleccionado: " + seleccionado);
    }
}