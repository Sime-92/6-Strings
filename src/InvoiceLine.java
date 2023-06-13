import java.text.DecimalFormat;
import java.util.Date;

public class InvoiceLine {
    private int quantity;
    private String itemCode;
    private String description;
    private float price;
    private float discountPercent;
    public static final String LINES =
            "------------------------------------------------------------------------------------------------------";
    private static final String FORMAT_STRING = "| %9s | %10s | %30s | %13s | %8s | %13s |";
    public static final String HEADER = LINES + "\n" +
            String.format(FORMAT_STRING, "QTY", "Item #", "DESCRIPTION",
                    "UNIT PRICE", "DISCOUNT", "LINE TOTAL") + "\n" + LINES;

    public InvoiceLine(int quantity, String itemCode,
                       String description, float price,
                       float discountPercent) {
        this.quantity = quantity;
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.discountPercent = discountPercent / 100;
    }

    public String toString() {
        String s = String.format("| %9s | %10s | %30s | %13s | %8s | %13s |",
                customFormat("###,###,###", quantity),
                itemCode,
                description,
                customFormat("$#,###,###.00", price),
                customFormat("##.00%", discountPercent),
                customFormat("$#,###,###.00", getTotalLine()));
        return s;
    }

    public float getTotalLine() {
        return quantity * price * (1 - discountPercent);
    }

    public static String customFormat(String pattern, double value) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        return output;
    }
}


