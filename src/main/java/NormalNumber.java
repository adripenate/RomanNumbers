import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NormalNumber {
    private static final Map<Character, Integer> numberOf = Collections.unmodifiableMap(Stream.of(
            new AbstractMap.SimpleEntry<>('I', 1),
            new AbstractMap.SimpleEntry<>('V', 5),
            new AbstractMap.SimpleEntry<>('X', 10),
            new AbstractMap.SimpleEntry<>('L', 50),
            new AbstractMap.SimpleEntry<>('C', 100),
            new AbstractMap.SimpleEntry<>('D', 500),
            new AbstractMap.SimpleEntry<>('M', 1000))
            .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)));
    private static int normalNumber;

    public static int toNormal(String romanNumber) {
        normalNumber = 0;
        if (romanNumber.contains("IV")) normalNumber-=2;
        for (int i=0; i< romanNumber.length(); i++) {
            if (letterIsNumber(romanNumber, i)) normalNumber+= valueOf(romanNumber, i);
        }
        return normalNumber;
    }

    private static Integer valueOf(String romanNumber, int i) {
        return numberOf.get(letterAt(romanNumber, i));
    }

    private static boolean letterIsNumber(String romanNumber, int pos) {
        return numberOf.containsKey(letterAt(romanNumber, pos));
    }

    private static char letterAt(String romanNumber, int pos) {
        return romanNumber.charAt(pos);
    }
}
