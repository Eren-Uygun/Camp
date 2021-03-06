package reCapWorkshop.business.concretes;

import java.util.List;

import reCapWorkshop.business.abstracts.ColorService;
import reCapWorkshop.core.utilities.results.DataResult;
import reCapWorkshop.core.utilities.results.Result;
import reCapWorkshop.dataAccess.abstracts.ColorRepository;
import reCapWorkshop.entities.concretes.Color;

public class ColorManager implements ColorService {

	private ColorRepository colorRepository;
	

	public ColorManager(ColorRepository colorRepository) {
		super();
		this.colorRepository = colorRepository;
	}

	@Override
	public Result add(Color entity) {
		// TODO Auto-generated method stub
		return colorRepository.add(entity);
	}

	@Override
	public Result update(Color entity,int id) {
		return colorRepository.update(entity,id);
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
