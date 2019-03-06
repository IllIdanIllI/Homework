package service;

import entity.Sweetness;

import java.util.List;

public interface FilterValueService {
    void filterByType(List<Sweetness> list, String type);
    void filterByForm(List<Sweetness> list, String form);
    void find_In_Range_Of_Sugar(List<Sweetness> list, short low, short high);
}
