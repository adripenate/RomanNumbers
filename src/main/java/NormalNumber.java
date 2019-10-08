import java.util.stream.IntStream;

public class NormalNumber {
    private final String romanNumber;

    public NormalNumber(String romanNumber) {
        this.romanNumber = romanNumber.toUpperCase();
    }

    public int toNormal() {
        return  obtainNormalValues().sum() - SpecialMapper.countSpecialValues(romanNumber);
    }

    private IntStream obtainNormalValues() {
        return romanNumber.chars()
                .mapToObj(letter -> (char) letter)
                .mapToInt(NormalMapper::calculateValue);
    }
}