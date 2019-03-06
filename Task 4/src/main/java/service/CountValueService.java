package service;

import entity.Sweetness;

import java.util.List;

public interface CountValueService {
    int countWeight(List<Sweetness> list);
    int countSugarValue(List<Sweetness> list);
}
