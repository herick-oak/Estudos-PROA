import kotlin.math.ceil
import kotlin.math.floor
import kotlin.system.exitProcess


// Essa e a versão que o Claude Corrigiu, ele modificou algumas coisas.

// ── Nome do hotel ──

const val NOME_HOTEL = "Overlook"

// ── Estado global ──

val quartos = BooleanArray(20) { false }

val reservaNome   = mutableListOf<String>()
val reservaQuarto = mutableListOf<Int>()
val reservaDias   = mutableListOf<Int>()
val reservaTotal  = mutableListOf<Double>()

val hospedesNome  = mutableListOf<String>()
val hospedesData  = mutableListOf<String>()

val eventoEmpresa = mutableListOf<String>()
val eventoTotal   = mutableListOf<Double>()

var nomeUsuario = ""
var contadorCadastro = 0

// ── Utils ──

fun lerDouble(msg: String): Double? {
    print(msg)
    return readln().trim().replace(",", ".").toDoubleOrNull()
}

fun lerInt(msg: String): Int? {
    print(msg)
    return readln().trim().toIntOrNull()
}

fun erroOpcao() {
    println("Opção inválida.")
}

fun formatarDinheiro(v: Double): String {
    val inteiro = v.toLong()
    val centavos = Math.round((v - inteiro) * 100)
    return "R$ %d,%02d".format(inteiro, centavos)
}

fun agora(): String {
    contadorCadastro++
    // Simula data/hora — em Kotlin puro sem java.time seria workaround
    // Usando System.currentTimeMillis para montar string simples
    val ms = System.currentTimeMillis()
    val seg = (ms / 1000) % 60
    val min = (ms / 60000) % 60
    val hora = (ms / 3600000) % 24
    return "cadastro #$contadorCadastro (${hora}h${min}m${seg}s)"
}

// ── Auth ──

fun autenticacao() {
    println("Bem-vindo ao $NOME_HOTEL")
    print("Nome: ")
    nomeUsuario = readln().trim().replaceFirstChar { it.uppercase() }

    var tentativas = 0

    while (tentativas < 3) {
        print("Senha: ")
        val senha = readln().trim().toIntOrNull()

        if (senha == null) {
            println("Senha inválida.")
            tentativas++
            println("Tentativa ($tentativas/3)")
            continue
        }

        if (senha == 2678) {
            println("Bem-vindo ao Hotel $NOME_HOTEL, $nomeUsuario. É um imenso prazer ter você por aqui!")
            return
        }

        tentativas++
        println("Senha incorreta ($tentativas/3)")
    }

    println("Sistema bloqueado.")
    exitProcess(0)
}

// ── Menu principal ──

fun menuPrincipal() {
    while (true) {
        println("\n===== Hotel $NOME_HOTEL =====")
        println("1 - Reservas de Quartos")
        println("2 - Cadastro de Hóspedes")
        println("3 - Eventos")
        println("4 - Ar-Condicionado")
        println("5 - Abastecimento")
        println("6 - Relatórios Operacionais")
        println("7 - Sair")
        print("Opção: ")

        when (readln().trim().toIntOrNull()) {
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

// ── Sub 1: Reservas ──

fun exibirMapaQuartos() {
    println("\nMapa de quartos:")
    println("+----+----+----+----+----+")
    for (linha in 0 until 4) {
        print("|")
        for (col in 0 until 5) {
            val idx = linha * 5 + col
            val status = if (quartos[idx]) " O  " else " L  "
            print("$status|")
        }
        println()
        println("+----+----+----+----+----+")
    }
    println("L = Livre  O = Ocupado")
}

fun verificarQuarto(q: Int): Boolean {
    if (q < 1 || q > 20) {
        println("Quarto inválido.")
        return false
    }
    if (!quartos[q - 1]) return true

    println("Quarto já está ocupado. Quartos livres:")
    var tem = false
    for (i in 1..20) {
        if (!quartos[i - 1]) {
            print("$i ")
            tem = true
        }
    }
    if (!tem) println("Nenhum disponível.")
    println()
    return false
}

fun reservaQuartos() {
    println("\n[Reservas]")

    val diaria = lerDouble("Informe o valor da diária: ")
    if (diaria == null || diaria <= 0) {
        println("Valor inválido, $nomeUsuario")
        return
    }

    val dias = lerInt("Informe a quantidade de diárias (1-30): ")
    if (dias == null || dias < 1 || dias > 30) {
        println("Valor inválido, $nomeUsuario")
        return
    }

    print("Informe o nome do hóspede: ")
    val nome = readln().trim()

    print("Tipo de quarto (S/E/L): ")
    val tipo = readln().trim().uppercase()

    val fator: Double
    val tipoNome: String

    when (tipo) {
        "S" -> { fator = 1.00; tipoNome = "Standard" }
        "E" -> { fator = 1.35; tipoNome = "Executivo" }
        "L" -> { fator = 1.65; tipoNome = "Luxo" }
        else -> {
            println("Tipo inválido.")
            return
        }
    }

    var quarto = 0
    while (true) {
        val q = lerInt("Escolha um quarto (1-20): ") ?: continue
        if (verificarQuarto(q)) {
            quarto = q
            break
        }
    }

    val subtotal = diaria * dias * fator
    val taxa     = subtotal * 0.10
    val total    = subtotal + taxa

    println("\nResumo:")
    println("Hóspede : $nome")
    println("Quarto  : $quarto ($tipoNome)")
    println("Subtotal: ${formatarDinheiro(subtotal)}")
    println("Taxa de serviço (10%): ${formatarDinheiro(taxa)}")
    println("Total   : ${formatarDinheiro(total)}")

    print("\n$nomeUsuario, confirma a reserva? (S/N): ")
    val conf = readln().trim().uppercase()

    if (conf == "S") {
        quartos[quarto - 1] = true
        reservaNome.add(nome)
        reservaQuarto.add(quarto)
        reservaDias.add(dias)
        reservaTotal.add(total)
        println("Reserva efetuada com sucesso.")
        exibirMapaQuartos()
    } else {
        println("Reserva não efetuada.")
    }
}

// ── Sub 2: Hóspedes ──

fun cadastroHospedes() {
    while (true) {
        println("\n[Cadastro de Hóspedes]")
        println("1-Cadastrar  2-Pesquisar exato  3-Pesquisar prefixo  4-Listar  5-Atualizar  6-Remover  7-Voltar")
        print("Opção: ")

        when (readln().trim().toIntOrNull()) {

            1 -> {
                if (hospedesNome.size >= 15) {
                    println("Máximo de cadastros atingido")
                } else {
                    print("Nome do hóspede: ")
                    val nome = readln().trim()

                    val existe = hospedesNome.any { it.equals(nome, ignoreCase = true) }
                    if (existe) {
                        println("Hóspede já cadastrado")
                    } else {
                        hospedesNome.add(nome)
                        hospedesData.add(agora())
                        println("Hóspede cadastrado com sucesso.")
                    }
                }
            }

            2 -> {
                print("Nome: ")
                val nome = readln().trim()
                val idx = hospedesNome.indexOfFirst { it.equals(nome, ignoreCase = true) }
                if (idx >= 0) println("Hóspede ${hospedesNome[idx]} foi encontrado")
                else println("Hóspede não encontrado")
            }

            3 -> {
                print("Prefixo: ")
                val prefixo = readln().trim()
                val resultados = hospedesNome.filter { it.startsWith(prefixo, ignoreCase = true) }
                if (resultados.isEmpty()) {
                    println("Hóspede não encontrado")
                } else {
                    println("Resultados:")
                    resultados.forEachIndexed { i, nome -> println("[${i + 1}] $nome") }
                }
            }

            4 -> {
                if (hospedesNome.isEmpty()) {
                    println("Nenhum hóspede cadastrado.")
                } else {
                    val ordenados = hospedesNome.zip(hospedesData).sortedBy { it.first }
                    ordenados.forEachIndexed { i, (nome, data) ->
                        println("${i + 1} - $nome  |  $data")
                    }
                }
            }

            5 -> {
                if (hospedesNome.isEmpty()) { println("Nenhum hóspede cadastrado."); continue }
                hospedesNome.forEachIndexed { i, nome -> println("${i + 1} - $nome") }
                val idx = (lerInt("Índice para atualizar: ") ?: continue) - 1
                if (idx < 0 || idx >= hospedesNome.size) { println("Índice inválido."); continue }
                print("Novo nome: ")
                val novo = readln().trim()
                hospedesNome[idx] = novo
                println("Operação realizada com sucesso")
            }

            6 -> {
                if (hospedesNome.isEmpty()) { println("Nenhum hóspede cadastrado."); continue }
                hospedesNome.forEachIndexed { i, nome -> println("${i + 1} - $nome") }
                val idx = (lerInt("Índice para remover: ") ?: continue) - 1
                if (idx < 0 || idx >= hospedesNome.size) { println("Índice inválido."); continue }
                hospedesNome.removeAt(idx)
                hospedesData.removeAt(idx)
                println("Operação realizada com sucesso")
            }

            7 -> return

            else -> erroOpcao()
        }
    }
}

// ── Sub 3: Eventos ──

fun selecionarAuditorio(convidados: Int): String {
    return if (convidados <= 150) {
        println("Auditório selecionado: Laranja (sem cadeiras adicionais)")
        "Laranja"
    } else if (convidados <= 220) {
        val extras = convidados - 150
        println("Auditório selecionado: Laranja ($extras cadeiras adicionais)")
        "Laranja"
    } else if (convidados <= 350) {
        println("Auditório selecionado: Colorado")
        "Colorado"
    } else {
        println("Número de convidados inválido.")
        ""
    }
}

fun validarJanela(dia: String, hora: Int, duracao: Int): Boolean {
    val limite = when (dia.lowercase()) {
        "segunda", "terca", "quarta", "quinta", "sexta" -> 23
        "sabado", "domingo" -> 15
        else -> return false
    }
    if (hora < 7 || hora >= limite) return false
    if (duracao < 1 || duracao > 12) return false
    if (hora + duracao > limite) return false
    return true
}

fun eventos() {
    println("\n[Eventos]")

    val convidados = lerInt("Convidados: ") ?: return
    if (convidados < 0 || convidados > 350) {
        println("Número de convidados inválido.")
        return
    }

    val auditorio = selecionarAuditorio(convidados)
    if (auditorio.isEmpty()) return

    print("Dia (segunda/terca/.../sabado/domingo): ")
    val dia = readln().trim()

    val hora = lerInt("Hora inicial: ") ?: return
    val duracao = lerInt("Duração (horas): ") ?: return

    if (!validarJanela(dia, hora, duracao)) {
        println("Dados inválidos.")
        return
    }

    print("Empresa: ")
    val empresa = readln().trim()

    println("Status: Auditório reservado.")

    // Garçons
    val garconBase = ceil(convidados / 12.0).toInt()
    val garconExtra = floor(duracao / 2.0).toInt()
    val totalGarcons = garconBase + garconExtra
    val custoGarcons = totalGarcons * duracao * 10.50

    println("\nGarçons necessários: $totalGarcons")
    println("Custo com garçons: ${formatarDinheiro(custoGarcons)}")

    // Buffet
    val cafe     = convidados * 0.2
    val agua     = convidados * 0.5
    val salgados = convidados * 7

    val custoCafe     = cafe * 0.80
    val custoAgua     = agua * 0.40
    val custoSalgados = (salgados / 100.0) * 34.00
    val custoBuffet   = custoCafe + custoAgua + custoSalgados

    println("\nBuffet:")
    println("Café    : %.1f L".format(cafe))
    println("Água    : %.1f L".format(agua))
    println("Salgados: $salgados un")
    println("Custo buffet: ${formatarDinheiro(custoBuffet)}")

    val totalEvento = custoGarcons + custoBuffet
    println("\nTotal do evento: ${formatarDinheiro(totalEvento)}")

    // Relatório técnico
    println("\n--- Relatório Técnico ---")
    println("Auditório : $auditorio")
    println("Empresa   : $empresa")
    println("Dia       : $dia")
    println("Horário   : ${hora}h às ${hora + duracao}h")
    println("Convidados: $convidados")
    println("Garçons   : $totalGarcons")
    println("Duração   : $duracao h")
    println("Custo garçons : ${formatarDinheiro(custoGarcons)}")
    println("Custo buffet  : ${formatarDinheiro(custoBuffet)}")
    println("Total geral   : ${formatarDinheiro(totalEvento)}")
    println("-------------------------")

    print("Confirmar reserva? (S/N): ")
    val conf = readln().trim().uppercase()

    if (conf == "S") {
        eventoEmpresa.add(empresa)
        eventoTotal.add(totalEvento)
        println("Reserva efetuada com sucesso.")
    } else {
        println("Reserva não efetuada.")
    }
}

// ── Sub 4: Ar-Condicionado ──

fun calcularOrcamento(valorUnit: Double, qtd: Int, descPerc: Double, minDesc: Int, desloc: Double): Double {
    var bruto = valorUnit * qtd
    if (qtd >= minDesc) bruto -= bruto * (descPerc / 100.0)
    return bruto + desloc
}

fun arCondicionado() {
    println("\n[Ar-Condicionado]")

    val nomes   = mutableListOf<String>()
    val valores = mutableListOf<Double>()

    var continuar = "S"

    while (continuar.uppercase() == "S") {
        print("Empresa: ")
        val nome = readln().trim()

        val v   = lerDouble("Valor por aparelho: ")   ?: return
        val q   = lerInt("Quantidade: ")              ?: return
        val d   = lerDouble("Desconto (%): ")         ?: return
        val m   = lerInt("Mínimo para desconto: ")    ?: return
        val des = lerDouble("Deslocamento: ")          ?: return

        val total = calcularOrcamento(v, q, d, m, des)

        println("O serviço de $nome custará ${formatarDinheiro(total)}")

        nomes.add(nome)
        valores.add(total)

        print("Deseja informar novos dados, $nomeUsuario? (S/N): ")
        continuar = readln().trim()
    }

    if (valores.isEmpty()) {
        println("Nenhum dado informado.")
        return
    }

    var iMenor = 0
    var iMaior = 0

    for (i in valores.indices) {
        if (valores[i] < valores[iMenor]) iMenor = i
        if (valores[i] > valores[iMaior]) iMaior = i
    }

    val menor = valores[iMenor]
    val maior = valores[iMaior]
    val diferenca = if (maior > 0) ((maior - menor) / maior) * 100 else 0.0

    println("\nMelhor orçamento: ${nomes[iMenor]} — ${formatarDinheiro(menor)}")
    println("Pior orçamento  : ${nomes[iMaior]} — ${formatarDinheiro(maior)}")
    println("Diferença       : %.1f%%".format(diferenca))
}

// ── Sub 5: Abastecimento ──

fun melhorCombustivel(alcool: Double, gasolina: Double): Pair<String, Double> {
    return if (alcool <= gasolina * 0.70) {
        Pair("Álcool", alcool * 42)
    } else {
        Pair("Gasolina", gasolina * 42)
    }
}

fun abastecimento() {
    println("\n[Abastecimento]")

    print("Wayne Oil -> Álcool: ")
    val alcool1 = readln().trim().replace(",", ".").toDoubleOrNull() ?: return
    print("Wayne Oil -> Gasolina: ")
    val gasolina1 = readln().trim().replace(",", ".").toDoubleOrNull() ?: return

    print("Stark Petrol -> Álcool: ")
    val alcool2 = readln().trim().replace(",", ".").toDoubleOrNull() ?: return
    print("Stark Petrol -> Gasolina: ")
    val gasolina2 = readln().trim().replace(",", ".").toDoubleOrNull() ?: return

    val (comb1, custo1) = melhorCombustivel(alcool1, gasolina1)
    val (comb2, custo2) = melhorCombustivel(alcool2, gasolina2)

    println("\nWayne Oil   : melhor opção = $comb1 | Total (42L) = ${formatarDinheiro(custo1)}")
    println("Stark Petrol: melhor opção = $comb2 | Total (42L) = ${formatarDinheiro(custo2)}")

    // Ranking
    if (custo1 <= custo2) {
        println("\n$nomeUsuario, é mais barato abastecer com ${comb1.lowercase()} no posto Wayne Oil.")
    } else {
        println("\n$nomeUsuario, é mais barato abastecer com ${comb2.lowercase()} no posto Stark Petrol.")
    }
}

// ── Sub 6: Relatórios ──

fun relatoriosOperacional() {
    println("\n[Relatórios Operacionais]")

    val ocupados = quartos.count { it }
    val taxaOcupacao = (ocupados / 20.0) * 100

    var receitaHospedagem = 0.0
    for (v in reservaTotal) receitaHospedagem += v

    var receitaEventos = 0.0
    for (v in eventoTotal) receitaEventos += v

    val receitaTotal = receitaHospedagem + receitaEventos

    println("+---------------------------------+")
    println("| Reservas confirmadas : %-8d|".format(reservaNome.size))
    println("| Quartos ocupados     : %-8d|".format(ocupados))
    println("| Taxa de ocupação     : %6.1f%% |".format(taxaOcupacao))
    println("| Hóspedes cadastrados : %-8d|".format(hospedesNome.size))
    println("| Eventos confirmados  : %-8d|".format(eventoEmpresa.size))
    println("+---------------------------------+")
    println("| Receita hospedagem   : %-10s|".format(formatarDinheiro(receitaHospedagem)))
    println("| Receita eventos      : %-10s|".format(formatarDinheiro(receitaEventos)))
    println("| Receita total        : %-10s|".format(formatarDinheiro(receitaTotal)))
    println("+---------------------------------+")
}

// ── Sair ──

fun sair() {
    print("Deseja sair? (S/N): ")
    if (readln().trim().uppercase() == "S") {
        println("Muito obrigado e até logo, $nomeUsuario.")
        exitProcess(0)
    }
}

// ── Main ──

fun main() {
    autenticacao()
    menuPrincipal()
}