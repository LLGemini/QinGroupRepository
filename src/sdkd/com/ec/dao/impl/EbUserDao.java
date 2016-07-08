package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户DAO
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUserDao extends BaseDao{
    public EbUser verify(String userName, String passWord)
    {
        ResultSet rs=null;
        String name=null;
        String password=null;
        EbUser re_user = null;
        String sql = "select * from easybuy_user where eu_user_name = ?";
        try {
            List<String> params = new ArrayList<String>();
            params.add(userName);
            rs = this.executeSearch(sql,params);
            rs.next();

            password=rs.getString("eu_password").trim();

            if(password.equals(passWord))
            {
                re_user = new EbUser();
                re_user.setEu_address(rs.getString("eu_address"));
                re_user.setEu_birthday(rs.getDate("eu_birthday"));
                re_user.setEu_mobile(rs.getString("eu_mobile"));
                re_user.setEu_email(rs.getString("eu_email"));
                re_user.setEu_identity_code(rs.getString("eu_identity_code"));
                re_user.setEu_password(rs.getString("eu_password"));
                re_user.setEu_user_name(rs.getString("eu_user_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return re_user;

    }
    public void addUser(EbUser new_user)
    {
        ResultSet rs=null;
        String sql = "insert into easybuy_user(eu_user_name,eu_password) values(?,?)";
        List<String> params = new ArrayList<String>();
        params.add(new_user.getEu_user_name());
        params.add(new_user.getEu_password());
        this.exeucteModify(sql,params);


    }
}
