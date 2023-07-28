package com.vadim.utils;

import com.vadim.model.Performer;
import com.vadim.model.Recruit;

import java.util.List;
import java.util.Objects;

public class PerformerListWrapper {

    private static List<Performer> performers;

    private PerformerListWrapper() {
    }

    public static List<Performer> getPerformers(boolean isReadOnly) {
        if (isReadOnly) {
            if (Objects.isNull(performers)) {
                performers = JsonMapper.getPerformers();
            }
            return performers;
        }
        return JsonMapper.getPerformers();
    }
}
