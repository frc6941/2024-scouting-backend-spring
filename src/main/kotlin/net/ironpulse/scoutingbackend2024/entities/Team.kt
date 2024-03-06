package net.ironpulse.scoutingbackend2024.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table
class Team(
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(unique = true, nullable = false)
    val teamNumber: Int
)