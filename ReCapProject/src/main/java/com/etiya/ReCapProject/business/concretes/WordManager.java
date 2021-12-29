package com.etiya.ReCapProject.business.concretes;

import com.etiya.ReCapProject.business.abstracts.WordService;
import com.etiya.ReCapProject.business.dtos.WordSearchListDto;
import com.etiya.ReCapProject.business.requests.wordRequests.CreateWordRequest;
import com.etiya.ReCapProject.core.utilities.mapping.ModelMapperService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.dataAccess.abstracts.WordDao;
import com.etiya.ReCapProject.entities.concretes.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordManager implements WordService {

    private WordDao wordDao;
    private ModelMapperService modelMapperService;

    @Autowired
    public WordManager(WordDao wordDao,ModelMapperService modelMapperService) {
        this.wordDao = wordDao;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public DataResult<WordSearchListDto> getByKey(String key) {
        Word word = this.wordDao.getWordsByKey(key);
        WordSearchListDto wordSearchListDto = modelMapperService.forDto().map(word,WordSearchListDto.class);
        return new SuccessDataResult<WordSearchListDto>(wordSearchListDto);
    }

    @Override
    public Result add(CreateWordRequest createWordRequest) {
        return null;
    }
}
