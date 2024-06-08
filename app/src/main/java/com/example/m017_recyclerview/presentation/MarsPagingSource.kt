//package com.example.m017_recyclerview.presentation
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.example.m017_recyclerview.data.MarchRepository
//import com.example.m017_recyclerview.data.Photo
//import com.example.m017_recyclerview.data.ResultDto
//import com.example.m017_recyclerview.data.Retrofit

//class MarsPagingSource(
//    private val repository: MarchRepository,
//    private val roverName: String
//) : PagingSource<Int, Photo>() {
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
//        val page = params.key ?: 1
//        return try {
//            val response = repository.getPhotos(page = page)
//            LoadResult.Page(
//                data = response.photos,
//                prevKey = if (page > 1) page - 1 else null,
//                nextKey = if (response.photos.isNotEmpty()) page + 1 else null
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }
//}