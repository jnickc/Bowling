package ten.pin.bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for scoring points for each ball
 * <p>
 * Created by Nicolai Cebanov on 3/27/16.
 */
public class Bowling {

    private List<Integer> knockedPins = new ArrayList<>();

    /**
     * Main method of bowling application, entry point for app
     *
     * @param args - knocked pins array
     */
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println(" No input data ");
            return;
        }


        int[] knockedPins = parseInputArray(args);


        int[] frames = new Bowling().score(knockedPins);

        int framesSum = 0;
        for (int i = 0; i < frames.length; i++) {
            System.out.println("Score per frame " + (i + 1) + " = " + frames[i]);
            framesSum += frames[i];
        }
        System.out.println("Total score = " + framesSum);
    }

    /**
     * Converts user input to int array
     *
     * @param knockedPins - input array of Strings
     * @return - int array
     */
    private static int[] parseInputArray(String[] knockedPins) {
        int[] result = new int[knockedPins.length];


        for (int i = 0; i < knockedPins.length; i++) {
            result[i] = Integer.parseInt(knockedPins[i]);
        }

        return result;
    }

    /**
     * Method which implements main logic for Bowling class
     *
     * @param knockedPins - array with the number of pins knocked down by each ball
     * @return - array with points for each frame
     */
    int[] score(int[] knockedPins) {
        int framesCount = 10;
        int[] frames = new int[framesCount];

        int frameIndex = 0;
        for (int frame = 0; frame < framesCount; frame++) {
            int frameScore;

            if (isStrike(knockedPins, frameIndex)) {
                frameScore = 10 + strikeAdd(knockedPins, frameIndex);
                frameIndex++;
            } else {
                frameScore = sumFrameScore(knockedPins, frameIndex);
                if (isSpare(frameScore)) {
                    frameScore += spareAdd(knockedPins, frameIndex);
                }

                frameIndex += 2;
            }

            frames[frame] = frameScore;
        }

        return frames;
    }

    /**
     * Sum score for knocked balls for given array
     *
     * @param knockedPins - array with the number of pins knocked down by each ball
     * @param frameIndex  - frame index for which count score
     * @return frameScore
     */
    private int sumFrameScore(int[] knockedPins, int frameIndex) {
        return knockedPins[frameIndex] + knockedPins[frameIndex + 1];
    }


    /**
     * Checks if player got strike
     *
     * @param knockedPins - array with the number of pins knocked down by each ball
     * @param frameIndex  - frame index for which count score
     * @return true if strike, else false
     */
    private boolean isStrike(int[] knockedPins, int frameIndex) {
        return knockedPins[frameIndex] == 10;
    }

    /**
     * Checks if player got spare
     *
     * @param frameScore - score in frame
     * @return true if spare, else false
     */
    private boolean isSpare(int frameScore) {
        return frameScore == 10;
    }

    /**
     * Counts bonus score for spare
     *
     * @param knockedPins - array with the number of pins knocked down by each ball
     * @param frameIndex  - frame index for which count score
     * @return score to add
     */
    private int spareAdd(int[] knockedPins, int frameIndex) {
        return knockedPins[frameIndex + 2];
    }

    /**
     * Counts bonus score for strike
     *
     * @param knockedPins - array with the number of pins knocked down by each ball
     * @param frameIndex  - frame index for which count score
     * @return score to add
     */
    private int strikeAdd(int[] knockedPins, int frameIndex) {

        return knockedPins[frameIndex + 1] + knockedPins[frameIndex + 2];
    }

}
