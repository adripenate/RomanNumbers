import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RomanNumbers {
    private final int number;

    public RomanNumbers(int number) {
        this.number = number;
    }

    public String toRoman() {
        if (new NumberBreaker(number).toDescomposition() == null) throw new IllegalParameterException();
        return createStream()
                .map(RomanMapper::createRomanNumber)
                .collect(Collectors.joining());
    }

    private Stream<int[]> createStream() {
        return Arrays.stream(new NumberBreaker(number).toDescomposition());
    }

    public class IllegalParameterException extends RuntimeException{
    }
}
