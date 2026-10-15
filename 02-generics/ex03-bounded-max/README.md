# 2.3 Generic max with a bound

**Topic:** Generics · **Level:** Warm-up  
**Module:** `02-generics/ex03-bounded-max` · **Package:** `com.javacore.generics.ex03`

## Goal

Use a bounded type parameter to call methods on `T`.

## Task

Write generic `max` and `min` utilities and a comparable `Version` class.

## Requirements

- `static <T extends Comparable<T>> T max(List<T> list)` and the matching `min`.
- An empty list throws `NoSuchElementException`. A `null` list throws `NullPointerException`.
- `record Version(int major, int minor, int patch) implements Comparable<Version>` with `static Version parse(String text)` for strings like `"1.10.0"`.
- Versions compare numerically by major, then minor, then patch, so `1.10.0` is greater than `1.9.3`.
- `parse` throws `IllegalArgumentException` for malformed input like `"1.2"`, `"a.b.c"` or `"1.-2.0"`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/generics/ex03`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `max` of integers, and of `"apple"`, `"pear"`, `"banana"` (gives `"pear"`).
- [ ] `max` of versions `1.9.3`, `1.10.0` and `1.2.15` gives `1.10.0`. `min` gives `1.2.15`.
- [ ] Empty list and `null` list.
- [ ] Malformed version strings (parameterized).

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Remove the bound (`<T>` only). Which line stops compiling, and why?
2. Why would comparing versions as strings be wrong?

## Run

```bash
mvn -pl 02-generics/ex03-bounded-max -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(2.3): generic max with a bound`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
