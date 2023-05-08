import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CargarXML {

    public static void main(String[] args) {
        try {
            // Crear un objeto File con la ruta del archivo XML
            File file = new File("daw1.xml"); // Cambiar el nombre del archivo

            // Crear una instancia de DocumentBuilderFactory y DocumentBuilder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Leer el archivo XML y obtener un objeto Document
            Document doc = db.parse(file);

            // Normalizar el documento
            doc.getDocumentElement().normalize();

            // Acceder al nodo raíz del documento
            Element root = doc.getDocumentElement();
            System.out.println("Nodo raíz: " + root.getNodeName());

            // Obtener una lista de nodos que coinciden con una etiqueta
            NodeList lista = doc.getElementsByTagName("alumno"); // Cambiar la etiqueta

            // Recorrer la lista de nodos
            for (int i = 0; i < lista.getLength(); i++) {
                // Acceder a un nodo específico por su índice
                Node nodo = lista.item(i);
                System.out.println("\nNodo actual: " + nodo.getNodeName());

                // Comprobar si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Convertir el nodo en un elemento
                    Element elemento = (Element) nodo;

                    // Obtener el texto que contiene el elemento nombre
                    System.out.println("Nombre: " + elemento.getElementsByTagName("nombre").item(0).getTextContent());

                    // Obtener el texto que contiene el elemento intervenciones
                    System.out.println("Intervenciones: " + elemento.getElementsByTagName("intervenciones").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

