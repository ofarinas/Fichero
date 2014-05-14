/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fichero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author osvaldo
 */
public class Fichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String leer = "D:\\leer.txt";
        String fEscritor = "D:\\es.txt";
        //    palabraMayor(leer, fEscritor);
        //   digitos(leer, fEscritor);
        letraMayuscula(leer, fEscritor);
    }

    public static void palabraMayor(String fichero, String FicheroEscribir) {
        Scanner scanner = null;
        PrintStream printStream = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fichero)));
            printStream = new PrintStream(FicheroEscribir);
            String aux = "";
            String palabra = "";
            while (scanner.hasNext()) {
                palabra = scanner.next();
                if (aux.length() < palabra.length()) {
                    aux = palabra;
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
// ve cuales son numeros del fichero y lo escibe en otro

    public static void digitos(String fichero, String FicheroEscribir) {
        Scanner scanner = null;
        PrintStream printStream = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fichero)));
            printStream = new PrintStream(FicheroEscribir);
            while (scanner.hasNext()) {
                String f = scanner.next();
                if (f.matches("(\\d)+")) {
                    printStream.print(" " + f + " ");
                }

            }

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
// convierte la 1 era letra a mayuscula de cada palabra y lo gurad en le fichero

    public static void letraMayuscula(String fichero, String FicheroEscribir) {
        Scanner scanner = null;
        PrintStream printStream = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fichero)));
            printStream = new PrintStream(FicheroEscribir);
            while (scanner.hasNextLine()) {
                String f = scanner.nextLine();

                printStream.println(lineaCambiada(f));

            }

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

    private static String lineaCambiada(String f) {
        Pattern pattern = Pattern.compile("(\\w)+");
        Matcher matcher = pattern.matcher(f);
        String aux = "";
        String aux2 = "";
        while (matcher.find()) {
            aux2=matcher.group();
            aux += matcher.group(0).substring(0, 1).toUpperCase() + matcher.group(0).substring(1) + " ";
        }
        return aux.trim();
    }
}
