package com.data.miner.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class ObjectMerger {

    private final ObjectMapper objectMapper;

    public ObjectMerger(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <T> T merge(Object input, T target, Class<T> type) {
        try {
            JsonNode original = objectMapper.valueToTree(target);
            JsonNode toMerge = objectMapper.valueToTree(input);
            JsonMergePatch patch = JsonMergePatch.fromJson(toMerge);
            JsonNode merged = patch.apply(original);

            return objectMapper.treeToValue(merged, type);

        } catch (IOException | JsonPatchException e) {
            throw new InvalidJsonException(e);
        }
    }

    public <T> FluidMerger<T> beginMergeWith(T initialObject, Class<T> type) {
        return new FluidMerger<>(initialObject, type);
    }

    public class FluidMerger<T> {
        private final T initialObject;
        private final Class<T> type;

        public FluidMerger(T initialObject, Class<T> type) {
            log.debug("before merge {}", initialObject);
            this.initialObject = initialObject;
            this.type = type;
        }

        public FluidMerger<T> thenMerge(Object input) {
            log.debug("merging with {}", input);
            T merged = ObjectMerger.this.merge(input, initialObject, type);
            log.debug("afterMerge {}", merged);
            return new FluidMerger<>(merged, type);
        }

        public T extractResult() {
            return initialObject;
        }
    }
}
