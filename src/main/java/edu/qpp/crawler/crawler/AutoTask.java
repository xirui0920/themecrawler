package edu.qpp.crawler.crawler;

import edu.qpp.crawler.crawler.crawlerprocess.WYentPageprocessor;
import edu.qpp.crawler.crawler.crawlerprocess.WYmoneyPageprocessor;
import edu.qpp.crawler.crawler.crawlerprocess.WYnewsPageprocessor;
import edu.qpp.crawler.crawler.crawlerprocess.WYsportPageProcessor;

import edu.qpp.crawler.crawler.dataprocess.MysqlPipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

/**
 * Created by xirui on 2017/4/13.
 */
@Service
public class AutoTask {
    private static final Logger log = LoggerFactory.getLogger(AutoTask.class);


    private WYentPageprocessor wYentPageprocessor = new WYentPageprocessor();

    private WYmoneyPageprocessor wYmoneyPageprocessor = new WYmoneyPageprocessor();

    private WYnewsPageprocessor wYnewsPageprocessor = new WYnewsPageprocessor();

    private WYsportPageProcessor wYsportPageProcessor = new WYsportPageProcessor();

    @Scheduled(cron = " 0 0 0/30 * * *")
    public void start(){
        log.info("定时抓取任务开始...");
        Spider.create(wYentPageprocessor).addUrl("http://ent.163.com/").addPipeline(new MysqlPipeline()).runAsync();
        Spider.create(wYsportPageProcessor).addUrl("http://sports.163.com/").addPipeline(new MysqlPipeline()).runAsync();
        Spider.create(wYmoneyPageprocessor).addUrl("http://money.163.com/").addPipeline(new MysqlPipeline()).runAsync();
        Spider.create(wYnewsPageprocessor).addUrl("http://news.163.com/").addPipeline(new MysqlPipeline()).runAsync();
    }


}
