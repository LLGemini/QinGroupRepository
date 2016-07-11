package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by qin on 2016-07-06.
 */
public class EbProductDao extends BaseDao {
    /**
     * 热卖商品
     * @return
     */
    public List<EbProduct> getHotProduct()
    {
        List<EbProduct> list = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product order by ep_stock asc limit 0,7";
        ResultSet rs = this.executeSearch(sql,null);
        try {
            while (rs.next()){
                EbProduct product = new EbProduct();
                product.setEp_id(rs.getInt("ep_id"));
                product.setEp_name(rs.getString("ep_name"));
                product.setEp_description(rs.getString("ep_description"));
                product.setEp_price(rs.getDouble("ep_price"));
                product.setEp_stock(rs.getInt("ep_stock"));
                product.setEpc_id(rs.getInt("epc_id"));
                product.setEpc_child_id(rs.getInt("epc_child_id"));
                product.setEp_file_name(rs.getString("ep_file_name"));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    /**
     * 促销商品
     * @return
     */
    public List<EbProduct> getPromotionProduct()
    {
        List<EbProduct> list = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product order by ep_stock asc limit 0,7";
        ResultSet rs = this.executeSearch(sql,null);
        try {
            while (rs.next()){
                EbProduct product = new EbProduct();
                product.setEp_id(rs.getInt("ep_id"));
                product.setEp_name(rs.getString("ep_name"));
                product.setEp_description(rs.getString("ep_description"));
                product.setEp_price(Double.valueOf(rs.getString("ep_price").trim()));
                product.setEp_stock(rs.getInt("ep_stock"));
                product.setEpc_id(rs.getInt("epc_id"));
                product.setEpc_child_id(rs.getInt("epc_child_id"));
                product.setEp_file_name(rs.getString("ep_file_name"));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据商品ID获取商品信息
     * @param product_id
     * @return
     */
    public EbProduct getProductById(int product_id)
    {
        EbProduct ep = new EbProduct();
        String sql = "select * from easybuy_product where ep_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(product_id+"");
        ResultSet rs = this.executeSearch(sql,params);
        try {
            rs.next();
            ep.setEp_id(rs.getInt("ep_id"));

            ep.setEpc_id(rs.getInt("epc_id"));
            ep.setEp_name(rs.getString("ep_name"));

            ep.setEp_file_name(rs.getString("ep_file_name"));
            ep.setEp_stock(rs.getInt("ep_stock"));
            ep.setEpc_child_id(rs.getInt("epc_child_id"));
            ep.setEp_description(rs.getString("ep_description"));
            ep.setEp_price(rs.getDouble("ep_price"));
            ep.setEp_dicount(rs.getInt("ep_discount"));
            ep.setEp_view(rs.getInt("ep_view"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ep;
    }

    /**
     * 获得最近浏览的商品列表
     * @return 最近浏览的商品列表
     */
    public List<EbProduct> getRecentVisitedProduct(String list) {
        List<EbProduct> productList = new ArrayList<EbProduct>();
        int count = Integer.parseInt(this.getPro("recentViewedProductCount").trim()); // 返回前x条浏览记录
        // 获取前x条记录
        if(list != null && !"".equals(list)) {
            String[] items = list.split(",");
            if(items.length >= count) {
                for(int i = items.length-1; i >= items.length-count; i--) {
                    productList.add(getProductById(Integer.parseInt(items[i])));
                }
            } else {
                for(int i = items.length-1; i>=0; i--) {
                    productList.add(getProductById(Integer.parseInt(items[i])));
                }
            }
        }
        return productList;
    }

    /**
     * 获得所有商品列表
     * @return 所有商品列表
     */
    public List<EbProduct> getProductsList()
    {
        List<EbProduct> list = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product";
        ResultSet rs = this.executeSearch(sql,null);
        try {
            while (rs.next()){
                EbProduct product = new EbProduct();
                product.setEp_id(rs.getInt("ep_id"));
                product.setEp_name(rs.getString("ep_name"));
                product.setEp_description(rs.getString("ep_description"));
                product.setEp_price(rs.getDouble("ep_price"));
                product.setEp_stock(rs.getInt("ep_stock"));
                product.setEpc_id(rs.getInt("epc_id"));
                product.setEpc_child_id(rs.getInt("epc_child_id"));
                product.setEp_file_name(rs.getString("ep_file_name"));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 更新商品库存
     * @param proId 商品编号
     * @param quantity 数量
     */
    public void updateStock(int proId, int quantity){
        String sql = "update easybuy_product set ep_stock = ep_stock-? where ep_id = ?";
        List<String> params = new ArrayList<String>();
    }
}
