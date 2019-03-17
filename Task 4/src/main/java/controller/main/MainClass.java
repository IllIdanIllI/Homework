package controller.main;


import service.GiftHandlerService;
import service.impl.SweetnessHandlerServiceImpl;

 class MainClass {

    public static void main(String[] args) {
//        long start = System.nanoTime();
//        long end = System.nanoTime() - start;
//        System.out.println("Lambda time: "+end);
//        Stream<Integer> number = Stream.of();
//        Optional<Integer> result  = number.max(Integer::compareTo);
//        result.ifPresent(line -> System.out.println("Your line: "+line));
//        System.out.println(result.map(o -> "Found").orElse("Not found"));
        GiftHandlerService gift = new SweetnessHandlerServiceImpl();
        gift.makeTheGift();
    }
}
