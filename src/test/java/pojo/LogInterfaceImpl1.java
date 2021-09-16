package pojo;

import java.util.ArrayList;
import java.util.List;

public class LogInterfaceImpl1 extends ILogBase implements LogInterface<BaseReqImpl1> {


    @Override
    public void bizDispose(BaseRequest req) {
        List<BaseReqImpl1> logs = List.class.cast(req.getLogs());
        for (BaseReqImpl1 log : logs) {
            System.out.println("address:" + log.getAddress());

            //业务逻辑、权限校验、过滤

        }

        //封装数据、存入到es
//        super.esDataSave(null);
    }

    @Override
    public List<BaseReqImpl1> userLoginLogList(BaseQuery query) {
        List<BaseReqImpl1> result = new ArrayList<>();
        BaseReqImpl1 baseReqImpl1 = new BaseReqImpl1();
        baseReqImpl1.setUserId("libo");
        baseReqImpl1.setAddress("ccbim查询");
        result.add(baseReqImpl1);
        return result;
    }
}
