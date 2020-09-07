package interview.OnlineTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/4/14 19:53
 */
public class PerfectWorld {
    public static void countExec(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str1 = s.split(" ");
        int[] weights = new int[str1.length];
        for(int i = 0; i<str1.length; i++)
        {
            weights[i] = Integer.parseInt(str1[i]);

        }
        int maxLoad = Integer.parseInt(br.readLine());
        int count = countLeastBoat(weights, maxLoad);
        System.out.println(count);
    }

    public static int countLeastBoat(int[] weights, int maxLoad)
    {
        Arrays.sort(weights);
        int result = 0;
        int m = 0;
        int n = weights.length-1;;
        while(m<n) {
            if(weights[m]+weights[n] <= maxLoad) {
                m++;
                n--;
            } else {
                n--;
            }
            result++;
        }
        if(n == m){
            result += 1;
        }
        return result;
    }





    public static int method(int diamondCount, int knapsackCapacity, int[] weights, int[] values) {
        int[] dp = new int[knapsackCapacity + 1];
        for (int i = 1; i < diamondCount + 1; i++) {
            for (int j = knapsackCapacity; j >= weights[i-1] ; j--) {
                dp[j] = Math.max(dp[j-weights[i-1]]+values[i-1],dp[j]);
            }
        }
        return dp[knapsackCapacity];
    }

    public static void methodExec(String[] args) {

        Scanner input = new Scanner(System.in);
        int diamondCount = Integer.parseInt(input.nextLine().trim());
        int knapsackCapacity = Integer.parseInt(input.nextLine().trim());
        String[] weightsStr = input.nextLine().split(" ");
        int[] weights = new int[weightsStr.length];
        for (int i = 0; i < weightsStr.length; i++) {

            weights[i] = Integer.parseInt(weightsStr[i].trim());

        }
        String[] valuesStr = input.nextLine().split(" ");

        int[] values = new int[valuesStr.length];

        for (int i = 0; i < valuesStr.length; i++) {

            values[i] = Integer.parseInt(valuesStr[i].trim());

        }

        System.out.println(method(diamondCount, knapsackCapacity, weights, values));

        input.close();

    }
}
