package dao.impl;

import dao.CandyFileReader;
import dao.DataFromFileHandler;
import entity.Sweetness;
import org.apache.log4j.Logger;
import service.GiftHandlerService;
import service.impl.SweetnessHandlerServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CandyFileReaderImpl implements CandyFileReader, AutoCloseable {

    private final static Logger LOGGER = Logger.getLogger(CandyFileReaderImpl.class);
    private final static String FILE_PATH_TO_DATA = "src\\main\\resources\\data.txt";
    private static BufferedReader reader;

    public List createListOfSweets() {
        DataFromFileHandler handler = new DataFromFileHandler();
        GiftHandlerService giftHandler = new SweetnessHandlerServiceImpl();
        Sweetness sweetness;
        try {
            List<Sweetness> list = new ArrayList<>();
            while (reader.ready()) {
                sweetness =giftHandler.createSweets(handler.sendParamsForOqj(read()));
                list.add(sweetness);
            }
            return list;
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return null;
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
//                sb.append(System.lineSeparator());
//                list.add(giftHandler.createSweets(handler.sendParamsForOqj(line)));
            return reader.readLine();
            // отсюда коллекция пойдет в GiftHandlerService
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
