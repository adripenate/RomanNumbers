import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NormalNumber {
    private static final Map<Character, Integer> numberValues = Collections.unmodifiableMap(Stream.of(
            new AbstractMap.SimpleEntry<>('I', 1),
            new AbstractMap.SimpleEntry<>('V', 5),
            new AbstractMap.SimpleEntry<>('X', 10),
            new AbstractMap.SimpleEntry<>('L', 50),
            new AbstractMap.SimpleEntry<>('C', 100),
            new AbstractMap.SimpleEntry<>('D', 500),
            new AbstractMap.SimpleEntry<>('M', 1000))
            .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)));
    private static final Map<String, Integer> specialNumberValues = Collections.unmodifiableMap(Stream.of(
            new AbstractMap.SimpleEntry<>("IV", 2),
            new AbstractMap.SimpleEntry<>("IX", 2),
            new AbstractMap.SimpleEntry<>("XL", 20),
            new AbstractMap.SimpleEntry<>("XC", 20),
            new AbstractMap.SimpleEntry<>("CD", 200),
            new AbstractMap.SimpleEntry<>("CM", 200))
            .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)));
    private int normalNumber;
    private final String romanNumber;

    public NormalNumber(String romanNumber) {
        this.romanNumber = romanNumber.toUpperCase();
        this.normalNumber = 0;
    }

    public int toNormal() {
        countSpecialValues();
        countNormalValues();
        return normalNumber;
    }

    private void countSpecialValues() {
        specialNumberValues.forEach((key, value) -> {if (romanNumber.contains(key)) normalNumber -= value; });
    }

    private void countNormalValues() {
        for (int i = 0; i < romanNumber.length(); i++) if (isNumber(letterAt(i))) normalNumber += valueOf(i);
    }

    private Integer valueOf(int i) {
        return numberValues.get(letterAt(i));
    }

    private boolean isNumber(char letter) {
        return numberValues.containsKey(letter);
    }

    private char letterAt(int pos) {
        return romanNumber.charAt(pos);
    }
}