package com.example.dictionary_2.data.mapper

import com.example.dictionary_2.data.dto.DefinitionDTO
import com.example.dictionary_2.data.dto.MeaningDTO
import com.example.dictionary_2.data.dto.WordItemDTO
import com.example.dictionary_2.domain.model.Definition
import com.example.dictionary_2.domain.model.Meaning
import com.example.dictionary_2.domain.model.WordItem

fun WordItemDTO.toWordItem() = WordItem (
    word = word ?: "",
    meanings = meanings?.map {
        it.toMeaning()
    } ?: emptyList(),
    phonetic = phonetic ?: ""
)

fun MeaningDTO.toMeaning() = Meaning(
    definition = definitionDtoToDefinition(definitions?.get(0)),
    partOfSpeech = partOfSpeech ?: ""
)


fun definitionDtoToDefinition(
    definitionDto: DefinitionDTO?
) = Definition(
    definition = definitionDto?.definition ?: "",
    example = definitionDto?.example ?: "",
    synonyms = definitionDto?.synonyms?.joinToString(", ") ?: "",
    antonyms = definitionDto?.antonyms?.joinToString(", ") ?: ""
)