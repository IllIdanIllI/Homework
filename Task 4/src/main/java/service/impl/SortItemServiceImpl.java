package service.impl;

import entity.Sweetness;
import service.SortItemService;

import java.util.ArrayList;
import java.util.List;

public class SortItemServiceImpl implements SortItemService {
    @Override
    public void sortByName(List<Sweetness> list) {
        for (int i=0;i<list.size()-2;i++){
            int min = i;
            int charIndex = 0;
            for(int j=i+1;j<list.size();j++){
                    if (list.get(j).getName().charAt(charIndex)
                            < list.get(min).getName().charAt(charIndex)) {
                        min = j;
                    } else if(list.get(j).getName().charAt(charIndex)
                            == list.get(min).getName().charAt(charIndex)){
                        charIndex++;
                    }
            }
            if(min!=i){
                swap(list,i,min);
            }
        }
        list.forEach(System.out::println);
    }

    @Override
    public void sortByWeight(List<Sweetness> list) {
        for (int i=0;i<list.size()-1;i++){
            int min = i;
            for(int j=i+1;j<list.size();j++){
                if(list.get(j).getWeight()<list.get(min).getWeight()){
                    min = j;
                }
            }
            if(min!=i){
                swap(list,i,min);
            }
        }
        list.forEach(System.out::println);
    }

    @Override
    public void sortBySugarPresence(List<Sweetness> list) {
        ArrayList<Sweetness>[] bucketsArray = new ArrayList[10];
        for (int i=0;i<bucketsArray.length;i++){
            bucketsArray[i] = new ArrayList<>();
        }
        boolean maxDigitLengthReached = false;
        short temp, placeValue = 1;
        while(!maxDigitLengthReached){
            maxDigitLengthReached=true;
            for (Sweetness element:list){
                temp =(short) (element.getSugarValue()/placeValue);
                bucketsArray[temp%10].add(element);
                if (maxDigitLengthReached&&temp>0){
                    maxDigitLengthReached = false;
                }
            }
            int a=0;
            for(int b=0;b<10;b++){
                for (Sweetness i:bucketsArray[b]){
//                    list.get(a++).getSugarValue()=i;
                    list.add(a++,i);
                    list.remove(a);
                }
                bucketsArray[b].clear();
            }
            placeValue = (short) (placeValue*10);
        }
        list.forEach(System.out::println);
    }

    @Override
    public void sortByType(List<Sweetness> list) {

    }

    private int isMaxValue(List<Sweetness> list){
        int max = 0;
        for (Sweetness aList : list) {
            if (aList.getSugarValue() > max) {
                max = aList.getSugarValue();
            }
        }
        return max;
    }
    private void swap(List<Sweetness> list, int i, int min){
        list.add(i,list.get(min));
        list.remove(min+1);
    }
}
