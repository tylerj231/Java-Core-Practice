# 2.6 Fix the max

**Topic:** Generics · **Level:** Core  
**Module:** `02-generics/ex06-comparable-super` · **Package:** `com.javacore.generics.ex06`

## Goal

Understand why the JDK's sorting and max methods use `Comparable<? super T>`.

## Task

Show that a naive bound rejects subclasses, then fix it.

## Requirements

- `class Animal implements Comparable<Animal>` with `name` and `weightKg`, compared by weight.
- `class Dog extends Animal`.
- `static <T extends Comparable<T>> T maxStrict(List<T> list)`.
- `static <T extends Comparable<? super T>> T max(List<T> list)`.
- Call `maxStrict(dogs)` with a `List<Dog>`, copy the compiler error into Notes, then leave that line commented out.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/generics/ex06`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `Dog heaviest = max(dogs);` compiles and returns the heaviest dog (the static type is `Dog`, not `Animal`).
- [ ] `maxStrict` works for `List<Animal>`.
- [ ] `max` works for `List<Animal>`, `List<Dog>` and `List<String>`.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why does `Dog` not satisfy `T extends Comparable<T>`?
2. `Collections.max` is declared as `<T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)`. Explain each part, including why `Object &` is there (hint: erasure and binary compatibility).

## Run

```bash
mvn -pl 02-generics/ex06-comparable-super -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(2.6): fix the max`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
