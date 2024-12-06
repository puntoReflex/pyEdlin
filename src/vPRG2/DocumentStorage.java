package vPRG2;

public interface DocumentStorage {
    boolean save(String serializedDoc);

    String load();
}
