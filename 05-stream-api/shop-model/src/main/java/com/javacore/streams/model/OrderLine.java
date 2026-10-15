package com.javacore.streams.model;

import java.math.BigDecimal;

public record OrderLine(Product product, int quantity) {

    public OrderLine {
        if (quantity < 1) {
            throw new IllegalArgumentException("quantity must be at least 1");
        }
    }

    /** Unit price multiplied by quantity. */
    public BigDecimal subtotal() {
        return product.price().multiply(BigDecimal.valueOf(quantity));
    }
}
