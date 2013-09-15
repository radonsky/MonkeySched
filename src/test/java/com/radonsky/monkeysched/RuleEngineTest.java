package com.radonsky.monkeysched;

import static org.junit.Assert.*;

import org.junit.Test;

public class RuleEngineTest {

    @Test
    public void testDefaultTimeRule() {
        assertNotNull(RuleEngine.getDefaultTimeRule());
    }

}
