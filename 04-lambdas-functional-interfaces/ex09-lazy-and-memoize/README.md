# 4.9 Lazy values and memoization

**Topic:** Lambdas and functional interfaces · **Level:** Challenge  
**Module:** `04-lambdas-functional-interfaces/ex09-lazy-and-memoize` · **Package:** `com.javacore.lambdas.ex09`

## Goal

Use suppliers and functions to defer and cache work, safely across threads.

## Task

Build a thread-safe lazy value and a memoizing function wrapper.

## Requirements

- `final class Lazy<T> implements Supplier<T>` created with `Lazy.of(Supplier<? extends T> supplier)`.
- The supplier runs at most once, on the first `get()`, even when many threads call `get()` at the same time. Use double-checked locking with a `volatile` field.
- A supplier that returns `null` is still called only once.
- After computing, drop the reference to the supplier so it can be garbage collected.
- `boolean isComputed()`.
- `static <T, R> Function<T, R> memoize(Function<? super T, ? extends R> f)` caches the result per input in a `ConcurrentHashMap`. Document in Notes how you handle `null` results, since `ConcurrentHashMap` can't store `null` values.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/lambdas/ex09`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Count supplier calls with an `AtomicInteger`: zero before `get()`, one after several calls.
- [ ] 16 threads started together (use a `CountDownLatch` and an `ExecutorService`) call `get()`: the supplier runs once and all threads see the same value.
- [ ] A `null`-returning supplier is called once.
- [ ] `memoize` calls the underlying function once per distinct input.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why must the field be `volatile` in double-checked locking? What can go wrong without it?
2. The `ConcurrentHashMap.computeIfAbsent` Javadoc says the mapping function must not modify the map. Why does that matter for memoizing a recursive function like Fibonacci?

## Run

```bash
mvn -pl 04-lambdas-functional-interfaces/ex09-lazy-and-memoize -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(4.9): lazy values and memoization`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
