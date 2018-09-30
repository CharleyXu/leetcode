package com.xu.design_patterns.filter;

/**
 * @author CharleyXu Created on 2018/9/27.
 *
 * 字符过滤器
 *
 * 使用装饰器模式、模板模式、工厂模式实现
 */
public interface StringFilter {

    //关联下一装饰器
    public void setNextStringFilter(StringFilter stringFilter);

    //处理过滤
    public String filter(String source);

}
