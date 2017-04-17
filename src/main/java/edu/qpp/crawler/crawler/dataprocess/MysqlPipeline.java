package edu.qpp.crawler.crawler.dataprocess;

import edu.qpp.crawler.domain.Result;
import edu.qpp.crawler.service.ResultService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by xirui on 2017/4/10.
 */
//@Component
public class MysqlPipeline implements Pipeline {

    private static  final org.slf4j.Logger logger = LoggerFactory.getLogger(MysqlPipeline.class);
//    private ResultService resultService;
/*
    public MysqlPipeline(){}

//    @Autowired
    public MysqlPipeline(ResultService resultService){
        this.resultService = resultService;
    }*/

    @Override
    public void process(ResultItems resultItems, Task task) {
/*        Result result = new Result();
        result.setUrl(resultItems.getAll().get("url").toString());
        result.setDigest(resultItems.getAll().get("digest").toString());
        result.setTheme(resultItems.getAll().get("theme").toString());
        resultService.savaOrUpdateResult(result);
        logger.info("保存成功{}",result.toString());*/

        try {
            StringBuffer sql = new StringBuffer("insert into result(url,digest,theme) values(?,?,?)");
            PreparedStatement pst = Dao.getCon().prepareStatement(sql.toString());
            int i = 1;
            for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
                pst.setString(i,entry.getValue().toString());
                i++;
            }

            int code = pst.executeUpdate();
            if (code > -1){
                logger.info("插入数据成功{}",sql.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
