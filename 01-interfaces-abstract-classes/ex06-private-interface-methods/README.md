# 1.6 Private interface methods

**Topic:** Interfaces and abstract classes · **Level:** Core  
**Module:** `01-interfaces-abstract-classes/ex06-private-interface-methods` · **Package:** `com.javacore.interfaces.ex06`

## Goal

Share logic between default methods with `private` interface methods, and see what interfaces still can't hide.

## Task

Build an input validator whose default methods share a private helper.

## Requirements

- `interface Validator` with `default boolean isValidEmail(String input)` and `default boolean isValidUsername(String input)`.
- Both delegate to one `private boolean matches(String input, Pattern pattern)` that returns `false` for `null` or blank input and otherwise matches the trimmed input.
- Username: 3 to 20 characters, letters, digits and underscores only, must start with a letter.
- Email (simplified): `^[\w.+-]+@[\w-]+(\.[\w-]+)+$`.
- `class DefaultValidator implements Validator {}` with no body.
- Interfaces can't have private fields, so decide where the compiled `Pattern`s live (public constants, a private static method, or a package-private holder class) and justify the choice in Notes.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/interfaces/ex06`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] A `@ParameterizedTest` with `@CsvSource` of at least 6 valid and invalid emails.
- [ ] Usernames: `"ab"` false, exactly 20 characters true, 21 false, `"1abc"` false, `"john_doe"` true.
- [ ] `null`, `""` and `"   "` are invalid for both methods.
- [ ] Input with surrounding spaces, like `" john_doe "`, is valid.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why were private interface methods added in Java 9?
2. Why can't interfaces have private fields, even now?

## Run

```bash
mvn -pl 01-interfaces-abstract-classes/ex06-private-interface-methods -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(1.6): private interface methods`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
