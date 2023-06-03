package com.example.kocsistemcase.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kocsistemcase.data.api.ApiServices
import com.example.kocsistemcase.data.dto.MusicResponse
import retrofit2.HttpException
import java.io.IOException

class MusicPagingDataSource(private val apiServices: ApiServices) :
    PagingSource<Int, MusicResponse.Result>() {
    override fun getRefreshKey(state: PagingState<Int, MusicResponse.Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MusicResponse.Result> {
        val page = params.key ?: PAGE_INDEX
        val offset =
            if (params.key != null) ((page - 1) * NETWORK_PAGE_SIZE) + 1 else NETWORK_PAGE_SIZE

        return try {
            val response = apiServices.getItunes(offset, params.loadSize)
            LoadResult.Page(
                data = response.results,
                prevKey = if (page == PAGE_INDEX) null else page - 1,
                nextKey = if (response.results.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }

    }


    companion object {
        private const val NETWORK_PAGE_SIZE = 20
        private const val PAGE_INDEX = 1
    }
}