package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbOrder;
import sdkd.com.ec.model.EbProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flower on 2016/7/10.
 */
public class EbOrderDao extends BaseDao {
    public List<EbOrder> getOrdersList()
    {
        List<EbOrder> list = new ArrayList<EbOrder>();
        String sql = "select * from easybuy_order";
        ResultSet rs = this.executeSearch(sql,null);
        try {
            while (rs.next()){
                EbOrder order = new EbOrder();
                order.setEo_id(rs.getInt("eo_id"));
                order.setEo_user_id(rs.getInt("eo_user_id"));
                order.setEo_user_name(rs.getString("eo_user_name"));
                order.setEo_user_address(rs.getString("eo_user_address"));
                order.setEo_status(rs.getInt("eo_status"));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
