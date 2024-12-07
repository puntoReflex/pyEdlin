package vPRG2;

public class RenderUtils {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static void printHorizontalLine() {
        System.out.println("-".repeat(50));
    }
    
    public static String separator(int line, int activeLine) {
        return line == activeLine ? ":*| " : ": | ";
    }
}
