package service.impl;

import entity.Sweetness;
import service.FilterValueService;

import java.util.List;

public class FilterValueServiceImpl implements FilterValueService {

    @Override
    public void filterByType(List<Sweetness> list, String type) {
        for (Sweetness sweet : list) {
            if (sweet.getType().toUpperCase()
                    .equals(type.toUpperCase())) {
                System.out.println(sweet);
            }
        }
    }

    @Override
    public void filterByForm(List<Sweetness> list, String form) {
        list.stream().filter(sweetness -> sweetness.getForm()
                .toUpperCase().equals(form
                        .toUpperCase()))
                .forEach(System.out::println);
    }

    @Override
    public void findInRangeOfSugar(List<Sweetness> list, short low, short high) {
        list.stream().filter(sweetness -> low < sweetness.getSugarValue()
                && sweetness.getSugarValue() < high)
                .forEach(sweetness -> System.out.println(sweetness));
    }
}
