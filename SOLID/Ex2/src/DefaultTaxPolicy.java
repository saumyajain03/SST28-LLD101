import java.util.list;
public class DefaultTaxPolicy implements TaxPolicy {
    @Override
    public double computeTax(String customerType, double subtotal, List<OrderLine> lines) {
        if ("student".equalsIgnoreCase(customerType)) return subtotal * 0.05;
        if ("staff".equalsIgnoreCase(customerType)) return subtotal * 0.02;
        return subtotal * 0.08;
    }

    public double getTaxPercent(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) return 5.0;
        if ("staff".equalsIgnoreCase(customerType)) return 2.0;
        return 8.0;
    }
}