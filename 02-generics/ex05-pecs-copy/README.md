# 2.5 PECS: producer extends, consumer super

**Topic:** Generics · **Level:** Core  
**Module:** `02-generics/ex05-pecs-copy` · **Package:** `com.javacore.generics.ex05`

## Goal

Write the most flexible signature for a method that both reads and writes generic collections.

## Task

Implement copy and move utilities with correct wildcards.

## Requirements

- `static <T> void copy(List<? super T> dest, List<? extends T> src)` appends all of `src` to `dest`.
- `static <T> int moveMatching(List<? extends T> src, Collection<? super T> dest, Predicate<? super T> condition)` adds matching elements of `src` to `dest` and returns how many it added. `src` is not modified.
- Both reject `null` arguments with `NullPointerException`.

## Example

```java
List<Integer> ints = List.of(1, 2, 3, 4);
List<Number> numbers = new ArrayList<>();
copy(numbers, ints);                    // numbers = [1, 2, 3, 4]

List<Object> objects = new ArrayList<>();
Predicate<Number> positive = n -> n.doubleValue() > 0;
moveMatching(ints, objects, positive);  // returns 4
```

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/generics/ex05`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Copy `List<Integer>` into `List<Number>` and into `List<Object>`.
- [ ] `moveMatching` with a `Predicate<Object>` and a `Predicate<Number>` on `List<Integer>`.
- [ ] `moveMatching` returns the right count and leaves `src` unchanged.
- [ ] `null` arguments throw.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Explain PECS in your own words, using `copy` as the example.
2. Compare your signature with `java.util.Collections.copy`. What's different and why?
3. Why does `condition` use `? super T`?

## Run

```bash
mvn -pl 02-generics/ex05-pecs-copy -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(2.5): pecs: producer extends, consumer super`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
