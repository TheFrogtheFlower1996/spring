import com.zh.statics.AgencyProxy;
import com.zh.statics.RentHouse;
import com.zh.statics.You;

/**
 * @author zh
 * @date 2022/3/29 16:08
 * @description:说明 静态代理测试
 */
public class StarterProxy {
    public static void main(String[] args) {

        AgencyProxy proxy = new AgencyProxy(new You());
        proxy.toRentHouse();

    }
}
