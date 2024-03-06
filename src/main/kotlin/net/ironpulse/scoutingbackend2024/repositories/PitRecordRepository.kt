package net.ironpulse.scoutingbackend2024.repositories

import net.ironpulse.scoutingbackend2024.entities.PitRecord
import org.springframework.data.repository.CrudRepository

interface PitRecordRepository: CrudRepository<PitRecord, Long> {
    fun getByTeamNumber(teamNumber: Int): PitRecord?

    fun existsByTeamNumber(teamNumber: Int): Boolean
}