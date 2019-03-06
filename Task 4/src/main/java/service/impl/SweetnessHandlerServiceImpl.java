package service.impl;

import dao.CandyFileReader;
import dao.FileHandler;
import dao.impl.CandyFileReaderImpl;
import service.CountValueService;
import service.GiftHandlerService;
import entity.Sweetness;
import entity.impl.Candy;
import entity.impl.Chocolate;
import entity.impl.Marshmallow;
import service.SortItemService;

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
        list = new ArrayList<Sweetness>(reader.readFile());
        for (Sweetness i : list) {
            System.out.println(i);
        }
//        System.out.println("Weight of the gift is " + countValue.countWeight(list) + " g");
//        sortSweets();
//        System.out.println();
//        for (Sweetness i : list) {
//            System.out.println(i);
//        }
        System.out.println();
        sort.sortBySugarPresence(list);
//        find_In_Range_Of_Sugar((short) 3,(short)7);
    }



    @Override
    public void sortSweets() {
        list.sort(Comparator.comparing(Sweetness::getWeight));
    }

    @Override
    public void find_In_Range_Of_Sugar(short low, short high) {
        for (Sweetness i : list) {
            if(i.getSugarValue()>low && i.getSugarValue()<high) {
                System.out.println(i);
            }
        }
    }

    @Override
    public Sweetness createSweets(String[] param) {
        String type = param[0];
        String name = param[1];
        short sugarValue = Short.parseShort(param[2]);
        int weight = Integer.parseInt(param[3]);
        short quantity = Short.parseShort(param[4]);
        String form = param[5];
        if (type.toUpperCase().equals("CANDY")) {
            return new Candy(type, name, sugarValue,
                    weight, quantity, form);
        } else if (type.toUpperCase().equals("MARSHMALLOW")) {
            return new Marshmallow(type, name, sugarValue,
                    weight, quantity, form);
        } else if (type.toUpperCase().equals("CHOCOLATE")) {
            return new Chocolate(type, name, sugarValue,
                    weight, quantity, form);
        } else {
            return null;
        }
    }

}
