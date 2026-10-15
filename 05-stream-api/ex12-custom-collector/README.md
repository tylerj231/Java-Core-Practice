# 5.12 Custom Collector

**Topic:** Stream API · **Level:** Challenge  
**Module:** `05-stream-api/ex12-custom-collector` · **Package:** `com.javacore.streams.ex12`

## Goal

Write your own `Collector`, including a combiner that works with parallel streams.

## Task

Collect order totals into a statistics record in one pass.

This exercise uses the shared domain model from [`05-stream-api/shop-model`](../shop-model/README.md). In tests, build small hand-made fixtures so you can assert exact results.

## Requirements

- `record Stats(long count, BigDecimal sum, BigDecimal min, BigDecimal max, BigDecimal average)` with a constant `Stats.EMPTY` (count 0, all values `BigDecimal.ZERO`).
- `static Collector<BigDecimal, ?, Stats> toStats()` built with `Collector.of(supplier, accumulator, combiner, finisher)` and a private mutable accumulator class.
- The average has scale 2, `HALF_EVEN`. Empty input gives `Stats.EMPTY`.
- `null` elements throw `NullPointerException`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex12`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Stats for a few known values.
- [ ] Empty input gives `Stats.EMPTY`.
- [ ] 10,000 random values: `parallelStream().collect(toStats())` equals the sequential result. This exercises your combiner.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. When is the combiner called? Why can't a sequential test catch a combiner bug?
2. What do collector characteristics like `UNORDERED` and `IDENTITY_FINISH` mean?

## Run

```bash
mvn -pl 05-stream-api/ex12-custom-collector -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.12): custom collector`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
