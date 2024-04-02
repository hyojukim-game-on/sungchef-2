package com.ssafy.sungchef.data.datasource.refrigerator

import com.ssafy.sungchef.commons.DataState
import com.ssafy.sungchef.data.api.RefrigeratorService
import com.ssafy.sungchef.data.datasource.BaseRemoteDataSource
import com.ssafy.sungchef.data.model.APIError
import com.ssafy.sungchef.data.model.requestdto.IngredientRequestDTO
import com.ssafy.sungchef.data.model.responsedto.ResponseDto
import com.ssafy.sungchef.data.model.responsedto.ingredient.search.SearchIngredientResponse
import okhttp3.MultipartBody
import javax.inject.Inject

class RefrigeratorDataSourceImpl @Inject constructor(
    private val refrigeratorService: RefrigeratorService
) : RefrigeratorDataSource, BaseRemoteDataSource() {
    override suspend fun searchIngredient(ingredientName: String): DataState<ResponseDto<List<SearchIngredientResponse>>> {
        return getResult {
            refrigeratorService.searchIngredient(ingredientName)
        }
    }

    override suspend fun registerIngredient(ingredientRequestDTO: IngredientRequestDTO): DataState<APIError> {
        return getResult {
            refrigeratorService.registerIngredient(ingredientRequestDTO)
        }
    }

    override suspend fun registerReceipt(convertImage: MultipartBody.Part?): DataState<ResponseDto<String>> {
        return getResult {
            refrigeratorService.registerReceipt(convertImage)
        }
    }
}