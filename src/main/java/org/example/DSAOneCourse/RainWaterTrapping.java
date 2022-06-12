package org.example.DSAOneCourse;

public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] levels = {3, 1, 2, 4, 0, 1, 3, 2};
        int rainWaterTrapped = getRainWaterTrapped(levels);
        System.out.println("Rain water trapped: " + rainWaterTrapped);
    }

    private static int getRainWaterTrapped(int[] levels) {
        int[] maxLevelTill = new int[levels.length];
        int[] maxLevelHereafter = new int[levels.length];

        for (int i = 0; i < levels.length; i++)
            maxLevelTill[i] = (i == 0) ? levels[i] : Math.max(maxLevelTill[i - 1], levels[i]);

        for (int j = levels.length - 1; j >= 0; j--)
            maxLevelHereafter[j] = (j == levels.length - 1) ? levels[j] : Math.max(levels[j], maxLevelHereafter[j + 1]);

        int rainWaterTrapped = 0;
        for (int k = 0; k < levels.length; k++)
            rainWaterTrapped += Math.min(maxLevelTill[k], maxLevelHereafter[k]) - levels[k];

        return rainWaterTrapped;
    }
}
