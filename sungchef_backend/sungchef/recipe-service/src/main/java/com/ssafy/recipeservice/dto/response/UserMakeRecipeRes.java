package com.ssafy.recipeservice.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserMakeRecipeRes {
	int makeRecipeCount;
	List<UserMakeRecipe> makeRecipeList;
}
