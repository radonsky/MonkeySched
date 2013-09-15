package com.radonsky.monkeysched;

import org.joda.time.DateTime;

import com.google.common.base.Predicates;

public class RuleEngine {

    public static TimeRule getDefaultTimeRule() {
        return new Rule(Predicates.<DateTime>alwaysFalse());
    }
    
}
