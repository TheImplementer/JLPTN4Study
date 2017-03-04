package solutions.clairthoughts.jlptn4study.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = OnyoumiReading.class, name = "ONYOUMI"),
        @JsonSubTypes.Type(value = KunyoumiWithOkuriganaReading.class, name = "KUNYOUMI_WITH_OKURIGANA"),
        @JsonSubTypes.Type(value = KunyoumiReading.class, name = "KUNYOUMI")
})
public abstract class KanjiReading {

    public abstract String getReading();

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return reflectionToString(this);
    }
}
