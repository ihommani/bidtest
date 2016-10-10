import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created on 10/10/16.<br/>
 */
public class WordHash {
    private static final Comparator<String> keyComparator = String.CASE_INSENSITIVE_ORDER;
    private TreeMap<String, Collection<String>> map = new TreeMap<String, Collection<String>>(keyComparator);
    private static final Comparator<String> valueComparator = String.CASE_INSENSITIVE_ORDER;
    private int totalSize;

    public WordHash(String[] listOfWords) {
        for (int i = 0; i < listOfWords.length; i++) {
            for (int j = 0; j < listOfWords.length; j++) {
                this.put(listOfWords[i], listOfWords[j]);
            }
        }
    }

    public boolean put(String key, String value) {
        Collection<String> collection = map.get(key);

        if(key.equals(value))
            return false;

        if(!canBeAdded(key, value))
            return false;

        if (collection == null) {
            collection = createCollection();
            if (collection.add(value)) {
                totalSize++;
                map.put(key, collection);
                return true;
            } else {
                throw new AssertionError("New Collection violated the Collection spec");
            }
        } else if (collection.add(value)) {
            totalSize++;
            return true;
        } else {
            collection.add(value);
            return false;
        }
    }

    private boolean canBeAdded(String key, String candidateValue){
        char[] a = candidateValue.toCharArray();
        Arrays.sort(a);
        for (int i = 0; i < key.toCharArray().length; i++) {
            if(Arrays.binarySearch(a, key.toCharArray()[i]) >= 0){
                 return true;
             }
        }
        return false;
    }

    private SortedSet<String> createCollection() {
        return new TreeSet<String>(valueComparator);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
