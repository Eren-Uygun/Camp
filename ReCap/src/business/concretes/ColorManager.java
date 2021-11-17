package business.concretes;

import java.util.List;

import business.abstracts.ColorService;
import core.utilities.results.DataResult;
import core.utilities.results.Result;
import dataAccess.abstracts.ColorRepository;
import entities.Color;

public class ColorManager implements ColorService {
	
	private ColorRepository colorRepository;
	
	

	public ColorManager(ColorRepository colorRepository) {
		super();
		this.colorRepository = colorRepository;
	}

	@Override
	public Result insert(Color entity) {
		// TODO Auto-generated method stub
		return colorRepository.insert(entity);
	}

	@Override
	public Result update(Color entity) {
		// TODO Auto-generated method stub
		return colorRepository.update(entity);
	}

	@Override
	public Result delete(Color entity) {
		// TODO Auto-generated method stub
		return colorRepository.delete(entity);
	}

	@Override
	public DataResult<Color> getById(int id) {
		// TODO Auto-generated method stub
		return colorRepository.getById(id);
	}

	@Override
	public DataResult<List<Color>> getAll() {
		// TODO Auto-generated method stub
		return colorRepository.getAll();
	}

}
