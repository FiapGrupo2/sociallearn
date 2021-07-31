package br.com.fiap.sociallearn

import android.content.SearchRecentSuggestionsProvider

class SearchableProvider() : SearchRecentSuggestionsProvider() {
    companion object {
        const val authority = "br.com.fiap.sociallearn.SearchableProvider"
        const val mode = DATABASE_MODE_QUERIES
    }

    init {
        setupSuggestions(authority, mode)
    }
}