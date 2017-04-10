package graph.walls.and.gates;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sarvesh on 10/4/17.
 */
public class Main {
    public static void main(String[] args) {
        int[][] rooms = new int[4][4];
        rooms[0][0] = Integer.MAX_VALUE;
        rooms[0][1] = -1;
        rooms[0][2] = 0;
        rooms[0][3] = Integer.MAX_VALUE;
        rooms[1][0] = Integer.MAX_VALUE;
        rooms[1][1] = Integer.MAX_VALUE;
        rooms[1][2] = Integer.MAX_VALUE;
        rooms[1][3] = -1;
        rooms[2][0] = Integer.MAX_VALUE;
        rooms[2][1] = -1;
        rooms[2][2] = Integer.MAX_VALUE;
        rooms[2][3] = -1;
        rooms[3][0] = 0;
        rooms[3][1] = -1;
        rooms[3][2] = Integer.MAX_VALUE;
        rooms[3][3] = Integer.MAX_VALUE;

        boolean bfs = false;

        if(bfs) {
            wallsAndGates(rooms);
        } else {
            wallsAndGatesDFS(rooms);
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.println(rooms[i][j]);
            }
        }
    }

    private static void wallsAndGates(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms.length; j++) {
                if(rooms[i][j] == 0) {
                    fillRooms(rooms, i, j);
                }
            }
        }
        return;
    }

    private static void wallsAndGatesDFS(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms.length; j++) {
                if(rooms[i][j] == 0) {
                    fillRoomsDFS(rooms, i, j);
                }
            }
        }
        return;
    }

    private static void fillRooms(int[][] rooms, int i, int j) {
        Queue<Integer> queue = new LinkedList();
        queue.add(i*rooms.length + j);

        while(!queue.isEmpty()) {
            Integer current = queue.poll();
            Integer currentI = current/rooms.length;
            Integer currentJ = current % rooms.length;

            if(currentI > 0) {
                if(rooms[currentI - 1][currentJ] > rooms[currentI][currentJ] + 1) {
                    rooms[currentI - 1][currentJ] = rooms[currentI][currentJ] + 1;
                    queue.add((currentI - 1) * rooms.length + currentJ);
                }
            }
            if(currentI < rooms.length - 1) {
                if(rooms[currentI + 1][currentJ] > rooms[currentI][currentJ] + 1) {
                    rooms[currentI + 1][currentJ] = rooms[currentI][currentJ] + 1;
                    queue.add((currentI + 1) * rooms.length + currentJ);
                }
            }
            if(currentJ > 0) {
                if(rooms[currentI][currentJ - 1] > rooms[currentI][currentJ] + 1) {
                    rooms[currentI][currentJ - 1] = rooms[currentI][currentJ] + 1;
                    queue.add((currentI) * rooms.length + currentJ - 1);
                }
            }
            if(currentJ < rooms[0].length - 1) {
                if(rooms[currentI][currentJ + 1] > rooms[currentI][currentJ] + 1) {
                    rooms[currentI][currentJ + 1] = rooms[currentI][currentJ] + 1;
                    queue.add((currentI) * rooms.length + currentJ + 1);
                }
            }
        }
    }

    private static void fillRoomsDFS(int[][] rooms, int i, int j) {
        Integer currentI = i;
        Integer currentJ = j;

        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;
        int minUp = Integer.MAX_VALUE;
        int minBottom = Integer.MAX_VALUE;

        if(currentI > 0) {
            if(rooms[currentI - 1][currentJ] > rooms[currentI][currentJ] + 1) {
                rooms[currentI - 1][currentJ] = rooms[currentI][currentJ] + 1;
                fillRoomsDFS(rooms, currentI - 1, currentJ);
            }
        }

        if(currentI < rooms.length - 1) {
            if(rooms[currentI + 1][currentJ] > rooms[currentI][currentJ] + 1) {
                rooms[currentI + 1][currentJ] = rooms[currentI][currentJ] + 1;
                fillRoomsDFS(rooms, currentI + 1, currentJ);
            }
        }

        if(currentJ > 0) {
            if(rooms[currentI][currentJ - 1] > rooms[currentI][currentJ] + 1) {
                rooms[currentI][currentJ - 1] = rooms[currentI][currentJ] + 1;
                fillRoomsDFS(rooms, currentI, currentJ - 1);
            }
        }
        if(currentJ < rooms[0].length - 1) {
            if(rooms[currentI][currentJ + 1] > rooms[currentI][currentJ]) {
                rooms[currentI][currentJ + 1] = rooms[currentI][currentJ] + 1;
                fillRoomsDFS(rooms, currentI, currentJ + 1);
            }
        }
    }
}