package com.radonsky.monkeysched;

import org.joda.time.DateTime;

import com.google.common.base.Predicate;

/**
 * Interface for a predicate that determines if an action can run at given time.
 */
public interface TimeRule extends Predicate<DateTime>{
    
}
