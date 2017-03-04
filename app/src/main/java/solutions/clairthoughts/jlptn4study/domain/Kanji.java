package solutions.clairthoughts.jlptn4study.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Kanji {

    private final String kanji;
    private final List<KanjiReading> readings;
    private final String meanings;

    public Kanji(@JsonProperty("kanji") String kanji,
                 @JsonProperty("readings") List<KanjiReading> readings,
                 @JsonProperty("meanings") String meanings) {
        this.kanji = kanji;
        this.readings = readings;
        this.meanings = meanings;
    }

    public String getKanji() {
        return kanji;
    }

    public List<KanjiReading> getReadings() {
        return readings;
    }

    public String getMeanings() {
        return meanings;
    }
}
