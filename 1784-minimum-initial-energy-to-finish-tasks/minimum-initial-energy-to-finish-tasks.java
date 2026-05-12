class Solution {
    public int minimumEffort(int[][] tasks) {

        // Sort by (minimum - actual) in descending order
        Arrays.sort(tasks, (a, b) -> 
            (b[1] - b[0]) - (a[1] - a[0])
        );

        int currentEnergy = 0;
        int answer = 0;

        for (int[] task : tasks) {

            int actual = task[0];
            int minimum = task[1];

           
            if (currentEnergy < minimum) {
                answer += (minimum - currentEnergy);
                currentEnergy = minimum;
            }

            // Finish the task
            currentEnergy -= actual;
        }

        return answer;
    }
}