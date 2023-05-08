import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.Random;

public class AlumnoAleatorio {


    public static void alumnoAleatorio () {
        try {
            // Cargar el archivo XML
            File file = new File("C:\\Users\\victo\\IdeaProjects\\Practica7\\src\\daw1.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            // Obtener la lista de nodos alumno
            NodeList alumnos = doc.getElementsByTagName("alumno");

            // Generar un número aleatorio entre 0 y el número de alumnos - 1
            Random random = new Random();
            int index = random.nextInt(alumnos.getLength());

            // Obtener el nombre del alumno en la posición aleatoria
            String nombre = alumnos.item(index).getFirstChild().getTextContent();

            // Mostrar el nombre por pantalla
            System.out.println("El nombre del alumno aleatorio es: " + nombre);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

