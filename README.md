# Java Core Mastery

Hands-on exercises for the core Java topics a strong middle-level backend engineer needs to know deeply: interfaces and abstract classes, generics, collections, lambdas and the Stream API, plus a capstone that combines them.

Each exercise is its own Maven module with a README describing the goal, requirements, required tests and questions to answer.

| # | Topic | Exercises | Hours |
| --- | --- | --- | --- |
| 1 | [Interfaces and abstract classes](01-interfaces-abstract-classes/README.md) | 9 | 6–8 |
| 2 | [Generics](02-generics/README.md) | 10 | 10–12 |
| 3 | [Collections](03-collections/README.md) | 11 | 12–15 |
| 4 | [Lambdas and functional interfaces](04-lambdas-functional-interfaces/README.md) | 9 | 6–8 |
| 5 | [Stream API](05-stream-api/README.md) | 13 | 12–15 |
| 6 | [Capstone: expense tracker](06-capstone-expense-tracker/README.md) | 1 | 8–10 |

Every topic goes from **Warm-up** (mechanics) to **Core** (what interviewers expect) to **Challenge** (real depth).

## Requirements

- JDK 21 or newer
- Maven 3.9 or newer
- JUnit 5 and AssertJ are already configured for every module

## Completion rules

An exercise is complete only when all of these are true:

1. **It has unit tests.** Every item under *Required tests* in its README is covered by a passing JUnit test. CI fails if an exercise has code but no tests.
2. **It is pushed to GitHub**, and the CI build is green.
3. **Its README Notes are filled in**, with answers to the *Explain* questions.

## Practice rules

1. Write the tests before or right after the solution, never "later".
2. Try for at least 20 minutes before searching or asking AI. Then look up the concept, not the solution.
3. If you can't explain your solution out loud, you're not done.
4. One exercise per commit or pull request, so your history shows your progress.

## How to work on an exercise

1. Read the exercise README.
2. Write your code in its `src/main/java` package and tests in `src/test/java`. (The `.gitkeep` files just keep empty folders in Git; delete them once you add files.)
3. Run its tests:
   ```bash
   mvn -pl 01-interfaces-abstract-classes/ex01-shapes -am test
   ```
4. Answer the Explain questions in the README's Notes section.
5. Commit, push, and check that CI is green. Then tick it off below.

Run everything with `mvn verify`, and the test check with `./scripts/check-tests.sh`.

## Progress

### 1. [Interfaces and abstract classes](01-interfaces-abstract-classes/README.md)

- [ ] 1.1 [Shapes](01-interfaces-abstract-classes/ex01-shapes/README.md) · Warm-up
- [ ] 1.2 [Static factory methods on interfaces](01-interfaces-abstract-classes/ex02-static-factory/README.md) · Warm-up
- [ ] 1.3 [Abstract base class](01-interfaces-abstract-classes/ex03-abstract-base/README.md) · Warm-up
- [ ] 1.4 [Default method conflicts](01-interfaces-abstract-classes/ex04-diamond-conflict/README.md) · Core
- [ ] 1.5 [Template method](01-interfaces-abstract-classes/ex05-template-method/README.md) · Core
- [ ] 1.6 [Private interface methods](01-interfaces-abstract-classes/ex06-private-interface-methods/README.md) · Core
- [ ] 1.7 [Payroll hierarchy](01-interfaces-abstract-classes/ex07-payroll-hierarchy/README.md) · Core
- [ ] 1.8 [Skeletal implementation](01-interfaces-abstract-classes/ex08-skeletal-implementation/README.md) · Challenge
- [ ] 1.9 [Payment plugins](01-interfaces-abstract-classes/ex09-payment-plugins/README.md) · Challenge

### 2. [Generics](02-generics/README.md)

- [ ] 2.1 [Generic Box](02-generics/ex01-box/README.md) · Warm-up
- [ ] 2.2 [Immutable Pair](02-generics/ex02-pair/README.md) · Warm-up
- [ ] 2.3 [Generic max with a bound](02-generics/ex03-bounded-max/README.md) · Warm-up
- [ ] 2.4 [Upper-bounded wildcards](02-generics/ex04-wildcard-sum/README.md) · Core
- [ ] 2.5 [PECS: producer extends, consumer super](02-generics/ex05-pecs-copy/README.md) · Core
- [ ] 2.6 [Fix the max](02-generics/ex06-comparable-super/README.md) · Core
- [ ] 2.7 [Generic repository](02-generics/ex07-generic-repository/README.md) · Core
- [ ] 2.8 [Type erasure and its workarounds](02-generics/ex08-erasure-workarounds/README.md) · Core
- [ ] 2.9 [Type-safe heterogeneous container](02-generics/ex09-typed-map/README.md) · Challenge
- [ ] 2.10 [Generic event bus](02-generics/ex10-event-bus/README.md) · Challenge

### 3. [Collections](03-collections/README.md)

- [ ] 3.1 [Word frequency](03-collections/ex01-word-frequency/README.md) · Warm-up
- [ ] 3.2 [Deduplicate](03-collections/ex02-deduplicate/README.md) · Warm-up
- [ ] 3.3 [Choose the right collection](03-collections/ex03-choose-the-collection/README.md) · Warm-up
- [ ] 3.4 [Broken equals and hashCode](03-collections/ex04-equals-hashcode/README.md) · Core
- [ ] 3.5 [Comparable and Comparator chains](03-collections/ex05-sorting/README.md) · Core
- [ ] 3.6 [Fail-fast iterators](03-collections/ex06-fail-fast/README.md) · Core
- [ ] 3.7 [Priority task scheduler](03-collections/ex07-task-scheduler/README.md) · Core
- [ ] 3.8 [Unmodifiable vs. immutable](03-collections/ex08-immutable-collections/README.md) · Core
- [ ] 3.9 [Build your own HashMap](03-collections/ex09-my-hashmap/README.md) · Challenge
- [ ] 3.10 [LRU cache, two ways](03-collections/ex10-lru-cache/README.md) · Challenge
- [ ] 3.11 [Bounded ring buffer queue](03-collections/ex11-ring-buffer/README.md) · Challenge

### 4. [Lambdas and functional interfaces](04-lambdas-functional-interfaces/README.md)

- [ ] 4.1 [Anonymous class, lambda, method reference](04-lambdas-functional-interfaces/ex01-comparators-three-ways/README.md) · Warm-up
- [ ] 4.2 [Know the standard functional interfaces](04-lambdas-functional-interfaces/ex02-functional-interfaces/README.md) · Warm-up
- [ ] 4.3 [Method references](04-lambdas-functional-interfaces/ex03-method-references/README.md) · Warm-up
- [ ] 4.4 [Your own functional interface](04-lambdas-functional-interfaces/ex04-custom-functional-interface/README.md) · Core
- [ ] 4.5 [Composing functions and predicates](04-lambdas-functional-interfaces/ex05-composition/README.md) · Core
- [ ] 4.6 [Captured variables and effectively final](04-lambdas-functional-interfaces/ex06-effectively-final/README.md) · Core
- [ ] 4.7 [Strategy pattern with lambdas](04-lambdas-functional-interfaces/ex07-strategy-with-lambdas/README.md) · Core
- [ ] 4.8 [Lambdas and checked exceptions](04-lambdas-functional-interfaces/ex08-checked-exceptions/README.md) · Challenge
- [ ] 4.9 [Lazy values and memoization](04-lambdas-functional-interfaces/ex09-lazy-and-memoize/README.md) · Challenge

### 5. [Stream API](05-stream-api/README.md)

- [ ] 5.1 [Stream basics](05-stream-api/ex01-basics/README.md) · Warm-up
- [ ] 5.2 [Laziness and processing order](05-stream-api/ex02-laziness/README.md) · Warm-up
- [ ] 5.3 [Primitive streams](05-stream-api/ex03-primitive-streams/README.md) · Warm-up
- [ ] 5.4 [Order totals with reduce](05-stream-api/ex04-order-totals/README.md) · Core
- [ ] 5.5 [flatMap](05-stream-api/ex05-flatmap/README.md) · Core
- [ ] 5.6 [groupingBy and downstream collectors](05-stream-api/ex06-grouping/README.md) · Core
- [ ] 5.7 [partitioningBy](05-stream-api/ex07-partitioning/README.md) · Core
- [ ] 5.8 [toMap and its pitfalls](05-stream-api/ex08-to-map/README.md) · Core
- [ ] 5.9 [Nested grouping](05-stream-api/ex09-nested-grouping/README.md) · Core
- [ ] 5.10 [Optional chains](05-stream-api/ex10-optional-chains/README.md) · Core
- [ ] 5.11 [Top N per group: streams vs. loops](05-stream-api/ex11-top-n-per-group/README.md) · Challenge
- [ ] 5.12 [Custom Collector](05-stream-api/ex12-custom-collector/README.md) · Challenge
- [ ] 5.13 [Parallel stream pitfalls](05-stream-api/ex13-parallel-pitfalls/README.md) · Challenge

### 6. [Capstone: expense tracker](06-capstone-expense-tracker/README.md)

- [ ] 6 [In-memory expense tracker](06-capstone-expense-tracker/README.md) · Capstone
