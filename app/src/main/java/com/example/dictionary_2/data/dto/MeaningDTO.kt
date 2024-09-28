package com.example.dictionary_2.data.dto

data class MeaningDTO(
    val definitions: List<DefinitionDTO>? = null,
    val partOfSpeech: String? = null
)