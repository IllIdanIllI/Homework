package dao.impl;

import dao.CandyFileReader;
import org.apache.log4j.Logger;

import java.io.*;

public class CandyFileReaderImpl implements CandyFileReader, AutoCloseable {

    private final static Logger LOGGER = Logger.getLogger(CandyFileReaderImpl.class);
    private final static String FILE_PATH_TO_DATA = "src\\controller\\resources\\data.txt";
    private static BufferedReader reader;

    public BufferedReader getReader() {
        return reader;
    }

    static {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH_TO_DATA)));
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public String read() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public void close()  {
        try {
            reader.close();
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
