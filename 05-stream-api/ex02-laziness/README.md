# 5.2 Laziness and processing order

**Topic:** Stream API · **Level:** Warm-up  
**Module:** `05-stream-api/ex02-laziness` · **Package:** `com.javacore.streams.ex02`

## Goal

See that streams process elements one at a time through the whole pipeline, and that stateful operations change that.

## Task

Record the order in which pipeline steps run, then assert it in tests.

## Requirements

- Each method takes a `List<String> log` and adds an entry from inside each step, like `"filter:bob"` or `"map:christina"`.
- `static Optional<String> firstLongNameUppercased(List<String> names, int minLength, List<String> log)`: `filter` (logs `filter:<name>`), then `map` to uppercase (logs `map:<name>`), then `findFirst`.
- `static Stream<String> pipelineWithoutTerminal(List<String> names, List<String> log)`: builds the same pipeline but returns it without a terminal operation.
- `static List<String> sortedInTheMiddle(List<String> names, List<String> log)`: `filter` (logs), then `sorted()`, then `map` (logs), then `toList()`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex02`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] For `["al", "bob", "christina", "dan"]` with `minLength` 4, the log is exactly `[filter:al, filter:bob, filter:christina, map:christina]`, and `dan` is never touched.
- [ ] After `pipelineWithoutTerminal`, the log is empty.
- [ ] `sortedInTheMiddle`: all `filter` entries come before any `map` entry.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Explain why `dan` is never filtered.
2. Why does `sorted()` force all `filter` calls to happen first? Which other operations are stateful?

## Run

```bash
mvn -pl 05-stream-api/ex02-laziness -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.2): laziness and processing order`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
