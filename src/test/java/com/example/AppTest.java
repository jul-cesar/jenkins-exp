package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void messageDebeSerHelloCICD() {
        assertEquals("Hello CI/CD", App.message());
    }
}
