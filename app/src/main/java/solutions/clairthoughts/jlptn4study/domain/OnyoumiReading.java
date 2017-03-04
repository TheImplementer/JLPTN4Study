package solutions.clairthoughts.jlptn4study.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OnyoumiReading extends KanjiReading {

    private final String reading;

    public OnyoumiReading(@JsonProperty("reading") String reading) {
        this.reading = reading;
    }

    @Override
    public String getReading() {
        return reading;
    }
}
