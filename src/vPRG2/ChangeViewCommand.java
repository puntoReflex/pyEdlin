package vPRG2;

public class ChangeViewCommand implements Command {
    private UserInterface ui;
    private DocumentRenderer previewRenderer;
    private DocumentRenderer editorRenderer;
    private boolean inPreviewMode;
 
    public ChangeViewCommand(UserInterface ui) {
        this.ui = ui;
        this.previewRenderer = new PreviewRenderer();
        this.editorRenderer = new EditorRenderer();
        this.inPreviewMode = false;
    }
 
    @Override
    public boolean execute(Document document) {
        if (inPreviewMode) {
            ui.setRenderer(editorRenderer);
        } else {
            ui.setRenderer(previewRenderer);
        }
        inPreviewMode = !inPreviewMode;
        return true;
    }
 }
