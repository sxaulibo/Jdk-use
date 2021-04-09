import com.sxau.proxy.iProxy.GPMatchMaker;
import com.sxau.proxy.iProxy.IPerson;
import com.sxau.proxy.iProxy.WoMan;
import com.sxau.proxy.jdk.MeiPo;

public class Main {

    public static void main(String[] args) {
        GPMatchMaker matchMaker = new GPMatchMaker();

        IPerson man = matchMaker.getInstance(() -> System.out.println("我叫libo,喜欢你"));
        IPerson woman = matchMaker.getInstance(new WoMan());

        MeiPo meiPo = new MeiPo();
        IPerson proxy = meiPo.getInstance(new IPerson() {
            @Override
            public void findLove() {
                System.out.println("我是李小博，我喜欢ni");
            }
        });

        proxy.findLove();
    }
}
