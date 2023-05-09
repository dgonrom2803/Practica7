import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args){

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while(!salir){

            System.out.println("1. Crear XML Base");
            System.out.println("2. Importar XML");
            System.out.println("3. Exportar XML");
            System.out.println("4. Seleccionar alumno");
            System.out.println("5. Poner a 0 todas las intervenciones");
            System.out.println("6. Salir");


            try {

            System.out.println("Escriba una de las opciones");
            opcion = sn.nextInt();

                switch(opcion) {
                    case 1:
                        System.out.println("Has seleccionado opción 1");
                        Daw1.daw1();
                        break;
                    case 2:
                        System.out.println("Has seleccionado opción 2");
                        ImportarXML.importaXML();
                        break;
                    case 3:
                        System.out.println("Has seleccionado opción 3");
                        ExportarXML.exportaXML();
                        break;
                    case 4:
                        System.out.println("Has seleccionado opción 4");
                        SeleccionAlumnoPrueba.seleccionAlumno();
                        break;
                    case 5:
                        System.out.println("Has seleccionado opción 5" );
                        Daw1.daw1();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe insertar un número");
                sn.next();
            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (SAXException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

