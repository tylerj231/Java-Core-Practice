# 3.8 Unmodifiable vs. immutable

**Topic:** Collections · **Level:** Core  
**Module:** `03-collections/ex08-immutable-collections` · **Package:** `com.javacore.collections.ex08`

## Goal

Know the difference between `List.of`, `List.copyOf` and `Collections.unmodifiableList`, and stop leaking internal state.

## Task

Build an immutable `Team` and use tests to pin down how each JDK option behaves.

## Requirements

- `final class Team` with a name and a list of members.
- The constructor makes a defensive copy with `List.copyOf`. The getter returns that list directly (it's already unmodifiable).
- `Team withMember(String member)` returns a new team and leaves the original unchanged.
- `null` members are rejected with `NullPointerException`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/collections/ex08`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Changing the list passed to the constructor afterwards doesn't change the team.
- [ ] Adding to `team.members()` throws `UnsupportedOperationException`.
- [ ] `withMember` leaves the original team unchanged.
- [ ] `Collections.unmodifiableList(original)` is a *view*: changing `original` changes the view.
- [ ] `List.of("a", null)` throws `NullPointerException`, and so does `List.of("a").contains(null)`.
- [ ] `List.copyOf` of an already-immutable `List.of` list returns the same instance (assert with `isSameAs`).

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Explain the difference between unmodifiable and immutable.
2. Why is a shallow-immutable list of mutable objects still risky?

## Run

```bash
mvn -pl 03-collections/ex08-immutable-collections -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(3.8): unmodifiable vs. immutable`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
