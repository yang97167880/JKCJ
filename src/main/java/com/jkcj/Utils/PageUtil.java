package com.jkcj.Utils;

import com.github.pagehelper.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:Xhy
 * @Date:2020/2/17 20:05
 * @Description:分页工具
 **/
public class PageUtil {
    /**
     * @author Ck
     * 生成 {list:[],pageSize:int,pageRows:long} 格式的map，统一返回列表带分页信息的内容
     */
    public static <T> Map<String, Object> getListWithPageInfo(List<T> list, Page page) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("pageCount", page.getPages());
        map.put("pageRows", page.getTotal());
        return map;
    }
}
