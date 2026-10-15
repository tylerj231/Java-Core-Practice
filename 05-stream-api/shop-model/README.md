# Shop domain model

The shared model used by most Stream API exercises. Every exercise module that needs it already depends on it.

```java
record Customer(long id, String name, String city, LocalDate registeredOn) {}
record Product(long id, String name, String category, BigDecimal price) {}
record OrderLine(Product product, int quantity) { BigDecimal subtotal(); }
record Order(long id, Customer customer, LocalDate date, Status status, List<OrderLine> lines) { BigDecimal total(); }
enum Status { NEW, PAID, SHIPPED, CANCELLED }
```

- `OrderLine.subtotal()` is implemented for you.
- `Order.total()` throws `UnsupportedOperationException` until you implement it in [exercise 5.4](../ex04-order-totals/README.md).
- `Order` keeps an unmodifiable copy of its lines.

## Test data

In each exercise, build a small fixture in the test class (or a shared `TestData` helper inside that exercise's test folder) with just enough customers, products and orders to make every assertion exact. Small, hand-checked data is better than a large random set.

Optionally, add a `SampleData` class here with around 10 customers, 15 products and 50 orders for exploring in `jshell` or a `main` method.
