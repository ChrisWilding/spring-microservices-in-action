package uk.co.chriswilding.license.model

data class License(
    val id: Int,
    val licenseId: String,
    val description: String,
    val organisationId: String,
    val productName: String,
    val licenseType: String,
)
