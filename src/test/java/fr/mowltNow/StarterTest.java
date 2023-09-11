package fr.mowltNow;

import fr.mowltnow.service.impl.StarterImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author oussama.gaied
 * @since 11/09/2023
 */
public class StarterTest {
    private StarterImpl starter;
    @Before
    public void setUp() {
        starter = StarterImpl.getInstance();
    }
    @Test
    public void testStarter() {
        String[] args = {"src/test/resources/mower"};

        starter.start(args[0]);
       List<String>resultMowers= starter.getResult();
        assertEquals(resultMowers.get(0),"1 3 NORTH");
        assertEquals(resultMowers.get(1),"5 1 EAST");




    }
}
