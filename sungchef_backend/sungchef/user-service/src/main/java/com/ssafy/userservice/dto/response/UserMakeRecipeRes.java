package com.ssafy.userservice.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class UserMakeRecipeRes {
	int makeRecipeCount;
	List<UserMakeRecipe> makeRecipeList;
}
