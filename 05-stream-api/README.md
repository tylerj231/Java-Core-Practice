# 5. Stream API

Solve grouping and aggregation problems fluently, and know when a plain loop is the better choice.

**Estimated time:** 12–15 hours

Most exercises in this topic use the shared domain model in `05-stream-api/shop-model` (`Customer`, `Product`, `OrderLine`, `Order`, `Status`). In tests, build small hand-made fixtures so you can assert exact results.

| # | Exercise | Level |
| --- | --- | --- |
| 5.1 | [Stream basics](ex01-basics/README.md) | Warm-up |
| 5.2 | [Laziness and processing order](ex02-laziness/README.md) | Warm-up |
| 5.3 | [Primitive streams](ex03-primitive-streams/README.md) | Warm-up |
| 5.4 | [Order totals with reduce](ex04-order-totals/README.md) | Core |
| 5.5 | [flatMap](ex05-flatmap/README.md) | Core |
| 5.6 | [groupingBy and downstream collectors](ex06-grouping/README.md) | Core |
| 5.7 | [partitioningBy](ex07-partitioning/README.md) | Core |
| 5.8 | [toMap and its pitfalls](ex08-to-map/README.md) | Core |
| 5.9 | [Nested grouping](ex09-nested-grouping/README.md) | Core |
| 5.10 | [Optional chains](ex10-optional-chains/README.md) | Core |
| 5.11 | [Top N per group: streams vs. loops](ex11-top-n-per-group/README.md) | Challenge |
| 5.12 | [Custom Collector](ex12-custom-collector/README.md) | Challenge |
| 5.13 | [Parallel stream pitfalls](ex13-parallel-pitfalls/README.md) | Challenge |

## Resources

- *Modern Java in Action*, chapters on streams and collectors
- José Paumard's stream and collector videos on the official Java YouTube channel
- The `java.util.stream` package Javadoc (its "Stream operations and pipelines" section)
