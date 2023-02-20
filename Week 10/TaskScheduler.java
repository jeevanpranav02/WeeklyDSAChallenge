package Day_4;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
	public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','B','B'};
		int n = 2;
		System.out.println(leastInterval(tasks, n));
	}
	public static int leastInterval(char[] tasks, int n) {
        if(n == 0){
            return tasks.length;
        }

        HashMap<Character,Integer> map = new HashMap<>();


        for(int i = 0;i < tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
        }

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());
        int maxFreq = pq.poll();

        int totalIdleTime = (maxFreq - 1) * n;
        while (!pq.isEmpty()){
            int currentFreq = pq.poll();
            if(currentFreq == maxFreq){
                totalIdleTime-=currentFreq;
                totalIdleTime+=1;
            }else {
                totalIdleTime -= currentFreq;
            }
        }
        if(totalIdleTime > 0){
            return totalIdleTime + tasks.length;
        }
        return tasks.length;
    }
}
