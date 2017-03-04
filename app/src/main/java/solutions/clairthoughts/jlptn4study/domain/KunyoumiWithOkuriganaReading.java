package solutions.clairthoughts.jlptn4study.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KunyoumiWithOkuriganaReading extends KanjiReading {

    private final String reading;
    private final String okurigana;

    public KunyoumiWithOkuriganaReading(
            @JsonProperty("reading") String reading,
            @JsonProperty("okurigana") String okurigana
    ) {
        this.reading = reading;
        this.okurigana = okurigana;
    }

    @Override
    public String getReading() {
        return String.format("%s。%s", reading, okurigana);
    }
}
