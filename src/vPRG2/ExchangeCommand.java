package vPRG2;

public class ExchangeCommand implements Command {
    private UserInterface ui;
    
    public ExchangeCommand(UserInterface ui) {
        this.ui = ui;
    }
    
    @Override
    public boolean execute(Document document) {
        System.out.print("Indique línea origen: ");
        int origin = ui.readInt();
        System.out.print("Indique línea destino: ");
        int destination = ui.readInt();
        
        String temp = document.getLine(destination);
        document.setLine(destination, document.getLine(origin));
        document.setLine(origin, temp);
        return true;
    }
 }