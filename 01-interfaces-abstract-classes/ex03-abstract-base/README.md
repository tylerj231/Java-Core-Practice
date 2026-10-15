# 1.3 Abstract base class

**Topic:** Interfaces and abstract classes · **Level:** Warm-up  
**Module:** `01-interfaces-abstract-classes/ex03-abstract-base` · **Package:** `com.javacore.interfaces.ex03`

## Goal

See what an abstract class can do that an interface can't: hold state, run constructors and keep members non-public.

## Task

Rewrite the shapes from exercise 1.1 on top of an abstract base class.

## Requirements

- Keep the `Shape` interface from 1.1.
- Create `abstract class AbstractShape implements Shape` with a `private final String name` set through a `protected` constructor.
- `AbstractShape` overrides `describe()` to use `name` instead of the class name: `"<name> with area <area>"`, 2 decimals, `Locale.ROOT`.
- Override `toString()` as `final` and make it return `describe()`.
- Add a `protected static double requirePositive(double value, String field)` helper that returns `value` or throws `IllegalArgumentException` with the message `"<field> must be positive"`.
- Implement `Circle`, `Rectangle` and `Triangle` as `final` classes extending `AbstractShape`, using `requirePositive` for validation. Their names are `"Circle"`, `"Rectangle"` and `"Triangle"`.

## Example

```java
new Circle(2).toString();  // "Circle with area 12.57"
new Circle(-1);           // IllegalArgumentException: radius must be positive
```

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/interfaces/ex03`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `toString()` equals `describe()` for all three shapes.
- [ ] `new Circle(-1)` throws `IllegalArgumentException` with the message `"radius must be positive"` (check the message with AssertJ `hasMessage`).
- [ ] `new Rectangle(3, 0)` throws with the message `"height must be positive"`.
- [ ] Areas and perimeters match the values from exercise 1.1.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. List everything `AbstractShape` does that an interface could not do.
2. Why can't the shapes be records anymore?
3. When would you choose this design over the interface-only design from 1.1?

## Run

```bash
mvn -pl 01-interfaces-abstract-classes/ex03-abstract-base -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(1.3): abstract base class`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
