import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(ThreadLocalRandom.current().nextInt(-10000, 10000));
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        long timeStart = System.currentTimeMillis();

        List<List<Integer>> listaAll = list.stream().collect(
                () -> Arrays.asList(new ArrayList<>(), new ArrayList<>()),
                (l, c) -> {
                    if (c > 0) {
                        l.get(1).add(c);
                    } else {
                        l.get(0).add(c);
                    }
                },
                (a, b) -> {
                    a.get(0).addAll(b.get(0));
                    a.get(1).addAll(b.get(1));
                });
        long timeStop = System.currentTimeMillis() - timeStart;

        System.out.println("Calculated : " + listaAll.get(0).size() + " in first list and " + listaAll.get(1).size() + " in second list " + " in " + timeStop + " ms.");


        List<Integer> listx1 = new ArrayList<>();
        List<Integer> listx2 = new ArrayList<>();
        List<Integer> listx3 = new ArrayList<>();

        long timeStart1 = System.currentTimeMillis();
        list.forEach(splitBy(n -> n > 0, listx1::add, listx2::add, 0));
        long timeStop2 = System.currentTimeMillis() - timeStart1;

        System.out.println("Second method took " + timeStop2);

    }

    private static <T> Consumer<T> splitBy(
            Predicate<T> condition,
            Consumer<T> action1,
            Consumer<T> action2,
            T zero) {
        return n -> {
            if (condition.test(n)) {
                action1.accept(n);
//                action2.accept(zero);
            } else {
//                action1.accept(zero);
                action2.accept(n);
            }
        };
    }
}
