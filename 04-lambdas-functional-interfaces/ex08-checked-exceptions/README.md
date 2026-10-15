# 4.8 Lambdas and checked exceptions

**Topic:** Lambdas and functional interfaces · **Level:** Challenge  
**Module:** `04-lambdas-functional-interfaces/ex08-checked-exceptions` · **Package:** `com.javacore.lambdas.ex08`

## Goal

Handle checked exceptions in functional code without hiding errors.

## Task

Read files in a lambda-based pipeline in two styles: wrapping exceptions and collecting results.

## Requirements

- `@FunctionalInterface interface ThrowingFunction<T, R> { R apply(T t) throws Exception; }`.
- `static <T, R> Function<T, R> unchecked(ThrowingFunction<? super T, ? extends R> f)`: an `IOException` becomes `UncheckedIOException`, a `RuntimeException` is rethrown unchanged, and any other checked exception becomes your own `WrappedCheckedException extends RuntimeException`. The original is always kept as the cause.
- `static List<String> readAll(List<Path> paths)` reads every file with `Files.readString`, through `unchecked`.
- `sealed interface Result<T> permits Success, Failure` with `record Success<T>(T value)` and `record Failure<T>(Exception error)`.
- `static <T, R> Function<T, Result<R>> attempt(ThrowingFunction<? super T, ? extends R> f)` never throws.
- `static List<Result<String>> readAllSafely(List<Path> paths)` reads every file and reports failures without stopping.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/lambdas/ex08`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Use JUnit's `@TempDir` to create real files.
- [ ] `readAll` on two files returns both contents in order.
- [ ] `readAll` with a missing file throws `UncheckedIOException` whose cause is `NoSuchFileException`.
- [ ] `unchecked` passes a `RuntimeException` through unchanged and wraps a non-IO checked exception.
- [ ] `readAllSafely` with one missing file returns one `Success` and one `Failure`. Use a pattern-matching `switch` over `Result` in the test.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Compare the two styles. When would you use each in a backend service?
2. Why must the original exception always be kept as the cause?

## Run

```bash
mvn -pl 04-lambdas-functional-interfaces/ex08-checked-exceptions -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(4.8): lambdas and checked exceptions`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
