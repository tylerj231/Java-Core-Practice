package com.javacore.streams.model;

import java.math.BigDecimal;

public record Product(long id, String name, String category, BigDecimal price) {}
