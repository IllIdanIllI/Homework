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
import service.menu.SwitchCase;
import service.userInput.InputData;

import java.io.IOException;
import java.util.*;

public class SweetnessHandlerServiceImpl implements GiftHandlerService {
    private List<Sweetness> list;
    private final static Logger LOGGER = Logger.getLogger(SweetnessHandlerServiceImpl.class);
    Sweetness sweet;

    @Override
    public void makeTheGift() {
        list = new ArrayList<>(createListOfSweets());
        if (list.size() == 0) {
            System.out.println("Check file!");
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
    public Optional<Sweetness> createSweets(String[] param) {
        if (param.length != 6) {
            return Optional.empty();
        }
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
                case ConstantType.CANDY:
                    return Optional.of(new Candy(type, name, sugarValue,
                            weight, quantity, form));
                case ConstantType.MARSHMALLOW:
                    return Optional.of(new Marshmallow(type, name, sugarValue,
                            weight, quantity, form));
                case ConstantType.CHOCOLATE:
                    return Optional.of(new Chocolate(type, name, sugarValue,
                            weight, quantity, form));
                default:
                    return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    private List createListOfSweets() {
        try (CandyFileReaderImpl reader = new CandyFileReaderImpl()) {
            DataFromFileHandler handler = new DataFromFileHandler();
            GiftHandlerService giftHandler = new SweetnessHandlerServiceImpl();
            Optional<Sweetness> optionalSweetness;
            List<Sweetness> sweetnessList = new ArrayList<>();
            while (reader.getReader().ready()) {
                String[] sweetnessParameters = handler.sendParamsForOqj(reader.read());
                optionalSweetness = giftHandler.createSweets(sweetnessParameters);
                optionalSweetness.ifPresent(sweetnessList::add);
            }
            return sweetnessList;
        } catch (IOException e) {
            LOGGER.error(e);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return null;
    }

}
