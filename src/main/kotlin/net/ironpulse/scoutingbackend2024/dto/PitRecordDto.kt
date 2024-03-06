package net.ironpulse.scoutingbackend2024.dto

import jakarta.validation.constraints.NotNull

data class PitRecordDto(
    @field:NotNull(message = "pit.record.teamNumber.notNull")
    val teamNumber: Int,

    @field:NotNull(message = "pit.record.canAmp.notNull")
    val canAmp: Boolean,

    @field:NotNull(message = "pit.record.canSpeaker.notNull")
    val canSpeaker: Boolean,

    @field:NotNull(message = "pit.record.canTrap.notNull")
    val canTrap: Boolean,

    @field:NotNull(message = "pit.record.chassisType.notNull")
    val chassisType: String,

    @field:NotNull(message = "pit.record.cycleTime.notNull")
    val cycleTime: Double,

    @field:NotNull(message = "pit.record.autoType.notNull")
    val autoType: String,

    @field:NotNull(message = "pit.record.pictureUrl.notNull")
    val pictureUrl: String,
)
