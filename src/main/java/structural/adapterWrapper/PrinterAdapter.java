package structural.adapterWrapper;

// adapter
public class PrinterAdapter implements Printer{
    private final LegacyPrinter legacyPrinter;

    public PrinterAdapter() {
        this.legacyPrinter = new LegacyPrinter();
    }

    @Override
    public void print() {
        legacyPrinter.setFormat("utf-8");
        legacyPrinter.printDocument();
    }
}
