package test.udacity.jokes.lib;

import com.udacity.jokes.lib.JokeBuilder;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by sengopal on 11/17/15.
 */
public class JokeBuilderTest {

    @Test
    public void testRandomJoke(){
        assertTrue(JokeBuilder.get().length() > 0);
    }
}
