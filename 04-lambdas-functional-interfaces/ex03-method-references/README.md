# 4.3 Method references

**Topic:** Lambdas and functional interfaces · **Level:** Warm-up  
**Module:** `04-lambdas-functional-interfaces/ex03-method-references` · **Package:** `com.javacore.lambdas.ex03`

## Goal

Recognize and write all four kinds of method reference.

## Task

Return functional interfaces built only from method references (no `->` anywhere).

## Requirements

- Static: `Function<String, Integer> parser()` using `Integer::parseInt`.
- Bound instance: `Consumer<String> appender(StringBuilder sb)` using `sb::append`.
- Unbound instance: `UnaryOperator<String> upper()` using `String::toUpperCase`, and `BiPredicate<String, String> startsWith()` using `String::startsWith`.
- Constructor: `Supplier<List<String>> listFactory()` using `ArrayList::new`, and `Function<Integer, List<String>> sizedListFactory()` using `ArrayList::new`.
- Comparator from an unbound method: `Comparator<String> ignoreCase()` using `String::compareToIgnoreCase`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/lambdas/ex03`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Each returned function behaves correctly.
- [ ] `parser()` throws `NumberFormatException` for `"abc"`.
- [ ] Two calls to `listFactory().get()` return different instances.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. What's the difference between a bound and an unbound instance method reference? Where does the receiver come from in each?
2. `sizedListFactory` uses `ArrayList::new` too. How does the compiler pick the `ArrayList(int)` constructor?

## Run

```bash
mvn -pl 04-lambdas-functional-interfaces/ex03-method-references -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(4.3): method references`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
