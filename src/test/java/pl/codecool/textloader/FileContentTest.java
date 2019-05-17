package pl.codecool.textloader;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileContentTest {

    @Test
    public void testGetFileContentThrowsException() {
        assertThrows(IOException.class, () -> {
            FileContent fileContent = new FileContent("badFileName.txt");
        }, "Test file loading class for thrown IOException with bad file name");
    }
}