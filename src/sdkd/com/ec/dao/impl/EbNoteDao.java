package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flower on 2016/7/8.
 */
public class EbNoteDao extends BaseDao {
    public List<EbNote> getRecentNote(){
        List<EbNote> noteList = new ArrayList<EbNote>();
        String sql = "select * from easybuy_note order by en_create_time desc limit 0,7";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbNote note = new EbNote();
                note.setEn_id(rs.getInt("en_id"));
                note.setEn_title(rs.getString("en_title"));
                note.setEn_create_time(rs.getTimestamp("en_create_time"));
                note.setEn_content(rs.getString("en_content"));
                //添加到集合中
                noteList.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noteList;
    }
    public EbNote getNoteById(int id){
        EbNote note = new EbNote();
        String sql = "select * from easybuy_note where en_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(""+id);
        try {
            ResultSet rs = this.executeSearch(sql,params);
            while (rs.next()){
                note.setEn_id(rs.getInt("en_id"));
                note.setEn_title(rs.getString("en_title"));
                note.setEn_create_time(rs.getTimestamp("en_create_time"));
                note.setEn_content(rs.getString("en_content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return note;
    }
}
