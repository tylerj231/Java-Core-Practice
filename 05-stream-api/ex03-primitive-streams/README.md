# 5.3 Primitive streams

**Topic:** Stream API · **Level:** Warm-up  
**Module:** `05-stream-api/ex03-primitive-streams` · **Package:** `com.javacore.streams.ex03`

## Goal

Use `IntStream`, `LongStream` and `DoubleStream` to avoid boxing and get numeric operations.

## Task

Compute numbers from orders and generate number sequences.

This exercise uses the shared domain model from [`05-stream-api/shop-model`](../shop-model/README.md). In tests, build small hand-made fixtures so you can assert exact results.

## Requirements

- `static int totalQuantity(List<Order> orders)`: sum of all line quantities (`flatMap` the lines, then `mapToInt`).
- `static IntSummaryStatistics quantityStats(List<OrderLine> lines)`: count, min, max, sum and average in one pass.
- `static OptionalDouble averagePrice(List<Product> products)` using `doubleValue()` on prices.
- `static int[] squares(int n)` for 1 to n with `IntStream.rangeClosed`.
- `static long countPrimesBelow(int n)` with `IntStream` and `noneMatch`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex03`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Each method on a small fixture.
- [ ] `quantityStats` of an empty list has count 0 (check what `getMin()` returns and assert it).
- [ ] `squares(5)` is `[1, 4, 9, 16, 25]`. `countPrimesBelow(30)` is 10.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why does `average()` return `OptionalDouble` while `sum()` returns a plain number?
2. Why is using `doubleValue()` on money only acceptable for statistics, never for totals?

## Run

```bash
mvn -pl 05-stream-api/ex03-primitive-streams -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.3): primitive streams`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
