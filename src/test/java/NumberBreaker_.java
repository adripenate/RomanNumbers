import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class NumberBreaker_ {
    private final int number;
    private final int[][] decomposition;

    public NumberBreaker_(int number, int[][] decomposition) {
        this.number = number;
        this.decomposition = decomposition;
    }

    @Test
    public void execute() {
        assertThat(toDescomposition(number)).isEqualTo(decomposition);
    }

    private int[][] toDescomposition(int number) {
        if (number <= 0 || number >= 4000) return new int[][]{};
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
    }

    private int getDigit(int number, int i) {
        return Character.getNumericValue(String.valueOf(number).charAt(i));
    }

    private int getNumberValidDigits(int number) {
        return String.valueOf(number).replace("0", "").length();
    }

    private int getNumberOfDigits(int number) {
        return String.valueOf(number).length();
    }

    @Parameterized.Parameters
    public static Object[][] cases(){
        return new Object[][]{
                {-1, new int[][]{}},
                {0, new int[][]{}},
                {1, new int[][]{{1,0}}},
                {10, new int[][]{{1,1}}},
                {20, new int[][]{{2,1}}},
                {25, new int[][]{{2,1}, {5,0}}},
                {100, new int[][]{{1,2}}},
                {245, new int[][]{{2,2}, {4,1}, {5,0}}},
                {306, new int[][]{{3,2}, {6,0}}},
                {1000, new int[][]{{1, 3}}},
                {2001, new int[][]{{2, 3}, {1,0}}},
                {4000, new int[][]{}},
                {5000, new int[][]{}}
        };
    }
}
