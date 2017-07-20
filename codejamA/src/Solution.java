import java.io.*;
import java.util.Scanner;

/**
 * Created by Shinelon on 2017/7/16.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        inputStream = new FileInputStream("A-large-practice.in");
        sc = new Scanner(inputStream, "UTF-8");
        int testNum = 0;
        testNum = sc.nextInt();
        int curNum = 0;
        File f = new File("output.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(f));
        while(curNum < testNum) {
            curNum++;
            int cityNum = sc.nextInt();
            int sightTime = sc.nextInt();
            int latestTime = sc.nextInt();
            int[] startTime = new int[cityNum - 1];
            int[] frequency = new int[cityNum - 1];
            int[] duringTime = new int[cityNum - 1];
            int[] earlyTime = new int[cityNum];
            int[] lateTime = new int[cityNum];
            earlyTime[0] = 0;
            for(int i = 0; i < cityNum - 1; i++) {

                startTime[i] = sc.nextInt();
                frequency[i] = sc.nextInt();
                duringTime[i] = sc.nextInt();
                if(earlyTime[i] <= startTime[i]) {
                    earlyTime[i + 1] = startTime[i] + duringTime[i];
                }else{
                    earlyTime[i + 1] = ((earlyTime[i] - startTime[i] - 1) / frequency[i] + 1) * frequency[i] + startTime[i] + duringTime[i];                }
            }
            if(earlyTime[cityNum - 1] > latestTime) {
                output.write("Case #" + curNum + ": IMPOSSIBLE");
                System.out.println("Case #" + curNum + ": IMPOSSIBLE");
                continue;
            }
            lateTime[cityNum - 1] = latestTime;
            for(int i = cityNum - 1; i > 0; i--) {
                lateTime[i - 1] = (lateTime[i] - duringTime[i - 1] - startTime[i - 1]) / frequency[i - 1] * frequency[i - 1] + startTime[i - 1];
            }
            System.out.println("Case #"+curNum+": " + new Solution().calMaxSight(startTime, frequency, duringTime,earlyTime,lateTime,sightTime, cityNum - 1, latestTime));
            output.write("Case #"+curNum+": " + new Solution().calMaxSight(startTime, frequency, duringTime,earlyTime,lateTime,sightTime, cityNum - 1, latestTime));
        }
        output.close();
    }

    public int calMaxSight(int[] startTime, int[] frequency, int[] duringTime, int[] earlyTime, int[] lateTime, int sightTime,int index, int curTime) {
        if(curTime < earlyTime[index] || curTime > lateTime[index])
            return -1;
        if(index == 0) {
            return 0;
        }
        int pre1 = (curTime - duringTime[index - 1] - startTime[index - 1])/ frequency[index - 1] * frequency[index - 1] + startTime[index - 1];
        int pre2 = 0;
//        if(curTime - duringTime[index - 1] - sightTime - startTime[index - 1] < 0)
//            pre2 = -1;
//        else
            pre2 = (curTime - duringTime[index - 1] - startTime[index - 1])/ frequency[index - 1] * frequency[index - 1] + startTime[index - 1] - sightTime;
        int a = calMaxSight(startTime, frequency, duringTime, earlyTime, lateTime, sightTime, index - 1, pre1);
        int b = calMaxSight(startTime, frequency, duringTime, earlyTime, lateTime, sightTime, index - 1, pre2);
        if(b == - 1)
            return a;
        else
            return Math.max(a, b + 1);
    }
}
