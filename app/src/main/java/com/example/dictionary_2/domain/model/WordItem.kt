package com.example.dictionary_2.domain.model

data class WordItem(
    val word: String,
    val meanings: List<Meaning>,
    val phonetic: String
)