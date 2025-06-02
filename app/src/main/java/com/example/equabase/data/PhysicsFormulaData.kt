package com.example.equabase.data

import com.example.equabase.data.formulas.DynamicsFormulas
import com.example.equabase.data.formulas.EnergyConservationFormulas
import com.example.equabase.data.formulas.KinematicsFormulas
import com.example.equabase.data.formulas.StaticsFormulas
import com.example.equabase.data.formulas.ThermalPhenomenaFormulas

object PhysicsFormulaData {
    val formulas: List<PhysicsFormula> = listOf(
        *KinematicsFormulas.list.toTypedArray(),
        *DynamicsFormulas.list.toTypedArray(),
        *StaticsFormulas.list.toTypedArray(),
        *EnergyConservationFormulas.list.toTypedArray(),
        *PressureFormulas.list.toTypedArray(),
        *MolecularKineticsFormulas.list.toTypedArray(),
        *ThermalPhenomenaFormulas.list.toTypedArray(),
        *ThermodynamicsFormulas.list.toTypedArray(),
        *ElectrostaticsFormulas.list.toTypedArray(),
        *DirectCurrentFormulas.list.toTypedArray(),
        *MagneticFieldFormulas.list.toTypedArray(),
        *SteamLiquidSolidFormulas.list.toTypedArray(),
        //*DynamicsFormulas.list.toTypedArray(),
        //*OpticsFormulas.list.toTypedArray()
    )
}