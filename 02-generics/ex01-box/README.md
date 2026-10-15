# 2.1 Generic Box

**Topic:** Generics · **Level:** Warm-up  
**Module:** `02-generics/ex01-box` · **Package:** `com.javacore.generics.ex01`

## Goal

Write a generic class and generic static factory methods.

## Task

Build a mutable container that holds at most one value of any type.

## Requirements

- `class Box<T>` with `T get()`, `void set(T value)`, `boolean isEmpty()` and `T orElse(T other)`.
- `get()` on an empty box throws `NoSuchElementException`.
- `set(null)` empties the box.
- Static factories `static <T> Box<T> of(T value)` (rejects `null` with `NullPointerException`) and `static <T> Box<T> empty()`.
- Implement `equals`, `hashCode` and `toString` (`"Box[42]"`, `"Box[]"`).

## Example

```java
Box<String> name = Box.of("Ann");
name.get();               // "Ann"
Box<Integer> none = Box.empty();
none.orElse(0);           // 0
```

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/generics/ex01`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `of`, `get`, `set`, `isEmpty` and `orElse` for a non-empty box.
- [ ] `get()` on an empty box throws `NoSuchElementException`.
- [ ] `Box.of(null)` throws `NullPointerException`.
- [ ] `set(null)` makes the box empty.
- [ ] Two boxes with equal contents are equal and have equal hash codes. `toString` formats.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Write `Box raw = new Box(); raw.set(1); Box<String> s = raw; String x = s.get();` in a scratch file. Where exactly does it fail, compile time or run time, and why?
2. What does the diamond operator `<>` infer, and from what?

## Run

```bash
mvn -pl 02-generics/ex01-box -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(2.1): generic box`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
