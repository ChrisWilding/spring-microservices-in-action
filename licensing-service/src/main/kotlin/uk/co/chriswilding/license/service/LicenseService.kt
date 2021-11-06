package uk.co.chriswilding.license.service

import org.springframework.stereotype.Service
import uk.co.chriswilding.license.model.License
import kotlin.random.Random

@Service
class LicenseService {
    fun createLicense(organisationId: String, license: License?): String {
        if (license != null) {
            val newLicense = license.copy(organisationId = organisationId)
            return "POST to create license: $newLicense"
        }
        return "POST to create license with null"
    }

    fun deleteLicense(organisationId: String, licenseId: String): String {
        return "DELETE to delete license=$licenseId for organisation=$organisationId"
    }

    fun getLicense(organisationId: String, licenseId: String): License {
        return License(
            id = Random.nextInt(1000),
            organisationId = organisationId,
            licenseId = licenseId,
            description = "Software product",
            productName = "Ostock",
            licenseType = "full",
        )
    }

    fun updateLicense(organisationId: String, license: License?): String {
        if (license != null) {
            val updatedLicense = license.copy(organisationId = organisationId)
            return "PUT to update license: $updatedLicense"
        }
        return "PUT to update license with null license"
    }
}
