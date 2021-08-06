package programmers.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingTheBridge {
    public static void main(String[] args) {
        int bridge_length1 = 2, weight1 = 10, bridge_length2 = 100, weight2 = 100, bridge_length3 = 100, weight3 = 100;
        int[] truck_weights1 = {7,4,5,6}, truck_weights2 = {10}, truck_weights3 = {10,10,10,10,10,10,10,10,10,10};

        calculateTime(bridge_length1, weight1, truck_weights1);
        calculateTime(bridge_length2, weight2, truck_weights2);
        calculateTime(bridge_length3, weight3, truck_weights3);
    }

    public static int calculateTime(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridgeQueue = new LinkedList<>();
        int count = 0, sum = 0;

        for(Integer truck : truck_weights) {
            while(true) {
                count++;
                if(bridgeQueue.isEmpty()) {
                    bridgeQueue.offer(truck);
                    sum = sum + truck;
                    break;
                } else if(bridgeQueue.size() == bridge_length) {
                    count--;
                    sum = sum - bridgeQueue.poll();
                } else {
                    if(sum + truck > weight) {
                        bridgeQueue.offer(0);
                    } else {
                        bridgeQueue.offer(truck);
                        sum = sum + truck;
                        break;
                    }
                }
            }
        }

        System.out.println(count + bridge_length);
        return count + bridge_length;
    }

    static class Truck {
        int weight;
        int location;

        public Truck(int weight) {
            this.weight = weight;
            this.location = 1;
        }
    }
}
