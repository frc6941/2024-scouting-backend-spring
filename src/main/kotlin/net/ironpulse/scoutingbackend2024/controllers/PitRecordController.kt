package net.ironpulse.scoutingbackend2024.controllers

import jakarta.validation.Validator
import net.ironpulse.scoutingbackend2024.dto.PitRecordDto
import net.ironpulse.scoutingbackend2024.services.IPitRecordService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PitRecordController(
    private val pitRecordService: IPitRecordService,
    private val validator: Validator
) {
    @GetMapping("/pit/record/team/{id}")
    fun getPitRecordByTeamNumber(@PathVariable id: Int): ResponseEntity<Any> {
        pitRecordService.getPitRecordByTeamNumber(id)?.let { return ResponseEntity.ok(it) }
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND.value())
            .body(mapOf("error" to "pit.record.team.notFound"))
    }

    @PostMapping("/pit/record")
    fun uploadPitRecord(@RequestBody form: PitRecordDto): ResponseEntity<Any> {
        val result = validator.validate(form)
        if (result.isNotEmpty())
            return ResponseEntity.badRequest().body(result.map { it.message })

        if (pitRecordService.isPitRecordExist(form.teamNumber)) {
            pitRecordService.editPitRecord(form)
            return ResponseEntity.ok(form)
        }

        pitRecordService.savePitRecord(form)
        return ResponseEntity.ok(form)
    }
}