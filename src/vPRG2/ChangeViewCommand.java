package vPRG2;

public class ChangeViewCommand implements Command {
    private UserInterface ui;
   
    public ChangeViewCommand(UserInterface ui) {
        this.ui = ui;
    }
    
    @Override
    public boolean execute(Document document) {
        ui.toggleView();
        return true;
    }
 }
