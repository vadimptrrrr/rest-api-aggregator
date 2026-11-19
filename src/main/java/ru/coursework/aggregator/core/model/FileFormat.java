package ru.coursework.aggregator.core.model;

public enum FileFormat {
    JSON,
    CSV;

    public static FileFormat fromString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("File format must not be empty");
        }
        try {
            return FileFormat.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unsupported file format: " + value + ". Allowed values: json, csv");
        }
    }
}