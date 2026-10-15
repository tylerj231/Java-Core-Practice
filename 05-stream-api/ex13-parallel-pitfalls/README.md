# 5.13 Parallel stream pitfalls

**Topic:** Stream API · **Level:** Challenge  
**Module:** `05-stream-api/ex13-parallel-pitfalls` · **Package:** `com.javacore.streams.ex13`

## Goal

Know when parallel streams are correct, when they're fast, and when they're neither.

## Task

Write correct and broken parallel code, and document the difference.

## Requirements

- `static long sumSequential(long n)` and `static long sumParallel(long n)` for 1 to n with `LongStream.rangeClosed`.
- `static List<Integer> squaresParallel(int n)`: correct, using `map` and `toList()`.
- `static List<Integer> squaresBroken(int n)`: adds to a shared `ArrayList` inside `parallel().forEach`. This is intentionally wrong.
- `static List<Integer> inOrder(int n)` and `static List<Integer> anyOrder(int n)`: collect 1 to n in parallel with `forEachOrdered` and `forEach` into a synchronized list.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex13`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Sequential and parallel sums agree for `n` = 10,000,000.
- [ ] `squaresParallel(100_000)` has the right size and values, in order.
- [ ] A test for `squaresBroken` that asserts the correct size, annotated `@Disabled("race condition: run manually to see it fail")`. Run it manually and record what you saw in Notes.
- [ ] `inOrder` is always in order. `anyOrder` contains the same elements (`containsExactlyInAnyOrder`).

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Which pool do parallel streams use by default, and why is that a risk inside a web server?
2. When are parallel streams worth using in a backend service? (Usually: rarely. Explain why.)

## Run

```bash
mvn -pl 05-stream-api/ex13-parallel-pitfalls -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.13): parallel stream pitfalls`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
