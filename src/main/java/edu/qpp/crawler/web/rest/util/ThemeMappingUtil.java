package edu.qpp.crawler.web.rest.util;

/**
 * Created by xirui on 2017/4/13.
 */
public class ThemeMappingUtil {

    private static final String sport = "体育";
    private static final String ent = "娱乐";
    private static final String world = "国际";
    private static final String domestic = "综合";
    private static final String money="财经";

    public static String getThemeMapping(String theme){
        if (theme.equals("sport")){
            return sport;
        }
        if (theme.equals("ent")){
            return ent;
        }
        if (theme.equals("world")){
            return world;
        }
        if (theme.equals("domestic")){
            return domestic;
        }
        if (theme.equals("money")){
            return money;
        }
        return null;
    }

    public static String getSport() {
        return sport;
    }

    public static String getEnt() {
        return ent;
    }

    public static String getWorld() {
        return world;
    }

    public static String getDomestic() {
        return domestic;
    }
}
