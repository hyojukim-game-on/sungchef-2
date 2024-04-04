package com.ssafy.recipeservice.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecipeStep {
	int recipeDetailStep;
	String recipeDetailImage;
	String recipeDetailDescription;
}
