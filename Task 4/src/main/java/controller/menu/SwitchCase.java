package controller.menu;

import entity.Sweetness;
import service.CountValueService;
import service.FilterValueService;
import service.SortItemService;
import service.impl.CountValueServiceImpl;
import service.impl.FilterValueServiceImpl;
import service.impl.SortItemServiceImpl;
import controller.userInput.InputData;

import java.io.IOException;
import java.util.List;

public class SwitchCase {
    private void userMenu() {
        System.out.println("Please make you choice");
        System.out.println("press 1 to sort gift");
        System.out.println("press 2 to filter gift");
        System.out.println("press 3 to know weight of gift");
        System.out.println("Press 4 and more for exit");
        System.out.println();
    }

    public void userChoice(List<Sweetness> list) throws IOException {
        System.out.println();
        userMenu();
        int number = InputData.enterNumber();
        while (number < 4 && number > 0) {
            switch (number) {
                case 1:
                    sortMenu();
                    sortChoice(InputData.enterNumber(), list);
                    break;
                case 2:
                    filterMenu();
                    filterChoice(InputData.enterNumber(), list);
                    break;
                case 3:
                    countMenu();
                    countParamsChoice(InputData.enterNumber(), list);
                    break;
                default:
                    System.out.println("Check your input");
                    break;
            }
            System.out.println();
            userMenu();
            number = InputData.enterNumber();
        }
    }

    private void sortMenu() {
        System.out.println("Please make you choice");
        System.out.println("Press 1 to sort by Name");
        System.out.println("Press 2 to sort by Weight");
        System.out.println("Press 3 to sort by Sugar");
        System.out.println();
    }

    private void sortChoice(int number, List<Sweetness> list) {
        SortItemService sort = new SortItemServiceImpl();
        switch (number) {
            case 1:
                sort.sortByName(list);
                break;
            case 2:
                sort.sortByWeight(list);
                break;
            case 3:
                sort.sortBySugarPresence(list);
                break;
            default:
                System.out.println("Check your input");
                break;
        }
    }

    private void filterMenu() {
        System.out.println("Please make you choice");
        System.out.println("Press 1 to filter by Type");
        System.out.println("Press 2 to sort by range of Sugar");
        System.out.println();
    }

    private void filterChoice(int number, List<Sweetness> list) throws IOException {
        FilterValueService filter = new FilterValueServiceImpl();
        switch (number) {
            case 1:
                System.out.println("Enter type, for example 'chocolate'");
                String typeOfSweetness = InputData.enterLine();
                filter.filterByType(list,typeOfSweetness);
                break;
            case 2:
                System.out.println("Enter the low range of sugar");
                short lowRange = (short) (InputData.enterNumber());
                System.out.println("Enter the high range of sugar");
                short highRange = (short) (InputData.enterNumber());
                System.out.println("Your result");
                filter.findInRangeOfSugar(list, lowRange, highRange);
                break;
            default:
                System.out.println("Check your input");
                break;
        }
    }

    private void countMenu() {
        System.out.println("Please make you choice");
        System.out.println("Press 1 to count weight of gift");
        System.out.println("Press 2 to count sugar persistence in gift");
        System.out.println();
    }

    private void countParamsChoice(int number, List<Sweetness> list) {
        CountValueService count = new CountValueServiceImpl();
        switch (number) {
            case 1:
                System.out.println(count.countWeight(list) + " g");
                break;
            case 2:
                System.out.println(count.countSugarValue(list) + " picogram");
                break;
            default:
                System.out.println("Check your input");
                break;
        }
    }
}
