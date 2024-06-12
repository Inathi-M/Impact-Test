package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        String[] numbers = input.split(",");
        List<Integer> numberList = new ArrayList<>();
        for (String number : numbers) {
            numberList.add(Integer.parseInt(number.trim()));
        }
        return numberList;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
    
        List<Integer> sortedNumbers = new ArrayList<>(input);
        Collections.sort(sortedNumbers);
    
        StringBuilder result = new StringBuilder();
        int rangeStart = sortedNumbers.get(0);
        int previous = rangeStart;
    
        for (int i = 1; i < sortedNumbers.size(); i++) {
            int current = sortedNumbers.get(i);
            if (current != previous + 1) {
                if (rangeStart == previous) {
                    result.append(rangeStart);
                } else {
                    result.append(rangeStart).append("-").append(previous);
                }
                result.append(", ");
                rangeStart = current;
            }
            previous = current;
        }
    
        // Append the last range or number
        if (rangeStart == previous) {
            result.append(rangeStart);
        } else {
            result.append(rangeStart).append("-").append(previous);
        }
    
        System.out.println(result.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> collectedNumbers = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String summarized = summarizer.summarizeCollection(collectedNumbers);
        System.out.println(summarized);  // Output: 1, 3, 6-8, 12-15, 21-24, 31
    }
}



