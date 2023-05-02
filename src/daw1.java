import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class daw1 {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        // Creamos el documento vacío para añadirle a continuación los nodos
        Document document = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument();

        // Creamos el nodo raíz
        Element daw1 = document.createElement("daw1");
        // Hacemos que cuelgue del documento
        document.appendChild(daw1);

        // Creamos el primer nodo y lo colgamos de su padre, el nodo raíz.
        Element alumno1 = document.createElement("alumno");
        daw1.appendChild(alumno1);

        // Creamos el segundo nodo y lo colgamos de su padre.
        Element nombreAlumno1 = document.createElement("nombre");
        alumno1.appendChild(nombreAlumno1);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text victor = document.createTextNode("Victor");
        // y lo colgamos del nodo anterior
        nombreAlumno1.appendChild(victor);

        // Creamos el tercer nodo y lo colgamos de su padre.
        Element interAlumno1 = document.createElement("intervenciones");
        alumno1.appendChild(interAlumno1);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text intervictor = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno1.appendChild(intervictor);

        // Creamos el primer nodo y lo colgamos de su padre, el nodo raíz.
        Element alumno2 = document.createElement("alumno");
        daw1.appendChild(alumno2);

        // Creamos el segundo nodo y lo colgamos de su padre.
        Element nombreAlumno2 = document.createElement("nombre");
        alumno2.appendChild(nombreAlumno2);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text diego = document.createTextNode("Diego");
        // y lo colgamos del nodo anterio
        nombreAlumno2.appendChild(diego);

        // Creamos el tercer nodo y lo colgamos de su padre.
        Element interAlumno2 = document.createElement("intervenciones");
        alumno2.appendChild(interAlumno2);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interdiego = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno2.appendChild(interdiego);

        // Creamos el primer nodo y lo colgamos de su padre, el nodo raíz.
        Element alumno3 = document.createElement("alumno");
        daw1.appendChild(alumno3);

        // Creamos el segundo nodo y lo colgamos de su padre.
        Element nombreAlumno3 = document.createElement("nombre");
        alumno3.appendChild(nombreAlumno3);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text jm = document.createTextNode("Juan María");
        // y lo colgamos del nodo anterior
        nombreAlumno3.appendChild(jm);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno3 = document.createElement("intervenciones");
        alumno3.appendChild(interAlumno3);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interjm = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno3.appendChild(interjm);

        // Clases necesarias para finalizar la creación del archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("src/daw1.xml"));

        // Se realiza la transformación, de Document a Fichero.
        transformer.transform(source, result);
    }
}

