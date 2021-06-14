import com.sun.prism.impl.packrect.RectanglePacker;
import com.sxau.proxy.iProxy.GPMatchMaker;
import com.sxau.proxy.iProxy.IPerson;
import com.sxau.proxy.iProxy.WoMan;
import com.sxau.proxy.jdk.MeiPo;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void libo() {
        // mock creation
        List mockedList = mock(List.class);

        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        // selective, explicit, highly readable verification
        verify(mockedList).add(null);
        verify(mockedList).clear();

    }

    private RectanglePacker verify(List mockedList) {
        return null;
    }

    @Test
    public void stubMethod() {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");

        // the following prints "first"
        System.out.println(mockedList.get(0));

        // the following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));
    }


}
