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

public class CandyFileReaderImpl implements CandyFileReader {
    private final static Logger LOGGER = Logger.getLogger(CandyFileReaderImpl.class);
    private final static String FILE_PATH_TO_DATA = "src\\main\\resources\\data.txt";

        public List readFile() {
        DataFromFileHandler handler = new DataFromFileHandler();
        GiftHandlerService giftHandler = new SweetnessHandlerServiceImpl();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH_TO_DATA)))) {
            List<Sweetness> list = new ArrayList<>();
            String line;
            while (br.ready()) {
                line = br.readLine();
                list.add(giftHandler.createSweets(handler.sendCreateObj(line)));
            }
            return list;
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return null;
    }


    @Override
    public String read() {
//        DataFromFileHandler handler = new DataFromFileHandler();
//        GiftHandlerService giftHandler = new SweetnessHandlerServiceImpl();
////        Sweetness sweet;
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH_TO_DATA)))) {
//            List<Sweetness> list = new ArrayList<>();
//            String line;
//            while (br.ready()) {
////                sb.append(System.lineSeparator());
//                line = br.readLine();
//                list.add(giftHandler.createSweets(handler.sendCreateObj(line)));
//            }
//            return list;
//            // отсюда коллекция пойдет в GiftHandlerService
//        } catch (IOException e) {
//            LOGGER.error(e);
//        }
        return null;
    }
}
