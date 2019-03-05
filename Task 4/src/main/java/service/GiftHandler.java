package service;

import entity.Sweetness;

public interface GiftHandler {
    public abstract void makeTheGift();
// тут с помощью сортировок и всего такого я планирую как нибудь составить
        //объект Gift и затем его уже вывести

    public abstract void sortSweets();
    public abstract void find_In_Range_Of_Suger(short low,short high);
    public abstract Sweetness createSweets(String[] params);
}
