package com.learn_java.sec_06;

public class HanoiTower {
    // Recursive method to solve the Tower of Hanoi problem
    public void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }
        solveHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        HanoiTower hanoi = new HanoiTower();
        hanoi.solveHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
    }
}
