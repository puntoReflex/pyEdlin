package vPRG2;

public class PreviewRenderer implements DocumentRenderer {
    @Override
    public void render(Document document, UserInterface ui) {
        ui.clearScreen();
        ui.printHorizontalLine();
        for (int i = 0; i < document.getLineCount(); i++) {
            System.out.println(document.getLine(i));
        }
        ui.printHorizontalLine();
    }
 }
