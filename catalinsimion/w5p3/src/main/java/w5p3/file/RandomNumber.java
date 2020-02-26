package w5p3.file;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNumber {
    Random rand = new Random();
    List<String> article = Arrays.asList("the", "a", "one", "some", "any");
    List<String> noun = Arrays.asList("boy", "girl", "dog", "town", "car");
    List<String> verb = Arrays.asList("drove", "jumped", "ran", "walked", "skipped");
    List<String> preposition = Arrays.asList("to", "from", "over", "under", "on");


    public String sentence() {

        int randomIndexArticle = rand.nextInt(article.size());
        String randomArticle = article.get(randomIndexArticle);
        String randomArticleOutput = randomArticle.substring(0, 1).toUpperCase() + randomArticle.substring(1);

        int randomIndexNoun = rand.nextInt(noun.size());
        String randomNoun = noun.get(randomIndexNoun);

        int randomIndexVerb = rand.nextInt(verb.size());
        String randomVerb = verb.get(randomIndexVerb);

        int randomIndexPosition = rand.nextInt(preposition.size());
        String randomprePosition = preposition.get(randomIndexPosition);

        int randomIndexArticle2 = rand.nextInt(article.size());
        String randomArticle2 = article.get(randomIndexArticle2);

        int randomIndexNoun2 = rand.nextInt(noun.size());
        String randomNoun2 = noun.get(randomIndexNoun2);

        String sen = randomArticleOutput + " " + randomNoun + " " + randomVerb + " " + randomprePosition + " " + randomArticle2 + " " + randomNoun2 + ". ";
        System.out.println(sen);


        return sen;

    }


}
