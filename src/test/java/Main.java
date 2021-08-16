import com.sxau.proxy.iProxy.GPMatchMaker;
import com.sxau.proxy.iProxy.IPerson;
import com.sxau.proxy.iProxy.WoMan;
import com.sxau.proxy.jdk.MeiPo;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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
//        verify(mockedList).add(null);
//        verify(mockedList).clear();

    }
/*
    private RectanglePacker verify(List mockedList) {
        return null;
    }*/

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

    @Test
    public void versionId(){
        /*class Man{
            Integer age;
            String versionName;

            public Man(Integer age, String versionName) {
                this.age = age;
                this.versionName = versionName;
            }

            @Override
            public String toString() {
                return "Man{" +
                        "age=" + age +
                        ", versionName='" + versionName + '\'' +
                        '}';
            }
        }
        Man adsd1 = new Man(1, "18.3.1");
        Man adsd2 = new Man(3, "18.3.2");
        Man adsd3 = new Man(2, "18.3.3");
        Man adsd4 = new Man(3, "18.3.4");

        List<Man> list = new ArrayList<>();
        list.add(adsd1);
        list.add(adsd2);
        list.add(adsd3);
        list.add(adsd4);

        Man man = list.stream().max(Comparator.comparing(x -> x.age)).get();
        System.out.println(man);
        System.out.println("=====================");
        List<Man> collect = list.stream().filter(x -> x.age == 2).collect(Collectors.toList());
        System.out.println(collect);*/


        System.out.println(Main.compareVersion("7.5.2.4","7.5.3"));

    }

    public static String compareVersion(String version1, String version2) {

        // 两个字符串的长度
        int n = version1.length(), m = version2.length();

        int i = 0;
        int j = 0;

        while (i < n || j < m) {
            // 用v1,v2来计算每一个块中版本号的大小
            int v1 = 0;
            int v2 = 0;

            // 若当前的字符不是分隔符，则计算
            while (i < n && version1.charAt(i) != '.') {
                v1 = v1 * 10 + version1.charAt(i) - '0';
                i++;
            }

            while (j < m && version2.charAt(j) != '.') {
                v2 = v2 * 10 + version2.charAt(j) - '0';
                j++;
            }
            // 判断当前块中的版本号是否一致
            if (v1 != v2) {
                if (v1 > v2) {
                    return version1;
                }
                return version2;
            }
            // 跳过分隔符
            i++;
            j++;
        }

        // 全部比较完了，没有不等的则返回0
        return version1;

    }


}
