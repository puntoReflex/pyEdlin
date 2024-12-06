package vPRG2;

public class SaveCommand implements Command {
    private DocumentStorage storage;
    private DocumentSerializer serializer;

    public SaveCommand(DocumentStorage storage, DocumentSerializer serializer) {
        this.storage = storage;
        this.serializer = serializer;
    }

    @Override
    public boolean execute(Document document) {
        String serialized = serializer.serialize(document);
        return storage.save(serialized);
    }
}
