
#include <vector>
using namespace std;

class Solution {
    
public:
    int candy(vector<int>& ratings) {
        
        vector<int> candyDistribution(ratings.size(), 1);

        for (int i = 1; i < ratings.size(); ++i) {
            if (ratings[i - 1] < ratings[i]) {
                candyDistribution[i] = candyDistribution[i - 1] + 1;
            }
        }

        int minimumNumberOfCandies = candyDistribution[ratings.size() - 1];
        for (int i = ratings.size() - 2; i >= 0; --i) {
            if (ratings[i + 1] < ratings[i]) {
                candyDistribution[i] = max(candyDistribution[i], candyDistribution[i + 1] + 1);
            }
            minimumNumberOfCandies += candyDistribution[i];
        }

        return minimumNumberOfCandies;
    }
};
