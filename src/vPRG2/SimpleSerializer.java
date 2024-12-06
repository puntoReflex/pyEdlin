package vPRG2;

public class SimpleSerializer implements DocumentSerializer {
    private static final String LINE_SEPARATOR = "\n";
    
    @Override
    public String serialize(Document document) {
        return String.join(LINE_SEPARATOR, document.getAllLines());
    }
    
    @Override
    public Document deserialize(String content) {
        return new Document(content.split(LINE_SEPARATOR));
    }
}