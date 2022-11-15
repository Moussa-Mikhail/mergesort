package mergesort;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Mergesort {

    public static void main(String... args) {

        var sorted = mergesort(List.of(args));

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