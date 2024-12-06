package vPRG2;

public class SaveCommand implements Command {
    private DocumentStorage storage;
    private UserInterface ui;
    
    public SaveCommand(DocumentStorage storage, UserInterface ui) {
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
        return storage.save(document.serialize());
    }
 }
