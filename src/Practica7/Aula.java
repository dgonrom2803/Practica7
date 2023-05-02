package Practica7;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Element;

public class Aula {
    private List<Estudiante> estudiantes;
    private List<Estudiante> estudiantesExcluidos;

    public Aula() {
        this.estudiantes = new ArrayList<>();
        this.estudiantesExcluidos = new ArrayList<>();
    }

    public void importarEstudiantes(String rutaFichero) {
        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new File(rutaFichero));
            Element root = doc.getRootElement();
            List<Element> elementos = root.getChildren();
            for (Element elemento : elementos) {
                String nombre = elemento.getAttributeValue("nombre");
                int intervenciones = Integer.parseInt(elemento.getAttributeValue("intervenciones"));
                Estudiante estudiante = new Estudiante(nombre, intervenciones);
                estudiantes.add(estudiante);
            }
        } catch (JDOMException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public void exportarEstudiantes(String rutaFichero) {
        try {
            Element root = new Element("estudiantes");
            for (Estudiante estudiante : estudiantes) {
                Element elemento = new Element("estudiante");
                elemento.setAttribute("nombre", estudiante.getNombre());
                elemento.setAttribute("intervenciones", String.valueOf(estudiante.getNumeroIntervenciones()));
                root.addContent(elemento);
            }
            Document doc = new Document(root);
            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
            out.output(doc, new java.io.FileWriter(rutaFichero));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Estudiante seleccionarEstudiante() {
        List<Estudiante> estudiantesDisponibles = new ArrayList<>(estudiantes);
        estudiantesDisponibles.removeAll(estudiantesExcluidos);
        if (estudiantesDisponibles.isEmpty()) {
            estudiantesDisponibles.addAll(estudiantes);
            estudiantesExcluidos.clear();
        }
        Collections.shuffle(estudiantesDisponibles);
        Estudiante estudianteSeleccionado = estudiantesDisponibles.get(0);
        int intervencionesMin = estudianteSeleccionado.getNumeroIntervenciones();
        for (int i = 1; i < estudiantesDisponibles.size(); i++) {
            Estudiante estudiante = estudiantesDisponibles.get(i);
            int intervenciones = estudiante.getNumeroIntervenciones();
            if (intervenciones < intervencionesMin) {
                estudianteSeleccionado = estudiante;
                intervencionesMin = intervenciones;
            }
        }
        estudianteSeleccionado.incrementarNumeroIntervenciones();
        return estudianteSeleccionado;
    }

    public void reiniciarIntervenciones() {
        for (Estudiante estudiante : estudiantes) {
            estudiante.setNumeroIntervenciones(0);
        }
    }
}

