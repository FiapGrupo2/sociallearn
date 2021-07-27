package br.com.fiap.sociallearn.utils.featuretoggle

data class FeatureConfig(
    val releasedVersion: Int,
    val minimumVersion: Int,
    val status: FeatureToggleState
)