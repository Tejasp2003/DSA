import  java.util.*;
class Solution {
    private final int MOD = 1000000007;

    // Recursive function to count the number of possible routes
    private int countPossibleRoutes(int[] locations, int currentCity, int targetCity, int remainingFuel, int[][] dp) {
        // If remaining fuel is negative, it means it's not possible to reach the target city
        if (remainingFuel < 0) return 0;

        int totalRoutes = 0;
        // If the result for the current city and remaining fuel has already been computed, return it
        if (dp[currentCity][remainingFuel] != -1) return dp[currentCity][remainingFuel];

        // If the current city is the target city, there is one valid route
        if (currentCity == targetCity) totalRoutes++;

        // Iterate through all the possible next cities
        for (int nextCity = 0; nextCity < locations.length; nextCity++) {
            // Exclude the current city and check if there is enough fuel to reach the next city
            if (nextCity != currentCity && remainingFuel >= Math.abs(locations[nextCity] - locations[currentCity])) {
                int fuelUsed = Math.abs(locations[nextCity] - locations[currentCity]);
                // Recursively count the number of possible routes from the next city
                totalRoutes = (totalRoutes + countPossibleRoutes(locations, nextCity, targetCity, remainingFuel - fuelUsed, dp)) % MOD;
            }
        }

        // Store the result in the dynamic programming array for future use
        return dp[currentCity][remainingFuel] = totalRoutes;
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int cityCount = locations.length;
        // Create a dynamic programming array to store computed results
        int[][] dp = new int[cityCount][fuel + 1];

        // Initialize the array with -1 to indicate that the result hasn't been computed yet
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        // Call the recursive function to count the number of possible routes
        return countPossibleRoutes(locations, start, finish, fuel, dp);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] locations = {2,3,6,8,4};
        int start = 1;
        int finish = 3;
        int fuel = 5;
        System.out.println("Test: " + sol.countRoutes(locations, start, finish, fuel));
    }
}
