# 5.11 Top N per group: streams vs. loops

**Topic:** Stream API · **Level:** Challenge  
**Module:** `05-stream-api/ex11-top-n-per-group` · **Package:** `com.javacore.streams.ex11`

## Goal

Solve a hard aggregation with streams and with loops, and judge which is more maintainable.

## Task

Find the best-selling products in each category, twice.

This exercise uses the shared domain model from [`05-stream-api/shop-model`](../shop-model/README.md). In tests, build small hand-made fixtures so you can assert exact results.

## Requirements

- `interface TopProducts { SortedMap<String, List<String>> topPerCategory(List<Order> orders, int n); }`.
- For each category, the names of the top `n` products by quantity sold (non-cancelled orders), descending, ties by product name ascending. Categories in alphabetical order.
- `TopProductsStreams`: streams only.
- `TopProductsLoops`: plain loops and collections only, no streams.
- `n` below 1 throws `IllegalArgumentException`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex11`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] A contract test (abstract test class) run against both implementations, as in exercise 3.10.
- [ ] A category with fewer than `n` products, a tie, cancelled orders ignored.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Which version would you rather maintain? Be specific about readability and debugging.
2. What's the complexity of your stream version?

## Run

```bash
mvn -pl 05-stream-api/ex11-top-n-per-group -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.11): top n per group: streams vs. loops`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
