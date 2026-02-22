import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");

        DefaultTaxPolicy taxPolicy = new DefaultTaxPolicy();
        DefaultDiscountPolicy discountPolicy = new DefaultDiscountPolicy();
        FileStore store = new FileStore();
        InvoiceFormatter formatter = new InvoiceFormatter(taxPolicy);

        CafeteriaSystem sys = new CafeteriaSystem(store, taxPolicy, discountPolicy, formatter);

        sys.addToMenu(new MenuItem("M1", "Veg Thali", 80.00));
        sys.addToMenu(new MenuItem("C1", "Coffee", 30.00));
        sys.addToMenu(new MenuItem("S1", "Sandwich", 60.00));

        List<OrderLine> order = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1)
        );

        sys.checkout("student", order);
    }
}