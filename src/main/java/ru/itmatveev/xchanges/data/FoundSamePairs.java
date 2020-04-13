package ru.itmatveev.xchanges.data;

import lombok.Data;

@Data
public class FoundSamePairs {
    private String samePairName;

    public FoundSamePairs(String samePairName) {
        this.samePairName = samePairName;
    }

    public String getSamePairName() {
        return samePairName;
    }

    public void setSamePairName(String samePairName) {
        this.samePairName = samePairName;
    }
}
