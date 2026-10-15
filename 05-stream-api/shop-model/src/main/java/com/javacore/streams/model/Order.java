package com.javacore.streams.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record Order(long id, Customer customer, LocalDate date, Status status, List<OrderLine> lines) {

    public Order {
        lines = List.copyOf(lines);
    }

    /** Sum of all line subtotals. Implemented in exercise 5.4. */
    public BigDecimal total() {
        throw new UnsupportedOperationException("Implement Order.total() in exercise 5.4");
    }
}
