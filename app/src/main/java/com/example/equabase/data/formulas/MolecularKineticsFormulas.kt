import com.example.equabase.SubCategoryType
import com.example.equabase.data.PhysicsFormula

object MolecularKineticsFormulas {

    private fun formula(
        name: String,
        formula: String,
        description: String
    ) = PhysicsFormula(name, formula, description, SubCategoryType.MOLECULAR)

    val list = listOf(
        formula("Кількість речовини (моль)", "ν = N/N_A", "ν — кількість речовини, N — число частинок, N_A — число Авогадро."),
        formula("Молярна маса", "M = m*ν", "M — молярна маса, m — маса, ν — кількість речовини."),
        formula("Маса молекули", "m_0 = m/N", "N — кількість молекул, m — маса речовини, m_0 — маса однієї молекули."),
        formula("Молярна маса", "M = m_0*N_A", "M — молярна маса, m_0 — маса молекули, N_A — число Авогадро."),
        formula("Число молекул", "N = m/m_0", "N — кількість молекул, m — маса речовини, m_0 — маса однієї молекули."),
        formula("Основне рівняння МКТ", "p = (1/3)*m_0*n*v^2", "p — тиск, m_0 — маса молекули, n — концентрація молекул, v — середня квадратична швидкість."),
        formula("Внутрішня енергія молекул", "E = {m*v^2}/2", "E — енергія однієї молекули, m — маса, v — швидкість."),
        formula("Тиск ідеального газу", "p = 2/3*E*n", "p — тиск, E — кінетична енергія однієї молекули, n — концентрація."),
        formula("Концентрація молекул", "n = N/V", "n — концентрація молекул, N — кількість молекул, V — об'єм."),
        formula("Газ: тиск, об’єм, середня кінетична енергія", "p*V = {2*E}/3*N", "p — тиск, V — об’єм, N — кількість молекул, E — середня кінетична енергія."),
        formula("Газ: тиск, об’єм, температура", "p*V = N*k*T", "p — тиск, V — об’єм, N — кількість молекул, k — стала Больцмана, T — температура."),
        formula("Середня кінетична енергія", "E = {3*k*T}/2", "E — енергія однієї молекули, k — стала Больцмана, T — температура."),
        formula("Газ: тиск, концентрація, температура", "p = n*k*T", "p — тиск, n — концентрація, k — стала Больцмана, T — температура."),
        formula("Газ: кількість речовини, об’єм", "n = V/V_M", "n — кількість речовини, V — об'єм, V_M — молярний(молярний) об'єм."),
        formula("Рівняння Менделєєва-Клапейрона", "p*V = v*R*T", "p — тиск, V — об’єм, ν — кількість речовини, R — універсальна газова стала, T — температура."),
        formula("Рівняння Менделєєва-Клапейрона (через M)", "p*V = {m*R*T}/M", "p — тиск, V — об’єм, m - маса, R — універсальна газова стала, T — температура, M — молярна маса."),
        formula("Середньоквадратична швидкість", "v = √{{3*k*T}/m_0}", "v — швидкість, T — температура, m_0 — маса молекули, k — стала Больцмана."),
        formula("Середньоквадратична швидкість (через M)", "v = √{3*R*T/M}", "v — швидкість, R — газова стала, M — молярна маса, T — температура."),
        formula("Закон Бойля-Маріотта", "p_1*V_1 = p_2*V_2", "p і V — тиск та об’єм при незмінній температурі (ізотермічний процес)."),
        formula("Закон Гей-Люссака", "V_1/T_1 = V_2/T_2", "V — об’єм, T — температура при постійному тиску (ізобарний процес)."),
        formula("Теплове розширення газу", "V = V_0*α*t)", "V — об’єм, V_0 — початковий об'єм, t — температура, α — коефіцієнт теплового розширення."),
        formula("Закон Шарля", "p_1/T_1 = p_2/T_2", "p — тиск, T — температура при незмінному об’ємі (ізохорний процес)."),
        formula("Закон Авогадро", "V/n = const", "V — об’єм, n — кількість речовини."),
        formula("Газова стала", "R = k*N_A", "R — газова стала, k — стала Больцмана, N_A — число Авогадро.")
    )
}