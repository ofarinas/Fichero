package fichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author osvaldo
 */
public class FileManipulator {
//busca la palabra mayor de un fichero y la escribe en otro
    public static void palabraMayor(String fichero, String FicheroEscribir) {
        Scanner scanner = null;
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(FicheroEscribir);
            scanner = new Scanner(new BufferedReader(new FileReader(fichero)));
            String aux = "";
            String palabra="";
            while (scanner.hasNext()) {
                palabra=scanner.next();
                if (aux.length() < palabra.length()) {
                    aux=palabra;
                }
            }
            printStream.print(aux);

        } catch (IOException e) {
            System.out.println("mal funcionamiento");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (printStream != null) {
                printStream.close();
            }
        }
    }
}
