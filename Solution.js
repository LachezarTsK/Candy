
/**
 * @param {number[]} ratings
 * @return {number}
 */
var candy = function (ratings) {

    const candyDistribution = new Array(ratings.length).fill(1);

    for (let i = 1; i < ratings.length; ++i) {
        if (ratings[i - 1] < ratings[i]) {
            candyDistribution[i] = candyDistribution[i - 1] + 1;
        }
    }

    let minimumNumberOfCandies = candyDistribution[ratings.length - 1];
    for (let i = ratings.length - 2; i >= 0; --i) {
        if (ratings[i + 1] < ratings[i]) {
            candyDistribution[i] = Math.max(candyDistribution[i], candyDistribution[i + 1] + 1);
        }
        minimumNumberOfCandies += candyDistribution[i];
    }

    return minimumNumberOfCandies;
};
