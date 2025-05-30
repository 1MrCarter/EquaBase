package com.example.equabase.data.formulas

import com.example.equabase.SubCategoryType
import com.example.equabase.data.PhysicsFormula

object ThermalPhenomenaFormulas {

    private fun formula(
        name: String,
        formula: String,
        description: String
    ) = PhysicsFormula(name, formula, description, SubCategoryType.PHENOMENA)

    val list = listOf(
        formula("Абсолютна температура", "T = t+273", "Абсолютна температура T (в К) дорівнює температурі t (у °C), збільшеній на 273."),
        formula("Температура Фаренгейта", "F = 32+1.8*C", "Температура за Фаренгейтом обчислюється через температуру Цельсія."),
        formula("Кількість теплоти", "Q = c*m*Δt", "Кількість теплоти Q, яку отримує або втрачає тіло масою m при зміні температури на Δt = (T2-T1), де c — питома теплоємність."),
        formula("Горіння палива", "Q = q*m", "Кількість теплоти Q, яка виділяється при згорянні палива масою m, де q — питома теплота згоряння."),
        formula("Теплота плавлення", "Q = λ*m", "Кількість теплоти Q, необхідна для плавлення речовини масою m, де λ — питома теплота плавлення."),
        formula("Теплота пароутворення", "Q = L*m", "Кількість теплоти Q, необхідна для перетворення рідини масою m на пару, де L — питома теплотф пароутворення і конденсації.")
    )
}