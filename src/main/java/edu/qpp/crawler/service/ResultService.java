package edu.qpp.crawler.service;

import edu.qpp.crawler.domain.Result;
import edu.qpp.crawler.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xirui on 2017/4/9.
 */
@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<Result> findByTheme(String theme){
        return resultRepository.findAllByTheme(theme);
    }

    public void savaOrUpdateResult(Result result){
            resultRepository.save(result);
    }

}
