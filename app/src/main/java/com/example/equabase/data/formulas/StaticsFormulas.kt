package com.example.equabase.data.formulas

import com.example.equabase.SubCategoryType
import com.example.equabase.data.PhysicsFormula

object StaticsFormulas {

    private fun formula(
        name: String,
        formula: String,
        description: String
    ) = PhysicsFormula(name, formula, description, SubCategoryType.STATICS)

    val list = listOf(
        formula("Момент сили", "M = F*d", "M — момент сили, F — сила, d — плече сили. Момент сили дорівнює добутку сили на плече."),
        formula("Плече сили", "d = r*sin(α)", "d — плече сили, r — відстань від осі до точки прикладання сили, α — кут між вектором сили та плечем."),
        formula("Правило важеля", "F_1/F_2 = d_2/d_1", "F_1, F_2 — сили, d_1, d_2 — відповідні плечі. Важіль у рівновазі, коли добутки сил на плечі рівні."),
        formula("Момент інерції тіла обертання", "J = m*r^2", "J — момент інерції, m — маса тіла, r — відстань від осі обертання до маси."),
        formula("Тиск", "p = F/S", "p — тиск, F — сила, S — площа поверхні. Тиск дорівнює силі, поділеній на площу.")
    )
}