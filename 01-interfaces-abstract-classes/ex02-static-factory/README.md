# 1.2 Static factory methods on interfaces

**Topic:** Interfaces and abstract classes · **Level:** Warm-up  
**Module:** `01-interfaces-abstract-classes/ex02-static-factory` · **Package:** `com.javacore.interfaces.ex02`

## Goal

Use `static` interface methods for factories and utilities, and learn how they differ from static methods on classes.

## Task

Copy your `Shape`, `Circle` and `Rectangle` from exercise 1.1 into this module's package and extend `Shape` with static methods.

## Requirements

- Add `static Shape square(double side)` to `Shape`. It returns a `Rectangle` with equal width and height.
- Add `static Shape unitCircle()` returning a `Circle` with radius 1.
- Add `static double totalArea(List<Shape> shapes)` returning the sum of the areas. An empty list returns `0.0`. A `null` list throws `NullPointerException` (use `Objects.requireNonNull`).
- Try calling `Circle.square(2)` and `new Circle(1).square(2)`. Neither compiles. Copy the compiler errors into the Notes section.

## Example

```java
Shape.square(3).area();                                 // 9.0
Shape.square(3) instanceof Rectangle;                   // true
Shape.totalArea(List.of(Shape.square(2), Shape.unitCircle())); // 4 + π
```

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/interfaces/ex02`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `square(3)` has area 9 and perimeter 12, and is an instance of `Rectangle`.
- [ ] `unitCircle()` has area `π`.
- [ ] `totalArea` of an empty list is `0.0`.
- [ ] `totalArea` of a square with side 2 and a unit circle is `4 + π`.
- [ ] `totalArea(null)` throws `NullPointerException`.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Static methods of a superclass can be called through a subclass name, but static interface methods cannot be called through an implementing class. Why did the Java designers make that choice? Think about a class implementing two interfaces with the same static method.
2. Why does `totalArea(List<Shape>)` reject a `List<Circle>`? (You'll fix this properly in topic 2.)

## Run

```bash
mvn -pl 01-interfaces-abstract-classes/ex02-static-factory -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(1.2): static factory methods on interfaces`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
