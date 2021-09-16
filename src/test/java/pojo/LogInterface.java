package pojo;

import java.util.List;

public interface LogInterface<T extends BaseReq> {

    /**
     * 添加用户登陆日志
     *
     * @param req 用户登陆日志基础请求
     */
    void bizDispose(BaseRequest req);


    /**
     * 用户登陆日志列表
     *
     * @param query 列表查询
     * @return 子类的日志数据
     */
    List<T> userLoginLogList(BaseQuery query);


}
