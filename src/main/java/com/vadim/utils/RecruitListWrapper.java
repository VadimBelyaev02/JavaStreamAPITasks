package com.vadim.utils;

import com.vadim.model.Recruit;

import java.util.List;
import java.util.Objects;

public class RecruitListWrapper {
    private static List<Recruit> recruits;

    private RecruitListWrapper() {
    }

    public static List<Recruit> getRecruits(boolean isReadOnly) {
        if (isReadOnly) {
            if (Objects.isNull(recruits)) {
                recruits = JsonMapper.getRecruits();
            }
            return recruits;
        }
        return JsonMapper.getRecruits();
    }
}
