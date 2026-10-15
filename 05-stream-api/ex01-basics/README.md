# 5.1 Stream basics

**Topic:** Stream API · **Level:** Warm-up  
**Module:** `05-stream-api/ex01-basics` · **Package:** `com.javacore.streams.ex01`

## Goal

Use the core operations: `filter`, `map`, `sorted`, `distinct`, `count`, `max` and `anyMatch`.

## Task

Answer simple questions about customers, orders and products with streams.

This exercise uses the shared domain model from [`05-stream-api/shop-model`](../shop-model/README.md). In tests, build small hand-made fixtures so you can assert exact results.

## Requirements

- `static List<String> customerNamesIn(List<Customer> customers, String city)`: sorted alphabetically.
- `static long countByStatus(List<Order> orders, Status status)`.
- `static Optional<Product> mostExpensive(List<Product> products)`.
- `static boolean hasCancelledOrder(List<Order> orders, long customerId)`.
- `static List<String> distinctCities(List<Customer> customers)`: sorted.
- No loops. Return results with `Stream.toList()` or a collector.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex01`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Each method on a small fixture, including empty input.
- [ ] `mostExpensive` of an empty list is empty.
- [ ] City matching is exact (document whether `"lviv"` matches `"Lviv"` in your implementation).

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. `Stream.toList()` and `collect(Collectors.toList())` both return lists. What's different about the returned lists?

## Run

```bash
mvn -pl 05-stream-api/ex01-basics -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.1): stream basics`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
