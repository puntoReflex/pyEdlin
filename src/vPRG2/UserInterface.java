package vPRG2;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private DocumentStorage storage;
    private DocumentRenderer renderer;
    private DocumentRenderer editorRenderer;
    private DocumentRenderer previewRenderer;
    private boolean inPreviewMode;

    public UserInterface(DocumentStorage storage) {
        this.scanner = new Scanner(System.in);
        this.storage = storage;
        this.editorRenderer = new EditorRenderer();
        this.previewRenderer = new PreviewRenderer();
        this.renderer = editorRenderer;
        this.inPreviewMode = false;
    }

    public void toggleView() {
        if (inPreviewMode) {
            renderer = editorRenderer;
        } else {
            renderer = previewRenderer;
        }
        inPreviewMode = !inPreviewMode;
    }

    public Command getCommand() {
        System.out
                .println("Comandos: [L]inea | [E]ditar | [I]ntercambiar | [B]orrar | [G]uardar | [C]argar | [V]ista(" +
                        (inPreviewMode ? "Preview" : "Normal") + ") | [S]alir");
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

    public void render(Document document) {
        renderer.render(document, this);
    }    
}