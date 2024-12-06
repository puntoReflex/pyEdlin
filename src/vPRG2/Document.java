package vPRG2;

public class Document {
    private static final String[] DEFAULT_LINES = {
            "Bienvenidos al editor EDLIN",
            "Utilice el menu inferior para editar el texto",
            "------",
            "[L] permite definir la linea activa",
            "[E] permite editar la linea activa",
            "[I] permite intercambiar dos lineas",
            "[B] borra el contenido de la linea activa",
            "[S] sale del programa",
            "",
            ""
    };
    private String[] lines;
    private int activeLine;
    private DocumentSerializer serializer;

    public Document() {
        this(DEFAULT_LINES);
    }

    public Document(String[] lines) {
        this.lines = lines;
        this.activeLine = 0;
        this.serializer = new SimpleSerializer();
    }

    public String serialize() {
        return serializer.serialize(this);
    }
 
    public static Document deserialize(String content) {
        return new SimpleSerializer().deserialize(content);
    }

    public String[] getAllLines() {
        return lines.clone();
    }

    public String getLine(int index) {
        return lines[index];
    }

    public void setLine(int index, String content) {
        lines[index] = content;
    }

    public int getActiveLine() {
        return activeLine;
    }

    public void setActiveLine(int line) {
        if (line >= 0 && line < lines.length) {
            this.activeLine = line;
        }
    }

    public int getLineCount() {
        return lines.length;
    }

    public void print(UserInterface ui) {
        ui.showLines(this);
    }

    public void updateFrom(Document other) {
        this.lines = other.lines.clone();
        this.activeLine = 0;
    }    
}
