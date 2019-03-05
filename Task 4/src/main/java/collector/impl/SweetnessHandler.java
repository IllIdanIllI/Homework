package collector.impl;

import collector.GiftHandler;
import entity.Sweetness;
import entity.impl.Candy;
import entity.impl.Chocolate;
import entity.impl.Marshmallow;

public class SweetnessHandler extends GiftHandler {
    @Override
    public Sweetness createSweets(String item) {
        if (item.toUpperCase().equals("CANDY")) {
            return new Candy();
        } else if(item.toUpperCase().equals("MARSHMALLOW")){
            return new Marshmallow();
        } else if(item.toUpperCase().equals("CHOCOLATE")){
            return new Chocolate();
        } else{
            return null;
        }
    }
}
