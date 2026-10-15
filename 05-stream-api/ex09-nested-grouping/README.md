# 5.9 Nested grouping

**Topic:** Stream API · **Level:** Core  
**Module:** `05-stream-api/ex09-nested-grouping` · **Package:** `com.javacore.streams.ex09`

## Goal

Build two-level summaries with nested `groupingBy` and choose the map implementations.

## Task

Build a revenue report by category and month.

This exercise uses the shared domain model from [`05-stream-api/shop-model`](../shop-model/README.md). In tests, build small hand-made fixtures so you can assert exact results.

## Requirements

- `static SortedMap<String, Map<Month, BigDecimal>> revenueByCategoryAndMonth(List<Order> orders, int year)`.
- Only non-cancelled orders dated in the given year.
- Lines need their order's date: `flatMap` each order into a small `record DatedLine(LocalDate date, OrderLine line)`.
- Outer map: `TreeMap` by category. Inner map: `EnumMap` by month, created with `() -> new EnumMap<>(Month.class)`.
- Months without sales are absent (not zero).

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex09`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Two categories across three months, with exact values.
- [ ] Orders from another year and cancelled orders are excluded.
- [ ] Inner maps iterate in calendar order (it's an `EnumMap`).

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why `EnumMap` for months? What does it give you over `HashMap`?
2. At what point would you write this as a SQL query instead? Write that SQL query in Notes.

## Run

```bash
mvn -pl 05-stream-api/ex09-nested-grouping -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.9): nested grouping`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
