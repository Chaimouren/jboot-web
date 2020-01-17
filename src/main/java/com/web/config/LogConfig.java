package com.web.config;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Writer;

public class LogConfig extends Writer {
    Logger logger = Logger.getLogger(LogConfig.class);

    public void write(String str) throws IOException {
        logger.info(str);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
    }

    public void flush() throws IOException {
    }

    public void close() throws IOException {
    }
}
