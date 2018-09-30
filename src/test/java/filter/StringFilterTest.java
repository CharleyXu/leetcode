package filter;

import com.xu.design_patterns.filter.StringFilter;
import com.xu.design_patterns.filter.StringFilterFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CharleyXu Created on 2018/9/28.
 */
public class StringFilterTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void filterTest() {
        String chains = "js,html";
        StringFilter stringFilter = StringFilterFactory.getInstance()
                .getStringFilterChain(chains);
        String string = "<script>123</script>''<b>aaaa</b>stringFilter<<<<<wd1<script>";
        String result = stringFilter.filter(string);
        logger.info(result);
    }

}
