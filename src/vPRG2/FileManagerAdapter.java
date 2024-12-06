package vPRG2;

public class FileManagerAdapter implements DocumentStorage {
    private FileManager fileManager;
    
    public FileManagerAdapter(String filePath) {
        this.fileManager = new FileManager(filePath);
    }
    
    @Override
    public boolean save(String serializedDocument) {
        return fileManager.createFile(serializedDocument);
    }
    
    @Override
    public String load() {
        return fileManager.readFile();
    }
 }