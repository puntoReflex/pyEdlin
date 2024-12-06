package vPRG2;

public class LoadCommand implements Command {
    private DocumentStorage storage;
    private UserInterface ui;
    
    public LoadCommand(DocumentStorage storage, UserInterface ui) {
        this.storage = storage;
        this.ui = ui;
    }
    
    @Override
    public boolean execute(Document document) {
        if (storage == null) {
            System.out.print("Nombre del archivo: ");
            String filePath = ui.readString();
            storage = new FileManagerAdapter(filePath);
        }
        String content = storage.load();
        if (content != null) {
            Document loaded = Document.deserialize(content);
            document.updateFrom(loaded);
            return true;
        }
        return false;
    }
 }
