package com.example.dictionary_2.data.dto

data class WordItemDTO(
    val meanings: List<MeaningDTO>? = null,
    val phonetic: String? = null,
    val word: String? = null
)