import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class TermFrequency {

    List<String> doc1;
    List<String> doc2;
    List<String> doc3;
    List<List<String>> corpus;

    ArrayList<String> uniqueWords;


    ArrayList<ArrayList<Double>> documentVector = new ArrayList<ArrayList<Double>>();
    ArrayList<Double> tf_idfScore = new ArrayList<Double>();

    public TermFrequency()
    {
         doc1 = Arrays.asList("the","sky","is","blue");
         doc2 = Arrays.asList("the","sun","is","bright");
         doc3 = Arrays.asList("the","sun","in","the","sky","is","bright");

         corpus = Arrays.asList(doc1,doc2,doc3);

        printList(doc1);
        printList(doc2);
        System.out.println("Document Collection" );
        printListOfLists(corpus);

        uniqueWords = new ArrayList<>();

        addUniqueWords();
        docVector();
    }

    public void addUniqueWords()

    {
        for(List<String> doc:corpus)
        {
            for(String d:doc)
            {
                if(!uniqueWords.contains(d))
                {
                    uniqueWords.add(d);

                }
            }
        }
    }
    public void docVector()
    {
        for(String word:uniqueWords)
        {
            tf_idfScore.add(tf_Idf(tf(doc1,word),idf(corpus,word)));
        }
        documentVector.add(tf_idfScore);
        System.out.println("TfIdf Score"+tf_idfScore);
    }
//    Calculates how many times the term appears in the document.
    public int tf(List<String> doc,String term)
    {
        int count = 0;
        for (String d:doc)
        {
            if(d.equals(term))
            {
                count++;
            }
        }
        return count;
    }

//    counts how many documents in the corpus contain the term and returns log of i.e. total no. of documents in the corpus / no. of term occurence
    public double idf(List<List<String>> docCollection,String term)

    {
        double calculatedIdf;

        int count = 0;
        for (List<String> docC:docCollection)
        {
            if(docC.contains(term))
            {
                count++;
            }
        }

        calculatedIdf  = Math.log10((double)docCollection.size()/(double)count);

        System.out.println("calculated idf for the term: "+term +"->"+calculatedIdf);
        return calculatedIdf;
    }

    public double tf_Idf(int tf, double idf)
    {
        return tf*idf;
    }
    public void printList(List<String> doc) {
        for(String word :doc)
        {
            System.out.println(word+"");
        }
        System.out.println("\n");
    }
    public void printListOfLists(List<List<String>> docs)
    {
        for(List<String> doc :docs)
        {
            for(String word:doc)
            {
                System.out.println(word +" ");
            }
            System.out.println("");
        }
    }

}
