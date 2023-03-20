package org.weeklydsa.Daily_Challenges;

public class CanPlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int plantedCount = 0;
        int prevElement = 0;
        int nextElement = 0;
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                prevElement = (i == 0 || flowerbed[i - 1] == 0) ? 0 : 1;
                nextElement = (i == len - 1 || flowerbed[i + 1] == 0) ? 0 : 1;

                if (prevElement == 0 && nextElement == 0) {
                    flowerbed[i] = 1;
                    plantedCount++;
                }
            }
        }
        return plantedCount >= n;
    }
}
