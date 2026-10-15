# 4.4 Your own functional interface

**Topic:** Lambdas and functional interfaces · **Level:** Core  
**Module:** `04-lambdas-functional-interfaces/ex04-custom-functional-interface` · **Package:** `com.javacore.lambdas.ex04`

## Goal

Design a functional interface with default methods, like the JDK's own.

## Task

Build a three-argument function with composition and currying.

## Requirements

- `@FunctionalInterface interface TriFunction<A, B, C, R> { R apply(A a, B b, C c); }`.
- `default <V> TriFunction<A, B, C, V> andThen(Function<? super R, ? extends V> after)`, which throws `NullPointerException` immediately if `after` is `null`.
- `default Function<A, Function<B, Function<C, R>>> curried()`.
- Use it: `TriFunction<BigDecimal, BigDecimal, Integer, BigDecimal> compoundInterest` computes `principal × (1 + rate)^years`, rounded to scale 2 with `HALF_EVEN`.
- Add a second abstract method to `TriFunction` temporarily and copy the compiler error into Notes.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/lambdas/ex04`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `compoundInterest` with 1000, 0.05 and 2 years gives `1102.50`.
- [ ] `andThen` converts the result (for example, to a formatted string).
- [ ] `curried()` gives the same result as `apply` for the same arguments.
- [ ] `andThen(null)` throws `NullPointerException` at the call, not later.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. What exactly does `@FunctionalInterface` enforce? Do methods like `equals` declared in the interface count?
2. Why does `andThen` take `Function<? super R, ? extends V>` and not `Function<R, V>`?

## Run

```bash
mvn -pl 04-lambdas-functional-interfaces/ex04-custom-functional-interface -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(4.4): your own functional interface`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
