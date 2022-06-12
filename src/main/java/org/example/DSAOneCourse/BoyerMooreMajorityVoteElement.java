package org.example.DSAOneCourse;

/**
 * find the element in array who's frequency is > N/2 where N = array size
 * Find in linear time and no extra space
 * https://www.youtube.com/watch?v=X0G5jEcvroo&list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p&index=12
 */
public class BoyerMooreMajorityVoteElement {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 1, 1};
        int majorityElement = findMajorityElement(arr);
        System.out.println("Majority Element: " + majorityElement);
    }

    private static int findMajorityElement(int[] arr) {
        int majorityCandidateIdx = -1;
        int majorityCandidateFreq = 0;
        for (int i = 0; i < arr.length; i++) {
            if (majorityCandidateIdx == -1) {
                majorityCandidateIdx = i;
                majorityCandidateFreq = 1;
            } else {
                if (arr[i] == arr[majorityCandidateIdx])
                    majorityCandidateFreq++;
                else {
                    majorityCandidateFreq--;
                    if (majorityCandidateFreq == 0) {
                        majorityCandidateIdx = i;
                        majorityCandidateFreq = 1;
                    }
                }
            }
        }

        //check if majorityCandidateIdx is really a majority
        int cnt = 0;
        for (int n : arr)
            if (n == arr[majorityCandidateIdx]) cnt++;
        if (cnt > (arr.length / 2)) return arr[majorityCandidateIdx];
        else return -1;
    }

}
