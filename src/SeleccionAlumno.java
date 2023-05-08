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

public class SeleccionAlumno {
    public static void main(String[] args) {
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

            // Buscar el alumno con menos intervenciones
            int menosIntervenciones = Integer.MAX_VALUE;
            for (int i = 0; i < intervenciones.length; i++) {
                if (intervenciones[i] != null) {
                    int interAlumno = Integer.parseInt(intervenciones[i]);
                    if (interAlumno < menosIntervenciones) {
                        menosIntervenciones = interAlumno;
                    }
                }
            }
            // Crear una lista de índices de los alumnos con la menor cantidad de intervenciones
            List<Integer> posAlumno = new ArrayList<>();
            for (int i = 0; i < intervenciones.length; i++) {
                if (intervenciones[i] != null && Integer.parseInt(intervenciones[i]) == menosIntervenciones) {
                    posAlumno.add(i);
                }
            }
            // Elegir aleatoriamente un índice de la lista de índices
            Random random = new Random();
            int randomIndex = posAlumno.get(random.nextInt(posAlumno.size()));

            // Obtener el nombre del alumno correspondiente al índice elegido
            String alumnoElegido = nombres[randomIndex];
            System.out.println("\nEl alumno encargado de corregir es: " + alumnoElegido);

            //En este caso definimos si lo que ha hecho el alumno ha sido correcto o no y le damos la opción al profesor de cambiar las intervenciones del alumno
            Scanner punto = new Scanner(System.in);
            System.out.println("\n¿El alumno ha realizado el ejercicio? \n-Sí. Pulse 'S' \n-No. Pulse 'N' \n-Saltar. Pulse 'O'");
            String puntuation = punto.nextLine();

            if (puntuation.equals("s")) {
                // Encontrar el nodo "alumno" correspondiente al alumno elegido
                Element elementoAlumnoElegido = null;
                for (int i = 0; i < alumnosClase.getLength(); i++) {
                    Node nodoAlumno = alumnosClase.item(i);
                    if (nodoAlumno.getNodeType() == Node.ELEMENT_NODE) {
                        Element elementoAlumno = (Element) nodoAlumno;
                        String nombreAlumno = elementoAlumno.getElementsByTagName("nombre").item(0).getTextContent();
                        //Mediante esta variable string cogemos el valor en el nodo nombre
                        //Mediante .item cogemos el valor 0 de ese nodo nombre (especificado mediante getElementByTagName) ejemplo Victor
                        if (nombreAlumno.equals(alumnoElegido)) {
                            elementoAlumnoElegido = elementoAlumno;
                            break;
                        }
                    }
                }
                // Para el caso en que no se encuentre al alumno nos dará un error
                if (elementoAlumnoElegido == null) {
                    System.out.println("Error: el alumno no se encuentra en la lista.");
                    return;
                }
                // Agregamos un punto de participación adicional para el alumno elegido
                String intervencionesAnteriores = elementoAlumnoElegido.getElementsByTagName("intervenciones").item(0).getTextContent();
                int participaciones = Integer.parseInt(intervencionesAnteriores) + 1;
                elementoAlumnoElegido.getElementsByTagName("intervenciones").item(0).setTextContent(Integer.toString(participaciones));
                //Mediante esta última línea editamos las intervenciones anteriores dejando las nuevas,
                //gracias al setTextContent añadimos los nuevos valores en el nodo intervenciones

                System.out.println("El número de intervenciones del alumno ha aumentado");

                // Finalmente, guardamos el documento XML actualizado en el archivo correspondiente
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(archivo);
                StreamResult result = new StreamResult(new File(path));
                transformer.transform(source, result);

            } else if (puntuation.equals("n")) {
                // Encontrar el nodo "alumno" correspondiente al alumno elegido
                Element elementoAlumnoElegido = null;
                for (int i = 0; i < alumnosClase.getLength(); i++) {
                    Node nodoAlumno = alumnosClase.item(i);
                    if (nodoAlumno.getNodeType() == Node.ELEMENT_NODE) {
                        Element elementoAlumno = (Element) nodoAlumno;
                        String nombreAlumno = elementoAlumno.getElementsByTagName("nombre").item(0).getTextContent();
                        //Mediante esta variable string cogemos el valor en el nodo nombre
                        //Mediante .item cogemos el valor 0 de ese nodo nombre (especificado mediante getElementByTagName) ejemplo Victor
                        if (nombreAlumno.equals(alumnoElegido)) {
                            elementoAlumnoElegido = elementoAlumno;
                            break;
                        }
                    }
                }
                // Para el caso en que no se encuentre al alumno nos dará un error
                if (elementoAlumnoElegido == null) {
                    System.out.println("Error: el alumno no se encuentra en la lista.");
                    return;
                }
                // Agregamos un punto de participación adicional para el alumno elegido
                String intervencionesAnteriores = elementoAlumnoElegido.getElementsByTagName("intervenciones").item(0).getTextContent();
                int participaciones = Integer.parseInt(intervencionesAnteriores) - 1;
                elementoAlumnoElegido.getElementsByTagName("intervenciones").item(0).setTextContent(Integer.toString(participaciones));
                //En este caso supuestamente debería de añadir el punto aunque no consigo encontrar el porqué de que no lo introduzca como tal

                System.out.println("El número de intervenciones del alumno ha disminuido");

                // Finalmente, guardamos el documento XML actualizado en el archivo correspondiente
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(archivo);
                StreamResult result = new StreamResult(new File(path));
                transformer.transform(source, result);

            } else if (puntuation.equals("o")) {
                System.out.println("No se han realizado cambios");
            } else{
                System.out.println("Debe insertar una de las opciones dadas");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}