package vPRG2;

public class LoadCommand implements Command {
    private DocumentStorage storage;
    private DocumentSerializer serializer;

    public LoadCommand(DocumentStorage storage, DocumentSerializer serializer) {
        this.storage = storage;
        this.serializer = serializer;
    }

    @Override
    public boolean execute(Document document) {
        String content = storage.load();
        if (content != null) {
            document = serializer.deserialize(content);
            return true;
        }
        return false;
    }
}
