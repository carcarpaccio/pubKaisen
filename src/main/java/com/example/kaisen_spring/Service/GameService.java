package com.example.kaisen_spring.Service;

import com.example.kaisen_spring.model.EFieldInfo;
import com.example.kaisen_spring.model.EPlayer;
import com.example.kaisen_spring.model.EResult;
import com.example.kaisen_spring.model.Field;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    private Field myField;
    private Field enemyField;

    private int turn;
    private EResult result;

    private Random random=new Random();

    public void settingGame(int x,int y){
        this.turn=0;
        this.result= EResult.none;

        myField=new Field(EPlayer.player);
        myField.setInfo(x,y, EFieldInfo.ship);

        enemyField=new Field(EPlayer.cpu);
        int enemyX=random.nextInt(5);
        int enemyY=random.nextInt(5);
        System.out.println(enemyX+","+enemyY);
        enemyField.setInfo(enemyX,enemyY,EFieldInfo.enemyShip);
    }

    public String update(int x,int y){

        turnCount();

        int enemyX=random.nextInt(5);
        int enemyY=random.nextInt(5);
        System.out.println("cpu/"+"y:"+enemyY+"x:"+enemyX);
        if(hitJudge(x,y,enemyField)&&hitJudge(enemyX,enemyY,myField)){
            myField.setInfo(enemyX,enemyY,EFieldInfo.breaked);
            enemyField.setInfo(x,y,EFieldInfo.breaked);
            result= EResult.drow;
            return "drow.html";
        } else if(hitJudge(x,y,enemyField)&&!hitJudge(enemyX,enemyY,myField)){
            myField.setInfo(enemyX,enemyY,EFieldInfo.attacked);
            enemyField.setInfo(x,y,EFieldInfo.breaked);
            result= EResult.win;
            return "win.html";
        } else if(!hitJudge(x,y,enemyField)&&hitJudge(enemyX,enemyY,myField)){
            myField.setInfo(enemyX,enemyY,EFieldInfo.breaked);
            enemyField.setInfo(x,y,EFieldInfo.attacked);
            result= EResult.lose;
            return "lose.html";
        } else {
            myField.setInfo(enemyX,enemyY,EFieldInfo.attacked);
            enemyField.setInfo(x,y,EFieldInfo.attacked);
            return "game.html";
        }
    }

    boolean hitJudge(int x,int y,Field field){
        return field.getInfo(x,y)==EFieldInfo.ship || field.getInfo(x,y)==EFieldInfo.enemyShip;
    }



    public void turnCount(){
        turn++;
    }

    public EFieldInfo[][] getMyField() {
        return myField.getField();
    }

    public EFieldInfo[][] getEnemyField() {
        return enemyField.getField();
    }

    public EResult getResult() {
        return result;
    }

    public int getTurn() {
        return turn;
    }
}
