package service.impl;

import entity.Sweetness;
import service.CountValueService;

import java.util.List;

public class CountValueServiceImpl implements CountValueService {
    @Override
    public int countWeight(List<Sweetness> list) {
        int sum = 0;
        for (Sweetness i : list) {
            sum += i.getWeight() * i.getQuantity();
        }
        return sum;
    }

    @Override
    public int countSugarValue(List<Sweetness> list) {
        int sum = 0;
        for (Sweetness i : list) {
            sum += i.getSugarValue() * i.getQuantity();
        }
        return sum;
    }
}
