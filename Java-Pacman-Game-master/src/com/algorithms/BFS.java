package com.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BFS {

    private Point[][] board;
    private ArrayDeque<Point> mainQ= new ArrayDeque<Point>();
    private ArrayDeque<Point> way = new ArrayDeque<Point>();

    public BFS(Point[][] board) {
        this.board = board;
    }

    public void setWay(ArrayDeque<Point> way){
        this.way = way;
    }

    public ArrayDeque<Point> BSF(){
        Point start = findStart();
        mainQ.add(start);
        board[start.getPositionI()][start.getPositionJ()].setPassed(true);
        findingWay(mainQ.pollFirst());
        return way;
    }

    public ArrayDeque<Point> continueFind(){
        Point s = mainQ.pollFirst();
        board[s.getPositionI()][s.getPositionJ()].setPassed(true);
        findingWay(s);
        return way;
    }

    private void findingWay(Point start) {
        Point current = start;

        int data = current.getData();
        ArrayDeque<Point> way1 = new ArrayDeque<>();
        way1.addAll(current.getWayToStart());
        ArrayDeque<Point> extraWay = new ArrayDeque<>();
        while(!way1.isEmpty()){
            extraWay.addLast(way1.pollLast());
        }
        way.addAll(extraWay);
        way.add(current);
        way.addAll(current.getWayToStart());


        if(current.getPositionJ()-1>0) {
            if (((data & 1) == 0) && (!board[current.getPositionI()][current.getPositionJ() - 1].isPassed())) {
                Point a = board[current.getPositionI()][current.getPositionJ() - 1];
                ArrayDeque<Point> queue = new ArrayDeque<>();
                queue.addAll(current.getWayToStart());
                queue.addFirst(current);
                board[current.getPositionI()][current.getPositionJ() - 1].setWayToStart(queue);
                board[current.getPositionI()][current.getPositionJ() - 1].setPassed(true);
                mainQ.add(a);
            }
        }
        if(current.getPositionI()-1>0) {
            if (((data & 2) == 0) && (!board[current.getPositionI() - 1][current.getPositionJ()].isPassed())) {
                Point b = board[current.getPositionI() - 1][current.getPositionJ()];
                ArrayDeque<Point> queue = new ArrayDeque<>();
                queue.addAll(current.getWayToStart());
                queue.addFirst(current);
                board[current.getPositionI() - 1][current.getPositionJ()].setWayToStart(queue);
                board[current.getPositionI() - 1][current.getPositionJ()].setPassed(true);
                mainQ.add(b);
            }
        }
        if(current.getPositionJ()+1<15) {
            if (((data & 4) == 0) && (!board[current.getPositionI()][current.getPositionJ() + 1].isPassed())) {
                Point c = board[current.getPositionI()][current.getPositionJ() + 1];
                ArrayDeque<Point> queue = new ArrayDeque<>();
                queue.addAll(current.getWayToStart());
                queue.addFirst(current);
                board[current.getPositionI()][current.getPositionJ() + 1].setWayToStart(queue);
                board[current.getPositionI()][current.getPositionJ() + 1].setPassed(true);
                mainQ.add(c);
            }
        }
        if(current.getPositionI()+1<15) {
            if (((data & 8) == 0) && (!board[current.getPositionI() + 1][current.getPositionJ()].isPassed())) {
                Point d = board[current.getPositionI() + 1][current.getPositionJ()];
                ArrayDeque<Point> queue = new ArrayDeque<>();
                queue.addAll(current.getWayToStart());
                queue.addFirst(current);
                board[current.getPositionI() + 1][current.getPositionJ()].setWayToStart(queue);
                board[current.getPositionI() + 1][current.getPositionJ()].setPassed(true);
                mainQ.add(d);
            }
        }
    ArrayDeque<Point> mainQQ = new ArrayDeque<>();
        mainQQ.addAll(mainQ);
        while(!mainQQ.isEmpty()){
            Point a = mainQQ.pollFirst();
            System.out.print(" | " + a.getPositionI() + " " + a.getPositionJ());
        }
        System.out.println();
    }

    private Point findStart(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j].isPassed()) return board[i][j];
            }
        }
        return null;
    }
}
