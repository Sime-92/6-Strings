import java.util.Date;

public class InvoiceSystem {
    public static void main(String[] args) {
        // Crear una instancia de Invoice
        Invoice invoice = new Invoice(123, new Date(), "Cliente", "Dirección", "Vendedor", "Método de envío",
                "Términos de envío", new Date(), "Términos de pago", new Date(), 10);

        // Crear instancias de InvoiceLine
        InvoiceLine line1 = new InvoiceLine(1, "item1", "Descripción del Item 1", 10, 5);
        InvoiceLine line2 = new InvoiceLine(2, "item2", "Descripción del Item 2", 20, 10);

        // Agregar las InvoiceLine a la Invoice
        invoice.addInvoiceLine(line1);
        invoice.addInvoiceLine(line2);

        // Imprimir la factura
        invoice.print();
    }
}
