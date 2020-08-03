package jdbc;

/**
 * @className: GetTable
 * @description: TODO
 * @author: zyd
 * @date: 2020/8/3 21:31
 * @version: 1.0
 */
public class GetTableName {

    /**
     * TODO 根据用户id取模，获取用户表命
     * @param baseTableName
	 * @param id
     * @return java.lang.String
     * @author zyd
     * @date 21:33 2020/8/3
     **/
    public static String getUserTableName(String baseTableName, Integer id) {
        if (id % 2 == 0) {
            return baseTableName + "2";
        } else {
            return baseTableName + "1";
        }
    }
}
