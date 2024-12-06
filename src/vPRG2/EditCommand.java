package vPRG2;

public class EditCommand implements Command {
    private UserInterface ui;
    
    public EditCommand(UserInterface ui) {
        this.ui = ui;
    }
    
    @Override
    public boolean execute(Document document) {
        System.out.println("EDITANDO> " + document.getLine(document.getActiveLine()));
        String newContent = ui.readString();
        document.setLine(document.getActiveLine(), newContent);
        return true;
    }
 }