package com.example.m017_recyclerview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.m017_recyclerview.data.ConstData
//import com.example.m017_recyclerview.data.MarchRepository
import com.example.m017_recyclerview.data.ResultDto
import com.example.m017_recyclerview.data.Retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
//
//private const val API_KEY = "FtNYYaqL9vjODepriB8JUXJWUfzg6UfqNTEMyQpb"
//private const val SOL = 1000

class MainViewModel (val repository: Retrofit) : ViewModel() {

    private var _photosStateFlow = MutableStateFlow<Response<ResultDto>?>(null)
    val photosStateFlow = _photosStateFlow.asStateFlow()
    private var _errorMessageFlow = MutableStateFlow<String?>(null)
    val errorMessageFlow = _errorMessageFlow.asStateFlow()
//    val pagedMarcs = Flow<PagingData<ResultDto>> =  Pager (
//        config = PagingConfig(pageSize = 10),
//        pagingSourceFactory = {MarsPagingSource()}
//    ).flow.cachedIn(viewModelScope)

    suspend fun getPhotosList() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.getPhotos.getPhotos(ConstData.SOL, ConstData.API_KEY)
            }.fold(
                onSuccess = { _photosStateFlow.value = it },
                onFailure = { _errorMessageFlow.value = it.message }
            )
        }
    }
}