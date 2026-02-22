import java.util.List;

public class InvoiceFormatter {
    private final DefaultTaxPolicy taxPolicy;

    public InvoiceFormatter(DefaultTaxPolicy taxPolicy) {
        this.taxPolicy = taxPolicy;
    }

    public String format(String invoiceId, String customerType, List<OrderLine> lines,
                         double subtotal, double tax, double discount, double total, Map<String, MenuItem> menu) {

        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invoiceId).append("\n");

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }

        out.append(String.format("Subtotal: %.2f\n", subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPolicy.getTaxPercent(customerType), tax));
        out.append(String.format("Discount: -%.2f\n", discount));
        out.append(String.format("TOTAL: %.2f\n", total));

        return out.toString();
    }
}