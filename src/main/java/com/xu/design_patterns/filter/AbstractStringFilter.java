package com.xu.design_patterns.filter;

/**
 * @author CharleyXu Created on 2018/9/27.
 */
public abstract class AbstractStringFilter implements StringFilter {

    private StringFilter stringFilter;

    public void setNextStringFilter(StringFilter stringFilter) {
        this.stringFilter = stringFilter;
    }

    public String filter(String source) {
        String target = doFilter(source);
        if (stringFilter == null) {
            return target;
        }
        return stringFilter.filter(target);

    }

    // 模板抽象方法,传入要处理的string,返回处理完的string
    public abstract String doFilter(String source);

}
