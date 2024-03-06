package net.ironpulse.scoutingbackend2024.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class GeneralRecordDto(
    @field:NotBlank(message = "record.scouter.notBlank")
    val scouter: String,

    @field:NotBlank(message = "record.matchType.notBlank")
    val matchType: String,

    @field:NotNull(message = "record.matchNumber.notNull")
    val matchNumber: Int,

    @field:NotBlank(message = "record.allianceRobot.notBlank")
    val allianceRobot: String,

    @field:NotNull(message = "record.teamNumber.notNull")
    val teamNumber: Int,

    @field:NotNull(message = "record.absent.notNull")
    val absent: Boolean,

    @field:NotNull(message = "record.autoAmpScored.notNull")
    val autoAmpScored: Int,

    @field:NotNull(message = "record.autoAmpMissed.notNull")
    val autoAmpMissed: Int,

    @field:NotNull(message = "record.autoSpeakerScored.notNull")
    val autoSpeakerScored: Int,

    @field:NotNull(message = "record.autoSpeakerMissed.notNull")
    val autoSpeakerMissed: Int,

    @field:NotNull(message = "record.teleopAmpScored.notNull")
    val teleopAmpScored: Int,

    @field:NotNull(message = "record.teleopAmpMissed.notNull")
    val teleopAmpMissed: Int,

    @field:NotNull(message = "record.teleopSpeakerScored.notNull")
    val teleopSpeakerScored: Int,

    @field:NotNull(message = "record.teleopSpeakerMissed.notNull")
    val teleopSpeakerMissed: Int,

    @field:NotNull(message = "record.climb.notNull")
    val climb: Boolean
)
