package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.model.EbShoppingCar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qin on 2016-07-07.
 */
public class EbShoppingCarDao extends BaseDao{
    public List<EbShoppingCar> getShoppingCarList() {
        List<EbShoppingCar> list = new ArrayList<EbShoppingCar>();
        String sql = "select * from easybuy_shoppingcar";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbShoppingCar ec = new EbShoppingCar();
                ec.setEsh_product_id(rs.getInt("esh_product_id"));
                ec.setEsh_product_name(rs.getString("esh_product_name"));
                ec.setEsh_product_price(rs.getDouble("esh_product_price"));

                ec.setEsh_product_quantity(rs.getInt("esh_product_quantity"));
                ec.setEsh_user_id(rs.getInt("esh_user_id"));
                //添加到集合中
                list.add(ec);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void  addProduct(int product_id,int user_id)
    {
        EbProductDao epd = new EbProductDao();
        EbProduct ep = epd.getProductById(product_id);
        ResultSet rs=null;
        String sql = "insert into easybuy_shoppingcar values(?,?,?,?,?)";
        List<String> params = new ArrayList<String>();
        params.add(ep.getEp_id()+"");
        params.add(ep.getEp_name());
        params.add(ep.getEp_price()+"");
        params.add(ep.getEp_stock()+"");
        params.add(user_id+"");

        this.exeucteModify(sql,params);




    }
}
