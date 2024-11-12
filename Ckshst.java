import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import files.Files;

public class Ckshst {

    boolean datosCargados = false;
    int[] arreglo;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean continuarProceso = true;
        String lectura;

        do {
            Ckshst instancia = new Ckshst();
            instancia.iniciar();

            do {
                System.out.print("¿Continuar en el programa(s/n)?: ");
                lectura = reader.readLine();
                if (lectura.charAt(0)) {
                    
                } else {
                    
                }
            } while (
                lectura.charAt(0) != 's' &&
                lectura.charAt(0) != 'S' &&
                lectura.charAt(0) != 'n' &&
                lectura.charAt(0) != 'N'
            );

        } while (continuarProceso);
    }

    public void iniciar() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "datos_ckshst";
        Files files = new Files();
        int options;

        do {
            System.out.println("Bienvenid@ al menú de opciones para el Cocktail-Shaker-Sort");
            System.out.println("Presiona 1 -> Cargar datos");
            System.out.println("Presiona 2 -> Guardar Datos");
            System.out.println("Presiona 3 -> !!Proceder sin Almacenamiento!!");
            options = Integer.parseInt(reader.readLine());

            switch (options) {
                case 1:
                    datosCargados = true;
                    arreglo = files.ReadFileIntToArray(fileName);
                    break;
                case 2:
                    datosCargados = false;
                    arreglo = preguntarDatos();
                    if (arreglo != null) {
                        files.writeIntArrayToFile(fileName, arreglo);
                        System.out.println("Datos guardados en el archivo " + fileName + ".txt");
                    } else {
                        System.out.println("No hay datos cargados para guardar.");
                    }
                    break;
                case 3:
                    datosCargados = false;
                    arreglo = preguntarDatos();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (options < 1 || options > 3);

            System.out.println("\nArreglo original:");
            imprimirArreglo();

            System.out.println("\nOrdenando el arreglo con el algoritmo Cocktail Sort...");
            cocktailSort();

            System.out.println("\nArreglo ordenado:");
            imprimirArreglo();

            System.out.println("No se realizaron operaciones debido a la falta de datos.");

    }

    public void cocktailSort() {
        boolean c;
        do {
            c = false;
            for (int i = 0; i < arreglo.length - 1; i++) {
                if (arreglo[i] > arreglo[i + 1]) {
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = temp;
                    c = true;
                }
            }

            if (!c) break;

            c = false;
            for (int i = arreglo.length - 2; i >= 0; i--) {
                if (arreglo[i] > arreglo[i + 1]) {
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = temp;
                    c = true;
                }
            }
        } while (c);
    }

    public void imprimirArreglo() {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int[] preguntarDatos() throws IOException {
        int[] arregloPreguntarDatos;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String leer;

        System.out.println("Cantidad de datos a guardar: ");
        leer = reader.readLine();
        arregloPreguntarDatos = new int[Integer.parseInt(leer)];

        for (int i = 0; i < arregloPreguntarDatos.length; i++) {
            System.out.println("Dato n° " + i + ": ");
            leer = reader.readLine();
            arregloPreguntarDatos[i] = Integer.parseInt(leer);
        }

        return arregloPreguntarDatos;

    }

}