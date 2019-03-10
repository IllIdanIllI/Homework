package service;

import entity.Sweetness;

import java.util.Optional;

public interface GiftHandlerService {

    void makeTheGift();

    void sortSweets();

    void findInRangeOfSugar(short low, short high);

    Optional<Sweetness> createSweets(String[] params);
}
