package edu.qpp.crawler.crawler.crawlerprocess;

import edu.qpp.crawler.crawler.dataprocess.MysqlPipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by xirui on 2017/4/11.
 */
public class WYentPageprocessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(2000);

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("http://ent\\.163\\.com/\\d+/\\d+/\\d+/\\w+.html").all());
        page.putField("url",page.getRequest().getUrl());
        page.putField("digest",page.getHtml().xpath("head/title"));
        page.putField("theme","娱乐");
        if (page.getHtml().xpath("head/title") == null){
            page.setSkip(true);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

/*    public static void main(String[] args){
        WYentPageprocessor wYentPageprocessor = new WYentPageprocessor();
        Spider.create(wYentPageprocessor).addUrl("http://ent.163.com/").addPipeline(new MysqlPipeline()).runAsync();
    }*/

}
