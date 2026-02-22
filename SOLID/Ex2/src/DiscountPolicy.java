import java.util.List;

public interface DiscountPolicy {
    double computeDiscount(String customerType, double subtotal, List<OrderLine> lines);
}