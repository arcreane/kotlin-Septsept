package com.example.teammanager.ui.util

class DegreeUtil {

    enum class Degree {
        Programming,
        Marketing,
        Cybersecurity
    }

    companion object {
        fun getDegreeList(): List<Degree> {
            val recurrenceList = mutableListOf<Degree>()
            recurrenceList.add(Degree.Programming)
            recurrenceList.add(Degree.Marketing)
            recurrenceList.add(Degree.Cybersecurity)

            return recurrenceList
        }
    }
}