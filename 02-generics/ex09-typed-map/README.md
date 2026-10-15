# 2.9 Type-safe heterogeneous container

**Topic:** Generics · **Level:** Challenge  
**Module:** `02-generics/ex09-typed-map` · **Package:** `com.javacore.generics.ex09`

## Goal

Use `Class<T>` as a key to store values of different types safely, the pattern from *Effective Java* Item 33.

## Task

Build a map from types to values, with no unchecked casts visible to callers.

## Requirements

- `final class TypedMap` with `<T> void put(Class<T> type, T value)`, `<T> Optional<T> get(Class<T> type)`, `boolean contains(Class<?> type)` and `<T> Optional<T> remove(Class<T> type)`.
- Internally a `Map<Class<?>, Object>`. Use `type.cast(...)` both when storing and when reading, so even raw-type abuse fails fast.
- `null` type or `null` value throws `NullPointerException`.
- Lookup is by exact class: a value stored under `Integer.class` is not found under `Number.class`.

## Example

```java
TypedMap prefs = new TypedMap();
prefs.put(String.class, "dark");
prefs.put(Integer.class, 14);
String theme = prefs.get(String.class).orElseThrow(); // no cast needed
```

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/generics/ex09`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Store and retrieve `String`, `Integer` and a custom record.
- [ ] Missing type gives an empty `Optional`.
- [ ] Exact-class lookup: `Integer` not found under `Number.class`.
- [ ] Raw-type abuse: `Class raw = Integer.class; map.put(raw, "text");` throws `ClassCastException` at `put`.
- [ ] `remove` and `contains`.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why does `put` need `type.cast(value)` if the signature already says `T value`?
2. Why can't this container store both a `List<String>` and a `List<Integer>`? How do libraries like Jackson work around it (super type tokens)?

## Run

```bash
mvn -pl 02-generics/ex09-typed-map -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(2.9): type-safe heterogeneous container`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
