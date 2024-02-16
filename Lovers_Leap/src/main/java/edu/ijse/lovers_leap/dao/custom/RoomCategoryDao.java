package edu.ijse.lovers_leap.dao.custom;

import edu.ijse.lovers_leap.dao.CrudDao;
import edu.ijse.lovers_leap.entity.RoomCategoryEntity;

public interface RoomCategoryDao extends CrudDao<RoomCategoryEntity,String, Integer> {
    RoomCategoryEntity getIdByStaringName(String sName) throws Exception;
}
