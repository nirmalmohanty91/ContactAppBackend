package com.cdk.customerdb.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum DateFormat {
  PATTERN("yyyy-MM-dd HH:mm:ss");

  private final String value;

  DateFormat(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static LocalDateTime of(String date) {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN.value());
    return LocalDateTime.parse(date, formatter);
  }
}