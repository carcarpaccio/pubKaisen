package com.example.kaisen_spring.model;

public class Field {
    private EPlayer name;
    private EFieldInfo[][] field;

    public Field(EPlayer  name){
        this.name=name;

        field =new EFieldInfo[5][5];
        for(int j=0;j<5;j++) {
            for(int i=0;i<5;i++) {
                this.field[i][j]=EFieldInfo.empty;
            }
        }
    }

    public void setInfo(int x,int y,EFieldInfo fieldInfo){
        this.field[x][y]=fieldInfo;
    }
    public EFieldInfo getInfo(int x,int y){
        return this.field[x][y];
    }

    public EFieldInfo[][] getField() {
        return field;
    }

    public EPlayer getName() {
        return name;
    }
}
