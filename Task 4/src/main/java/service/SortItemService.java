package service;

import entity.Sweetness;

import java.util.List;

public interface SortItemService {
    void sortByName(List<Sweetness> list);

    void sortByWeight(List<Sweetness> list);

    void sortBySugarPresence(List<Sweetness> list);

    void sortByType(List<Sweetness> list);
}
