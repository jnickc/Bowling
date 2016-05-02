package ten.pin.bowling;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Class for testing Bowling app
 *
 * Created by Nicolai Cebanov on 3/27/16.
 */
public class BowlingTest {

    private Bowling bowling;

    /**
     * Init bowling class before test run
     */
    @Before
    public void setUp() {

        bowling = new Bowling();
    }


    /**
     * Run test with normal data
     *
     * @throws Exception
     */
    @Test
    public void testScore() throws Exception {

        int[] knockedPins = new int[]{1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};

        assertEquals("Score for given example rolls should 133", 133, sumFrames(bowling.score(knockedPins)));

        knockedPins = new int[]{1, 4, 0, 5, 10, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};
        assertEquals("Score for given example rolls should 133", 134, sumFrames(bowling.score(knockedPins)));


        knockedPins = new int[]{0,0,0,0,3,5,0,0,0,0,10,0,7,0,0,0,0,0,0,0};
        assertEquals("Score for given example rolls should 133", 32, sumFrames(bowling.score(knockedPins)));
    }


    /**
     * Run test for checking max values
     *
     * @throws Exception
     */
    @Test
    public void testScoreMax() throws Exception {

        int[] knockedPins = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        assertEquals("Score should be at max value 300", 300, sumFrames(bowling.score(knockedPins)));
    }


    /**
     * Run test for checking min values
     *
     * @throws Exception
     */
    @Test
    public void testScoreMin() throws Exception {

        int[] knockedPins = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        assertEquals("Score should be 0 for min value", 0, sumFrames(bowling.score(knockedPins)));
    }

    /**
     * Counts points for all frames
     * @param frames array with score for each frame
     * @return sum of points
     */
    private int sumFrames(int [] frames){

        return Arrays.stream(frames).sum();
    }
}