interface File {
    void open();
    void close();
}

class TextFile implements File {
    
    public void open() {
        System.out.println("Opening Word document...");
    }
    
    public void close() {
        System.out.println("Closing Word document...");
    }
}

class PortableDocument implements File {
    
    public void open() {
        System.out.println("Opening PDF document...");
    }
    
    public void close() {
        System.out.println("Closing PDF document...");
    }
}

class Spreadsheet implements File {
    
    public void open() {
        System.out.println("Opening Excel document...");
    }
    
    public void close() {
        System.out.println("Closing Excel document...");
    }
}

abstract class FileFactory {
    public abstract File createFile();
}

class TextFileFactory extends FileFactory {
    
    public File createFile() {
        return new TextFile();
    }
}

class PortableDocumentFactory extends FileFactory {
    
    public File createFile() {
        return new PortableDocument();
    }
}

class SpreadsheetFactory extends FileFactory {
    
    public File createFile() {
        return new Spreadsheet();
    }
}

public class FactoryMethodExample {
    public static void main(String[] args) {
        FileFactory textFactory = new TextFileFactory();
        File textFile = textFactory.createFile();
        textFile.open();
        textFile.close();

        FileFactory pdfFactory = new PortableDocumentFactory();
        File pdfFile = pdfFactory.createFile();
        pdfFile.open();
        pdfFile.close();

        FileFactory spreadsheetFactory = new SpreadsheetFactory();
        File excelFile = spreadsheetFactory.createFile();
        excelFile.open();
        excelFile.close();
    }
}
