package files;

import java.io.File;
//import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Files {

    public int countFileLines(String fileName) {
        File file; // Apunta a un archivo físico en el DD
        FileReader reader; // llave con permisos de solo lectura
        BufferedReader br; // Recuperar info del archivo
        int numLines = 0;

        try {
            // crear un apuntador al archivo físico
            System.out.println("Filename: " + fileName);
            file = new File("C:\\archivos\\" + fileName + ".txt");
            // abrir el archivo para lectura
            reader = new FileReader(file);
            // configurar el buffer para leer los datos del archivo
            br = new BufferedReader(reader);
            while ( (br.readLine()) != null) {
                numLines++;
            }
            reader.close();
        } catch ( Exception e ) {
            System.out.println( "Error al leer el archivo" + e.toString() );
        }

        System.out.println("Countlines: " + numLines);

        return numLines;
    }

    public void ReadFileInScreen(String fileName) {
        File file; // Apunta a un archivo físico en el DD
        FileReader reader; // llave con permisos de solo lectura
        BufferedReader br; // Recuperar info del archivo
        String line;

        try {
            // crear un apuntador al archivo físico
            System.out.println("Filename: " + fileName);
            file = new File("C:\\archivos\\" + fileName + ".txt");
            // abrir el archivo para lectura
            reader = new FileReader(file);
            // configurar el buffer para leer los datos del archivo
            br = new BufferedReader(reader);
            while ( (line = br.readLine()) != null) {
                System.out.println("línea leída: " + line);
            }
            reader.close();
        } catch ( Exception e ) {
            System.out.println( "Error al leer el archivo" + e.toString() );
        }
    }   

    public int[] ReadFileIntToArray(String filename) {
        int[] arregloAMostrar = null;
        File file;
        FileReader reader;
        BufferedReader br;
        String line;
        int fileLines = 0;
    
        try {
            // Establece el archivo y cuenta las líneas
            file = new File("C:\\archivos\\" + filename + ".txt");
            reader = new FileReader(file);
            fileLines = countFileLines(filename);
    
            // Inicializa el arreglo con el número de líneas contadas
            arregloAMostrar = new int[fileLines];
            br = new BufferedReader(reader);
    
            int i = 0;
            while ((line = br.readLine()) != null) {
                try {
                    arregloAMostrar[i] = Integer.parseInt(line.trim());
                    i++;
                } catch (NumberFormatException e) {
                    System.out.println("Línea no válida en el archivo: " + line);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.toString());
        }
    
        return arregloAMostrar;
    }

    public String[] fileToStringArray(String fileName) {
        File file; // Apunta a un archivo físico en el DD
        FileReader reader; // llave con permisos de solo lectura
        BufferedReader br; // Recuperar info del archivo
        String line; // Linea recuperada del archivo de texto
        String[] array = null;
        int t; // Tamaño del archivo en lineas de texto
        int i = 0; // Indice del arreglo
        
        try {
            // Obtener el tamaño el archivo en líneas
            t = countFileLines(fileName);
            System.out.println( "ttttttttttttttt(fileToStringArray): " + t);
            array = new String[t];
            file = new File("C:\\archivos\\" + fileName + ".txt");
            reader = new FileReader(file);
            br = new BufferedReader(reader);
            while ( ( line = br.readLine() ) != null ) {
                array[i] = line;
                i++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + fileName);
        }
        
        return array;
    }

    public int[] fileToIntArray(String fileName) {
        File file; // Apunta a un archivo físico en el DD
        FileReader reader; // llave con permisos de solo lectura
        BufferedReader br; // Recuperar info del archivo
        String line; // Linea recuperada del archivo de texto
        int[] array = null;
        int t; // Tamaño del archivo en lineas de texto
        int i = 0; // Indice del arreglo
        
        try {
            // Obtener el tamaño el archivo en líneas
            t = countFileLines(fileName);
            System.out.println( "ttttttttttttttt(fileToStringArray): " + t);
            array = new int[t];
            file = new File("C:\\archivos\\" + fileName + ".txt");
            reader = new FileReader(file);
            br = new BufferedReader(reader);
            while ( ( line = br.readLine() ) != null ) {
                array[i] = Integer.parseInt(line);
                i++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + fileName);
        }
        
        return array;
    }

    public void printStringArray(String[] array){
        for ( String element : array ) {
            System.out.println(element);
        }
    }

    public void printIntArray(int[] array){
        for ( int element : array ) {
            System.out.println(element);
        }
    }

    public void writeKeyboardToFile(String fileName) {
        // Un apuntador a un espacio físico en el disco duro
        FileWriter file;
        // Llave de acceso para el archivo
        PrintWriter writer;
        // Configurar buffer p leer del teclado
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;

        try {
            // Apuntando a un espacio físico del disco duro
            file = new FileWriter("c:\\archivos\\" + fileName + ".txt");
            // Crear y abrir archivo en modo escritura
            writer = new PrintWriter(file);
            do {
                System.out.println("Escribe datos para guardar al archivo: ");
                entrada = bufer.readLine();
                // Guardar la entrada del archivo
                writer.println(entrada);
                System.out.println("Escriba x para salir, este campo no puede estar vacio");
                entrada = bufer.readLine();
                respuesta = entrada.charAt(0);
            } while ( respuesta != 'x' );
            file.close();
        } catch (Exception e) {
            System.out.println("################ Error al escribir el archivo ################");
            System.out.println("################ Error:                       ################");
            System.out.println(e.toString());
        }
    }

    public void writeIntArrayToFile(String fileName, int[] numeros) {
    FileWriter file;
    PrintWriter writer;

    try {
        file = new FileWriter("c:\\archivos\\" + fileName + ".txt");
        writer = new PrintWriter(file);

        for (int numero : numeros) {
            writer.println(numero);
        }

        writer.close();
        System.out.println("Arreglo " + fileName + ".txt convertido y almacenado");
    } catch (IOException e) {
        System.out.println("Error al escribir el archivo: " + e.getMessage());
    }
}

    public void writeStringArraydToFile(String fileName) {
        // Un apuntador a un espacio físico en el disco duro
        FileWriter file;
        // Llave de acceso para el archivo
        PrintWriter writer;
        // Configurar buffer p leer del teclado
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;

        try {
            // Apuntando a un espacio físico del disco duro
            file = new FileWriter("c:\\archivos\\" + fileName + ".txt");
            // Crear y abrir archivo en modo escritura
            writer = new PrintWriter(file);
            do {
                System.out.println("Escribe datos para guardar al archivo: ");
                entrada = bufer.readLine();
                // Guardar la entrada del archivo
                writer.println(entrada);
                System.out.println("Escriba x para salir, este campo no puede estar vacio");
                entrada = bufer.readLine();
                respuesta = entrada.charAt(0);
            } while ( respuesta != 'x' );
            file.close();
        } catch (Exception e) {
            System.out.println("################ Error al escribir el archivo ################");
            System.out.println("################ Error:                       ################");
            System.out.println(e.toString());
        }
    }

}
