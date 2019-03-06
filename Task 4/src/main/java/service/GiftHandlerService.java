package service;

import entity.Sweetness;

public interface GiftHandlerService {

    void makeTheGift();

    void sortSweets();

    void find_In_Range_Of_Sugar(short low, short high);

    Sweetness createSweets(String[] params);
}
