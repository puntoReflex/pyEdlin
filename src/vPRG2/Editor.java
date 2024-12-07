package vPRG2;

public class Editor {
    private Document document;
    private UserInterface ui;
    private DocumentSerializer serializer;
    private DocumentStorage storage;

    public Editor() {
        this.serializer = new SimpleSerializer();
        this.document = new Document();
        this.ui = new UserInterface(storage);
    }

    public void setStorage(String filePath) {
        this.storage = new FileManagerAdapter(filePath);
    }

    public boolean hasStorage() {
        return storage != null;
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