package com.radonsky.monkeysched;

import static com.google.common.base.Predicates.*;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class RuleEngine {

    private static final RuleEngine INSTANCE = new RuleEngine();
    
    private final ImmutableList<TimeRule> whiteList;

    private final ImmutableList<TimeRule> blackList;
    
    private RuleEngine() {
        whiteList = ImmutableList.of();
        blackList = ImmutableList.of();
    }
    
    public RuleEngine(List<? extends TimeRule> whiteList, List<? extends TimeRule> blackList) {
        this.whiteList = ImmutableList.copyOf(whiteList);
        this.blackList = ImmutableList.copyOf(blackList);        
    }
    
    public static RuleEngine getDefault() {
        return INSTANCE;
    }
    
    public TimeRule getTimeRule() {
        return new Rule(and(or(whiteList), not(or(blackList))));
    }

    public ImmutableList<TimeRule> getWhiteList() {
        return whiteList;
    }

    public ImmutableList<TimeRule> getBlackList() {
        return blackList;
    }
    
    
    
}
