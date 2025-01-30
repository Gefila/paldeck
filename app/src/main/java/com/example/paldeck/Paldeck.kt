package com.example.paldeck

data class Paldeck(
    val no: Int,
    val name: String,
    val description: String,
    val elements: List<Element>,
    val stats: Stats,
    val image: String
)

enum class Element {
    FIRE, WATER, GRASS, ELECTRIC, ICE, GROUND, DARK, DRAGON, NEUTRAL
}

data class Stats(
    val hp: Int,
    val defense: Int,
    val craftingSpeed: Int,
    val meleeAttack: Int,
    val shotAttack: Int,
    val price: Int,
    val stamina: Int,
    val support: Int,
    val runningSpeed: Int,
    val sprintingSpeed: Int,
    val slowWalkSpeed: Int
)
