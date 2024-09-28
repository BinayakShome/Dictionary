package com.example.dictionary_2.domain.repository

import com.example.dictionary_2.domain.model.WordItem
import com.example.dictionary_2.util.Result
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {
    suspend fun getWordResult(
        word: String
    ): Flow<Result<WordItem>>
}