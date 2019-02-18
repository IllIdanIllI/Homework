import java.util.Random;

public class TaskOne {
    private final static int ONE = 1;
    private final static int QUANTITY = 1000;

    public static void main(String[] args) {
        throwCoin();
    }

    private static void throwCoin() {
        int head = 0, randomExpression;
        Random random = new Random();
        for (int i = 0; i < QUANTITY; i++) {
            randomExpression = random.nextInt(2);
            if (randomExpression != ONE) {
                head += 1;
            }
        }
        showRes(head, QUANTITY - head);
    }

    private static void showRes(int head, int tail) {
        System.out.println("We have :" + head + " heads");
        System.out.println("We have :" + tail + " tails");
    }

}
