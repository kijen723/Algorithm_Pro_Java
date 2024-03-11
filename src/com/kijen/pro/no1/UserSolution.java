package com.kijen.pro.no1;

import java.util.ArrayList;
import java.util.HashMap;

class UserSolution {
    Monarch[][] map;
    HashMap<String, String> allies;
    HashMap<String, ArrayList<String>> enemies;

    class Monarch {
        int cnt;
        String name;

        public Monarch(int cnt, String name) {
            this.cnt = cnt;
            this.name = name;
        }
    }

    void init(int N, int mSoldier[][], char mMonarch[][][]) {
        map = new Monarch[N][N];
        allies = new HashMap<>();
        enemies = new HashMap<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = new Monarch(mSoldier[r][c], new String(mMonarch[r][c]));
                allies.put(map[r][c].name, map[r][c].name);
            }
        }
    }

    void destroy() {

    }

    int ally(char mMonarchA[], char mMonarchB[]) {
        String a = new String(mMonarchA);
        String b = new String(mMonarchB);

        unionSet(a, b);


        return -4;
    }

    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[]) {
        return -3;
    }

    int recruit(char mMonarch[], int mNum, int mOption) {
        return -1;
    }

    /* My function */
    void unionSet(String mMonarchA, String mMonarchB) {
        String a = findSet(mMonarchA);
        String b = findSet(mMonarchB);

        if (a.compareTo(b) < 0) {
            allies.put(a, b);
        } else {
            allies.put(b, a);
        }


    }

    String findSet(String mMonarch) {
        if (allies.get(mMonarch).equals(mMonarch)) {
            return mMonarch;
        } else {
            return allies.put(mMonarch, findSet(mMonarch));
        }
    }
}
