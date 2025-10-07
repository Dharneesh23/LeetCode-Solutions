class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;
        
        while (empty >= numExchange) {
            int newBottles = empty / numExchange;   // how many new full bottles we get
            total += newBottles;                   // add them to total drunk bottles
            empty = empty % numExchange + newBottles; // leftover empties + newly drunk empties
        }
        
        return total;
    }
}
