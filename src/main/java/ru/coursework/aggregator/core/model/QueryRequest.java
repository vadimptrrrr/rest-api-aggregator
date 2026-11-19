package ru.coursework.aggregator.core.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public final class QueryRequest {
    private final String sourceName;
    private final Map<String, String> queryParams;

    public QueryRequest(String sourceName, Map<String, String> queryParams) {
        if (sourceName == null || sourceName.isBlank()) {
            throw new IllegalArgumentException("Source name must not be blank");
        }
        this.sourceName = sourceName.trim().toLowerCase();
        this.queryParams = queryParams == null
                ? Collections.emptyMap()
                : Collections.unmodifiableMap(new LinkedHashMap<>(queryParams));
    }

    public static QueryRequest ofDefault(String sourceName) {
        return new QueryRequest(sourceName, Collections.emptyMap());
    }

    public String getSourceName() {
        return sourceName;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public String formatQueryParams() {
        if (queryParams.isEmpty()) {
            return "default";
        }
        return queryParams.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QueryRequest that)) return false;
        return Objects.equals(sourceName, that.sourceName)
                && Objects.equals(queryParams, that.queryParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceName, queryParams);
    }
}