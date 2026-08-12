package HotelOverlookteste

import kotlin.system.exitProcess

// ── Estado global ──

val quartos = BooleanArray(20) { false }
val reservaNome = mutableListOf<String>()
val reservaQuarto = mutableListOf<Int>()
val reservaDias = mutableListOf<Int>()
val reservaTotal = mutableListOf<Double>()
val hospedes = mutableListOf<String>()
val hospedesData = mutableListOf<String>()
val eventoEmpresa = mutableListOf<String>()
val eventoTotal = mutableListOf<Double>()
var nomeUsuario = ""

var contadorCadastro = 0

fun agora(): String {
    contadorCadastro++
    return "cadastro #$contadorCadastro"
}

// ── Util ──

fun lerDouble(msg: String): Double? {
    print(msg)
    return readln().replace(",", ".").toDoubleOrNull()
}

fun lerInt(msg: String): Int? {
    print(msg)
    return readln().toIntOrNull()
}

fun erroOpcao() {
    println("Opção inválida.")
}

// ── Auth ──

fun autenticacao() {
    print("Nome: ")
    nomeUsuario = readln().replaceFirstChar { it.uppercase() }

    var tentativas = 0

    while (tentativas < 3) {
        print("Senha: ")
        val senha = readln().toIntOrNull()

        if (senha == null) {
            println("Senha inválida.")
            continue
        }

        if (senha == 2678) {
            println("Bem-vindo, $nomeUsuario!")
            return
        }

        tentativas++
        println("Senha incorreta ($tentativas/3)")
    }

    println("Sistema bloqueado.")
    exitProcess(0)
}

// ── Menu ──

fun menuPrincipal() {
    while (true) {
        println("\n1-Reservas  2-Hóspedes  3-Eventos  4-Ar  5-Combustível  6-Relatórios  7-Sair")
        print("Opção: ")

        when (readln().toIntOrNull()) {
            1 -> reservaQuartos()
            2 -> cadastroHospedes()
            3 -> eventos()
            4 -> arCondicionado()
            5 -> abastecimento()
            6 -> relatoriosOperacional()
            7 -> sair()
            else -> erroOpcao()
        }
    }
}

// ── Quartos ──

fun verificarQuarto(q: Int): Boolean {

    if (q < 1 || q > 20) {
        println("Quarto inválido.")
        return false
    }

    if (quartos[q - 1] == false) return true

    println("Quarto ocupado. Livres:")

    var tem = false
    for (i in 1..20) {
        if (quartos[i - 1] == false) {
            print("$i ")
            tem = true
        }
    }

    if (!tem) println("Nenhum disponível.")

    println()
    return false
}

fun reservaQuartos() {

    val diaria = lerDouble("Diária: ")
    if (diaria == null || diaria <= 0) return

    val dias = lerInt("Dias: ")
    if (dias == null || dias < 1 || dias > 30) return

    print("Nome: ")
    val nome = readln()

    print("Tipo (S/E/L): ")
    val tipo = readln().uppercase()

    var fator = 0.0
    var tipoNome = ""

    if (tipo == "S") {
        fator = 1.0
        tipoNome = "Standard"
    } else if (tipo == "E") {
        fator = 1.35
        tipoNome = "Executivo"
    } else if (tipo == "L") {
        fator = 1.65
        tipoNome = "Luxo"
    } else {
        println("Tipo inválido.")
        return
    }

    var quarto = 0

    while (true) {
        val q = lerInt("Quarto (1-20): ") ?: continue
        if (verificarQuarto(q)) {
            quarto = q
            break
        }
    }

    val total = diaria * dias * fator * 1.10

    print("Confirmar? (S/N): ")
    if (readln().trim().uppercase() == "S") {
        quartos[quarto - 1] = true
        reservaNome.add(nome)
        reservaQuarto.add(quarto)
        reservaDias.add(dias)
        reservaTotal.add(total)
        println("Reservado.")
    }
}

// ── Hóspedes ──

fun cadastroHospedes() {

    while (true) {
        println("\n1-Cadastrar 2-Buscar 3-Listar 4-Voltar")
        val op = readln().toIntOrNull()

        if (op == 1) {

            if (hospedes.size >= 15) {
                println("Limite.")
                continue
            }

            print("Nome: ")
            val nome = readln()

            var existe = false
            for (h in hospedes) {
                if (h.equals(nome, true)) {
                    existe = true
                    break
                }
            }

            if (existe) println("Já existe")
            else {
                hospedes.add(nome)
                hospedesData.add(agora())
            }

        } else if (op == 2) {

            print("Nome: ")
            val nome = readln()

            var achou = false
            for (h in hospedes) {
                if (h.equals(nome, true)) {
                    println("Encontrado: $h")
                    achou = true
                }
            }

            if (!achou) println("Não encontrado")

        } else if (op == 3) {

            for (i in hospedes.indices) {
                println("${i + 1} - ${hospedes[i]}")
            }

        } else if (op == 4) {
            return
        }
    }
}

// ── Eventos ──

fun validarJanela(dia: String, h: Int, d: Int): Boolean {

    val diaFormatado = dia.lowercase()

    var limite = 0

    if (diaFormatado in listOf("segunda","terca","quarta","quinta","sexta")) {
        limite = 23
    } else if (diaFormatado == "sabado" || diaFormatado == "domingo") {
        limite = 15
    } else return false

    if (h < 7 || h >= limite) return false
    if (d < 1 || d > 12) return false
    if (h + d > limite) return false

    return true
}

fun eventos() {

    val convidados = lerInt("Convidados: ") ?: return
    if (convidados < 0 || convidados > 350) return

    print("Dia: ")
    val dia = readln()

    val h = lerInt("Hora: ") ?: return
    val d = lerInt("Duração: ") ?: return

    if (!validarJanela(dia, h, d)) {
        println("Dados inválidos.")
        return
    }

    print("Empresa: ")
    val emp = readln()

    val total = convidados * 5.0
    eventoEmpresa.add(emp)
    eventoTotal.add(total)

    println("Evento cadastrado.")
}

// ── Ar ──

fun calcularOrcamento(v: Double, q: Int, desc: Double, min: Int, desloc: Double): Double {

    var bruto = v * q
    if (q >= min) bruto -= bruto * (desc / 100)

    return bruto + desloc
}

fun arCondicionado() {

    val nomes = mutableListOf<String>()
    val valores = mutableListOf<Double>()

    var continuar = "S"

    while (continuar.uppercase() == "S") {

        print("Empresa: ")
        val nome = readln()

        val v = lerDouble("Valor: ") ?: return
        val q = lerInt("Qtd: ") ?: return
        val d = lerDouble("Desc: ") ?: return
        val m = lerInt("Min: ") ?: return
        val des = lerDouble("Desloc: ") ?: return

        val total = calcularOrcamento(v, q, d, m, des)

        nomes.add(nome)
        valores.add(total)

        print("Continuar? ")
        continuar = readln()
    }

    if (valores.isEmpty()) {
        println("Nenhum dado.")
        return
    }

    var menor = valores[0]
    var maior = valores[0]
    var iMenor = 0
    var iMaior = 0

    for (i in valores.indices) {
        if (valores[i] < menor) {
            menor = valores[i]
            iMenor = i
        }
        if (valores[i] > maior) {
            maior = valores[i]
            iMaior = i
        }
    }

    println("Melhor: ${nomes[iMenor]}")
    println("Pior: ${nomes[iMaior]}")
}

// ── Combustível ──

fun escolherCombustivel(a: Double, g: Double): Pair<String, Double> {

    if (a <= 0 || g <= 0) return Pair("Inválido", 0.0)

    if (a <= g * 0.7) return Pair("Álcool", a * 42)

    return Pair("Gasolina", g * 42)
}

fun abastecimento() {

    val a1 = lerDouble("Álcool 1: ") ?: return
    val g1 = lerDouble("Gasolina 1: ") ?: return

    val r = escolherCombustivel(a1, g1)

    println("Melhor: ${r.first}")
}

// ── Relatório ──

fun relatoriosOperacional() {

    var ocupados = 0
    for (q in quartos) if (q) ocupados++

    var total = 0.0
    for (v in reservaTotal) total += v

    println("Ocupação: $ocupados")
    println("Receita: $total")
}

// ── Sair ──

fun sair() {
    print("Sair? ")
    if (readln().trim().uppercase() == "S") exitProcess(0)
}

// ── Main ──

fun main() {
    autenticacao()
    menuPrincipal()
}
