import java.util.*;
import java.util.Set;

public class numbersPermutations {

    public static void main(String[] args) {

        // create scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter 4 numbers separated by comma (,): ");
        int[] numbers = new int[4];

        String[] input = scanner.nextLine().split(",");
        for (int i = 0; i < 4; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        scanner.close();

        Set<List<Integer>> results = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < numbers.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    for (int l = 0; l < numbers.length; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }
                        List<Integer> permutations = new ArrayList<Integer>();
                        permutations.add(numbers[i]);
                        permutations.add(numbers[j]);
                        permutations.add(numbers[k]);
                        permutations.add(numbers[l]);

                        results.add(permutations);
                    }
                }
            }

        }
        for (List<Integer> permutations : results) {
            System.out.println(permutations);
        }
    }
}
