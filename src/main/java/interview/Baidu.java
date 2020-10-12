package interview;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Baidu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] s;
        int[] nums = new int[n];
        s = in.next().split("");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println(minJumpSteps(nums));
    }

    public static int minJumpSteps(int[] arr) {
        if (arr.length == 1) return 0;
        boolean[] visited = new boolean[arr.length];
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> linkedList = map.getOrDefault(arr[i], new LinkedList<Integer>());
            linkedList.add(i);
            map.put(arr[i], linkedList);
        }
        deque.offer(0);
        visited[0] = true;
        int step = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int current = deque.poll();
                if (current == arr.length - 1) return step;
                if (map.containsKey(arr[current])) {
                    for (int tag : map.get(arr[current])) {
                        if (!visited[tag]) {
                            deque.offer(tag);
                            visited[tag] = true;
                        }
                    }
                    map.remove(arr[current]);
                }
                if (current + 1 < arr.length && !visited[current + 1]) {
                    deque.offer(current + 1);
                    visited[current + 1] = true;
                }
                if (current - 1 >= 0 && !visited[current - 1]) {
                    deque.offer(current - 1);
                    visited[current - 1] = true;
                }

            }
            step++;

        }
        return step;
    }


    // public static int minJumpSteps(int[] arr) {
    //     int n = arr.length;
    //     Map<Integer, List<Integer>> map = new HashMap<>();
    //     int[] dist = new int[n];
    //     boolean[] canJump = new boolean[n];
    //     Arrays.fill(canJump, true);
    //     for (int i = 0; i < n; i++) {
    //         List<Integer> orDefault = map.computeIfAbsent(arr[i], key -> new ArrayList<>());
    //         orDefault.add(i);
    //     }
    //     Arrays.fill(dist, Integer.MAX_VALUE);
    //
    //     Queue queue = new LinkedList();
    //     queue.add(0);
    //     dist[0] = 0;
    //     while (!queue.isEmpty()) {
    //         Integer x = (Integer) queue.poll();
    //         if (x - 1 >= 0 && dist[x - 1] == Integer.MAX_VALUE) {
    //             queue.add(x - 1);
    //             dist[x - 1] = dist[x] + 1;
    //         }
    //         if (x + 1 < n && dist[x + 1] == Integer.MAX_VALUE) {
    //             queue.add(x + 1);
    //             dist[x + 1] = dist[x] + 1;
    //         }
    //         if (canJump[x]) {
    //             for (int tmp : map.get(arr[x])) {
    //                 if (dist[tmp] == Integer.MAX_VALUE) {
    //                     dist[tmp] = dist[x] + 1;
    //                     queue.add(tmp);
    //                     canJump[tmp] = false;
    //                 }
    //             }
    //         }
    //     }
    //     return dist[n - 1];
    // }
}
