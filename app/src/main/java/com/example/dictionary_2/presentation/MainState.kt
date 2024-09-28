package com.example.dictionary_2.presentation

import com.example.dictionary_2.domain.model.WordItem

data class MainState(
    val isLoading: Boolean = false,
    val searchWord: String = "",

    val wordItem: WordItem? = null
)