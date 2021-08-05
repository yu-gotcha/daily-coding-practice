package programmers.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/* 프린터 */
public class Printer {
    public static void main(String[] args) {
        int[] properties1 = {2, 1, 3, 2}, properties2 = {1, 1, 9, 1, 1, 1};
        int location1 = 2, location2 = 0;

        System.out.println(findOrder(properties2, location2));
    }

    public static int findOrder(int[] properties, int location) {
        Queue<Task> taskQueue = new LinkedList<>();

        for(int i = 0; i < properties.length; i++)  taskQueue.add(new Task(properties[i], i));
        Arrays.sort(properties);
        int printed = 1;

        while(!taskQueue.isEmpty()) {
            if(taskQueue.peek().priority == properties[properties.length - printed]) {
                if(taskQueue.peek().location == location) return printed;
                taskQueue.poll();
                printed++;
            }
            else {
                taskQueue.add(taskQueue.poll());
            }
        }
        return 0;
    }

    static class Task {
        Integer priority;
        Integer location;

        public Task(Integer priority, Integer location){
            this.priority = priority;
            this.location = location;
        }

    }
}
