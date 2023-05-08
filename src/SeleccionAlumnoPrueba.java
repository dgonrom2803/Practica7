import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SeleccionAlumnoPrueba {
    public static void main(String[] args) {
        seleccionAlumno();
    }
    public static void seleccionAlumno() {
        String path = "C://Users//victo//IdeaProjects//Practica7//src//daw1.xml";

        try {
            // Cargamos el archivo XML
            File daw1 = new File(path);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document archivo = db.parse(daw1);
            archivo.getDocumentElement().normalize();

            // Obtenemos los nodos del archivo XML que se llamen alumno
            NodeList alumnosClase = archivo.getElementsByTagName("alumno");

            // Declaramos arrays para poder almacenar los datos ya guardados dentro del arhivo XML
            String[] nombres = new String[alumnosClase.getLength()];
            String[] intervenciones = new String[alumnosClase.getLength()];

            // Antes hemos creado una lista llamaeda alumnos Clase , a continuacion con el metodo for recorremos dicha
            // lista
            for (int i = 0; i < alumnosClase.getLength(); i++) {
                Node etiquetaAlumno = alumnosClase.item(i);
                if (etiquetaAlumno.getNodeType() == Node.ELEMENT_NODE) {
                    Element valorAlumno = (Element) etiquetaAlumno;
                    nombres[i] = valorAlumno.getElementsByTagName("nombre").item(0).getTextContent();
                    intervenciones[i] = valorAlumno.getElementsByTagName("intervenciones").item(0).getTextContent();
                }
            }

            // Buscamos el alumno que tenga menos intervenciones
            int menosIntervenciones = Integer.MAX_VALUE;
            for (int i = 0; i < intervenciones.length; i++) {
                if (intervenciones[i] != null) {
                    int interAlumno = Integer.parseInt(intervenciones[i]);
                    if (interAlumno < menosIntervenciones) {
                        menosIntervenciones = interAlumno;
                    }
                }
            }
            // Con un ArrayList englobamos todos los alumnos que tengan menos intervenciones (el mismo número)
            List<Integer> posicionesAlumno = new ArrayList<>();
            for (int i = 0; i < intervenciones.length; i++) {
                if (intervenciones[i] != null && Integer.parseInt(intervenciones[i]) == menosIntervenciones) {
                    posicionesAlumno.add(i);
                }
            }
            // Elegimos un alumno de la lista de alumnos con menos intervenciones de manera aleatoria
            Random alumnoAleatorio = new Random();
            int posicionAleatoria = posicionesAlumno.get(alumnoAleatorio.nextInt(posicionesAlumno.size()));
            String Corrector = nombres[posicionAleatoria];
            System.out.println("El alumno encargado de corregir es: " + Corrector);

            // Creamos un scanner para ver si el alumno ha hecho o no el ejercicio
            Scanner hechoNoHecho = new Scanner(System.in);
            System.out.println("¿El alumno ha realizado el ejercicio?");
            System.out.println("-Sí. Introduzca 'yes'");
            System.out.println("-No. Introduzca 'no'");
            String respuesta = hechoNoHecho.nextLine();

            // Creamos un if con lo que pasaría si el alumno tiene la tarea
            if (respuesta.equals("yes")) {
                Element valorCorrector = null;
                for (int i = 0; i < alumnosClase.getLength(); i++) {
                    Node etiquetaAlumno = alumnosClase.item(i);
                    if (etiquetaAlumno.getNodeType() == Node.ELEMENT_NODE) {
                        Element valorAlumno = (Element) etiquetaAlumno;
                        String nombreAlumno = valorAlumno.getElementsByTagName("nombre").item(0).getTextContent();
                        if (nombreAlumno.equals(Corrector)) {
                            valorCorrector = valorAlumno;
                            break;
                        }
                    }
                }
                // Sumamos una intervencion si el alumno tiene la tarea
                String intervencionPrevia = valorCorrector.getElementsByTagName("intervenciones").item(0).getTextContent();
                int actualizacionIntervenciones = Integer.parseInt(intervencionPrevia) + 1;
                valorCorrector.getElementsByTagName("intervenciones").item(0).setTextContent(Integer.toString(actualizacionIntervenciones));

                System.out.println("El número de intervenciones del alumno ha aumentado");

                // Guardamos los cambios
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(archivo);
                StreamResult result = new StreamResult(new File(path));
                transformer.transform(source, result);

            } else if (respuesta.equals("no")) {
                System.out.println("No se han realizado cambios");
                seleccionAlumno();

            } else{
                System.out.println("Debe insertar una de las opciones por defecto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
