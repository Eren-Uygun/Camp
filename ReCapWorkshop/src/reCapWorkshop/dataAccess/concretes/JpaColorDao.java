package reCapWorkshop.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import reCapWorkshop.core.utilities.results.DataResult;
import reCapWorkshop.core.utilities.results.Result;
import reCapWorkshop.core.utilities.results.SuccessDataResult;
import reCapWorkshop.core.utilities.results.SuccessResult;
import reCapWorkshop.dataAccess.abstracts.ColorRepository;
import reCapWorkshop.entities.concretes.Color;

public class JpaColorDao implements ColorRepository {

	private List<Color> colors;

	public JpaColorDao() {
		colors = new ArrayList<Color>();
	}

	@Override
	public Result add(Color entity) {
		colors.add(entity);
		return new SuccessResult("Renk eklendi.");
	}

	@Override
	public Result update(Color entity,int id) {
		Color color = colors.get(entity.getColorId());
		color.setColorName(entity.getColorName());
		colors.set(entity.getColorId(), color);
		return new SuccessResult("Renk bilgisi gŁncellendi.");
	}

	@Override
	public Result delete(Color entity) {
		colors.remove(entity);
		return new SuccessResult("Renk bilgis silindi.");
	}

	@Override
	public DataResult<Color> getById(int id) {
		return new SuccessDataResult<Color>(colors.get(id),"Renk bilgisi getirildi.");
	}

	@Override
	public DataResult<List<Color>> getAll() {
		return new SuccessDataResult<List<Color>>(colors,"Renk bilgileri getirildi.");
	}

}
