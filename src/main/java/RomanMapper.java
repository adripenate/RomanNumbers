import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RomanMapper {
    private static final Map<Integer, String> tuplas = Collections.unmodifiableMap(Stream.of(
            new AbstractMap.SimpleEntry<>(10, "I"),
            new AbstractMap.SimpleEntry<>(11, "X"),
            new AbstractMap.SimpleEntry<>(12, "C"),
            new AbstractMap.SimpleEntry<>(13, "M"),
            new AbstractMap.SimpleEntry<>(20, "II"),
            new AbstractMap.SimpleEntry<>(21, "XX"),
            new AbstractMap.SimpleEntry<>(22, "CC"),
            new AbstractMap.SimpleEntry<>(23, "MM"),
            new AbstractMap.SimpleEntry<>(30, "III"),
            new AbstractMap.SimpleEntry<>(31, "XXX"),
            new AbstractMap.SimpleEntry<>(32, "CCC"),
            new AbstractMap.SimpleEntry<>(33, "MMM"),
            new AbstractMap.SimpleEntry<>(40, "IV"),
            new AbstractMap.SimpleEntry<>(41, "XL"),
            new AbstractMap.SimpleEntry<>(42, "CD"),
            new AbstractMap.SimpleEntry<>(50, "V"),
            new AbstractMap.SimpleEntry<>(51, "L"),
            new AbstractMap.SimpleEntry<>(52, "D"),
            new AbstractMap.SimpleEntry<>(60, "VI"),
            new AbstractMap.SimpleEntry<>(61, "LX"),
            new AbstractMap.SimpleEntry<>(62, "DC"),
            new AbstractMap.SimpleEntry<>(70, "VII"),
            new AbstractMap.SimpleEntry<>(71, "LXX"),
            new AbstractMap.SimpleEntry<>(72, "DCC"),
            new AbstractMap.SimpleEntry<>(80, "VIII"),
            new AbstractMap.SimpleEntry<>(81, "LXXX"),
            new AbstractMap.SimpleEntry<>(82, "DCCC"),
            new AbstractMap.SimpleEntry<>(90, "IX"),
            new AbstractMap.SimpleEntry<>(91, "XC"),
            new AbstractMap.SimpleEntry<>(92, "CM"))
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())));

    public static String createRomanNumber(int[] breakedNumber) {
        return tuplas.get(createKey(breakedNumber));
    }

    private static int createKey(int[] breakedNumber) {
        return Integer.parseInt(breakedNumber[0] + "" + breakedNumber[1]);
    }
}
