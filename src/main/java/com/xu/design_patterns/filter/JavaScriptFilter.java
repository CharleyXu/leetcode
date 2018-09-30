package com.xu.design_patterns.filter;

import java.util.regex.Pattern;

/**
 * @author CharleyXu Created on 2018/9/28.
 */
public class JavaScriptFilter extends AbstractStringFilter {

    @Override
    public String doFilter(String source) {
        return Pattern.compile("<script[\\s\\S]*?>[\\s\\S]*?<\\/script>", Pattern.CASE_INSENSITIVE)
                .matcher(source).replaceAll("");
    }
}
