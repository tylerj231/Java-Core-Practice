# 2.8 Type erasure and its workarounds

**Topic:** Generics · **Level:** Core  
**Module:** `02-generics/ex08-erasure-workarounds` · **Package:** `com.javacore.generics.ex08`

## Goal

Know what type erasure forbids, and the standard workarounds: suppliers and class tokens.

## Task

First record what erasure forbids, then build utilities that work around it.

## Requirements

- **Investigate first.** In a scratch class (not committed, or commented out), try each of these and copy the exact compiler error into Notes: `new T()`, `new T[10]`, `o instanceof List<String>` where `o` is declared as `Object`, overloading `void f(List<String>)` with `void f(List<Integer>)`, and a `static T` field.
- `class GenericArray<T>` created with `GenericArray(Class<T> type, int length)`, using `java.lang.reflect.Array.newInstance`. Methods: `T get(int)`, `void set(int, T)`, `int length()` and `T[] toArray()` returning a copy whose runtime type is really `T[]`. Keep the single unchecked cast in one place with a justified `@SuppressWarnings("unchecked")`.
- `static <T> List<T> createMany(Supplier<? extends T> factory, int count)` returns `count` new instances. A negative count throws `IllegalArgumentException`.
- `static <T> List<T> castAll(List<?> items, Class<T> type)` returns a new `List<T>`, or throws `ClassCastException` naming the index and actual type of the first element that doesn't match. `null` elements are allowed.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/generics/ex08`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `new GenericArray<>(String.class, 3).toArray()` has runtime class `String[].class`.
- [ ] `get` and `set`, and out-of-range indexes throw `IndexOutOfBoundsException` (the array's own exception is fine).
- [ ] `createMany(StringBuilder::new, 3)` returns 3 distinct instances.
- [ ] `castAll` succeeds for matching items, including `null`, and fails with a message containing the index for a mismatch.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. What is type erasure, and why did Java choose it?
2. Why is `Class<T>` called a type token? What can't it represent? (Try `List<String>.class`.)

## Run

```bash
mvn -pl 02-generics/ex08-erasure-workarounds -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(2.8): type erasure and its workarounds`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
