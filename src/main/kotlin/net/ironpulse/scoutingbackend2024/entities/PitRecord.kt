package net.ironpulse.scoutingbackend2024.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.ironpulse.scoutingbackend2024.dto.PitRecordDto

@Entity
@Table
class PitRecord(
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(unique = true, nullable = false)
    val teamNumber: Int,

    @Column(nullable = false)
    var canAmp: Boolean,

    @Column(nullable = false)
    var canSpeaker: Boolean,

    @Column(nullable = false)
    var canTrap: Boolean,

    @Column(nullable = false)
    var chassisType: String,

    @Column(nullable = false)
    var cycleTime: Double,

    @Column(nullable = false)
    var autoType: String,

    @Column
    var pictureUrl: String,
) {
    fun toDto(): PitRecordDto {
        return PitRecordDto(
            teamNumber,
            canAmp,
            canSpeaker,
            canTrap,
            chassisType,
            cycleTime,
            autoType,
            pictureUrl
        )
    }
}