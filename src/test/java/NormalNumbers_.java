import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class NormalNumbers_ {
    private int number;
    private String romanNumber;

    public NormalNumbers_(String romanNumber, int number) {
        this.number = number;
        this.romanNumber = romanNumber;
    }

    @Test
    public void execute() {
        assertThat(NormalNumber.toNormal(romanNumber)).isEqualTo(number);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"I", 1},
                {"II", 2},
                {"IV", 4},
                {"V", 5},
                {"IX", 9},
                {"X", 10},
                {"XX", 20},
                {"L", 50},
                {"C", 100},
                {"D", 500},
                {"CC", 200},
                {"M", 1000},
                {"MM", 2000}
        };
    }
}
