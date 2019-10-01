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
        assertThat(new NumberBreaker(number).toDescomposition()).isEqualTo(decomposition);
    }


    @Parameterized.Parameters
    public static Object[][] cases(){
        return new Object[][]{
                {-1, null},
                {0, null},
                {1, new int[][]{{1,0}}},
                {10, new int[][]{{1,1}}},
                {20, new int[][]{{2,1}}},
                {25, new int[][]{{2,1}, {5,0}}},
                {100, new int[][]{{1,2}}},
                {245, new int[][]{{2,2}, {4,1}, {5,0}}},
                {306, new int[][]{{3,2}, {6,0}}},
                {1000, new int[][]{{1, 3}}},
                {2001, new int[][]{{2, 3}, {1,0}}},
                {4000, null},
                {5000, null}
        };
    }
}
