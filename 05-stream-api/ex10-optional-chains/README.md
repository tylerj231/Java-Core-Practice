# 5.10 Optional chains

**Topic:** Stream API · **Level:** Core  
**Module:** `05-stream-api/ex10-optional-chains` · **Package:** `com.javacore.streams.ex10`

## Goal

Work with `Optional` fluently, without `get()` or `isPresent()`.

## Task

Answer questions whose answer might not exist.

This exercise uses the shared domain model from [`05-stream-api/shop-model`](../shop-model/README.md). In tests, build small hand-made fixtures so you can assert exact results.

## Requirements

- `static Optional<String> cityOfLatestShippedOrder(List<Order> orders)`: latest by date, ties by highest order id.
- `static String displayName(Optional<Customer> customer)`: the name, or `"Guest"`.
- `static Optional<BigDecimal> priceOf(Map<Long, Product> catalog, long productId)`.
- `static Optional<String> firstCategoryOfCustomer(List<Order> orders, long customerId)`: the category of the first line of that customer's earliest order.
- Rule: no `Optional.get()`, `isPresent()` or `isEmpty()` anywhere in this module.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex10`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Each method with data present and absent.
- [ ] A tie on dates in `cityOfLatestShippedOrder`.
- [ ] An earliest order with no lines gives empty.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. What's the difference between `orElse(compute())` and `orElseGet(() -> compute())`? Write a test that proves it.
2. Why shouldn't `Optional` be used for fields or method parameters?

## Run

```bash
mvn -pl 05-stream-api/ex10-optional-chains -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.10): optional chains`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
