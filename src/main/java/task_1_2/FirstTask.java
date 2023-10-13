package task_1_2;


//        Дан массив целых чисел. Необходимо реализовать метод, который возвращает индексы массива, значения которых в сумме дают число переданное в массив.
//
//        Предполагается, что массив содержит только уникальные числа и всегда имеет искомые числа.
//        Один и тот же элемент не может быть использован дважды.
//
//        array = [3, 8, 15, 17], Number = 23
//        result = [1,2]
//
//        Т.е. индексы 1 и 2 (значение 8 и 15) в сумме дают искомое число 23

// -> [index] if (??==value)

import java.util.ArrayList;
import java.util.Arrays;

public class FirstTask {

    static int[] array = {8, 1, 118, 6, 15, 67};

    public static void main(String[] args) {

        System.out.print(task1(16));
    }

    public static ArrayList<Integer> task1(int number) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {

            int[] newArray = Arrays.copyOfRange(array, i + 1, array.length);

            for (int j = 0; j < newArray.length; j++) {

                if (array[i] + newArray[j] == number) {
                    result.add(i);
                    result.add((i + j + 1));
                }
            }
        }
        return result;
    }


}

