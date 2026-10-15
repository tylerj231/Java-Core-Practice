# 3.7 Priority task scheduler

**Topic:** Collections · **Level:** Core  
**Module:** `03-collections/ex07-task-scheduler` · **Package:** `com.javacore.collections.ex07`

## Goal

Use a `PriorityQueue` correctly, including a stable tie-break.

## Task

Build a scheduler that runs the highest-priority task first.

## Requirements

- `record Task(String name, int priority, long sequence)`: higher `priority` runs first. Equal priorities run in submission order (FIFO).
- `PriorityQueue` is not stable, so assign `sequence` from an internal counter on each submission.
- `TaskScheduler` methods: `Task submit(String name, int priority)`, `Optional<Task> next()` (removes), `Optional<Task> peek()`, `int size()`, and `List<Task> pending()` returning all tasks in execution order without removing them.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/collections/ex07`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Tasks come out by priority.
- [ ] Equal priorities come out in submission order (use at least 5 tasks).
- [ ] `pending()` is in execution order and leaves `size()` unchanged.
- [ ] `next()` and `peek()` on an empty scheduler return empty.
- [ ] Document in a test that iterating the internal `PriorityQueue` directly is **not** in priority order for some input.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why isn't iterating a `PriorityQueue` sorted? Describe the binary heap layout.
2. What's the complexity of `offer`, `poll` and `peek`?

## Run

```bash
mvn -pl 03-collections/ex07-task-scheduler -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(3.7): priority task scheduler`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
