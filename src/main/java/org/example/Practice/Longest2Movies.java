package org.example.Practice;

import java.util.Arrays;

/**
 * You are a in-flight movie service provider. You are given a list of movie lengths and the duration of the flight.
 * Return a pair of (2) movies whose combined length is the highest and is less than or equal to flight duration.
 * If multiple such combinations are possible, return the pair which has the movie of longer longest duration.
 * Ex :
 * MovieLenghts : {27, 1,10, 39, 12, 52, 32, 67, 76}
 * Flight Duration : 77.
 * The 2 possible pairs are (1,76) and (10,67), The answer is (1,76) as per the last constraint.
 * https://www.geeksforgeeks.org/amazon-interview-experience-sde-2-10/
 */
public class Longest2Movies {

    public static void main(String[] args) {
        int[] movies = {27, 1, 10, 39, 12, 52, 32, 67, 76};
        int flightDuration = 77;
        int[] result = new Longest2Movies().getLongest2Movies(movies, flightDuration);
        System.out.println(result[0] + ", " + result[1]);
    }

    public int[] getLongest2Movies(int[] movies, int fd) {
        Arrays.sort(movies);
        int m1 = -1, m2 = -1;
        int maxSum = -1;
        int l = 0;
        int r = movies.length - 1;
        int sum;
        while (l < r) {
            sum = movies[l] + movies[r];
            if (sum > maxSum && sum <= fd) {
                m1 = movies[r];
                m2 = movies[l];
                maxSum = m1 + m2;
                if (sum == fd) break;
            }
            if (sum < fd) {
                l++;
            } else if (sum > fd) {
                r--;
            }
        }
        return new int[]{m1, m2};
    }

}
