import org.testng.annotations.Test;

/**
 * Created on 10/10/16.<br/>
 */
public class WordHashTest {

    @Test
    public void should_Name_when() {
        WordHash wordHash = new WordHash(new String[]{"ca", "ma"});
        System.out.println(wordHash.toString());
    }
}