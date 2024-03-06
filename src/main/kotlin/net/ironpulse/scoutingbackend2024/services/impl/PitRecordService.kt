package net.ironpulse.scoutingbackend2024.services.impl

import net.ironpulse.scoutingbackend2024.dto.PitRecordDto
import net.ironpulse.scoutingbackend2024.entities.PitRecord
import net.ironpulse.scoutingbackend2024.repositories.PitRecordRepository
import net.ironpulse.scoutingbackend2024.services.IPitRecordService
import org.springframework.stereotype.Service

@Service
class PitRecordService(
    private val pitRecordRepository: PitRecordRepository
): IPitRecordService {
    override fun getPitRecordByTeamNumber(teamNumber: Int): PitRecordDto? {
        return pitRecordRepository.getByTeamNumber(teamNumber = teamNumber)?.toDto()
    }

    override fun savePitRecord(form: PitRecordDto) {
        pitRecordRepository.save(
            PitRecord(
                teamNumber = form.teamNumber,
                canAmp = form.canAmp,
                canSpeaker = form.canSpeaker,
                canTrap = form.canTrap,
                chassisType = form.chassisType,
                cycleTime = form.cycleTime,
                autoType = form.autoType,
                pictureUrl = form.pictureUrl
            )
        )
    }

    override fun editPitRecord(form: PitRecordDto) {
        pitRecordRepository.getByTeamNumber(form.teamNumber)?.let {
            with(it) {
                canAmp = form.canAmp
                canSpeaker = form.canSpeaker
                canTrap = form.canTrap
                chassisType = form.chassisType
                cycleTime = form.cycleTime
                autoType = form.autoType
                pictureUrl = form.pictureUrl
            }
            pitRecordRepository.save(it)
        }
    }

    override fun isPitRecordExist(teamNumber: Int): Boolean {
        return pitRecordRepository.existsByTeamNumber(teamNumber)
    }
}