package com.example.dictionary_2.presentation

sealed class MainUiEvents {
    data class OnSearchWordChange(
        val newWord: String
    ) : MainUiEvents()

    object OnSearchClick : MainUiEvents()
}