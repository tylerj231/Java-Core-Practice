# 1.1 Shapes

**Topic:** Interfaces and abstract classes · **Level:** Warm-up  
**Module:** `01-interfaces-abstract-classes/ex01-shapes` · **Package:** `com.javacore.interfaces.ex01`

## Goal

Define a contract with an interface and give every implementation shared behavior through a `default` method.

## Task

Model three geometric shapes behind one `Shape` interface.

## Requirements

- Create an interface `Shape` with abstract methods `double area()` and `double perimeter()`.
- Add a `default String describe()` that returns `"<SimpleClassName> with area <area>"`, with the area formatted to exactly 2 decimals using `Locale.ROOT` (so it prints `12.57`, never `12,57`). Example: `new Circle(2).describe()` returns `"Circle with area 12.57"`.
- Implement `Circle(double radius)`, `Rectangle(double width, double height)` and `Triangle(double a, double b, double c)`. Records are a good fit.
- Calculate the triangle's area with Heron's formula: `s = (a + b + c) / 2`, `area = sqrt(s(s-a)(s-b)(s-c))`.
- Reject invalid input with `IllegalArgumentException`: any dimension that is zero or negative, and triangle sides that break the triangle inequality (each side must be shorter than the sum of the other two).

## Example

```java
Shape c = new Circle(2);
c.area();      // 12.566370614359172
c.describe();  // "Circle with area 12.57"

new Rectangle(3, 4).perimeter(); // 14.0
new Triangle(3, 4, 5).area();     // 6.0
new Triangle(1, 2, 10);           // throws IllegalArgumentException
```

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/interfaces/ex01`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Circle with radius 2: area is `4π` (compare with a tolerance, e.g. AssertJ `isCloseTo(..., within(1e-9))`) and perimeter is `4π`.
- [ ] Rectangle 3 × 4: area 12, perimeter 14.
- [ ] Triangle 3, 4, 5: area 6, perimeter 12.
- [ ] `describe()` returns exactly `"Circle with area 12.57"` for radius 2, and the matching text for a rectangle and a triangle.
- [ ] Zero and negative dimensions throw `IllegalArgumentException` for all three shapes (use `@ParameterizedTest`).
- [ ] Triangle 1, 2, 10 throws `IllegalArgumentException`.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why can `describe()` be a `default` method while `area()` cannot?
2. Why does the format need `Locale.ROOT`? What would `String.format("%.2f", 12.566)` print on a machine with a Ukrainian locale?

## Run

```bash
mvn -pl 01-interfaces-abstract-classes/ex01-shapes -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(1.1): shapes`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
