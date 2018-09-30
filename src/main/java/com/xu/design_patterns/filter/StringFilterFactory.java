package com.xu.design_patterns.filter;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CharleyXu Created on 2018/9/27.
 */
public class StringFilterFactory {

    private static final StringFilterFactory stringFilterFactory = new StringFilterFactory();
    private static Map<String, String> filterMap = new HashMap();

    // TODO: 2018/9/30 对应关系可以写在配置文件里
    static {
        filterMap.put("html", "com.xu.design_patterns.filter.HtmlFilter");
        filterMap.put("js", "com.xu.design_patterns.filter.JavaScriptFilter");
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private StringFilterFactory() {
    }

    public static final StringFilterFactory getInstance() {
        return stringFilterFactory;
    }

    public static void main(String[] args) {
        StringFilter stringFilter = StringFilterFactory.getInstance().getStringFilter("html");
        String source = "123ecscasca<<<<<wd1";
        String result = stringFilter.filter(source);
        System.out.println(result);
    }

    //通过一个以逗号分割的过滤器引用名串，获取过滤器
    public StringFilter getStringFilterChain(String chain) {
        if (chain == null || chain.length() == 0) {
            return new EmptyFilter();
        }
        if ("all".equalsIgnoreCase(chain)) {
            return getAllStringFilterChain();
        }
        String[] filters = chain.split("\\,");
        return getStringFilterChain(filters);
    }

    public StringFilter getAllStringFilterChain() {
        String[] filters = filterMap.values().toArray(new String[filterMap.size()]);
        return getStringFilterChain(filters);
    }

    public StringFilter getStringFilterChain(String[] filters) {
        if (filters == null || filters.length == 0) {
            return new EmptyFilter();
        }
        StringFilter[] stringFilters = new StringFilter[filters.length];
        for (int i = filters.length - 1; i >= 0; i--) {
            stringFilters[i] = getStringFilter(filters[i]);
            if (i != filters.length - 1) {
                stringFilters[i].setNextStringFilter(stringFilters[i + 1]);
            } else {
                stringFilters[i].setNextStringFilter(null);
            }
        }
        return stringFilters[0];
    }

    public StringFilter getStringFilter(String key) {
        if (key != null) {
            try {
                //通过类名反射得到过滤器的实例
                Class clazz = Class.forName(filterMap.get(key));
                StringFilter stringFilter = (StringFilter) clazz.newInstance();
                return stringFilter;
            } catch (ClassNotFoundException e) {
                logger.error(e.getMessage(), e);
            } catch (InstantiationException e) {
                logger.error(e.getMessage(), e);
            } catch (IllegalAccessException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return new EmptyFilter();
    }


}
