package task_1_2;

import java.util.ArrayList;

public class FirstTask {

    static int[] array = {15, 8, 3, 17};

    public static void main(String[] args) {

        System.out.print(task1(23));
    }

    public static ArrayList<Integer> task1(int number) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {

            for (int j = i; j < array.length; j++) {

                if (array[i] + array[j] == number) {
                    result.add(i);
                    result.add((j));
                }
            }
        }
        return result;
    }


}

