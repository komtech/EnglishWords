import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DictionaryTest extends TestCase {


    @Test
    public void testIsEnglishWordFound() {
        final WebAPI webapi = mock(WebAPI.class);
        when(webapi.getEnglishWords()).thenReturn(new String[]{"WORK", "KING", "ROW", "RING", "KNOW"});

        Dictionary dic = new Dictionary(webapi);
        boolean actual = dic.isEnglishWord("ROW");

        assertEquals(true, actual);
    }

    @Test
    public void testIsEnglishWordNotFound() {
        final WebAPI webapi = mock(WebAPI.class);
        when(webapi.getEnglishWords()).thenReturn(new String[]{"WORK", "KING", "ROW", "RING", "KNOW"});

        Dictionary dic = new Dictionary(webapi);
        boolean actual = dic.isEnglishWord("ROWW");

        assertEquals(false, actual);
    }
}