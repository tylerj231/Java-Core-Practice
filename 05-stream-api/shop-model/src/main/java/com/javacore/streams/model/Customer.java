package com.javacore.streams.model;

import java.time.LocalDate;

public record Customer(long id, String name, String city, LocalDate registeredOn) {}
