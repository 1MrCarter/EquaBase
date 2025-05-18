package com.example.equabase

enum class SubCategoryType(val title: String, val parent: CategoryType) {

    // MECHANICS
    DYNAMICS("Динаміка", CategoryType.MECHANICS),
    KINEMATICS("Кінематика", CategoryType.MECHANICS),
    STATICS("Статика", CategoryType.MECHANICS),
    ENERGY("Закони збереження механічної енергії", CategoryType.MECHANICS),
    PRESSURE("Тиск рідини і газу", CategoryType.MECHANICS),

    // THERMODYNAMICS
    MOLECULAR("Молекулярна кінетика", CategoryType.THERMODYNAMICS),
    OBJECT_STATE("Пара, рідини, твердий стан", CategoryType.THERMODYNAMICS),
    THERMODYNAMIC("Термодинаміка", CategoryType.THERMODYNAMICS),
    PHENOMENA("Теплові явища", CategoryType.THERMODYNAMICS),

    // ELECTRODYNAMICS
    VOLTAGE("Постійний струм", CategoryType.ELECTRODYNAMICS),
    ELECTROSTATICS("Електростатика", CategoryType.ELECTRODYNAMICS),
    FIELD("Магнітне поле", CategoryType.ELECTRODYNAMICS),
    INDUCTION("Електромагнітна індукція", CategoryType.ELECTRODYNAMICS),
    METALS("Електричний струм в металах", CategoryType.ELECTRODYNAMICS),

    // FLUCUATIONSS
    AC_ELECTRICITY("Змінний струм", CategoryType.FLUCUATIONSS),
    E_VIBRATIONS("Електромагнітні коливання", CategoryType.FLUCUATIONSS),
    E_WAVES("Електромагнітні хвилі", CategoryType.FLUCUATIONSS),
    M_VIBRATIONS("Механічні коливання", CategoryType.FLUCUATIONSS),
    M_WAVES("Механічні хвилі", CategoryType.FLUCUATIONSS),

    // OPTICS
    PHOTOMETRY("Фотометрія", CategoryType.OPTICS),
    QUANTUM_OPTICS("Квантова оптика", CategoryType.OPTICS),
    PHYSICAL_OPTICS("Фізична (хвильова) оптика", CategoryType.OPTICS),
    GEOMETRIC_OPTICS("Геометрична (променева) оптика", CategoryType.OPTICS),

    // ATOM
    RELATIVITY("Теорія відносності", CategoryType.ATOM),
    ATOMIC("Атом і ядро атома", CategoryType.ATOM)
}
