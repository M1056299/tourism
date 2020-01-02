package com.mindtree.tourismapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.tourismapplication.dto.TourismDto;
import com.mindtree.tourismapplication.entity.Hotel;
import com.mindtree.tourismapplication.entity.State;
import com.mindtree.tourismapplication.entity.Tourism;

@Service
public interface TravelTourismService {

	public State registerStateToDatabase(State state);

	public List<State> getAllStatesFromDataBase();

	public Tourism addTourismDetails(int stateId, Tourism tourism);

	public List<TourismDto> getAllTourismPlacesByStateId(int stateId);

	public Hotel addHotelToDatabase(int tourismId, Hotel hotel);

}
