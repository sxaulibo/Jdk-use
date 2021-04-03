import com.example.java.proxy.iProxy.GPMatchMaker;
import com.example.java.proxy.iProxy.IPerson;

public class Main {

    public static void main(String[] args) {
        GPMatchMaker matchMaker = new GPMatchMaker();

        IPerson man = matchMaker.getInstance(() -> System.out.println("我叫libo,喜欢你"));
        man.findLove();
    }
}
