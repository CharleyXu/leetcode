package com.xu.design_patterns.filter;

/**
 * @author CharleyXu Created on 2018/9/27.
 */
public class EmptyFilter extends AbstractStringFilter {

    @Override
    public String doFilter(String source) {
        return source;
    }
}
