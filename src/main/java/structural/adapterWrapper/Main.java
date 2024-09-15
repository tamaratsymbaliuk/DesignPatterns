package structural.adapterWrapper;

public class Main {
    public static void main(String[] args) {
        Printer printer = new PrinterAdapter();
        printer.print();
    }
}
