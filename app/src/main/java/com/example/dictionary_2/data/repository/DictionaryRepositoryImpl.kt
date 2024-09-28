package com.example.dictionary_2.data.repository

import android.app.Application
import com.example.dictionary_2.R
import com.example.dictionary_2.data.api.DictionaryApi
import com.example.dictionary_2.data.mapper.toWordItem
import com.example.dictionary_2.domain.model.WordItem
import com.example.dictionary_2.domain.repository.DictionaryRepository
import com.example.dictionary_2.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(
    private val dictionaryApi: DictionaryApi,
    private val application: Application
) : DictionaryRepository {

    override suspend fun getWordResult(
        word: String
    ): Flow<com.example.dictionary_2.util.Result<WordItem>> {
        return flow {
            emit(com.example.dictionary_2.util.Result.Loading(true))

            val remoteWordResultDto = try {
                dictionaryApi.getWordResult(word)
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(com.example.dictionary_2.util.Result.Error(application.getString(R.string.can_t_get_result)))
                emit(com.example.dictionary_2.util.Result.Loading(false))
                return@flow
            } catch (e: IOException) {
                e.printStackTrace()
                emit(com.example.dictionary_2.util.Result.Error(application.getString(R.string.can_t_get_result)))
                emit(com.example.dictionary_2.util.Result.Loading(false))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(com.example.dictionary_2.util.Result.Error(application.getString(R.string.can_t_get_result)))
                emit(com.example.dictionary_2.util.Result.Loading(false))
                return@flow
            }

            remoteWordResultDto?.let { wordResultDto ->
                wordResultDto[0]?.let { wordItemDto ->
                    emit(com.example.dictionary_2.util.Result.Success(wordItemDto.toWordItem()))
                    emit(com.example.dictionary_2.util.Result.Loading(false))
                    return@flow
                }
            }

            emit(com.example.dictionary_2.util.Result.Error(application.getString(R.string.can_t_get_result)))
            emit(Result.Loading(false))
        }
    }
}