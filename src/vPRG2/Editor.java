package vPRG2;

public class Editor {
    private Document document;
    private UserInterface ui;
    
    public Editor() {
        this.document = new Document();
        this.ui = new UserInterface();
    }
    
    public void run() {
        boolean running = true;
        while (running) {
            document.print(ui);
            Command command = ui.getCommand();
            running = command.execute(document);
        }
    }
    
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.run();
    }
 }
