package edu.ijse.lovers_leap.service.custom.impl;

import edu.ijse.lovers_leap.dao.DaoFactory;
import edu.ijse.lovers_leap.dao.custom.ReservationDao;
import edu.ijse.lovers_leap.dto.ReservationDto;
import edu.ijse.lovers_leap.entity.ReservationEntity;
import edu.ijse.lovers_leap.service.custom.ReservationService;

import java.util.ArrayList;

public class ReservationServiceImpl implements ReservationService {
    private ReservationDao reservationDao= (ReservationDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.RESERVATION);

    @Override
    public String saveReservation(ReservationDto dto) throws Exception {

        if(reservationDao.add(new ReservationEntity(dto.getCustomerId(),
                dto.getInDate(),
                dto.getOutDate(),
                dto.getBookingStatus(),
                dto.getRoomNo(),
                dto.getGuests(),
                dto.getBookedDate(),
                dto.getBookedTime()))){
            return "Successfully Booked the room!";
        }else {
            return "Fail to Book!";
        }
    }

    @Override
    public String updateReservation(ReservationDto dto) throws Exception {
        if(reservationDao.update(new ReservationEntity(dto.getReservationId(),dto.getCustomerId(),dto.getInDate(),dto.getOutDate(),dto.getBookingStatus(),dto.getRoomNo(),dto.getGuests(),dto.getBookedDate(),dto.getBookedTime()))){
            return "Successfully updated the Reservation!";
        }else {
            return "Fail to update!";
        }
    }

    @Override
    public String deleteReservation(int id) throws Exception {
        if(reservationDao.delete(id)){
            return "Successfully deleted the Reservation !";
        }else {
            return "Fail to delete!";
        }
    }

    @Override
    public ArrayList<ReservationDto> getAll() throws Exception {
        ArrayList<ReservationDto> dlist=new ArrayList<>();
        ArrayList<ReservationEntity> ety=reservationDao.getAll();
        for(ReservationEntity entity:ety){
            dlist.add(new ReservationDto(entity.getReservationId(),entity.getCustomerId(),entity.getInDate(),entity.getOutDate(),entity.getBookingStatus(),entity.getRoomNo(),entity.getNoOfGuests(),entity.getBookedDate(),entity.getBookedTime()));
        }
        return dlist;
    }
}
