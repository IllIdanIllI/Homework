package service;

import service.impl.SweetnessHandlerServiceImpl;
import entity.Sweetness;

public class DataFromFileHandler {
    public String[] sendParamsForOqj(String line) {
        return line.split(",");
    }
}
