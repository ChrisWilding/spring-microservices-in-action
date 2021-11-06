package uk.co.chriswilding.license.model

import org.springframework.hateoas.RepresentationModel;

data class License(
    val id: Int,
    val licenseId: String,
    val description: String,
    val organisationId: String,
    val productName: String,
    val licenseType: String,
): RepresentationModel<License>()
