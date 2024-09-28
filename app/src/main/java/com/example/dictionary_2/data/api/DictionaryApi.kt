package com.example.dictionary_2.data.api

import com.example.dictionary_2.data.dto.WordResultDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {
    @GET("{word}")
    suspend fun getWordResult(
        @Path("word") word: String
    ): WordResultDTO?

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"
    }
}