package edu.ijse.lovers_leap.dao;

import edu.ijse.lovers_leap.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){

    }

    public static DaoFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoTypes daoTypes){
        switch (daoTypes){
            case RECEPTIONIST:
                return new ReceptionistDaoImpl();
            case CUSTOMER:
                return new CustomerDaoImpl();
            case HOTELDETAIL:
                return new HotelDetailDaoImpl();
            case ROOMCATEGORY:
                return new RoomCategoryDaoImpl();
            case ROOMMANAGEMENT:
                return new RoomManagementDaoImpl();
            case RESERVATION:
                return new ReservationDaoImpl();
            default:
                return null;
        }
    }

    public enum DaoTypes{
        RECEPTIONIST,CUSTOMER,HOTELDETAIL,ROOMCATEGORY,ROOMMANAGEMENT,RESERVATION;
    }
}
