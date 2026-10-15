# 5.6 groupingBy and downstream collectors

**Topic:** Stream API · **Level:** Core  
**Module:** `05-stream-api/ex06-grouping` · **Package:** `com.javacore.streams.ex06`

## Goal

Group data and aggregate each group with downstream collectors.

## Task

Build the kind of summary maps a reporting endpoint returns.

This exercise uses the shared domain model from [`05-stream-api/shop-model`](../shop-model/README.md). In tests, build small hand-made fixtures so you can assert exact results.

## Requirements

- `static Map<Status, List<Order>> byStatus(List<Order> orders)`.
- `static SortedMap<String, Long> orderCountByCity(List<Order> orders)`, keyed by the customer's city.
- `static Map<String, BigDecimal> revenueByCategory(List<Order> orders)`: excludes cancelled orders. `flatMap` to lines, then `groupingBy` category with `Collectors.reducing(BigDecimal.ZERO, OrderLine::subtotal, BigDecimal::add)`.
- `static Map<Status, Set<Long>> customerIdsByStatus(List<Order> orders)` with `Collectors.mapping`.
- `static Map<String, Optional<Order>> largestOrderPerCity(List<Order> orders)` with `Collectors.maxBy`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex06`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Each method on one shared fixture of about 8 orders.
- [ ] `orderCountByCity` keys are sorted.
- [ ] `revenueByCategory` ignores cancelled orders.
- [ ] A status with no orders is absent from `byStatus` (assert it).

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. What does the three-argument `groupingBy(classifier, mapFactory, downstream)` let you control?
2. Why does `maxBy` give `Optional` values here? How can `collectingAndThen` remove them?

## Run

```bash
mvn -pl 05-stream-api/ex06-grouping -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.6): groupingby and downstream collectors`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
