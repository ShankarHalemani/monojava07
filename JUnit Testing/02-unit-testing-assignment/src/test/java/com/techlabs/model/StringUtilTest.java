package com.techlabs.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {
    private StringUtil util;

    @BeforeEach
    void init(){
        util=new StringUtil();
    }

    @Test
    @DisplayName("Truncate 'A' in first two places")
    void testTruncateAInFirstTwoPlaces(){
        assertAll(
                ()-> Assertions.assertEquals("BC",util.truncateAInFirstTwoPlaces("AABC")),
                ()-> Assertions.assertEquals("BCA",util.truncateAInFirstTwoPlaces("BACA")),
                ()-> Assertions.assertEquals("BCD",util.truncateAInFirstTwoPlaces("ABCD")),
                ()-> Assertions.assertEquals("BC",util.truncateAInFirstTwoPlaces("ABC")),
                ()-> Assertions.assertEquals("BCDA", util.truncateAInFirstTwoPlaces("BCDA")),
                ()-> Assertions.assertEquals("",util.truncateAInFirstTwoPlaces("AA")),
                ()-> Assertions.assertEquals("B",util.truncateAInFirstTwoPlaces("AB")),
                ()-> Assertions.assertEquals("",util.truncateAInFirstTwoPlaces("A")),
                ()-> Assertions.assertEquals("",util.truncateAInFirstTwoPlaces("")),
                ()-> Assertions.assertEquals("BB",util.truncateAInFirstTwoPlaces("BB"))
        );
    }

    @Test
    @DisplayName("First and Last two characters are equal")
    void testFirstAndLastTwoCharactersAreEqual(){
        assertAll(
                ()-> Assertions.assertTrue(util.firstAndLastTwoCharactersAreEqual("ABAB")),
                ()-> Assertions.assertFalse(util.firstAndLastTwoCharactersAreEqual("ABBBA")),
                ()-> Assertions.assertTrue(util.firstAndLastTwoCharactersAreEqual("ABCDAB")),
                ()-> Assertions.assertFalse(util.firstAndLastTwoCharactersAreEqual("ABC")),
                ()-> Assertions.assertFalse(util.firstAndLastTwoCharactersAreEqual("AB")),
                ()-> Assertions.assertFalse(util.firstAndLastTwoCharactersAreEqual("A")),
                ()-> Assertions.assertFalse(util.firstAndLastTwoCharactersAreEqual(""))
        );
    }

}