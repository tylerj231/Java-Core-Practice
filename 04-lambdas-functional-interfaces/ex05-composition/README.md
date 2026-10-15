# 4.5 Composing functions and predicates

**Topic:** Lambdas and functional interfaces · **Level:** Core  
**Module:** `04-lambdas-functional-interfaces/ex05-composition` · **Package:** `com.javacore.lambdas.ex05`

## Goal

Build behavior from small pieces with `andThen`, `compose`, `and`, `or` and `negate`.

## Task

Build a text-cleaning pipeline and a validation rule from small functions.

## Requirements

- In `TextPipeline`, static `Function<String, String>` steps: `trim`, `lowercase`, `removePunctuation` (regex `\p{Punct}`) and `collapseSpaces` (any whitespace run becomes one space).
- `static Function<String, String> normalize()` = trim, then lowercase, then remove punctuation, then collapse spaces, using `andThen`.
- `static Function<String, String> pipeline(List<Function<String, String>> steps)` combines any number of steps in order. An empty list gives the identity function.
- In `TitleRules`: `Predicate<String> notBlank()`, `Predicate<String> maxLength(int n)`, `Predicate<String> containsAny(Set<String> words)` (case-insensitive).
- `static Predicate<String> isValidTitle(Set<String> forbidden)` = not blank, at most 60 characters, and no forbidden words, built with `and` and `negate`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/lambdas/ex05`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `normalize()` on `"  Hello,   WORLD!!  "` gives `"hello world"`.
- [ ] `pipeline` with an empty list returns the input unchanged. The order of steps matters: show a case where two orders give different results.
- [ ] `isValidTitle`: blank, too long (61 characters), forbidden word in different case, and valid.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. What's the difference between `f.andThen(g)` and `f.compose(g)`?
2. Why can removing punctuation *after* collapsing spaces leave double spaces?

## Run

```bash
mvn -pl 04-lambdas-functional-interfaces/ex05-composition -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(4.5): composing functions and predicates`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
