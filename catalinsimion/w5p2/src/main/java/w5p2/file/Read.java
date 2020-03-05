package w5p2.file;

import java.util.Arrays;
import java.util.List;

public class Read implements Titlelizer {
    private List<String> ignoreWordsList = Arrays.asList("the", "a", "to", "in", "of", "is");

    @Override
    public String titlelize(String toTitlelize) {
        if (toTitlelize == null) {
            throw new IllegalArgumentException("null");
        }
        if (toTitlelize.isEmpty()) {
           return toTitlelize;
        }
        String[] tokens = toTitlelize.split(" ");
        String sentence = "";
        for (String token : tokens) {

            if (!ignoreWordsList.contains(token)) {
                String  firstLetter = token.substring(0, 1).toUpperCase() + token.substring(1);
                sentence += firstLetter + " ";

            } else {
                sentence += token + " ";
            }
        }
        sentence = sentence.substring(0, sentence.length() - 1);
        System.out.println(sentence);

        return sentence;
    }
}
