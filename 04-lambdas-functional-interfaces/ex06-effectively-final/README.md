# 4.6 Captured variables and effectively final

**Topic:** Lambdas and functional interfaces · **Level:** Core  
**Module:** `04-lambdas-functional-interfaces/ex06-effectively-final` · **Package:** `com.javacore.lambdas.ex06`

## Goal

Understand what lambdas can capture, and the right way to keep mutable state.

## Task

Count things from inside lambdas in several ways.

## Requirements

- First, try incrementing an `int` local variable inside `list.forEach(...)`. Copy the compiler error into Notes.
- `static int countLongWordsAtomic(List<String> words, int minLength)` using `forEach` and an `AtomicInteger`.
- `static int countLongWordsArray(List<String> words, int minLength)` using a one-element `int[]`.
- `static long countLongWordsStream(List<String> words, int minLength)` with `stream().filter(...).count()`.
- `static Supplier<Integer> counterFrom(int start)` returns a supplier giving `start`, `start + 1`, and so on, on each call. Each supplier has its own independent state.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/lambdas/ex06`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] All three counting methods agree on the same inputs, including an empty list.
- [ ] `counterFrom(10)` gives 10, 11, 12. Two counters don't affect each other.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why does Java require captured locals to be effectively final?
2. Why is the `int[]` trick a bad habit, especially with parallel streams?
3. Why can a lambda modify a *field* but not a local variable?

## Run

```bash
mvn -pl 04-lambdas-functional-interfaces/ex06-effectively-final -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(4.6): captured variables and effectively final`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
