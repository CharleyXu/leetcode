package com.xu.design_patterns.filter;

import org.apache.commons.lang3.StringUtils;

/**
 * @author CharleyXu Created on 2018/9/27.
 */
public class HtmlFilter extends AbstractStringFilter {

    @Override
    public String doFilter(String source) {
        source = StringUtils.replace(source, "&", "&amp;");
        source = StringUtils.replace(source, "<", "&lt;");
        source = StringUtils.replace(source, ">", "&gt;");
        source = StringUtils.replace(source, " ", "&nbsp;");
        source = StringUtils.replace(source, "\"", "&quot;");
        source = StringUtils.replace(source, "\'", "&apos;");
        return source;
    }
}
