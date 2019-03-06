package service.impl;

import dao.impl.CandyFileReaderImpl;
import service.CountValueService;
import service.FilterValueService;
import service.GiftHandlerService;
import entity.Sweetness;
import entity.impl.Candy;
import entity.impl.Chocolate;
import entity.impl.Marshmallow;
import service.SortItemService;
import service.helper.DataValidateHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SweetnessHandlerServiceImpl implements GiftHandlerService {
    private List<Sweetness> list;
    Sweetness sweet;

    @Override
    public void makeTheGift() {
        CandyFileReaderImpl reader = new CandyFileReaderImpl();
        CountValueService countValue = new CountValueServiceImpl();
        SortItemService sort = new SortItemServiceImpl();
        FilterValueService filter = new FilterValueServiceImpl();
        list = new ArrayList<Sweetness>(reader.createListOfSweets());
        for (Sweetness i : list) {
            System.out.println(i);
        }
        System.out.println();
        sort.sortBySugarPresence(list);
        System.out.println();
        sort.sortByName(list);
        System.out.println();
        sort.sortByWeight(list);
        System.out.println();
        filter.filterByType(list, "candy");
        System.out.println();
        filter.filterByForm(list, "circle");
        System.out.println();
        filter.find_In_Range_Of_Sugar(list, (short) 3, (short) 7);
//        find_In_Range_Of_Sugar((short) 3,(short)7);
    }


    @Override
    public void sortSweets() {
        list.sort(Comparator.comparing(Sweetness::getWeight));
    }

    @Override
    public void find_In_Range_Of_Sugar(short low, short high) {
        for (Sweetness i : list) {
            if (i.getSugarValue() > low && i.getSugarValue() < high) {
                System.out.println(i);
            }
        }
    }

    @Override
    public Sweetness createSweets(String[] param) {
        DataValidateHelper helper = new DataValidateHelper();
        String type = helper.isValidType(param[0]);
        String name = helper.isValidName(param[1]);
        short sugarValue = helper.isValidSugarValue(param[2]);
        int weight = helper.isValidWeight(param[3]);
        short quantity = helper.isValidQuantity(param[4]);
        String form = helper.isValidForm(param[5]);
        if (helper.conditionForSend(type, name,
                sugarValue, weight, quantity, form)) {
            switch (type.toUpperCase()) {
                case "CANDY":
                    return new Candy(type, name, sugarValue,
                            weight, quantity, form);
                case "MARSHMALLOW":
                    return new Marshmallow(type, name, sugarValue,
                            weight, quantity, form);
                case "CHOCOLATE":
                    return new Chocolate(type, name, sugarValue,
                            weight, quantity, form);
                default:
                    return null;
            }
        } else {
            return null;
        }

//        if (type.toUpperCase().equals("CANDY")) {
//            return new Candy(type, name, sugarValue,
//                    weight, quantity, form);
//        } else if (type.toUpperCase().equals("MARSHMALLOW")) {
//            return new Marshmallow(type, name, sugarValue,
//                    weight, quantity, form);
//        } else if (type.toUpperCase().equals("CHOCOLATE")) {
//            return new Chocolate(type, name, sugarValue,
//                    weight, quantity, form);
//        } else {
//            return null;
//        }
    }

}
