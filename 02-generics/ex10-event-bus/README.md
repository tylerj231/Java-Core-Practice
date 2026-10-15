# 2.10 Generic event bus

**Topic:** Generics · **Level:** Challenge  
**Module:** `02-generics/ex10-event-bus` · **Package:** `com.javacore.generics.ex10`

## Goal

Combine class tokens, wildcards and functional interfaces in one small, realistic API.

## Task

Build a synchronous in-process event bus.

## Requirements

- `<E> Subscription subscribe(Class<E> type, Consumer<? super E> handler)`.
- `int publish(Object event)` calls every handler whose type matches and returns the number of handlers called.
- A handler subscribed to a supertype or interface receives events of all subtypes (use `type.isInstance(event)`). A handler for `Object.class` receives everything.
- Handlers are called in subscription order.
- `interface Subscription extends AutoCloseable { void unsubscribe(); }`, where `close()` calls `unsubscribe()` and doesn't throw checked exceptions. Unsubscribing twice is harmless.
- If a handler throws, the other handlers still run, and `publish` then throws an exception carrying the first failure as its cause.

## Example

```java
bus.subscribe(OrderPlaced.class, e -> emails.send(e));
bus.subscribe(DomainEvent.class, e -> audit.log(e));
bus.publish(new OrderPlaced(42)); // returns 2
```

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/generics/ex10`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] A subtype event reaches both its own handler and a supertype handler. The return value counts both.
- [ ] A `Consumer<Object>` can subscribe to a specific type (this needs `? super E`).
- [ ] Handlers run in subscription order (record calls in a list).
- [ ] `unsubscribe` and try-with-resources stop delivery.
- [ ] A failing handler doesn't stop the others.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why is the handler typed `Consumer<? super E>` rather than `Consumer<E>`?
2. Why `isInstance` instead of `event.getClass() == type`?
3. Spring has `ApplicationEventPublisher` and `@EventListener`. What does your design share with it?

## Run

```bash
mvn -pl 02-generics/ex10-event-bus -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(2.10): generic event bus`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
