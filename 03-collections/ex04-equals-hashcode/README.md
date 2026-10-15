# 3.4 Broken equals and hashCode

**Topic:** Collections · **Level:** Core  
**Module:** `03-collections/ex04-equals-hashcode` · **Package:** `com.javacore.collections.ex04`

## Goal

See exactly how a broken `equals`/`hashCode` contract breaks hash-based collections.

## Task

Write three versions of a `Person` class and use tests to document how each behaves in a `HashSet`.

## Requirements

- `BrokenPerson(String name, String email)`: overrides `equals` (by email) but not `hashCode`.
- `Person(String name, String email)`: correct `equals` and `hashCode`, both by email only.
- `MutablePerson`: correct `equals` and `hashCode` by email, but with a `setEmail` method.
- Tests document the behavior (they pass by asserting what actually happens).

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/collections/ex04`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Two equal `BrokenPerson`s in a `HashSet` give size 2 (identity hash codes differ). Note in Notes why this isn't strictly guaranteed but is practically certain.
- [ ] Two equal `Person`s give size 1, and `contains` finds a new equal instance.
- [ ] `MutablePerson`: add to a `HashSet`, change the email, then `contains(samePerson)` is `false` and `remove` fails, yet iterating the set still shows it.
- [ ] The `equals` contract for `Person`: reflexive, symmetric, transitive, consistent, and `equals(null)` is false.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Explain both bugs: the missing `hashCode` and the mutated key.
2. Would making `Person` a record prevent both bugs? What if one component were a mutable `List`?

## Run

```bash
mvn -pl 03-collections/ex04-equals-hashcode -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(3.4): broken equals and hashcode`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
