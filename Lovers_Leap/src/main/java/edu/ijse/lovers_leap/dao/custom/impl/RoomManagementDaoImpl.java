package edu.ijse.lovers_leap.dao.custom.impl;

import edu.ijse.lovers_leap.dao.custom.RoomManagementDao;
import edu.ijse.lovers_leap.entity.RoomManagementEntity;

import java.util.ArrayList;

public class RoomManagementDaoImpl implements RoomManagementDao {
    @Override
    public boolean add(RoomManagementEntity roomManagementEntity) throws Exception {
        return false;
    }

    @Override
    public RoomManagementEntity get(Integer id) throws Exception {
        return null;
    }

    @Override
    public RoomManagementEntity getId(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RoomManagementEntity> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean update(RoomManagementEntity roomManagementEntity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return false;
    }

    @Override
    public boolean deleteRoomByStringID(String sId) throws Exception {
        return false;
    }
}
