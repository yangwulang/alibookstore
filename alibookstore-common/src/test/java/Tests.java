import com.yangwulang.utils.ParseToBeanImpl;
import com.yangwulang.utils.RedisUtils;
import org.junit.jupiter.api.Test;

class Tests {
    RedisUtils redisUtils = new RedisUtils();
    @Test
   void testd(){
        System.out.println(redisUtils.exists("366604910712111104"));
    }
    void ss(){
        ParseToBeanImpl i = new ParseToBeanImpl();

    }
}
