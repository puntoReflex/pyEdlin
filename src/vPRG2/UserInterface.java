package vPRG2;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private DocumentRenderer renderer;
    private DocumentStorage storage;
    
    public UserInterface(DocumentStorage storage) {
        this.scanner = new Scanner(System.in);
        this.renderer = new EditorRenderer();
        this.storage = storage;
    }
 
    public void setRenderer(DocumentRenderer renderer) {
        this.renderer = renderer;
    }
    
    public void showLines(Document document) {
        renderer.render(document, this);
    }
    
    public String separator(int line, int activeLine) {
        return line == activeLine ? ":*| " : ": | ";
    }
    
    public void printHorizontalLine() {
        System.out.println("-".repeat(50));
    }
    
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public Command getCommand() {
        System.out.println("Comandos: [L]inea | [E]ditar | [I]ntercambiar | [B]orrar | [G]uardar | [C]argar | [V]ista | [S]alir");
        char option = readChar();
        return createCommand(option);
    }
    
    private Command createCommand(char option) {
        return switch (Character.toUpperCase(option)) {
            case 'S' -> new ExitCommand();
            case 'L' -> new SetActiveLineCommand(this);
            case 'E' -> new EditCommand(this);
            case 'I' -> new ExchangeCommand(this);
            case 'B' -> new DeleteCommand(this);
            case 'G' -> new SaveCommand(storage, this);
            case 'C' -> new LoadCommand(storage, this);
            case 'V' -> new ChangeViewCommand(this);
            default -> null;
        };
    }
    
    public char readChar() {
        return scanner.next().charAt(0);
    }
    
    public String readString() {
        scanner.nextLine();
        return scanner.nextLine();
    }
    
    public int readInt() {
        return scanner.nextInt();
    }
 }