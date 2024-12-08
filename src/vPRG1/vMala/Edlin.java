package vPRG1.vMala;
import java.util.Scanner;

// Esta clase hace un editor de texto tipo EDLIN
// Creada por mi el 8/12/2024
// Modificada por última vez el 8/12/2024 a las 15:45
// TODO: Añadir más funcionalidades
// FIXME: Arreglar bugs
public class Edlin {
    // Variables globales para usar en toda la clase
    static Scanner input = new Scanner(System.in);  // Scanner global
    static int x = 1;                   // línea activa
    static String[] doc;                // documento
    static boolean continuar = true;    // flag para el bucle principal

    // Método principal que ejecuta todo
    public static void main(String[] args) {
        // Inicializamos el documento con el texto inicial
        doc = new String[]{
                "Bienvenidos al editor EDLIN",
                "Utilice el menu inferior para editar el texto",
                "------",
                "[L] permite definir la linea activa",
                "[E] permite editar la linea activa",
                "[I] permite intercambiar dos lineas",
                "[B] borra el contenido de la linea activa",
                "[S] sale del programa",
                "",
                ""
        };

        // Bucle principal del programa
        while(continuar) {
            pintar();
            hacer();
        }
    }

    // Muestra todo el documento
    private static void pintar() {
        // Limpia la pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Dibuja línea superior
        for(int i = 0; i < 50; i++) System.out.print("-");
        System.out.println();

        // Muestra cada línea
        for(int i = 0; i < doc.length; i++) {
            if(i == x) {
                System.out.println(i + ":*| " + doc[i]);  // línea activa
            } else {
                System.out.println(i + ": | " + doc[i]);  // línea normal
            }
        }

        // Dibuja línea inferior
        for(int i = 0; i < 50; i++) System.out.print("-");
        System.out.println();
    }

    // Procesa el menú principal
    private static void hacer() {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
        
        // Lee la opción del usuario
        char c = input.next().charAt(0);
        
        // Procesa la opción
        if(c == 'S' || c == 's') {
            continuar = false;
        } else if(c == 'L' || c == 'l') {
            mover();
        } else if(c == 'E' || c == 'e') {
            cambiar();
        } else if(c == 'I' || c == 'i') {
            swap();
        } else if(c == 'B' || c == 'b') {
            limpiar();
        }
    }

    // Cambia la línea activa
    private static void mover() {
        System.out.print("Línea?: ");
        int temp = input.nextInt();
        if(temp >= 0 && temp < doc.length) {
            x = temp;
        }
    }

    // Edita la línea activa
    private static void cambiar() {
        System.out.println("EDITANDO> " + doc[x]);
        input.nextLine();  // limpia el buffer
        doc[x] = input.nextLine();
    }

    // Intercambia dos líneas
    private static void swap() {
        System.out.print("Línea origen?: ");
        int l1 = obtener();
        System.out.print("Línea destino?: ");
        int l2 = obtener();
        
        String temp = doc[l1];
        doc[l1] = doc[l2];
        doc[l2] = temp;
    }

    // Pide un número de línea válido
    private static int obtener() {
        int l;
        do {
            System.out.print("Indique línea: ");
            l = input.nextInt();
        } while(l < 0 || l >= doc.length);
        return l;
    }

    // Borra la línea activa
    private static void limpiar() {
        System.out.println("ATENCIÓN: Esta acción es irreversible");
        System.out.println("Confirme el número de línea [" + x + "]");
        int confirmacion = input.nextInt();
        if(confirmacion == x) {
            doc[x] = "";
        }
    }
}