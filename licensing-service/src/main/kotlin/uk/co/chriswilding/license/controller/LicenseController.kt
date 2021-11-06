package uk.co.chriswilding.license.controller

import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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

    @DeleteMapping("/{licenseId}")
    fun deleteLicense(
        @PathVariable("organisationId") organisationId: String,
        @PathVariable("licenseId") licenseId: String,
    ): ResponseEntity<String> {
        return ResponseEntity.ok(licenseService.deleteLicense(organisationId, licenseId));
    }

    @GetMapping("/{licenseId}")
    fun getLicense(
        @PathVariable("organisationId") organisationId: String,
        @PathVariable("licenseId") licenseId: String,
    ): ResponseEntity<License> {
        val license = licenseService.getLicense(organisationId, licenseId)

        license.add(
            linkTo<LicenseController> {
                this.getLicense(organisationId, license.licenseId)
            }.withSelfRel(),
            linkTo<LicenseController> {
                this.createLicense(organisationId, license)
            }.withRel("createLicense"),
            linkTo<LicenseController> {
                this.updateLicense(organisationId, license)
            }.withRel("updateLicense"),
            linkTo<LicenseController> {
                this.deleteLicense(organisationId, license.licenseId)
            }.withRel("deleteLicense")
        )

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
