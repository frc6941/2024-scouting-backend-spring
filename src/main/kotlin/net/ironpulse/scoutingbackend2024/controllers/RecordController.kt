package net.ironpulse.scoutingbackend2024.controllers

import jakarta.validation.Validator
import net.ironpulse.scoutingbackend2024.dto.GeneralRecordDto
import net.ironpulse.scoutingbackend2024.entities.Record
import net.ironpulse.scoutingbackend2024.dto.SubjectiveRecordDto
import net.ironpulse.scoutingbackend2024.services.IRecordService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RecordController(
    private val recordService: IRecordService,
    private val validator: Validator
) {
    @GetMapping("/records/team/{id}")
    fun getRecordByTeamNumber(@PathVariable id: Int): ResponseEntity<Any> {
        val records = recordService.getRecordsByTeamNumber(id)
        if (records.isEmpty()) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND.value())
                .body(mapOf("error" to "record.team.notFound"))
        }
        return ResponseEntity.ok(records)
    }

    @PostMapping("/record")
    fun uploadRecord(@RequestBody form: GeneralRecordDto): ResponseEntity<Any> {
        val result = validator.validate(form)
        if (result.isNotEmpty())
            return ResponseEntity.badRequest().body(result.map { it.message })
        if (recordService.isRecordExist(
                form.teamNumber,
                Record.MatchType.valueOf(form.matchType),
                form.matchNumber)) {
            recordService.editRecord(form)
            return ResponseEntity.ok(form)
        }

        recordService.saveRecord(form)
        return ResponseEntity.ok(form)
    }

    @PostMapping("/record/subjective")
    fun uploadSubjective(@RequestBody form: SubjectiveRecordDto): ResponseEntity<Any> {
        val result = validator.validate(form)
        if (result.isNotEmpty())
            return ResponseEntity.badRequest().body(result.map { it.message })
        if (recordService.isRecordExist(form.teamNumber, Record.MatchType.valueOf(form.matchType), form.matchNumber)) {
            recordService.editSubjectRecord(form)
            return ResponseEntity.ok(form)
        }
        recordService.saveSubjectRecord(form)
        return ResponseEntity.ok(form)
    }
}