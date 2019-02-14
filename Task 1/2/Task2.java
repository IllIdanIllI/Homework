import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Task2 {
    public static void main(String[] args) {
        System.out.println("Enter how much your dinosaur weighs in kg:");
        int kilo = enterMass();
        long gram = kilo * 1000;
        long milligram = gram * 10;
        float ton = (float) kilo / 100;
        System.out.println("Our Dino weighs:" + kilo + "kg " + gram + "g " + milligram + "mg " + ton + "ton");
    }

    private static int enterMass() {
        int mass = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            mass = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mass;
    }
}
