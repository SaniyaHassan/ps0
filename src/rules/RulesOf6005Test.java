/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }
    /**
     * Rule 2: code from a public source that is properly cited, is not 6.005
     * course work, and is not required to be implemented by you, may be used.
     */
    @Test
    public void testPublicCitedCodeAllowed() {
        assertTrue("Expected true: cited public code that is not required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }

    /**
     * Rule 2: another student's 6.005 course work may never be used,
     * even when it is public and properly cited.
     */
    @Test
    public void testCourseWorkFromOthersNotAllowed() {
        assertFalse("Expected false: someone else's 6.005 course work",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }

    /**
     * Rule 2: public cited code is not allowed when the assignment
     * explicitly asks you to implement that feature yourself.
     */
    @Test
    public void testImplementationRequiredNotAllowed() {
        assertFalse("Expected false: assignment requires your own implementation",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, true));
    }
}
