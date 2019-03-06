package dao;

import service.impl.SweetnessHandlerServiceImpl;
import entity.Sweetness;

public class DataFromFileHandler {
    public String[] sendParamsForOqj(String line) {
        return line.split(",");
    }

//    Sweetness splitLineFromFile(Sweetness sweetness, String line) {

//        String[] many = line.split("\\s");
//        sweetness.setName(many[1]);
//        sweetness.setWeight(Integer.parseInt(many[2]));
//        sweetness.setSugarValue(Short.parseShort(many[3]));
//        sweetness.setQuantity(Byte.parseByte(many[4]));
//        return sweetness;
//    }
}
