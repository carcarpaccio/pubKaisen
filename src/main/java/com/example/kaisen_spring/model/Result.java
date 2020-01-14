package com.example.kaisen_spring.model;

public class Result {
    private int turn;
    private EResult result;

    public Result() {
    }

    public Result(EResult result,int turn) {
        this.result = result;
        this.turn = turn;
    }


    public EResult getResult() {
        return result;
    }

    public void setResult(EResult result) {
        this.result = result;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
