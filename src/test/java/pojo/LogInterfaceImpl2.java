package pojo;

import java.util.List;

public class LogInterfaceImpl2 extends ILogBase implements LogInterface<BaseReqImpl2> {
    @Override
    public void bizDispose(BaseRequest req) {
        List<BaseReqImpl2> logs = List.class.cast(req.getLogs());

        for (BaseReqImpl2 log : logs) {
            System.out.println("weight:" + log.getWeight());

            //业务逻辑、权限校验、过滤

        }

        //封装数据、存入到es
//        super.esDataSave(null);
    }

    @Override
    public List<BaseReqImpl2> userLoginLogList(BaseQuery query) {
        return null;
    }
}
