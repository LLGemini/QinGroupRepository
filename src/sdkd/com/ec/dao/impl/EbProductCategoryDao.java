package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbProductCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qin on 2016-07-07.
 */
public class EbProductCategoryDao extends BaseDao{
    public List<EbProductCategory> getCategories()
    {
        List<EbProductCategory> list = new ArrayList<EbProductCategory>();
        String sql = "select * from easybuy_product_category";
        ResultSet rs = this.executeSearch(sql,null);
        try {
            while(rs.next())
            {
                EbProductCategory category = new EbProductCategory();
                category.setEpc_id(rs.getInt("epc_id"));
                category.setEpc_name(rs.getString("epc_name"));
                category.setEpc_parent_id(rs.getInt("epc_parent_id"));
                list.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
}
