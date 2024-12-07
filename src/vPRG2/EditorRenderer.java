package vPRG2;

public class EditorRenderer implements DocumentRenderer {
    @Override
    public void render(Document document, UserInterface ui) {
        ui.clearScreen();
        ui.printHorizontalLine();
        for (int i = 0; i < document.getLineCount(); i++) {
            System.out.println(i + ui.separator(i, document.getActiveLine()) + document.getLine(i));
        }
        ui.printHorizontalLine();
    }
}
