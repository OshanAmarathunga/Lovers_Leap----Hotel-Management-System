package edu.ijse.lovers_leap.dao.custom.impl;

import edu.ijse.lovers_leap.dao.CrudUtil;
import edu.ijse.lovers_leap.dao.custom.HotelDetailDao;
import edu.ijse.lovers_leap.entity.HotelDetailEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class HotelDetailDaoImpl implements HotelDetailDao {
    @Override
    public boolean add(HotelDetailEntity ety) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO hotelbranchdetail (NAME,ADDRESS,District,Contact_No) VALUES(?,?,?,?)",ety.getName(),ety.getAddress(),ety.getDistrict(),ety.getContactNo());
    }

    @Override
    public HotelDetailEntity get(Integer id) throws Exception {
        return null;
    }

    @Override
    public HotelDetailEntity getId(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<HotelDetailEntity> getAll() throws Exception {
        ResultSet rs=CrudUtil.executeQuery("SELECT * FROM hotelbranchdetail");
        ArrayList<HotelDetailEntity> enty=new ArrayList<>();
        while (rs.next()){
            enty.add(new HotelDetailEntity(rs.getInt("Hotel_ID"),rs.getString("NAME"),rs.getString("ADDRESS"),rs.getString("District"),rs.getString("Contact_No")));
        }
        return enty;
    }

    @Override
    public boolean update(HotelDetailEntity ety) throws Exception {
        return CrudUtil.executeUpdate("UPDATE hotelbranchdetail SET NAME=?,ADDRESS=?,District=?,Contact_No=? WHERE Hotel_ID=?",ety.getName(),ety.getAddress(),ety.getDistrict(),ety.getContactNo(),ety.getHotel_ID());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM hotelbranchdetail WHERE Hotel_ID=?",id);
    }
}
