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

    public ArrayDeque<Point> BSF(){

        Point start = findStart();
        mainQ.add(start);
        while(!mainQ.isEmpty())
            findingWay(mainQ.peekFirst());
        return way;
    }

    private void findingWay(Point start) {
        Point current = start;
        int data = current.getData();
        way.add(current);
        ArrayDeque<Point> way1 = current.getWayToStart();
        for(int i = 0; i<way1.size();i++){
            way.add(current.getWayToStart().peekFirst());
        }
        if(((data & 1) != 0) && (!board[current.getPositionI()][current.getPositionJ()-1].isPassed())) {Point a = board[current.getPositionI()][current.getPositionJ()-1]; ArrayDeque<Point> queue = new ArrayDeque<>(); queue = current.getWayToStart(); queue.addFirst(current); a.setWayToStart(queue);mainQ.add(a);};
        if(((data & 2) != 0) && (!board[current.getPositionI()-1][current.getPositionJ()].isPassed())) {Point a = board[current.getPositionI()-1][current.getPositionJ()]; ArrayDeque<Point> queue = new ArrayDeque<>(); queue = current.getWayToStart(); queue.addFirst(current); a.setWayToStart(queue);mainQ.add(a);};
        if(((data & 4) != 0) && (!board[current.getPositionI()][current.getPositionJ()+1].isPassed())) {Point a = board[current.getPositionI()][current.getPositionJ()+1]; ArrayDeque<Point> queue = new ArrayDeque<>(); queue = current.getWayToStart(); queue.addFirst(current); a.setWayToStart(queue);mainQ.add(a);};
        if(((data & 8) != 0) && (!board[current.getPositionI()+1][current.getPositionJ()].isPassed())) {Point a = board[current.getPositionI()+1][current.getPositionJ()]; ArrayDeque<Point> queue = new ArrayDeque<>(); queue = current.getWayToStart(); queue.addFirst(current); a.setWayToStart(queue);mainQ.add(a);};
        if((data & 16) != 0) return;
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
