package com.example.paldeck

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Paldeck(
    val name: String,
    val description: String,
    val elements: List<Element>,
    val stats: Stats,
    val image: String
): Parcelable

enum class Element {
    FIRE, WATER, GRASS, ELECTRIC, ICE, GROUND, DARK, DRAGON, NEUTRAL
}

@Parcelize
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
): Parcelable
