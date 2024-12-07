package vPRG2;

public class EditorRenderer implements DocumentRenderer {
    @Override
    public void render(Document document, UserInterface ui) {
        RenderUtils.clearScreen();
        RenderUtils.printHorizontalLine();
        for (int i = 0; i < document.getLineCount(); i++) {
            System.out.println(i + RenderUtils.separator(i, document.getActiveLine()) + document.getLine(i));
        }
        RenderUtils.printHorizontalLine();
    }
}
