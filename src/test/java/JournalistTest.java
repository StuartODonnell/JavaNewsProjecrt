import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JournalistTest {

    private Journalist journalist1;

    @Before
    public void before(){
        journalist1 = new Journalist("Stuart", "journalist1");
    }

    @Test
    public void canGetJounalistUsername(){
        assertEquals("journalist1", journalist1.getUsername());
    }
}
