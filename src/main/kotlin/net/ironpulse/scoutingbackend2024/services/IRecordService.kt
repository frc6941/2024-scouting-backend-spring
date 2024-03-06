package net.ironpulse.scoutingbackend2024.services

import net.ironpulse.scoutingbackend2024.dto.GeneralRecordDto
import net.ironpulse.scoutingbackend2024.dto.RecordDto
import net.ironpulse.scoutingbackend2024.dto.SubjectiveRecordDto
import net.ironpulse.scoutingbackend2024.entities.Record

interface IRecordService {
    fun getRecordsByTeamNumber(teamNumber: Int): List<RecordDto>
    fun isRecordExist(teamNumber: Int, matchType: Record.MatchType, matchNumber: Int): Boolean
    fun saveRecord(form: GeneralRecordDto)
    fun saveSubjectRecord(form: SubjectiveRecordDto)
    fun editSubjectRecord(form: SubjectiveRecordDto)
    fun editRecord(form: GeneralRecordDto)
}