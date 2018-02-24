import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.netflix.zuul.ZuulFilter;

class PreFilter extends ZuulFilter{
    Logger logger = LoggerFactory.getLogger()
}