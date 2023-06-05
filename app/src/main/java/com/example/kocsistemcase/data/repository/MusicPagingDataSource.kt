package com.example.kocsistemcase.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kocsistemcase.data.api.ApiServices
import com.example.kocsistemcase.data.dto.MusicResponse
import com.example.kocsistemcase.data.dto.toEntityModel
import com.example.kocsistemcase.data.local.MusicDao
import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException

class MusicPagingDataSource(
    private val movieApi: ApiServices,
    private val musicDao: MusicDao,
) : PagingSource<Int, MusicResponse.Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MusicResponse.Result> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = movieApi.getItunes(20, page)
            val apiResponse = Gson().fromJson(response, MusicResponse::class.java)
            apiResponse?.results?.let {
                val t = it.map { asdy -> asdy.toEntityModel() }
                musicDao.insert(t)
            }
            LoadResult.Page(
                data = apiResponse.results,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (apiResponse.results.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, MusicResponse.Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

}