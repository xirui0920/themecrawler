package edu.qpp.crawler.web.rest;


import edu.qpp.crawler.config.Constants;
import edu.qpp.crawler.domain.Result;
import edu.qpp.crawler.service.ResultService;
import edu.qpp.crawler.web.rest.util.JsonResult;
import edu.qpp.crawler.web.rest.util.JsonResultData;
import edu.qpp.crawler.web.rest.util.ThemeMappingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by xirui on 2017/4/9.
 */
@RestController
@RequestMapping("/qpp")
public class ResultResource {

    private final Logger logger = LoggerFactory.getLogger(ResultResource.class);

    @Autowired
    private ResultService resultService;


//    @ResponseBody
    @RequestMapping(value = "/result/{theme}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult getAllResult(@PathVariable(value = "theme") String theme, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        theme = ThemeMappingUtil.getThemeMapping(theme);

        logger.info("开始获取主题为 {} 的爬取结果",theme);
        List<Result> list = null;
        list = resultService.findByTheme(theme);
        if (list != null && list.size() > 0) {
            return new JsonResultData<List<Result>>(Constants.SUCCESS_CODE,Constants.THEME_SUC,list);
        }else {
            logger.info("获取主题为 {} 的爬取结果失败",theme);
            return  new JsonResult(Constants.FAIL_CODE,Constants.THEME_ERROR);
        }

    }

}
