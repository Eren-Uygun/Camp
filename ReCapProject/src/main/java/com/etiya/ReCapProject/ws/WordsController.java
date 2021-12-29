package com.etiya.ReCapProject.ws;

import com.etiya.ReCapProject.business.abstracts.WordService;
import com.etiya.ReCapProject.business.dtos.WordSearchListDto;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.entities.concretes.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/words")
public class WordsController {
    private WordService wordService;

    @Autowired
    public WordsController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("getByKey")
    public DataResult<WordSearchListDto> getByKey(String key){
        return this.wordService.getByKey(key);
    }
}
