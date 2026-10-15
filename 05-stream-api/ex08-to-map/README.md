# 5.8 toMap and its pitfalls

**Topic:** Stream API · **Level:** Core  
**Module:** `05-stream-api/ex08-to-map` · **Package:** `com.javacore.streams.ex08`

## Goal

Build maps with `Collectors.toMap`, and handle duplicate keys and `null` values correctly.

## Task

Build lookup maps and pin down `toMap`'s failure modes in tests.

This exercise uses the shared domain model from [`05-stream-api/shop-model`](../shop-model/README.md). In tests, build small hand-made fixtures so you can assert exact results.

## Requirements

- `static Map<Long, Customer> customersById(List<Customer> customers)`.
- `static SortedMap<String, BigDecimal> lowestPriceByName(List<Product> products)`: duplicate names keep the lowest price. Use the four-argument `toMap` with `TreeMap::new`.
- `static Map<Long, BigDecimal> totalSpentByCustomer(List<Order> orders)`: non-cancelled orders only, with a merge function that adds.
- `static Map<Long, String> productCategoryById(List<Product> products)`: some products may have a `null` category. Decide how to handle it (skip, or replace with `"uncategorized"`) and document it in Notes.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex08`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `customersById` with a duplicate id throws `IllegalStateException` (assert the message mentions the key).
- [ ] `lowestPriceByName` with duplicate names, and sorted keys.
- [ ] `totalSpentByCustomer` sums several orders per customer.
- [ ] Plain `Collectors.toMap` with a `null` value throws `NullPointerException`, and your `productCategoryById` doesn't.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why does `toMap` reject `null` values even though `HashMap` allows them?
2. When is `groupingBy` a better fit than `toMap` with a merge function?

## Run

```bash
mvn -pl 05-stream-api/ex08-to-map -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.8): tomap and its pitfalls`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
