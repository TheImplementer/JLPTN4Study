package solutions.clairthoughts.jlptn4study.parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import solutions.clairthoughts.jlptn4study.domain.Kanji;
import solutions.clairthoughts.jlptn4study.loading.KanjiFileReader;

public class KanjiParser {

    private final KanjiFileReader kanjiFilerReader;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KanjiParser(KanjiFileReader kanjiFilerReader) {
        this.kanjiFilerReader = kanjiFilerReader;
    }

    public List<Kanji> parse() {
        final String kanjiFileContent = readKanjiFileContent();
        return parseContent(kanjiFileContent);
    }

    private List<Kanji> parseContent(String kanjiFileContent) {
        try {
            return objectMapper.readValue(kanjiFileContent, TypeFactory.defaultInstance().constructCollectionLikeType(List.class, Kanji.class));
        } catch (IOException e) {
            throw new KanjiFileParseException(e);
        }
    }

    private String readKanjiFileContent() {
        final InputStream input = kanjiFilerReader.load();
        try {
            return IOUtils.toString(input);
        } catch (Exception e) {
            throw new KanjiFileReadException(e);
        }
    }
}
