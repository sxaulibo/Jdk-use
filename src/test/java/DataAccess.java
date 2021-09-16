import com.alibaba.fastjson.JSON;
import pojo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataAccess {

    private static String SOURCE = "pojo.LogInterfaceImpl1";

    private static final HashMap<String, String> map = new HashMap<>();

    public DataAccess() {
        map.put("CCBIM", "pojo.LogInterfaceImpl1");
        map.put("SAFE", "pojo.LogInterfaceImpl2");
    }

    public void addUserLoginLog(BaseRequest req) throws Exception {
        Class<?> aClass = Class.forName(map.get(req.getSourceSoftware()));
        ((LogInterface) aClass.getDeclaredConstructor().newInstance()).bizDispose(req);
    }

    public List userLoginLogList(BaseQuery query) throws Exception {
        Class<?> aClass = Class.forName(map.get(query.getSourceSoftware()));
        return ((LogInterface) aClass.getDeclaredConstructor().newInstance()).userLoginLogList(query);
    }


    public static void main(String[] args) throws Exception {
        DataAccess dataAccess = new DataAccess();
        BaseRequest<BaseReqImpl1> baseRequest1 = new BaseRequest<BaseReqImpl1>();
        baseRequest1.setSourceSoftware("CCBIM");
        List<BaseReqImpl1> log1s = new ArrayList<>();
        BaseReqImpl1 log1 = new BaseReqImpl1();
        log1.setAddress("ccbim手机端上传");
        log1s.add(log1);
        baseRequest1.setLogs(log1s);



        BaseRequest<BaseReqImpl2> baseRequest2 = new BaseRequest<BaseReqImpl2>();
        baseRequest2.setSourceSoftware("SAFE");
        List<BaseReqImpl2> log2s = new ArrayList<>();
        BaseReqImpl2 log2 = new BaseReqImpl2();
        log2.setWeight("安全软件");
        log2s.add(log2);
        baseRequest2.setLogs(log2s);
        dataAccess.addUserLoginLog(baseRequest2);

        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setSourceSoftware("CCBIM");
        List list = dataAccess.userLoginLogList(baseQuery);
        System.out.println(JSON.toJSON(list));
    }

}
