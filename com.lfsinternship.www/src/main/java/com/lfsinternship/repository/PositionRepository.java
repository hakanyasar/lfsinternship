package com.lfsinternship.repository;

import java.util.List;

import com.lfsinternship.model.intern.Position;

public interface PositionRepository {

	Position savePosition(Position position);
	
	Position updatePosition(Position position);
	
	Position removePosition(Position position);
	
	List<Position> findPositions();
	
	Position findById(Integer id);
	
	Position findWithInternshipById(Integer id);
	
	List<Position> findWithInternshipByPositionName(String name);
	
	Position findWithStudentById(Integer id);
	
	List<Position> findWithStudentByPositionName(String name);
	
}
