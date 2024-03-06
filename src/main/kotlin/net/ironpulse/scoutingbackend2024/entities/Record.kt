package net.ironpulse.scoutingbackend2024.entities

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import net.ironpulse.scoutingbackend2024.dto.GeneralRecordDto
import net.ironpulse.scoutingbackend2024.dto.RecordDto
import net.ironpulse.scoutingbackend2024.dto.SubjectiveRecordDto

@Entity
@Table
class Record(
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column
    var scouter: String? = null,

    @Column
    @Enumerated(EnumType.STRING)
    var matchType: MatchType? = null,

    @Column
    var matchNumber: Int? = null,

    @Column
    @Enumerated(EnumType.STRING)
    var allianceRobot: AllianceRobot? = null,

    @Column
    var teamNumber: Int? = null,

    @Column
    var absent: Boolean? = null,

    @Column
    var autoAmpScored: Int? = null,

    @Column
    var autoAmpMissed: Int? = null,

    @Column
    var autoSpeakerScored: Int? = null,

    @Column
    var autoSpeakerMissed: Int? = null,

    @Column
    var teleopAmpScored: Int? = null,

    @Column
    var teleopAmpMissed: Int? = null,

    @Column
    var teleopSpeakerScored: Int? = null,

    @Column
    var teleopSpeakerMissed: Int? = null,

    @Column
    var climb: Boolean? = null,

    @Column
    var offenseSkillRating: Int? = null,

    @Column
    var defenseSkillRating: Int? = null,

    @Column
    var humanPlayerRating: Int? = null,

    @Column
    var driverRating: Int? = null,

    @Column
    var strategyRating: Int? = null,

    @Column
    var cycleTime: Double? = null,

    @Column
    var comment: String? = null,
) {
    enum class AllianceRobot {
        RED_1, RED_2, RED_3, BLUE_1, BLUE_2, BLUE_3
    }

    enum class MatchType {
        PRACTICE, QUALIFICATION
    }

    fun toGeneralDto(): GeneralRecordDto {
        return GeneralRecordDto(
            scouter ?: "",
            matchType?.name ?: "",
            matchNumber ?: 0,
            allianceRobot?.name ?: "",
            teamNumber ?: 0,
            absent ?: false,
            autoAmpScored ?: 0,
            autoAmpMissed ?: 0,
            autoSpeakerScored ?: 0,
            autoSpeakerMissed ?: 0,
            teleopAmpScored ?: 0,
            teleopAmpMissed ?: 0,
            teleopSpeakerScored ?: 0,
            teleopSpeakerMissed ?: 0,
            climb ?: false
        )
    }

    fun toSubjectiveDto(): SubjectiveRecordDto {
        return SubjectiveRecordDto(
            teamNumber ?: 0,
            matchType?.name ?: "PRACTICE",
            matchNumber ?: 0,
            offenseSkillRating ?: 0,
            defenseSkillRating ?: 0,
            humanPlayerRating ?: 0,
            driverRating ?: 0,
            strategyRating ?: 0,
            cycleTime ?: 0.0,
            comment ?: ""
        )
    }

    fun toDto(): RecordDto {
        return RecordDto(
            scouter ?: "",
            matchType?.name ?: "",
            matchNumber ?: 0,
            allianceRobot?.name ?: "",
            teamNumber ?: 0,
            absent ?: false,
            autoAmpScored ?: 0,
            autoAmpMissed ?: 0,
            autoSpeakerScored ?: 0,
            autoSpeakerMissed ?: 0,
            teleopAmpScored ?: 0,
            teleopAmpMissed ?: 0,
            teleopSpeakerScored ?: 0,
            teleopSpeakerMissed ?: 0,
            climb ?: false,
            offenseSkillRating ?: 0,
            defenseSkillRating ?: 0,
            humanPlayerRating ?: 0,
            driverRating ?: 0,
            strategyRating ?: 0,
            cycleTime ?: 0.0,
            comment ?: ""
        )
    }
}