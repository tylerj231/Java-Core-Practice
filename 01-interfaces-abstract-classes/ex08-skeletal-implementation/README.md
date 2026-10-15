# 1.8 Skeletal implementation

**Topic:** Interfaces and abstract classes · **Level:** Challenge  
**Module:** `01-interfaces-abstract-classes/ex08-skeletal-implementation` · **Package:** `com.javacore.interfaces.ex08`

## Goal

Combine an interface with an abstract skeletal class, the pattern behind `java.util.AbstractList`.

## Task

Build a minimal read-only list API where new implementations only need two methods.

## Requirements

- `interface SimpleList<E> extends Iterable<E>` with `E get(int index)`, `int size()`, `boolean isEmpty()`, `boolean contains(Object o)` and `int indexOf(Object o)`.
- `abstract class AbstractSimpleList<E> implements SimpleList<E>` implements everything except `get` and `size`: `isEmpty`, `indexOf` (null-safe, using `Objects.equals`), `contains` (via `indexOf`), `iterator()`, and `equals`, `hashCode` and `toString`.
- `toString` gives `"[a, b, c]"`. `equals` is true for any two `SimpleList`s with the same elements in the same order, even different implementations. `hashCode` follows the `java.util.List` formula so it is consistent with `equals`.
- `final class ArraySimpleList<E> extends AbstractSimpleList<E>` backed by a defensive copy of an array, created with `@SafeVarargs static <E> ArraySimpleList<E> of(E... items)`.
- `final class RangeList extends AbstractSimpleList<Integer>` for `from` (inclusive) to `to` (exclusive), storing only the two bounds.
- Both implementations contain only a constructor or factory, `get` and `size`. `get` throws `IndexOutOfBoundsException` for invalid indexes.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/interfaces/ex08`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `indexOf` and `contains`, including `null` elements.
- [ ] `toString` for an empty list and a 3-element list.
- [ ] `ArraySimpleList.of(1, 2, 3)` equals `new RangeList(1, 4)`, both ways, with equal hash codes.
- [ ] Iteration with a for-each loop yields elements in order.
- [ ] Changing the array passed to `of` afterwards doesn't change the list.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. How does this pattern give you both the flexibility of an interface and the code reuse of an abstract class?
2. Find two skeletal implementations in the JDK besides `AbstractList`.

## Run

```bash
mvn -pl 01-interfaces-abstract-classes/ex08-skeletal-implementation -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(1.8): skeletal implementation`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
