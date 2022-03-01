package com.recapProject.WoodWorldBeta.business.Dtos.categoryDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryDto {

    private String Id;

    private String categoryName;

    private String categoryDescription;

}
