package edu.qpp.crawler.crawler.crawlerprocess;

import edu.qpp.crawler.crawler.dataprocess.MysqlPipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by xirui on 2017/4/13.
 */
public class WYnewsPageprocessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("http://news\\.163\\.com/\\d+/\\d+/\\d+/\\w+.html").all());
        page.putField("url",page.getRequest().getUrl());
        page.putField("digest",page.getHtml().xpath("head/title"));
        page.putField("theme","综合");
        if (page.getHtml().xpath("head/title") == null){
            page.setSkip(true);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

/*    public static void main(String[] args){
        WYsportPageProcessor wangYiPageProcessor = new WYsportPageProcessor();
        Spider.create(wangYiPageProcessor).addUrl("http://news.163.com/").addPipeline(new MysqlPipeline()).runAsync();
    }*/
}
