import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(org.junit.runners.Parameterized.class)
public class RomanNumbers_ {
    private final int number;
    private final String value;
    private final Class exceptionClass;

    public RomanNumbers_(int number, String value, Class exceptionClass) {
        this.number = number;
        this.value = value;
        this.exceptionClass = exceptionClass;
    }

    @Test
    public void execute(){
        try{
            assertThat(new RomanNumbers(number).toRoman()).isEqualTo(this.value);
            assertFalse(exceptionClass != null);
        }catch (RomanNumbers.IllegalParameterException e){
            assertTrue(exceptionClass != null);
        }

    }

    @Parameterized.Parameters
    public static Object[][] cases(){
        return new Object[][]{
                {-1, null, RomanNumbers.IllegalParameterException.class},
                {0, null, RomanNumbers.IllegalParameterException.class},
                {4000, null, RomanNumbers.IllegalParameterException.class},
                {5000, null, RomanNumbers.IllegalParameterException.class},
                {1, "I", null},
                {2, "II", null},
                {3, "III", null},
                {4, "IV", null},
                {10, "X", null},
                {11, "XI", null},
                {20, "XX", null},
                {30, "XXX", null},
                {100, "C", null},
                {110, "CX", null},
                {200, "CC", null},
                {300, "CCC", null},
                {1100, "MC", null},
                {2000, "MM", null},
                {3000, "MMM", null}
        };
    }
}
