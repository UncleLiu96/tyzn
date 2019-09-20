package com.common.core.page;

import com.common.Utils.Constants;
import com.common.Utils.ServletUtils;

/**
 * 表格数据处理
 * 
 * @Author: Uncle liu
 */
public class TableSupport
{
    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain()
    {
        PageDomain pageDomain = new PageDomain();
       int page= ServletUtils.getParameterToInt(Constants.PAGE_NUM)==null?ServletUtils.getParameterToInt("page"):ServletUtils.getParameterToInt(Constants.PAGE_NUM);
        pageDomain.setPageNum(page);
        int pagesize = ServletUtils.getParameterToInt(Constants.PAGE_SIZE)==null?ServletUtils.getParameterToInt("limit"):ServletUtils.getParameterToInt(Constants.PAGE_SIZE);
        pageDomain.setPageSize(pagesize);
        pageDomain.setOrderByColumn(ServletUtils.getParameter(Constants.ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(Constants.IS_ASC));
        return pageDomain;
    }

    public static PageDomain buildPageRequest()
    {
        return getPageDomain();
    }
}
