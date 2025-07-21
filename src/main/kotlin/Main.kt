package org.example

fun main() {
    //Create and Populate Collections
    val studentNames = listOf("Mirvt", "Maryam", "Rana","Nour", "Mona")
    val studentScores = mapOf(
        "Mirvt" to 85,
        "Maryam" to 72,
        "Rana" to 95,
        "Nour" to 45,
        "Mona" to 59
    )
    val graduatedStudents= setOf("Mirvt")

    println("All Students: $studentNames")
    println("Student Scores: $studentScores")
    println("Graduated Students: $graduatedStudents\n")

    //Looping and Searching
    println("Students and their scores (excluding graduates):")
    studentNames.forEach{
        name ->
        if (name !in graduatedStudents){
            val score = studentScores[name] ?: "No Score"
            println("$name: $score")
        }
    }
    println()

    //  Requirement 3: Transforming and Filtering
    val uppercaseNames = studentNames.map { it.uppercase() }
    println("Uppercase Names: $uppercaseNames")

    val topStudents = studentScores.filter { it.value > 80 }
        .map { "${it.key}: ${it.value}"}

    println("Top Scores (Above 80)")
    topStudents.forEach{ println(it) }
    println()

    // Requirement 4: Reducing and Aggregation
    val totalScore = studentScores.values.reduce{acc, score -> acc+score }
    println("Total score : $totalScore")

    val formattedString = studentScores.entries.fold("") { acc, entry ->
        if (acc.isEmpty()) "${entry.key}: ${entry.value}"
        else "$acc | ${entry.key}: ${entry.value}"
    }
    println("Formatted String (fold): $formattedString\n")

    //  Requirement 5: Mini Scenario – Student Report Generation

    println("Passed Students Report:")
    generateReport(studentScores)

    println("\n Empty Input Handling:")
    generateReport(emptyMap())
}

// Function for Requirement 5

fun generateReport(scores: Map<String, Int>){
    if (scores.isEmpty()){
        println("No data available")
        return
    }
    scores.filter { it.value >= 60 }
        .map { "${it.key}: ${it.value}" }
        .forEach{ println(it) }
}