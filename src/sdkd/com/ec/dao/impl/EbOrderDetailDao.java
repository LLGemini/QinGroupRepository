package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbOrder;
import sdkd.com.ec.model.EbOrderDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flower on 2016/7/11.
 */
public class EbOrderDetailDao extends BaseDao {
    /*private int eod_id;
    private int eo_id;
    private int ep_id;
    private int eod_quantity;
    private double eod_cost;*/
    public void saveOrderDeatil(EbOrderDetail detail) {
        String sql = "insert into easybuy_order_detail(eo_id,ep_id,eod_quantity,eod_cost) values(?,?,?,?)";
        List<String> params = new ArrayList<String>();
        params.add(detail.getEo_id()+"");
        params.add(detail.getEp_id()+"");
        params.add(detail.getEod_quantity()+"");
        params.add(detail.getEod_cost()+"");

        this.exeucteModify(sql,params);
    }
}
