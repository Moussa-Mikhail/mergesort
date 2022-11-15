/*
Mergesort

1.0.0

Created by: Moussa Mikhail

This program is a demonstration of the Mergesort algorithm.
It takes an array of strings and sorts them in alphabetical order.
The input must be in the form of a comma separated list of strings.
The output is the sorted array of strings.
 */
package mergesort;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Mergesort {

    public static void main(String... args) {

        if (args.length == 0) {
            return;
        }

        String csvList = args[0];



        String[] array = csvList.split(",");

        var sorted = mergesort(List.of(array));

        System.out.println(sorted);
    }

    public static <T extends Comparable<T>> @NotNull List<T> mergesort(@NotNull List<T> list) {

        if (list.size() <= 1) {
            return list;
        }

        var middle = list.size() / 2;

        List<T> left = list.subList(0, middle);

        List<T> right = list.subList(middle, list.size());

        return merge(mergesort(left), mergesort(right));

    }

    private static <T extends Comparable<T>> @NotNull List<T> merge(@NotNull List<T> left, @NotNull List<T> right) {

        List<T> merged = new ArrayList<>();

        int leftIndex = 0;

        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {

            var leftElement = left.get(leftIndex);

            var rightElement = right.get(rightIndex);

            if (leftElement.compareTo(rightElement) < 0) {

                merged.add(leftElement);

                leftIndex++;

            } else {

                merged.add(rightElement);

                rightIndex++;

            }
        }

        if (leftIndex < left.size()) {

            merged.addAll(left.subList(leftIndex, left.size()));

        }

        if (rightIndex < right.size()) {

            merged.addAll(right.subList(rightIndex, right.size()));

        }

        return merged;
    }
}