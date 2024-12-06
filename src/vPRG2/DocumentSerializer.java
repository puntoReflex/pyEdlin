package vPRG2;

public interface DocumentSerializer {
    String serialize(Document doc);

    Document deserialize(String content);
}
