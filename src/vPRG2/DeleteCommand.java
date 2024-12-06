package vPRG2;

public class DeleteCommand implements Command {
    private UserInterface ui;
    
    public DeleteCommand(UserInterface ui) {
        this.ui = ui;
    }
    
    @Override
    public boolean execute(Document document) {
        System.out.println("ATENCIÓN: Esta acción es irreversible");
        System.out.println("Indique el número de línea activa para confirmarlo [" + document.getActiveLine() + "]");
        int line = ui.readInt();
        if (line == document.getActiveLine()) {
            document.setLine(document.getActiveLine(), "");
        }
        return true;
    }
 }
