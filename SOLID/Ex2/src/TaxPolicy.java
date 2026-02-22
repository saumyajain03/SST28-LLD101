import java.util.List;

public interface TaxPolicy {
    double computeTax(String customerType, double subtotal, List<OrderLine> lines);
}