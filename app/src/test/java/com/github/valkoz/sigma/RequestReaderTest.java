package com.github.valkoz.sigma;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class RequestReaderTest {

    private static final String data = "Test Data";

    @Test
    public void read() {

        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        RequestReader requestReader = new RequestReader();
        String s = requestReader.read(inputStream);
        assertEquals(s, data);

    }
}