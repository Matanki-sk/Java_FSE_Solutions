public class Factory_method{
	
    // Step 1: Define the Document interface
    interface Document{
        void open();
    }

    // Step 2: Concrete document classes
    static class WordDocument implements Document{
        public void open(){
            System.out.println("Opening a Word document.");
        }
    }
    static class PdfDocument implements Document{
        public void open(){
            System.out.println("Opening a PDF document.");
        }
    }
    static class ExcelDocument implements Document{
        public void open(){
            System.out.println("Opening an Excel document.");
        }
    }

    // Step 3: Abstract Factory
    abstract static class DocumentFactory{
        public abstract Document createDocument();
    }

    // Step 4: Concrete Factories
    static class WordDocumentFactory extends DocumentFactory{
        public Document createDocument() {
            return new WordDocument();
        }
    }
    static class PdfDocumentFactory extends DocumentFactory{
        public Document createDocument() {
            return new PdfDocument();
        }
    }
    static class ExcelDocumentFactory extends DocumentFactory{
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Step 5: Test the factory method pattern
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        wordDoc.open();
        pdfDoc.open();
        excelDoc.open();
    }
}
