/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movinggame;

import java.util.Scanner;

/**
 *
 * @author HP Pavilion
 */
public class MovingGame {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static int PLAYERX, PLAYERY;
    static int ENEMYX, ENEMYY;
    static int ENDX, ENDY;
    static char[][] MAP = new char[5][5];
    static int TURN = 10;

    public static void main(String[] args) {
        PLAYERX = 2;
        PLAYERY = 2;
        ENEMYX = 0;
        ENEMYY = 0;
        do {
            ENDX = (int) (Math.random() * 4);
            ENDY = (int) (Math.random() * 4);
        } while (ENDX == PLAYERX && ENDY == PLAYERY && ENDX == ENEMYX && ENDY == ENEMYY);

        for (int x = 0; x < MAP.length; x++) {
            for (int y = 0; y < MAP[0].length; y++) {
                if (x == PLAYERX && y == PLAYERY) {
                    MAP[x][y] = 'X';
                } else if (x == ENDX && y == ENDY) {
                    MAP[x][y] = 'O';
                } else if (x == ENEMYX && y == ENEMYY) {
                    MAP[x][y] = 'E';
                } else {
                    MAP[x][y] = '-';
                }
            }
        }
        while (true) {
            loadMap();
            char input = input();
            movePlayer(input);
            moveEnemy();
            switch (check()) {
                case 1:
                    System.out.println("WIN");
                    return;
                case -1:
                    System.out.println("LOSE");
                    return;
                case 0:

            }
        }
    }

    private static void loadMap() {
        for (int x = 0; x < MAP.length; x++) {
            for (int y = 0; y < MAP[0].length; y++) {
                System.out.print(MAP[x][y] + "");
            }
            System.out.println("");
        }
        System.out.println(TURN + " remaining");
    }

    private static void movePlayer(char input) {
        switch (input) {
            case 'A':
                MAP[PLAYERX][PLAYERY] = '-';
                PLAYERY = (PLAYERY - 1 + MAP.length) % MAP.length;
                MAP[PLAYERX][PLAYERY] = 'X';
                TURN--;
                break;

            case 'D':
                MAP[PLAYERX][PLAYERY] = '-';
                PLAYERY = (PLAYERY + 1) % MAP.length;
                MAP[PLAYERX][PLAYERY] = 'X';
                TURN--;
                break;

            case 'W':
                MAP[PLAYERX][PLAYERY] = '-';
                PLAYERX = (PLAYERX - 1 + MAP.length) % MAP.length;
                MAP[PLAYERX][PLAYERY] = 'X';
                TURN--;
                break;

            case 'S':
                MAP[PLAYERX][PLAYERY] = '-';
                PLAYERX = (PLAYERX + 1) % MAP.length;
                MAP[PLAYERX][PLAYERY] = 'X';
                TURN--;
                break;

        }

    }

    private static int check() {
        if (PLAYERX == ENDX && PLAYERY == ENDY) {
            return 1;
        } else if (TURN == 0 || (PLAYERX == ENEMYX && PLAYERY == ENEMYY) || (ENEMYX == ENDX && ENEMYY == ENDY)) {
            return -1;
        }
        return 0;

    }

    private static char input() {
        System.out.println("Nhap vao WASD: ");
        String value = sc.nextLine();
        return value.charAt(0);

    }

    private static void moveEnemy() {
        MAP[ENEMYX][ENEMYY] = '-';
        if (ENEMYX < PLAYERX){
            ENEMYX = (ENEMYX + 1) % MAP.length;
            MAP[ENEMYX][ENEMYY] = 'E';
        } else if(ENEMYX > PLAYERX){
            ENEMYX = (ENEMYX - 1 +MAP.length) % MAP.length;
            MAP[ENEMYX][ENEMYY] = 'E';
        } else if(ENEMYY < PLAYERY){
            ENEMYY = (ENEMYY + 1) % MAP.length;
            MAP[ENEMYX][ENEMYY] = 'E';
        } else if(ENEMYY > PLAYERY){
            ENEMYY = (ENEMYY - 1 +MAP.length) % MAP.length;
            MAP[ENEMYX][ENEMYY] = 'E';
        }
    }

}
