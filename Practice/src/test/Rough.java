package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Rough {

    public static void main(String[] args) {

        // split into batches

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        splitIntoBatches(list, 10);

    }

    private static void splitIntoBatches(List<Integer> list, int batchSize) {

        int noOfBatches = list.size() / batchSize;
        int extra = list.size() % batchSize;

        System.out.println(noOfBatches);
        System.out.println(extra);

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> batch;

        int k = 0;
        for (int i = 0; i < noOfBatches + extra; i++) {
            batch = new ArrayList<>();
            for (int j = 0; j < batchSize && k < list.size(); j++) {
                batch.add(list.get(k++));
            }
            if (!batch.isEmpty()) {
                answer.add(batch);
            }

        }

        System.out.println(answer);


    }
}
