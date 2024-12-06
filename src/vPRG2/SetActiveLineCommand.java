package vPRG2;

public class SetActiveLineCommand implements Command {
    private UserInterface ui;
    
    public SetActiveLineCommand(UserInterface ui) {
        this.ui = ui;
    }
    
    @Override
    public boolean execute(Document document) {
        int line = ui.readInt();
        document.setActiveLine(line);
        return true;
    }
 }