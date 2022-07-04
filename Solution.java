
import java.util.Arrays;

public class Solution {

    public int candy(int[] ratings) {

        int[] candyDistribution = new int[ratings.length];
        Arrays.fill(candyDistribution, 1);

        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i - 1] < ratings[i]) {
                candyDistribution[i] = candyDistribution[i - 1] + 1;
            }
        }

        int minimumNumberOfCandies = candyDistribution[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; --i) {
            if (ratings[i + 1] < ratings[i]) {
                candyDistribution[i] = Math.max(candyDistribution[i], candyDistribution[i + 1] + 1);
            }
            minimumNumberOfCandies += candyDistribution[i];
        }

        return minimumNumberOfCandies;
    }
}
