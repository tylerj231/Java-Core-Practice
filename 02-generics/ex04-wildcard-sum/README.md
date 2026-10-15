# 2.4 Upper-bounded wildcards

**Topic:** Generics · **Level:** Core  
**Module:** `02-generics/ex04-wildcard-sum` · **Package:** `com.javacore.generics.ex04`

## Goal

Read from a generic collection of subtypes with `? extends`.

## Task

Write numeric utilities that accept a list of any `Number` subtype.

## Requirements

- `static double sum(List<? extends Number> numbers)`.
- `static OptionalDouble average(List<? extends Number> numbers)`: empty for an empty list.
- `static Number largest(List<? extends Number> numbers)` comparing by `doubleValue()`. Throws `NoSuchElementException` for an empty list.
- `null` elements throw `NullPointerException`.
- Inside `sum`, try `numbers.add(1)` and copy the compiler error into Notes. Then check what `numbers.add(null)` does.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/generics/ex04`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `sum` works with `List<Integer>`, `List<Double>`, `List<BigDecimal>` and a mixed `List<Number>`.
- [ ] `average` of an empty list is empty. `average` of `1, 2, 3, 4` is `2.5`.
- [ ] `largest` returns the original element (for example, the same `BigDecimal` instance).
- [ ] A list containing `null` throws `NullPointerException`.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why can't you add an `Integer` to a `List<? extends Number>`, even though `Integer` is a `Number`?
2. Why would `sum(List<Number>)` be a worse signature?

## Run

```bash
mvn -pl 02-generics/ex04-wildcard-sum -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(2.4): upper-bounded wildcards`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
