package vPRG2;

public class Document {
    private String[] lines;
    private int activeLine;
    
    public Document() {
        this.lines = new String[] {
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
        this.activeLine = 0;
    }

    public Document(String[] lines) {
        this.lines = lines;
        this.activeLine = 0;
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
 }
 