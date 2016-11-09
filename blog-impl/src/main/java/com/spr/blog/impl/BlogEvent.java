package com.spr.blog.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lightbend.lagom.javadsl.persistence.AggregateEvent;
import com.lightbend.lagom.javadsl.persistence.AggregateEventTag;
import com.lightbend.lagom.javadsl.persistence.AggregateEventTagger;
import com.lightbend.lagom.serialization.CompressedJsonable;
import com.lightbend.lagom.serialization.Jsonable;
import com.spr.blog.api.PostContent;

import javax.annotation.concurrent.Immutable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * Events related to blog post entities.
 *
 * @author Matt Sicker
 * @see BlogEntity
 */
public interface BlogEvent extends Jsonable, AggregateEvent<BlogEvent> {

    @Override
    default AggregateEventTagger<BlogEvent> aggregateTag() {
        return AggregateEventTag.of(BlogEvent.class);
    }

    @Immutable
    @JsonDeserialize
    @Data
    @AllArgsConstructor(onConstructor = @__(@JsonCreator))
    final class PostAdded implements BlogEvent, CompressedJsonable {
        @NonNull
        private final String id;
        @NonNull
        private final PostContent content;
    }

    @Immutable
    @JsonDeserialize
    @Data
    @AllArgsConstructor(onConstructor = @__(@JsonCreator))
    final class PostUpdated implements BlogEvent, CompressedJsonable {
        @NonNull
        private final String id;
        @NonNull
        private final PostContent content;
    }
}
