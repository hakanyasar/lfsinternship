package com.lfsinternship.service.impl;

import java.util.List;

import com.lfsinternship.model.intern.Position;
import com.lfsinternship.repository.PositionRepository;
import com.lfsinternship.repository.impl.PositionRepositoryImpl;
import com.lfsinternship.service.PositionService;

public class PositionServiceImpl implements PositionService{

	private PositionRepository positionRepository = new PositionRepositoryImpl();

	@Override
	public Position savePosition(Position position) {

		Position tempPosition = this.positionRepository.savePosition(position);
		
		return tempPosition;
	}

	@Override
	public Position updatePosition(Position position) {

		Position tempPosition = this.positionRepository.updatePosition(position);
		
		return tempPosition;
	}

	@Override
	public Position removePosition(Position position) {

		Position tempPosition = this.positionRepository.removePosition(position);
		
		return tempPosition;
	}

	@Override
	public List<Position> findPositions() {

		List<Position> tempPositions = this.positionRepository.findPositions();
		
		return tempPositions;
	}

	@Override
	public Position findById(Integer id) {

		Position tempPosition = this.positionRepository.findById(id);
		
		return tempPosition;
	}

	@Override
	public Position findWithInternshipById(Integer id) {

		Position tempPosition = this.positionRepository.findWithInternshipById(id);
		
		return tempPosition;
	}

	@Override
	public List<Position> findWithInternshipByPositionName(String name) {

		List<Position> tempPositions = this.positionRepository.findWithInternshipByPositionName(name);
		
		return tempPositions;
	}

	@Override
	public Position findWithStudentById(Integer id) {

		Position tempPosition = this.positionRepository.findWithStudentById(id);
		
		return tempPosition;
	}

	@Override
	public List<Position> findWithStudentByPositionName(String name) {

		List<Position> tempPositions = this.positionRepository.findWithStudentByPositionName(name);
		
		return tempPositions;
	}
	
	
}
