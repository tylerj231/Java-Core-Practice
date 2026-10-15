# 4.1 Anonymous class, lambda, method reference

**Topic:** Lambdas and functional interfaces · **Level:** Warm-up  
**Module:** `04-lambdas-functional-interfaces/ex01-comparators-three-ways` · **Package:** `com.javacore.lambdas.ex01`

## Goal

See the same behavior written three ways and learn to read each one.

## Task

Write string comparators in progressively shorter forms.

## Requirements

- `static Comparator<String> byLengthAnonymous()` as an anonymous inner class.
- `static Comparator<String> byLengthLambda()` as a lambda.
- `static Comparator<String> byLengthMethodRef()` using `Comparator.comparingInt(String::length)`.
- `static Comparator<String> byLengthThenAlphabetical()`.
- `static Comparator<String> byLastCharIgnoringCase()`. Empty strings sort first.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/lambdas/ex01`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] The three length comparators sort the same input to the same order.
- [ ] `byLengthThenAlphabetical` on `["pear", "fig", "apple", "kiwi"]` gives `["fig", "kiwi", "pear", "apple"]`.
- [ ] `byLastCharIgnoringCase` including an empty string.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Compile the module and look in `target/classes`. Which version created an extra `.class` file, and why? (Hint: lambdas use `invokedynamic`.)
2. What does `this` refer to inside an anonymous class versus inside a lambda?

## Run

```bash
mvn -pl 04-lambdas-functional-interfaces/ex01-comparators-three-ways -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(4.1): anonymous class, lambda, method reference`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
