package daily.control;

import daily.util.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 王金飞 on 2016/10/13.
 */
public class ShowId {

    // 查询已存在用户或日报数量
    public int showId(String str) {

         int max = 0;
        List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
        String strSql = "select max(id) id from " + str;

        listResult = DBUtils.queryTable(strSql);

        //遍历daily_，返回id

        for (Map<String, Object> map : listResult) {


            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                //获取id最大数
                max = (int)value;
            }

        }
        return max;
    }
}
