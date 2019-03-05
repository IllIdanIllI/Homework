package dao;

import service.impl.SweetnessHandler;
import entity.Sweetness;

class DataFromFileHandler {
    String[] sendCreateObj(String line) {
        SweetnessHandler sHandler = new SweetnessHandler();
        String split[] = line.split(",");
        return split;
    }

    Sweetness sendParams(Sweetness sweetness, String line) {
        //        line = line.replaceFirst("[a-zA-Z]*:\\s","");
        String[] many = line.split("\\s");
        sweetness.setName(many[1]);
        sweetness.setWeight(Integer.parseInt(many[2]));
        sweetness.setSugarValue(Short.parseShort(many[3]));
        sweetness.setQuantity(Byte.parseByte(many[4]));
//тут хочу сделать метод с разбиением строки и занесением значений в нужный объект
        //Потом этот объект пойдет в FileHandler  добаится в коллекцию
        return sweetness;
    }
}