package net.ironpulse.scoutingbackend2024.services

import net.ironpulse.scoutingbackend2024.dto.PitRecordDto

interface IPitRecordService {
    fun getPitRecordByTeamNumber(teamNumber: Int): PitRecordDto?

    fun savePitRecord(form: PitRecordDto)

    fun editPitRecord(form: PitRecordDto)

    fun isPitRecordExist(teamNumber: Int): Boolean
}