import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpecialMapper {
    private static final Map<String, Integer> specialNumberValues = Collections.unmodifiableMap(Stream.of(
            new AbstractMap.SimpleEntry<>("IV", 2),
            new AbstractMap.SimpleEntry<>("IX", 2),
            new AbstractMap.SimpleEntry<>("XL", 20),
            new AbstractMap.SimpleEntry<>("XC", 20),
            new AbstractMap.SimpleEntry<>("CD", 200),
            new AbstractMap.SimpleEntry<>("CM", 200))
            .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)));

    public static int countSpecialValues(String romanNumber) {
        int specialValue = 0;
        for(Map.Entry<String, Integer> entry: specialNumberValues.entrySet())
            if (existsSpecial(romanNumber, entry.getKey())) specialValue += entry.getValue();
        return specialValue;
    }

    private static boolean existsSpecial(String romanNumber, String specialValue) {
        return romanNumber.contains(specialValue);
    }
}
