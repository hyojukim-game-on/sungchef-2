package com.ssafy.ingredientservice.dto.response;

import com.ssafy.ingredientservice.util.sungchefEnum.IngredientType;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeIngredientListRes {
	int recipeId;
	@Getter
	List<RecipeIngredientInfo> recipeIngredientInfoList;
	public RecipeIngredientListRes(int recipeId) {
		this.recipeId = recipeId;
		recipeIngredientInfoList = new ArrayList<>();
		for (int i = 0; i < IngredientType.values().length; i++) {
			recipeIngredientInfoList.add(
				new RecipeIngredientInfo(
					IngredientType.values()[i]
				)
			);
		}
	}

}
