package se.iths.tt.javafxtt;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Strategy {
    public static void main(String[] args) {
        System.out.println(sum(List.of(1, 2, 3, 4, 5), i -> true));
        System.out.println(sum(List.of(1, 2, 3, 4, 5), i -> i % 2 == 0));
        System.out.println(sum(List.of(1, 2, 3, 4, 5), new OnlyOddNumbers()));
        System.out.println(sum(List.of(1, 2, 3, 4, 5), Strategy::testNumbers));

     //   List.of(1,2,3,4).forEach(System.out::println);
    }

    public static int sum(List<Integer> integers, Predicate<Integer> chooser){
        System.out.println(chooser.getClass().getName());
        int sum = 0;
        for( int i : integers) {
            if( chooser.test(i))
                sum += i;
        }
        return sum;
    }

    public static boolean testNumbers(Integer i){
        return i > 2;
    }

//    public static int sumEven(List<Integer> integers){
//        int sum = 0;
//        for( int i : integers) {
//            if( i % 2 == 0)
//                sum += i;
//        }
//        return sum;
//    }
}

class OnlyOddNumbers implements Predicate<Integer>{

    @Override
    public boolean test(Integer integer) {
        return integer % 2 == 1;
    }
}
