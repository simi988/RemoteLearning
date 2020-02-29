package w5p2.file;

import java.util.Arrays;
import java.util.List;

public class Read implements Titlelizer {
    private List<String> ignore = Arrays.asList("the", "a", "to", "in", "of", "is");

    @Override
    public String titlelize(String toTitlelize) throws Exception {
        if (toTitlelize == null) {
            throw new IllegalArgumentException("null");
        }
        if (toTitlelize.isEmpty()) {
           return toTitlelize;
        }
        String[] tokens = toTitlelize.split(" ");
        String sentence = "";
        for (String t : tokens) {

            if (!ignore.contains(t)) {
                String ch = t.substring(0, 1).toUpperCase() + t.substring(1);
                sentence = sentence + ch + " ";
                System.out.print(sentence + " ");
            } else {
                sentence = sentence + t + " ";
                System.out.print(sentence + " ");
            }

        }
        sentence = sentence.substring(0, sentence.length() - 1);

        return sentence;
    }
}
