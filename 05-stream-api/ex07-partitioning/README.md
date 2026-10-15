# 5.7 partitioningBy

**Topic:** Stream API · **Level:** Core  
**Module:** `05-stream-api/ex07-partitioning` · **Package:** `com.javacore.streams.ex07`

## Goal

Split data into two groups, and know how this differs from grouping by a boolean.

## Task

Separate big spenders from everyone else.

This exercise uses the shared domain model from [`05-stream-api/shop-model`](../shop-model/README.md). In tests, build small hand-made fixtures so you can assert exact results.

## Requirements

- `static Map<Boolean, List<Customer>> bigSpenders(List<Customer> customers, List<Order> orders, BigDecimal threshold)`: `true` for customers with at least one non-cancelled order whose total is greater than the threshold. Customers without orders go to `false`.
- `static Map<Boolean, Long> paidVsOther(List<Order> orders)`: `true` counts `PAID` and `SHIPPED`, `false` counts the rest.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex07`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Mixed customers, including one without orders and one whose only big order was cancelled.
- [ ] Empty input still gives a map with **both** keys present.
- [ ] `paidVsOther` counts.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. How does `partitioningBy` differ from `groupingBy(x -> condition)`? Show it with the empty-input test.
2. Why build a lookup of orders by customer first, instead of streaming all orders for each customer?

## Run

```bash
mvn -pl 05-stream-api/ex07-partitioning -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.7): partitioningby`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
