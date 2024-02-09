package com.example.teammanager.ui.util

class DegreeUtil {
    enum class Degree {
        Programmation,
        Marketing,
        Cybersecurite
    }

    companion object {
        fun getDegreeList(): List<Degree> {
            val recurrenceList = mutableListOf<Degree>()
            recurrenceList.add(Degree.Programmation)
            recurrenceList.add(Degree.Marketing)
            recurrenceList.add(Degree.Cybersecurite)

            return recurrenceList
        }
    }
}