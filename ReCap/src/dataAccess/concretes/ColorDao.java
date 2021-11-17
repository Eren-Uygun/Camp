package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import core.utilities.results.DataResult;
import core.utilities.results.Result;
import core.utilities.results.SuccessDataResult;
import core.utilities.results.SuccessResult;
import dataAccess.abstracts.ColorRepository;
import entities.Color;

public class ColorDao implements ColorRepository {
	
	private List<Color> colors;
	
	

	public ColorDao() {
		this.colors = new ArrayList<Color>();
	}

	@Override
	public Result insert(Color entity) {
		colors.add(entity);
		return new SuccessResult("Veri tabanına Eklendi");
	}

	@Override
	public Result update(Color entity) {
		colors.set(entity.getColorId(), entity);
		return new SuccessResult("Veri güncellendi");
	}

	@Override
	public Result delete(Color entity) {
		colors.remove(entity.getColorId());
		return new SuccessResult("Veri tabanından silindi.");
	}

	@Override
	public DataResult<Color> getById(int id) {
		return new SuccessDataResult<Color>(colors.get(id), "Veri tabanından id ile getirildi.");
	}

	@Override
	public DataResult<List<Color>> getAll() {
		return new SuccessDataResult<List<Color>>(colors,"Veriler getirildi.");
	}

}
