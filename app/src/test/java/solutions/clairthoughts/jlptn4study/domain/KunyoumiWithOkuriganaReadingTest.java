package solutions.clairthoughts.jlptn4study.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class KunyoumiWithOkuriganaReadingTest {

    @Test
    public void appendsOkuriganaWhenReturningReading() throws Exception {
        KunyoumiWithOkuriganaReading reading = new KunyoumiWithOkuriganaReading("わる", "い");

        assertThat(reading.getReading(), is("わる。い"));
    }
}