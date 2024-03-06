package net.ironpulse.scoutingbackend2024.repositories

import net.ironpulse.scoutingbackend2024.entities.Record
import org.springframework.data.repository.CrudRepository

interface RecordRepository: CrudRepository<Record, Long> {
    fun getRecordsByTeamNumber(teamNumber: Int): List<Record>

    fun existsByTeamNumberAndMatchNumberAndMatchType(
        teamNumber: Int,
        matchNumber: Int,
        matchType: Record.MatchType
    ): Boolean

    fun getByTeamNumberAndMatchNumberAndMatchType(
        teamNumber: Int,
        matchNumber: Int,
        matchType: Record.MatchType
    ): Record?
}