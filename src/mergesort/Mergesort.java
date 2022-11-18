/*
Mergesort

1.0.0

Created by: Moussa Mikhail

This program is a implementation of the Mergesort algorithm.
It takes an array of strings and sorts them in alphabetical order.
 */
 
import java.util.ArrayList;
import java.util.List;

public class Mergesort {

    public static void main(String... args) {

        if (args.length == 0) {
			
            return;
        }

        var sorted = mergesort(List.of(args));

        System.out.println(sorted);
    }

    public static <T extends Comparable<T>> List<T> mergesort(List<T> list) {

        if (list.size() <= 1) {
			
            return list;
        }

        var middle = list.size() / 2;

        List<T> left = list.subList(0, middle);

        List<T> right = list.subList(middle, list.size());
		
		List<T> sortedLeft = mergesort(left);
		
		List<T> sortedRight = mergesort(right);

        return merge(sortedLeft, sortedRight);

    }

    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {

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