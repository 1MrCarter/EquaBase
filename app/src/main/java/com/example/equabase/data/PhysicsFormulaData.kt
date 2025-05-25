package com.example.equabase.data

import com.example.equabase.data.formulas.KinematicsFormulas

object PhysicsFormulaData {
    val formulas: List<PhysicsFormula> = listOf(
        *KinematicsFormulas.list.toTypedArray(),
        //*DynamicsFormulas.list.toTypedArray(),
        //*OpticsFormulas.list.toTypedArray()
    )
}