package dao;

import entity.Sweetness;
import org.apache.log4j.Logger;
import service.GiftHandlerService;
import service.impl.SweetnessHandlerServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private final static Logger log = Logger.getLogger(FileHandler.class);
    private final static String path = "src\\main\\resources\\data.txt";

    public List readFile() {
        DataFromFileHandler handler = new DataFromFileHandler();
        GiftHandlerService giftHandler = new SweetnessHandlerServiceImpl();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            List<Sweetness> list = new ArrayList<>();
            String line;
            while (br.ready()) {
//                sb.append(System.lineSeparator());
                line = br.readLine();
                list.add(giftHandler.createSweets(handler.sendCreateObj(line)));
            }
            return list;
            // отсюда коллекция пойдет в GiftHandlerService
        } catch (IOException e) {
            log.error(e);
        }
        return null;
    }
}
