import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.util.Scanner;

public class ExportarXML {

    public static void exportaXML() throws ParserConfigurationException, TransformerException, IOException {
        Scanner export = new Scanner(System.in);
        System.out.println("Escriba la ruta de exportación");
        String rutaExportacion = export.nextLine();


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
        Text victor = document.createTextNode("Víctor");
        // y lo colgamos del nodo anterior
        nombreAlumno1.appendChild(victor);

        // Creamos el tercer nodo y lo colgamos de su padre.
        Element interAlumno1 = document.createElement("intervenciones");
        alumno1.appendChild(interAlumno1);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interVictor = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno1.appendChild(interVictor);

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
        Text interDiego = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno2.appendChild(interDiego);

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
        Text interJm = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno3.appendChild(interJm);


        /////////////////////////////// 4
        Element alumno4 = document.createElement("alumno");
        daw1.appendChild(alumno4);

        Element nombreAlumno4 = document.createElement("nombre");
        alumno4.appendChild(nombreAlumno4);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text pablo = document.createTextNode("Pablo");
        // y lo colgamos del nodo anterior
        nombreAlumno4.appendChild(pablo);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno4 = document.createElement("intervenciones");
        alumno4.appendChild(interAlumno4);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interPablo = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno4.appendChild(interPablo);


        /////////////////////////////// 5
        Element alumno5 = document.createElement("alumno");
        daw1.appendChild(alumno5);

        Element nombreAlumno5 = document.createElement("nombre");
        alumno5.appendChild(nombreAlumno5);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text jorge = document.createTextNode("Jorge");
        // y lo colgamos del nodo anterior
        nombreAlumno5.appendChild(jorge);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno5 = document.createElement("intervenciones");
        alumno5.appendChild(interAlumno5);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interJorge = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno5.appendChild(interJorge);


        /////////////////////////////// 6
        Element alumno6 = document.createElement("alumno");
        daw1.appendChild(alumno6);

        Element nombreAlumno6 = document.createElement("nombre");
        alumno6.appendChild(nombreAlumno6);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text adrian = document.createTextNode("Adrián");
        // y lo colgamos del nodo anterior
        nombreAlumno6.appendChild(adrian);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno6 = document.createElement("intervenciones");
        alumno6.appendChild(interAlumno6);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interAdrian = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno6.appendChild(interAdrian);


        /////////////////////////////// 7
        Element alumno7 = document.createElement("alumno");
        daw1.appendChild(alumno7);

        Element nombreAlumno7 = document.createElement("nombre");
        alumno7.appendChild(nombreAlumno7);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text daniel = document.createTextNode("Daniel");
        // y lo colgamos del nodo anterior
        nombreAlumno7.appendChild(daniel);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno7 = document.createElement("intervenciones");
        alumno7.appendChild(interAlumno7);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interDaniel = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno7.appendChild(interDaniel);


        /////////////////////////////// 8
        Element alumno8 = document.createElement("alumno");
        daw1.appendChild(alumno8);

        Element nombreAlumno8 = document.createElement("nombre");
        alumno8.appendChild(nombreAlumno8);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text jonathan = document.createTextNode("Jonathan");
        // y lo colgamos del nodo anterior
        nombreAlumno8.appendChild(jonathan);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno8 = document.createElement("intervenciones");
        alumno8.appendChild(interAlumno8);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interJonathan = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno8.appendChild(interJonathan);


        /////////////////////////////// 9
        Element alumno9 = document.createElement("alumno");
        daw1.appendChild(alumno9);

        Element nombreAlumno9 = document.createElement("nombre");
        alumno9.appendChild(nombreAlumno9);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text herrera = document.createTextNode("Juan Manuel Herrera");
        // y lo colgamos del nodo anterior
        nombreAlumno9.appendChild(herrera);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno9 = document.createElement("intervenciones");
        alumno9.appendChild(interAlumno9);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interHerrera = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno9.appendChild(interHerrera);


        /////////////////////////////// 10
        Element alumno10 = document.createElement("alumno");
        daw1.appendChild(alumno10);

        Element nombreAlumno10 = document.createElement("nombre");
        alumno10.appendChild(nombreAlumno10);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text saborido = document.createTextNode("Juan Manuel Saborido");
        // y lo colgamos del nodo anterior
        nombreAlumno10.appendChild(saborido);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno10 = document.createElement("intervenciones");
        alumno10.appendChild(interAlumno10);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interSaborido = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno10.appendChild(interSaborido);


        /////////////////////////////// 11
        Element alumno11 = document.createElement("alumno");
        daw1.appendChild(alumno11);

        Element nombreAlumno11 = document.createElement("nombre");
        alumno11.appendChild(nombreAlumno11);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text david = document.createTextNode("David");
        // y lo colgamos del nodo anterior
        nombreAlumno11.appendChild(david);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno11 = document.createElement("intervenciones");
        alumno11.appendChild(interAlumno11);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interDavid = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno11.appendChild(interDavid);


        /////////////////////////////// 12
        Element alumno12 = document.createElement("alumno");
        daw1.appendChild(alumno12);

        Element nombreAlumno12 = document.createElement("nombre");
        alumno12.appendChild(nombreAlumno12);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text telles = document.createTextNode("Antonio");
        // y lo colgamos del nodo anterior
        nombreAlumno12.appendChild(telles);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno12 = document.createElement("intervenciones");
        alumno12.appendChild(interAlumno12);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interAntonio = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno12.appendChild(interAntonio);


        /////////////////////////////// 13
        Element alumno13 = document.createElement("alumno");
        daw1.appendChild(alumno13);

        Element nombreAlumno13 = document.createElement("nombre");
        alumno13.appendChild(nombreAlumno13);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text julian = document.createTextNode("Julián");
        // y lo colgamos del nodo anterior
        nombreAlumno13.appendChild(julian);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno13 = document.createElement("intervenciones");
        alumno13.appendChild(interAlumno13);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interJulian = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno13.appendChild(interJulian);


        /////////////////////////////// 14
        Element alumno14 = document.createElement("alumno");
        daw1.appendChild(alumno14);

        Element nombreAlumno14 = document.createElement("nombre");
        alumno14.appendChild(nombreAlumno14);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text ricardo = document.createTextNode("Ricardo");
        // y lo colgamos del nodo anterior
        nombreAlumno14.appendChild(ricardo);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno14 = document.createElement("intervenciones");
        alumno14.appendChild(interAlumno14);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interRicardo = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno14.appendChild(interRicardo);


        /////////////////////////////// 15
        Element alumno15 = document.createElement("alumno");
        daw1.appendChild(alumno15);

        Element nombreAlumno15 = document.createElement("nombre");
        alumno15.appendChild(nombreAlumno15);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text pepe = document.createTextNode("Pepe");
        // y lo colgamos del nodo anterior
        nombreAlumno15.appendChild(pepe);

        // Creamos el tercer nodo y lo colgamos de su padre
        Element interAlumno15 = document.createElement("intervenciones");
        alumno15.appendChild(interAlumno15);

        // Creamos un nodo de texto que será el valor del elemento anterior
        Text interPepe = document.createTextNode("0");
        // y lo colgamos del nodo anterior
        interAlumno15.appendChild(interPepe);


        // Clases necesarias para finalizar la creación del archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(rutaExportacion));

        // Se realiza la transformación, de Document a Fichero.
        transformer.transform(source, result);

    }
}