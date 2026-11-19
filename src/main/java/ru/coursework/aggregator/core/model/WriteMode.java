package ru.coursework.aggregator.core.model;

public enum WriteMode {
    OVERWRITE,
    APPEND;

    public static WriteMode fromString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Write mode must not be empty");
        }
        String normalized = value.trim().toUpperCase();
        return switch (normalized) {
            case "OVERWRITE", "NEW", "CREATE" -> OVERWRITE;
            case "APPEND" -> APPEND;
            default -> throw new IllegalArgumentException(
                    "Unsupported write mode: " + value + ". Allowed values: overwrite (or new), append"
            );
        };
    }
}
