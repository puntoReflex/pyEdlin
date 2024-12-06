package vPRG2;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }
    
    public void showLines(Document doc) {
        clearScreen();
        printHorizontalLine();
        for (int i = 0; i < doc.getLineCount(); i++) {
            System.out.println(i + separator(i, doc.getActiveLine()) + doc.getLine(i));
        }
        printHorizontalLine();
    }
    
    private String separator(int line, int activeLine) {
        return line == activeLine ? ":*| " : ": | ";
    }
    
    private void printHorizontalLine() {
        System.out.println("-".repeat(50));
    }
    
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public Command getCommand() {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
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