package solutions.clairthoughts.jlptn4study.parsing;

import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import solutions.clairthoughts.jlptn4study.domain.Kanji;
import solutions.clairthoughts.jlptn4study.domain.KunyoumiWithOkuriganaReading;
import solutions.clairthoughts.jlptn4study.domain.OnyoumiReading;
import solutions.clairthoughts.jlptn4study.loading.KanjiFileReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KanjiParserTest {

    private final KanjiFileReader kanjiFilerReader = mock(KanjiFileReader.class);
    private final KanjiParser underTest = new KanjiParser(kanjiFilerReader);

    @Test
    public void loadsKanjisAsExpected() throws Exception {
        when(kanjiFilerReader.load()).thenReturn(testInput());
        final List<Kanji> result = underTest.parse();

        assertThat(result, hasSize(1));
        final Kanji loadedKanji = result.get(0);
        assertThat(loadedKanji.getKanji(), is("悪"));
        assertThat(loadedKanji.getReadings(), contains(new OnyoumiReading("アク"), new KunyoumiWithOkuriganaReading("わる", "い")));
        assertThat(loadedKanji.getMeanings(), is("bad, mean"));
    }

    private InputStream testInput() {
        return getClass().getClassLoader().getResourceAsStream("test_input.json");
    }
}