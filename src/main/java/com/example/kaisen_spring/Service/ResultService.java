package com.example.kaisen_spring.Service;

import com.example.kaisen_spring.ResultRepository;
import com.example.kaisen_spring.model.EResult;
import com.example.kaisen_spring.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;

import java.util.List;

@Service
public class ResultService {
    private List<Result> results;

    @Autowired
    ResultRepository repository;

    public void register(EResult eResult,int turn){
        Result result=new Result(eResult,turn);
        try {
            repository.insert(result);
        }
        catch (DataAccessException e){
            e.printStackTrace();
        }
    }


    public List<Result> findAll(){
        try{
            return repository.select();
        }
        catch (DataAccessException e) {
            e.printStackTrace();
        }
        return emptyList();
    }
}
