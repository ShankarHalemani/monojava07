package com.techlabs.model;

public class ResultAnalyzer {
    private Board board;
    private ResultType result;

    public ResultAnalyzer() {
        this.board = new Board();
        this.result = ResultType.PROGRESS;
    }

    public void horizontalWinCheck(){
        for(int i=0; i<9; i+=3){
            if(board.getCells()[i].getMark()!=MarkType.EMPTY &&
                    board.getCells()[i].getMark()==board.getCells()[i+1].getMark() &&
                    board.getCells()[i].getMark()==board.getCells()[i+2].getMark()
            ){
                result = ResultType.WIN;
            }
        }
    }

    public void verticalWinCheck(){
        for(int i=0; i<3; i++){
            if(board.getCells()[i].getMark()!=MarkType.EMPTY &&
                    board.getCells()[i].getMark()==board.getCells()[i+3].getMark() &&
                    board.getCells()[i].getMark()==board.getCells()[i+6].getMark()
            ){
                result = ResultType.WIN;
            }
        }
    }

    public void diagonalWinCheck(){
        if(board.getCells()[0].getMark()!=MarkType.EMPTY &&
                board.getCells()[0].getMark()==board.getCells()[4].getMark() &&
                board.getCells()[0].getMark()==board.getCells()[8].getMark()
        ){
            result = ResultType.WIN;
        }

        if(board.getCells()[2].getMark()!=MarkType.EMPTY &&
                board.getCells()[2].getMark()==board.getCells()[4].getMark() &&
                board.getCells()[2].getMark()==board.getCells()[6].getMark()
        ){
            result = ResultType.WIN;
        }
    }

    public ResultType getResult() {
        return result;
    }

    public Board getBoard(){
        return this.board;
    }

    public ResultType analyzeResult(){
        horizontalWinCheck();
        verticalWinCheck();
        diagonalWinCheck();
        if(result==ResultType.PROGRESS && board.isBoardFull()){
            result=ResultType.DRAW;
        }
        return result;
    }


}
