package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void testPageTitle() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://playwright.dev");
            assertEquals("Playwright", page.title());
        }
    }
}
