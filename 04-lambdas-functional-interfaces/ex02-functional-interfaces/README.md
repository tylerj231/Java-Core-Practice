# 4.2 Know the standard functional interfaces

**Topic:** Lambdas and functional interfaces · **Level:** Warm-up  
**Module:** `04-lambdas-functional-interfaces/ex02-functional-interfaces` · **Package:** `com.javacore.lambdas.ex02`

## Goal

Pick the right `java.util.function` interface without looking it up, including the primitive versions.

## Task

Implement each behavior with the most fitting functional interface.

## Requirements

- In a `Functions` class, add static methods that return:
    - a test for blank strings (`Predicate<String>`)
    - a factory for new empty `ArrayList<String>`s (`Supplier<List<String>>`)
    - a consumer that appends each string to a given `StringBuilder` (`Consumer<String> appendTo(StringBuilder sb)`)
    - string to length (`Function<String, Integer>`)
    - integer addition (`BinaryOperator<Integer>`)
    - uppercasing (`UnaryOperator<String>`)
    - repeat a string n times (`BiFunction<String, Integer, String>`)
- Then add primitive versions: `IntPredicate isEven()`, `ToIntFunction<String> lengthAsInt()`, `IntBinaryOperator addInts()` and `IntUnaryOperator square()`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/lambdas/ex02`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] One test per returned function, covering edge cases (blank vs. empty strings, negative numbers for `isEven`).
- [ ] The supplier returns a new, distinct list on each call.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why do primitive specializations like `IntPredicate` exist?
2. `UnaryOperator<T>` extends `Function<T, T>`. When would you prefer one over the other in a method signature?

## Run

```bash
mvn -pl 04-lambdas-functional-interfaces/ex02-functional-interfaces -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(4.2): know the standard functional interfaces`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
