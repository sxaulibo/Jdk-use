import com.squareup.okhttp.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BizBoImpl implements BizBo {

    private static final ExecutorService executorService = new ThreadPoolExecutor(5, 20,
            20L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());


    @Override
    public List<String> getData() {

        try {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                throw new RuntimeException("运行时异常");
            });

        } catch (Exception e) {
            System.out.println("有异常啦");
        }

        System.out.println("嗯嗯呢");
        return null;
    }

    public static void main(String[] args) throws IOException {
//        BizBo bizBo = new BizBoImpl();
//        bizBo.getData();

        class Man{
            private String name;
            private Integer age;

            public Man(String name, Integer age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getAge() {
                return age;
            }

            public void setAge(Integer age) {
                this.age = age;
            }
        }

        int[] array1 = {1,2,3,4,5,6};
        int[] clone = array1.clone();
//        System.arraycopy(array1,1,array1,2,3);

        int[] array2=new int[array1.length];
        System.arraycopy(array1,0,array2,0,array1.length);
        System.out.println("");

        Man[] array3 = new Man[]{
                new Man("libo",23),new Man("libo1",23)
        };
        Man[] array4 = new Man[array3.length];
        System.arraycopy(array3,0,array4,0,array3.length);

        Man[] clone1 = array3.clone();
        clone1[0].age=99;
        System.out.println(" ");






        /*OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("{HOSTURL}/oauth/token?grant_type=client_credentials")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("authorization", "Basic YWQ4YjAwYjctOGE0NS0yYzkxLTgwODctMDAwMjA4NjQ1ZDQ2OmFkOGIwMGI3LThhNDUtMmM5MS04MDg3LTAwMDMwMDM5NDFhNA==")
                .build();
        Response response = client.newCall(request).execute();*/
    }
}
