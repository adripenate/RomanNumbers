import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NormalMapper {
    private static final Map<Character, Integer> numberValues = Collections.unmodifiableMap(Stream.of(
            new AbstractMap.SimpleEntry<>('I', 1),
            new AbstractMap.SimpleEntry<>('V', 5),
            new AbstractMap.SimpleEntry<>('X', 10),
            new AbstractMap.SimpleEntry<>('L', 50),
            new AbstractMap.SimpleEntry<>('C', 100),
            new AbstractMap.SimpleEntry<>('D', 500),
            new AbstractMap.SimpleEntry<>('M', 1000))
            .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)));

    public static int calculateValue(char letter) {
        return isNumber(letter) ? valueOf(letter) : 0;
    }

    private static Integer valueOf(char letter) {
        return numberValues.get(letter);
    }

    private static boolean isNumber(char letter) {
        return numberValues.containsKey(letter);
    }
}
