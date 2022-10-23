package GeneticAlgorithm.Choosers;

import junit.framework.TestCase;
import org.junit.Assert;

public class RouletteChooserTest extends TestCase {
    public void testUpdateChooser() {
        int populationSize = 9;
        int [] evaluation = new int[]{2, 3, 1, 0, 0, 4, 0, 6, 0};
        RouletteChooser rouletteChooser = new RouletteChooser();
        rouletteChooser.setup(populationSize);
        rouletteChooser.updateChooser(evaluation);
        Assert.assertArrayEquals(new int[]{0, 3, 7, 9, 10, 11, 16, 17, 24}, rouletteChooser.intervalsStarts);
        Assert.assertArrayEquals(new int[]{3, 7, 9, 10, 11, 16, 17, 24, 25}, rouletteChooser.intervalsEnds);
        Assert.assertEquals(25, rouletteChooser.maxNumber);
    }

    public void testChoose() {
        int populationSize = 9;
        RouletteChooser rouletteChooser = new RouletteChooser();
        rouletteChooser.setup(populationSize);
        int choice = rouletteChooser.choose();
        Assert.assertTrue(choice<populationSize);
    }

    public void testSetup() {
        int populationSize = 9;
        RouletteChooser rouletteChooser = new RouletteChooser();
        rouletteChooser.setup(populationSize);
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8}, rouletteChooser.intervalsStarts);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, rouletteChooser.intervalsEnds);
        Assert.assertEquals(9, rouletteChooser.maxNumber);
    }
}