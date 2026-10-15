# 1.4 Default method conflicts

**Topic:** Interfaces and abstract classes · **Level:** Core  
**Module:** `01-interfaces-abstract-classes/ex04-diamond-conflict` · **Package:** `com.javacore.interfaces.ex04`

## Goal

Learn the three rules Java uses to resolve conflicting `default` methods.

## Task

Build small hierarchies that trigger each resolution rule.

## Requirements

- `interface Flyer { default String move() { return "fly"; } }` and `interface Swimmer { default String move() { return "swim"; } }`.
- Rule 1, you must choose: `class Duck implements Flyer, Swimmer`. First compile it without overriding `move()` and copy the error into Notes. Then override `move()` to return `"fly and swim"` by calling `Flyer.super.move()` and `Swimmer.super.move()`.
- Rule 2, classes win: `abstract class Animal { public String move() { return "walk"; } }` and `class Penguin extends Animal implements Swimmer` with no override. `new Penguin().move()` returns `"walk"`.
- Rule 3, the more specific interface wins: `interface FastSwimmer extends Swimmer` overrides `move()` to return `"swim fast"`. `class Fish implements Swimmer, FastSwimmer` with no override returns `"swim fast"`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/interfaces/ex04`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `new Duck().move()` returns `"fly and swim"`.
- [ ] `new Penguin().move()` returns `"walk"`.
- [ ] `new Fish().move()` returns `"swim fast"`.
- [ ] A `Duck` referenced as `Flyer` and as `Swimmer` still returns `"fly and swim"`.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. State the three resolution rules in your own words.
2. Why does `X.super.move()` only work for interfaces the class directly implements?
3. What problem did default methods solve when they were added in Java 8? (Hint: `Collection.stream()`.)

## Run

```bash
mvn -pl 01-interfaces-abstract-classes/ex04-diamond-conflict -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(1.4): default method conflicts`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
