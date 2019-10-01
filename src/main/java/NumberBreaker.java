import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.IntStream.iterate;

public class NumberBreaker {
    private final int number;
    private static final int MIN = 0;
    private static final int MAX = 4000;

    public NumberBreaker(int number) {
        this.number = number;
    }

    public int[][] toDescomposition() {
        if (number <= MIN || number >= MAX) return null;
        return createStream()
                .map(this::tupleOf)
                .filter(this::isNotZero)
                .collect(createList())
                .toArray(new int[0][]);
        /*
        int[][] decomposition = new int[getNumberValidDigits(number)][2];
        int indexValidDigit=0;
        for (int i = 0; i< getNumberOfDigits(number); i++){
            if (String.valueOf(number).charAt(i) != '0') {
                decomposition[indexValidDigit][0] = getDigit(number, i);
                decomposition[indexValidDigit][1] = getNumberOfDigits(number)-1-i;
                indexValidDigit++;
            }
        }
        return decomposition;
        */
    }

    private Collector<int[], ?, List<int[]>> createList() {
        return Collectors.toList();
    }

    private boolean isNotZero(int[] x) {
        return x[0] > 0;
    }

    private Stream<Integer> createStream() {
        return iterate(0, i -> i+1)
                .limit(number().length())
                .boxed();
    }

    private String number() {
        return String.valueOf(number);
    }

    private int[] tupleOf(Integer x) {
        return new int[]{Integer.parseInt(number().substring(x, x + 1)), number().length()-x-1};
    }

/*
    private int getDigit(int number, int i) {
        return Character.getNumericValue(String.valueOf(number).charAt(i));
    }

    private int getNumberValidDigits(int number) {
        return String.valueOf(number).replace("0", "").length();
    }

    private int getNumberOfDigits(int number) {
        return String.valueOf(number).length();
    }

 */
}
