# 2.2 Immutable Pair

**Topic:** Generics · **Level:** Warm-up  
**Module:** `02-generics/ex02-pair` · **Package:** `com.javacore.generics.ex02`

## Goal

Use multiple type parameters, and compare a hand-written generic class with a generic record.

## Task

Build an immutable pair twice: once as a class and once as a record.

## Requirements

- `final class Pair<A, B>` with private final fields, `first()` and `second()` accessors, `equals`, `hashCode` and `toString` (`"(1, one)"`).
- `static <A, B> Pair<A, B> of(A first, B second)`. `null` values are allowed.
- `Pair<B, A> swap()`.
- `record PairRecord<A, B>(A first, B second)` with the same `swap()` and `of`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/generics/ex02`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `swap()` of `(1, "one")` is `("one", 1)` and has the swapped static type: `Pair<String, Integer> s = p.swap();`.
- [ ] `p.swap().swap()` equals `p`.
- [ ] Equality and hash code by value, including pairs containing `null`.
- [ ] The same tests pass for `PairRecord`.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. List what the record generated for you that you wrote by hand in `Pair`.
2. Is `Pair<Integer, String>` a subtype of `Pair<Object, Object>`? Why not?

## Run

```bash
mvn -pl 02-generics/ex02-pair -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(2.2): immutable pair`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
