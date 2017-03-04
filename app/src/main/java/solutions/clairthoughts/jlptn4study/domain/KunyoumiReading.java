package solutions.clairthoughts.jlptn4study.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KunyoumiReading extends KanjiReading {

    private final String reading;

    public KunyoumiReading(
            @JsonProperty("reading") String reading
    ) {
        this.reading = reading;
    }

    @Override
    public String getReading() {
        return reading;
    }
}
