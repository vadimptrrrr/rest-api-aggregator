package ru.coursework.aggregator.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class AggregatedRecord {
    private final String id;
    private final String sourceName;
    private final String queryParams;
    private final Instant fetchedAt;
    private final String summary;
    private final Map<String, Object> metrics;

    @JsonCreator
    public AggregatedRecord(
            @JsonProperty("id") String id,
            @JsonProperty("sourceName") String sourceName,
            @JsonProperty("queryParams") String queryParams,
            @JsonProperty("fetchedAt") Instant fetchedAt,
            @JsonProperty("summary") String summary,
            @JsonProperty("metrics") Map<String, Object> metrics
    ) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.sourceName = Objects.requireNonNull(sourceName, "sourceName must not be null");
        this.queryParams = Objects.requireNonNull(queryParams, "queryParams must not be null");
        this.fetchedAt = Objects.requireNonNull(fetchedAt, "fetchedAt must not be null");
        this.summary = Objects.requireNonNull(summary, "summary must not be null");
        this.metrics = metrics == null
                ? Collections.emptyMap()
                : Collections.unmodifiableMap(new LinkedHashMap<>(metrics));
    }

    public String getId() {
        return id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public Instant getFetchedAt() {
        return fetchedAt;
    }

    public String getSummary() {
        return summary;
    }

    public Map<String, Object> getMetrics() {
        return metrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AggregatedRecord that)) return false;
        return Objects.equals(id, that.id)
                && Objects.equals(sourceName, that.sourceName)
                && Objects.equals(queryParams, that.queryParams)
                && Objects.equals(fetchedAt, that.fetchedAt)
                && Objects.equals(summary, that.summary)
                && Objects.equals(metrics, that.metrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceName, queryParams, fetchedAt, summary, metrics);
    }

    @Override
    public String toString() {
        return "AggregatedRecord{" +
                "id='" + id + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", queryParams='" + queryParams + '\'' +
                ", fetchedAt=" + fetchedAt +
                ", summary='" + summary + '\'' +
                ", metrics=" + metrics +
                '}';
    }
}