package com.example.kaisen_spring;

import com.example.kaisen_spring.model.EResult;
import com.example.kaisen_spring.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.springframework.jdbc.core.BeanPropertyRowMapper.newInstance;

@org.springframework.stereotype.Repository
public class ResultRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public void insert(Result result){
        var sql="insert into RESULT values(?,?)";
        jdbc.update(sql,result.getResult().toString(),result.getTurn());
    }

    public List<Result> select(){
        var sql="SELECT RESULT, TURN  FROM RESULT";
        return  jdbc.query(sql,newInstance(Result.class));
    }
}
