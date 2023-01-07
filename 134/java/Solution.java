class Solution 
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        // The amount of gas remaining in the gas tank
        int remainingGas = 0;
        // The number of the gas station that the car started at
        int startIndex = 0;
        // The total gas surplus of the entire journey
        // A positive value indicates that there is more gas available than needed
        // A negative value indicates that there is less gas available than needed, which means that the journey is impossible to complete
        int totalGasSurplus = 0;
        int travelCost;

        // Only one loop is needed because failing to reach a particular gas station (P) from a starting gas station (S) means 
        // that starting from any station between S and P will NOT allow to go further than P because it was already impossible to reach it from S.
        // Starting from a station further than S will always provide LESS (or the same amount) of fuel than starting from S, making P impossible to reach.
        for(int i =  0; i < gas.length; i++)
        {
            // On each travel, we add to the tank the amount provided by the station minus the cost of the travel
            // A positive travel cost indicates that the station provided more fuel than needed to travel to the next station
            // A negative travel cost indicates that the station provided less fuel than needed to travel to the next station
            travelCost = gas[i] - cost[i];
            remainingGas += travelCost;
            // We add the travel cost to the total gas surplus
            totalGasSurplus += travelCost;

            // If the amount of remaining gas drops below zero, it means that there wasn't enough gas to travel to the next station
            if(remainingGas < 0)
            {
                // We then update the start index and reset the gas tank
                startIndex = i + 1;
                remainingGas = 0;
            }
        }

        // If there is less gas available than needed to travel trough all gas stations, it means that the journey is impossible to complete
        if(totalGasSurplus < 0)
            return -1;
        return startIndex;
    }
}
