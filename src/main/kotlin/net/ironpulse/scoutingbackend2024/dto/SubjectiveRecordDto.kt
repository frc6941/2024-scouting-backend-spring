package net.ironpulse.scoutingbackend2024.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class SubjectiveRecordDto(
    @field:NotNull(message = "record.subjective.teamNumber.notNull")
    val teamNumber: Int,

    @field:NotBlank(message = "record.subjective.matchType.notBlank")
    val matchType: String,

    @field:NotNull(message = "record.subjective.matchNumber.notNull")
    val matchNumber: Int,

    @field:NotNull(message = "record.subjective.offenseSkillRating.notNull")
    val offenseSkillRating: Int,

    @field:NotNull(message = "record.subjective.defenseSkillRating.notNull")
    val defenseSkillRating: Int,

    @field:NotNull(message = "record.subjective.humanPlayerRating.notNull")
    val humanPlayerRating: Int,

    @field:NotNull(message = "record.subjective.driverRating.notNull")
    val driverRating: Int,

    @field:NotNull(message = "record.subjective.strategyRating.notNull")
    val strategyRating: Int,

    @field:NotNull(message = "record.subjective.cycleTime.notNull")
    val cycleTime: Double,

    val comment: String,
)
