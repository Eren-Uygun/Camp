package com.etiya.ReCapProject.business.abstracts;

import com.etiya.ReCapProject.business.dtos.WordSearchListDto;
import com.etiya.ReCapProject.business.requests.wordRequests.CreateWordRequest;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.Word;

public interface WordService {
    DataResult<WordSearchListDto> getByKey(String key);
    Result add(CreateWordRequest createWordRequest);
}
