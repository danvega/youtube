package dev.danvega.githubcopilot.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiteboardServiceTest {

    @Test
    void isPalindrome() {
        assertTrue(WhiteboardService.isPalindrome("racecar"));
    }
}
