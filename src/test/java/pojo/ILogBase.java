package pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ILogBase {

    protected  <T extends BaseReq> void esDataSave(T... wrapperList) {
        List<T> result = new ArrayList<T>(Arrays.asList(wrapperList));
        System.out.println(result);
        //esBo.index(result)
    }

}
