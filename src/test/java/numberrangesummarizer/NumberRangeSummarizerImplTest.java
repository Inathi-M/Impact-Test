package numberrangesummarizer;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.Test;

class NumberRangeSummarizerImplTest {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

    @Test
    void testCollect() {
        Collection<Integer> collected = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        assertEquals(13, collected.size());
    }

    @Test
    void testSummarizeCollection() {
        Collection<Integer> collected = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String summarized = summarizer.summarizeCollection(collected);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", summarized);
    }

    @Test
    void testEmptyInput() {
        Collection<Integer> collected = summarizer.collect("");
        String summarized = summarizer.summarizeCollection(collected);
        assertEquals("", summarized);
    }

    @Test
    void testSingleNumber() {
        Collection<Integer> collected = summarizer.collect("5");
        String summarized = summarizer.summarizeCollection(collected);
        assertEquals("5", summarized);
    }

    @Test
    void testNoRange() {
        Collection<Integer> collected = summarizer.collect("1,3,5");
        String summarized = summarizer.summarizeCollection(collected);
        assertEquals("1, 3, 5", summarized);
    }
}
