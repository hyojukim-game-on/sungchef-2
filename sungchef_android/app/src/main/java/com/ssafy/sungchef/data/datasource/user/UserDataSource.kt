package com.ssafy.sungchef.data.datasource.user

import com.ssafy.sungchef.commons.DataState
import com.ssafy.sungchef.data.model.APIError
import com.ssafy.sungchef.data.model.requestdto.BookMarkRequest
import com.ssafy.sungchef.data.model.requestdto.ContactRequestDTO
import com.ssafy.sungchef.data.model.requestdto.SurveyRequestDTO
import com.ssafy.sungchef.data.model.requestdto.UserRequestDTO
import com.ssafy.sungchef.data.model.requestdto.UserSnsIdRequestDTO
import com.ssafy.sungchef.data.model.requestdto.UserUpdateRequestDTO
import com.ssafy.sungchef.data.model.responsedto.BookmarkRecipeList
import com.ssafy.sungchef.data.model.responsedto.MakeRecipeList

import com.ssafy.sungchef.data.model.responsedto.ResponseDto

import com.ssafy.sungchef.data.model.responsedto.UserSettingInfo

import com.ssafy.sungchef.data.model.responsedto.UserSimple
import com.ssafy.sungchef.data.model.responsedto.survey.SurveyResponse
import com.ssafy.sungchef.data.model.responsedto.token.TokenResponse
import com.ssafy.sungchef.data.model.responsedto.user.LoginResponse
import okhttp3.MultipartBody
import retrofit2.Response

interface UserDataSource {

    suspend fun duplicateNickname(nickname : String) : DataState<APIError>

    suspend fun userSimple() : UserSimple
    suspend fun makeRecipeList(page : Int) : MakeRecipeList;

    suspend fun bookmarkRecipeList(page : Int) : BookmarkRecipeList;

    suspend fun changeBookmarkRecipe(bookMarkRequest: BookMarkRequest): DataState<APIError>

    suspend fun surveySubmit(surveyRequestDTO: SurveyRequestDTO) : DataState<APIError>

    suspend fun getSurvey() : DataState<ResponseDto<SurveyResponse>>

    suspend fun userSettingInfo() : UserSettingInfo

    // 회원가입 api
    suspend fun signupUser(userRequestDTO: UserRequestDTO) : DataState<ResponseDto<TokenResponse>>

    suspend fun login(userSnsIdRequestDTO: UserSnsIdRequestDTO) : DataState<ResponseDto<LoginResponse>>

    suspend fun inquire(contactRequestDTO: ContactRequestDTO): Response<APIError>
    suspend fun updateUserInfo(userUpdateRequestDTO: UserUpdateRequestDTO) : Response<APIError>

    suspend fun autoLogin() : DataState<APIError>
}