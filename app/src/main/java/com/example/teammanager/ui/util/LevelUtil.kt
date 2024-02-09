package com.example.teammanager.ui.util

class LevelUtil {

    enum class Level {
        B1,
        B2,
        B3,
        M1,
        M2
    }

    companion object {
        fun getLevelList(): List<Level> {
            val recurrenceList = mutableListOf<Level>()
            recurrenceList.add(Level.B1)
            recurrenceList.add(Level.B2)
            recurrenceList.add(Level.B3)
            recurrenceList.add(Level.M1)
            recurrenceList.add(Level.M2)

            return recurrenceList
        }
    }
}