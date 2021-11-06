package uk.co.chriswilding.license.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import uk.co.chriswilding.license.model.License
import uk.co.chriswilding.license.service.LicenseService

@RestController
@RequestMapping("v1/organisation/{organisationId}/license")
class LicenseController(private val licenseService: LicenseService) {
    @PostMapping
    fun createLicense(
        @PathVariable("organisationId") organisationId: String,
        @RequestBody license: License,
    ): ResponseEntity<String> {
        return ResponseEntity.ok(licenseService.createLicense(organisationId, license))
    }

    @DeleteMapping( "/{licenseId}")
    fun deleteLicense(
        @PathVariable("organisationId") organisationId: String,
        @PathVariable("licenseId") licenseId: String,
    ): ResponseEntity<String> {
        return ResponseEntity.ok(licenseService.deleteLicense(organisationId, licenseId));
    }

    @GetMapping( "/{licenseId}")
    fun getLicense(
        @PathVariable("organisationId") organisationId: String,
        @PathVariable("licenseId") licenseId: String,
    ): ResponseEntity<License> {
        val license = licenseService.getLicense(organisationId, licenseId)
        return ResponseEntity.ok(license)
    }

    @PutMapping
    fun updateLicense(
        @PathVariable("organisationId") organisationId: String,
        @RequestBody license: License,
    ): ResponseEntity<String> {
        return ResponseEntity.ok(licenseService.updateLicense(organisationId, license))
    }
}
