package com.radonsky.monkeysched;

import javax.annotation.Nullable;

import org.joda.time.DateTime;

import com.google.common.base.Predicate;

public class Rule implements TimeRule {

    private final Predicate<DateTime> predicate;
    
    public Rule(Predicate<DateTime> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean apply(@Nullable DateTime input) {
        return predicate.apply(input);
    }
    
    
}
