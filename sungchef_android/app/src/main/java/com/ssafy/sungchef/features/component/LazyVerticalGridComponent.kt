package com.ssafy.sungchef.features.component

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ssafy.sungchef.data.model.responsedto.BookmarkRecipeDetailList
import com.ssafy.sungchef.data.model.responsedto.MakeRecipeDetailList

/**
 * @param photoUrls : 썸네일 링크 리스트
 * @param onClick : 클릭했을 때 수행 함수
 */
@Composable
fun LazyVerticalGridComponentForUpload(
    modifier: Modifier = Modifier,
    makePhotoDataList : List<MakeRecipeDetailList> ,
//    photoUrls: List<String>,
    onClick:(MakeRecipeDetailList) -> (Unit)
){
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(makePhotoDataList) { item ->
            ImageComponent(modifier = Modifier.clickable {
                onClick(item)
            },
                //각 아이템 썸네일 이미지
                imageResource = item.makeRecipeImage)
        }
    }
}

@Composable
fun LazyVerticalGridComponentForBookmark(
    modifier: Modifier = Modifier,
    bookmarkPhotoDatalist : List<BookmarkRecipeDetailList> ,
//    photoUrls: List<String>,
    onClick:(BookmarkRecipeDetailList) -> (Unit)
){
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(bookmarkPhotoDatalist) { item ->
            ImageComponent(modifier = Modifier.clickable {
                onClick(item)
            },
                //각 아이템 썸네일 이미지
                imageResource = item.recipeImage)
        }
    }
}

@Preview
@Composable
private fun BodyPreview() {
    val lst = mutableListOf<String>()
    lst.add("원")
    lst.add("투")
    lst.add("쓰리")
    lst.add("포")
    lst.add("ㅍㅇㅂ")
    lst.add("ㅅㅅ")
    lst.add("ㅅㅂ")
    lst.add("ㄷㄷ")
    lst.add("ㅜㅇ")
    lst.add("ㅌ")
//    LazyVerticalGridComponent(photoUrls = lst, onClick = { Log.d("TAG", "BodyPreview: $it")})
}