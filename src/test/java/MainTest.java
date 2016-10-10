import org.testng.annotations.Test;

/**
 * Created on 10/10/16.<br/>
 */
public class MainTest {

    @Test
    public void should_Name_when() {
        Main.main(new String[]{"cat", "dog", "mad", "mud", "bat", "tree", "mad", "but"});
    }
}