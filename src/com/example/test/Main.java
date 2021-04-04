import com.example.java.proxy.iProxy.GPMatchMaker;
import com.example.java.proxy.iProxy.IPerson;
import com.example.java.proxy.iProxy.WoMan;
import com.example.java.proxy.jdk.MeiPo;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Main {

    public static void main(String[] args) {
        /*GPMatchMaker matchMaker = new GPMatchMaker();

        IPerson man = matchMaker.getInstance(() -> System.out.println("我叫libo,喜欢你"));
        IPerson woman = matchMaker.getInstance(new WoMan());*/

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
