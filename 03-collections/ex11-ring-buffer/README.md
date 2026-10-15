# 3.11 Bounded ring buffer queue

**Topic:** Collections · **Level:** Challenge  
**Module:** `03-collections/ex11-ring-buffer` · **Package:** `com.javacore.collections.ex11`

## Goal

Implement a real `java.util.Queue` on top of `AbstractQueue`, with a fail-fast iterator.

## Task

Build a fixed-capacity FIFO queue backed by a circular array.

## Requirements

- `class RingBuffer<E> extends AbstractQueue<E>` with a fixed capacity set in the constructor (below 1 throws `IllegalArgumentException`).
- `offer` returns `false` when full. Inherited `add` must then throw `IllegalStateException` (that comes from `AbstractQueue`).
- `poll`, `peek` and `size` in O(1), using head and tail indexes that wrap around.
- `null` elements throw `NullPointerException`, as the `Queue` contract recommends.
- `iterator()` returns elements oldest first and is fail-fast: it throws `ConcurrentModificationException` if the buffer changes during iteration. Its `remove()` may throw `UnsupportedOperationException`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/collections/ex11`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] FIFO order, including after wrapping around the array several times.
- [ ] `offer` on a full buffer returns `false`, and `add` throws `IllegalStateException`.
- [ ] Iterator order after wrap-around, and `ConcurrentModificationException` when offering during iteration.
- [ ] `null` rejected.
- [ ] Inherited methods like `contains`, `toString` and `addAll` work.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Which methods did you get for free from `AbstractQueue` and `AbstractCollection`?
2. When would you use this instead of `ArrayDeque` or `ArrayBlockingQueue`?
3. Optional: benchmark `ArrayList` vs. `LinkedList` for adding at the front, middle and end with JMH, and explain why `LinkedList` usually loses.

## Run

```bash
mvn -pl 03-collections/ex11-ring-buffer -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(3.11): bounded ring buffer queue`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
