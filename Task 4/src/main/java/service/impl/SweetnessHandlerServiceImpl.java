package service.impl;

import service.DataFromFileHandler;
import dao.impl.CandyFileReaderImpl;
import entity.constant.ConstantType;
import org.apache.log4j.Logger;
import service.GiftHandlerService;
import entity.Sweetness;
import entity.impl.Candy;
import entity.impl.Chocolate;
import entity.impl.Marshmallow;
import service.helper.DataValidateHelper;
import controller.menu.SwitchCase;
import controller.userInput.InputData;
import service.possipleException.NotValidFileException;

import java.io.IOException;
import java.util.*;

public class SweetnessHandlerServiceImpl implements GiftHandlerService {

    private final static Logger LOGGER = Logger.getLogger(SweetnessHandlerServiceImpl.class);

    private List<Sweetness> list;

    private final static String TYPE = "type";
    private final static String NAME = "name";
    private final static String SUGAR_VALUE = "sugarValue";
    private final static String WEIGHT = "weight";
    private final static String QUANTITY = "quantity";
    private final static String FORM = "form";
    private final static String HELPER = "helper";

    @Override
    public void makeTheGift() {
        list = new ArrayList<>(createListOfSweets());
        if (list.isEmpty()) {
            try {
                throw new NotValidFileException("Check your file");
            } catch (NotValidFileException e) {
                LOGGER.error(e);
            }
        } else {
            for (Sweetness i : list) {
                System.out.println(i);
            }
            SwitchCase choice = new SwitchCase();
            try {
                choice.userChoice(list);
            } catch (IOException e) {
                LOGGER.error(e);
            } finally {
                InputData.closeStream();
            }
        }
    }


    @Override
    public void sortSweets() {
        list.sort(Comparator.comparing(Sweetness::getWeight));
    }

    @Override
    public void findInRangeOfSugar(short low, short high) {
        for (Sweetness i : list) {
            if (i.getSugarValue() > low && i.getSugarValue() < high) {
                System.out.println(i);
            }
        }
    }

    @Override
    public Optional<Sweetness> createSweets(String[] sweetnessParams) {
        if (sweetnessParams.length != 6) {
            return Optional.empty();
        }
        Map<String, Object> map = new HashMap();
        DataValidateHelper helper = DataValidateHelper.getDataValidateHelper();
        String type = helper.isValidType(sweetnessParams[0]);
        String name = helper.isValidName(sweetnessParams[1]);
        Short sugarValue = helper.isValidSugarValue(sweetnessParams[2]);
        Integer weight = helper.isValidWeight(sweetnessParams[3]);
        Short quantity = helper.isValidQuantity(sweetnessParams[4]);
        String form = helper.isValidForm(sweetnessParams[5]);
        map.put(TYPE, type);
        map.put(NAME, name);
        map.put(SUGAR_VALUE, sugarValue);
        map.put(WEIGHT, weight);
        map.put(QUANTITY, quantity);
        map.put(FORM, form);
        map.put(HELPER, helper);
        return createNewSweetness(map);
    }

    private Optional<Sweetness> createNewSweetness(Map<String, Object> map) {
        DataValidateHelper helper = (DataValidateHelper) map.get(HELPER);
        String type = (String) map.get(TYPE);
        String name = (String) map.get(NAME);
        Short sugarValue = (Short) map.get(SUGAR_VALUE);
        Integer weight = (Integer) map.get(WEIGHT);
        Short quantity = (Short) map.get(QUANTITY);
        String form = (String) map.get(FORM);
        if (helper.areConditionRight(type, name,
                sugarValue, weight, quantity, form)) {
            switch (type.toUpperCase()) {
                case ConstantType.CANDY:
                    return Optional.of(new Candy.CandyBuilder()
                            .weight(weight).type(type)
                            .form(form).sugarValue(sugarValue)
                            .name(name).quantity(quantity)
                            .build());
                case ConstantType.MARSHMALLOW:
                    return Optional.of(new Marshmallow.MarshmallowBuilder()
                            .weight(weight).type(type)
                            .form(form).sugarValue(sugarValue)
                            .quantity(quantity).name(name)
                            .build());
                case ConstantType.CHOCOLATE:
                    return Optional.of(new Chocolate.ChocolateBuilder()
                            .weight(weight).type(type)
                            .form(form).sugarValue(sugarValue)
                            .quantity(quantity).name(name)
                            .build());
                default:
                    return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    private List<Sweetness> createListOfSweets() {
        List<Sweetness> sweetnessList = new ArrayList<>();
        try (CandyFileReaderImpl reader = new CandyFileReaderImpl()) {
            DataFromFileHandler handler = new DataFromFileHandler();
            GiftHandlerService giftHandler = new SweetnessHandlerServiceImpl();
            Optional<Sweetness> optionalSweetness;
            while (reader.getReader().ready()) {
                String[] sweetnessParameters = handler.sendParamsForOqj(reader.read());
                optionalSweetness = giftHandler.createSweets(sweetnessParameters);
                optionalSweetness.ifPresent(sweetnessList::add);
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return sweetnessList;
    }

}
