package net.ironpulse.scoutingbackend2024.services.impl

import net.ironpulse.scoutingbackend2024.dto.GeneralRecordDto
import net.ironpulse.scoutingbackend2024.dto.RecordDto
import net.ironpulse.scoutingbackend2024.dto.SubjectiveRecordDto
import net.ironpulse.scoutingbackend2024.entities.Record
import net.ironpulse.scoutingbackend2024.repositories.RecordRepository
import net.ironpulse.scoutingbackend2024.services.IRecordService
import org.springframework.stereotype.Service

@Service
class RecordService(
    private val recordRepository: RecordRepository
): IRecordService {
    override fun getRecordsByTeamNumber(teamNumber: Int): List<RecordDto> {
        return recordRepository.getRecordsByTeamNumber(teamNumber).map { it.toDto() }
    }

    override fun isRecordExist(
        teamNumber: Int,
        matchType: Record.MatchType,
        matchNumber: Int
    ): Boolean {
        return recordRepository
            .existsByTeamNumberAndMatchNumberAndMatchType(
                teamNumber, matchNumber, matchType)
    }

    override fun saveRecord(form: GeneralRecordDto) {
        with(form) {
            recordRepository.save(
                Record(
                    scouter = scouter,
                    matchType = Record.MatchType.valueOf(matchType),
                    matchNumber = matchNumber,
                    allianceRobot = Record.AllianceRobot.valueOf(allianceRobot),
                    teamNumber = teamNumber,
                    absent = absent,
                    autoAmpScored = autoAmpScored,
                    autoAmpMissed = autoAmpMissed,
                    autoSpeakerScored = autoSpeakerScored,
                    autoSpeakerMissed = autoSpeakerMissed,
                    teleopAmpScored = teleopAmpScored,
                    teleopAmpMissed = teleopAmpMissed,
                    teleopSpeakerScored = teleopSpeakerScored,
                    teleopSpeakerMissed = teleopSpeakerMissed,
                    climb = climb
                )
            )
        }
    }

    override fun editRecord(form: GeneralRecordDto) {
        recordRepository.getByTeamNumberAndMatchNumberAndMatchType(
            form.teamNumber,
            form.matchNumber,
            Record.MatchType.valueOf(form.matchType)
        )?.let {
            with(form) {
                it.scouter = scouter
                it.matchType = Record.MatchType.valueOf(matchType)
                it.matchNumber = matchNumber
                it.allianceRobot = Record.AllianceRobot.valueOf(allianceRobot)
                it.teamNumber = teamNumber
                it.absent = absent
                it.autoAmpScored = autoAmpScored
                it.autoAmpMissed = autoAmpMissed
                it.autoSpeakerScored = autoSpeakerScored
                it.autoSpeakerMissed = autoSpeakerMissed
                it.teleopAmpScored = teleopAmpScored
                it.teleopAmpMissed = teleopAmpMissed
                it.teleopSpeakerScored = teleopSpeakerScored
                it.teleopSpeakerMissed = teleopSpeakerMissed
                it.climb = climb
            }
        }
    }

    override fun saveSubjectRecord(form: SubjectiveRecordDto) {
        with(form) {
            val record = Record(
                matchType = Record.MatchType.valueOf(matchType),
                matchNumber = matchNumber,
                teamNumber = teamNumber,
                offenseSkillRating = offenseSkillRating,
                defenseSkillRating = defenseSkillRating,
                humanPlayerRating = humanPlayerRating,
                driverRating = driverRating,
                strategyRating = strategyRating,
                cycleTime = cycleTime,
                comment = comment
            )
            recordRepository.save(record)
        }
    }

    override fun editSubjectRecord(form: SubjectiveRecordDto) {
        recordRepository.getByTeamNumberAndMatchNumberAndMatchType(
            form.teamNumber,
            form.matchNumber,
            Record.MatchType.valueOf(form.matchType)
        )?.let {
            it.offenseSkillRating = form.offenseSkillRating
            it.defenseSkillRating = form.defenseSkillRating
            it.humanPlayerRating = form.humanPlayerRating
            it.driverRating = form.driverRating
            it.strategyRating = form.strategyRating
            it.cycleTime = form.cycleTime
            it.comment = form.comment
        }
    }
}