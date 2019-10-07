import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class NormalNumbers_ {
    private static final char ONE = 'I';
    private int number;
    private String romanNumber;

    public NormalNumbers_(String romanNumber, int number) {
        this.number = number;
        this.romanNumber = romanNumber;
    }

    @Test
    public void execute() {
        assertThat(toNormal(romanNumber)).isEqualTo(number);
    }

    private int toNormal(String romanNumber) {
        int normalNumber = 0;
        for (int i=0; i< romanNumber.length(); i++) {
            if (romanNumber.charAt(i) == ONE) normalNumber++;
            else normalNumber=10;
        }
        return normalNumber;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"I", 1},
                {"II", 2},
                {"III", 3},
                {"X", 10}
        };
    }
}
