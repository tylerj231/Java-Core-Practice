# 5.4 Order totals with reduce

**Topic:** Stream API · **Level:** Core  
**Module:** `05-stream-api/ex04-order-totals` · **Package:** `com.javacore.streams.ex04`

## Goal

Aggregate `BigDecimal` values with `reduce`, and sort by computed values.

## Task

Implement `Order.total()` in the shared model, then build reports on top of it.

This exercise uses the shared domain model from [`05-stream-api/shop-model`](../shop-model/README.md). In tests, build small hand-made fixtures so you can assert exact results.

## Requirements

- In `shop-model`, replace the stub in `Order.total()` with a stream that maps each line to `subtotal()` and reduces with `BigDecimal.ZERO` and `BigDecimal::add`.
- In this module: `static List<Order> largest(List<Order> orders, int n)`: by total descending, ties by order id ascending.
- `static BigDecimal revenue(List<Order> orders)`: sum of totals of all orders except `CANCELLED`.
- `static Map<Status, BigDecimal> totalByStatus(List<Order> orders)` (a preview of `groupingBy`; any approach is fine here).

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex04`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `Order.total()` for an order with several lines, and for an order with no lines (zero).
- [ ] `largest` with a tie on total.
- [ ] `revenue` ignores cancelled orders.
- [ ] Compare `BigDecimal`s with `isEqualByComparingTo`.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. There are three forms of `reduce`. When do you need the three-argument form with a combiner?
2. Why is `BigDecimal.ZERO` the identity, and what breaks if the identity isn't really an identity?

## Run

```bash
mvn -pl 05-stream-api/ex04-order-totals -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.4): order totals with reduce`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
