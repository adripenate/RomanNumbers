import org.junit.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberBreakerPerformance_ {
    @Test
    public void should_execute_1000_times_in_less_than_a_second() {
        Instant start = Instant.now();
        for (int i = 1; i<=1000; i++){
            new NumberBreaker(i).toDescomposition();
        }
        Instant finish = Instant.now();
        assertThat(finish.getNano() - start.getNano()).isLessThan((int) 1e9);
    }
}
