package com.example.dictionary_2.data.dto

data class DefinitionDTO(
    val definition: String? = null,
    val example: String? = null,
    val synonyms: List<String>? = null,
    val antonyms: List<String>? = null
)