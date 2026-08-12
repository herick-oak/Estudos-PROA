import kotlin.system.exitProcess

var saldo = 100.5f
val senhaCorreta = 3589
var nomeUsuario = ""
val extrato = mutableListOf<String>()

fun main() {
    print("Digite seu nome: ")
    nomeUsuario = readln()
    println("Olá $nomeUsuario, é um prazer ter você por aqui!")

    inicio()
}

fun inicio() {
    while (true) {
        println("\n=== MENU ===")
        println("1 - Saldo")
        println("2 - Extrato")
        println("3 - Saque")
        println("4 - Depósito")
        println("5 - Transferência")
        println("6 - Sair")
        print("Escolha uma opção: ")

        val escolha = readln().toInt()

        when (escolha) {
            1 -> verSaldo()
            2 -> verExtrato()
            3 -> fazerSaque()
            4 -> fazerDeposito()
            5 -> fazerTransferencia()
            6 -> sair()
            else -> println("Opção inválida")
        }
    }
}

fun validarSenha(): Boolean {
    print("Digite sua senha: ")
    val senha = readln().toInt()

    if (senha != senhaCorreta) {
        println("Senha incorreta!")
        return false
    }
    return true
}

fun verSaldo() {
    if (!validarSenha()) return

    println("Seu saldo atual é: R$ $saldo")
}

fun verExtrato() {
    if (!validarSenha()) return

    println("\n=== EXTRATO ===")

    if (extrato.size == 0) {
        println("Nenhuma movimentação.")
    } else {
        for (item in extrato) {
            println(item)
        }
    }
}

fun fazerDeposito() {
    print("Qual o valor para depósito? ")
    val deposito = readln().toFloat()

    if (deposito <= 0) {
        println("Operação não autorizada")
    } else {
        saldo += deposito
        extrato.add("Depósito de R$ $deposito")
        println("Depósito realizado com sucesso!")
    }
}

fun fazerSaque() {
    if (!validarSenha()) return

    print("Qual o valor para saque? ")
    val saque = readln().toFloat()

    if (saque <= 0 || saque > saldo) {
        println("Operação não autorizada")
    } else {
        saldo -= saque
        extrato.add("Saque de R$ $saque")
        println("Saque realizado com sucesso!")
    }
}

fun fazerTransferencia() {
    if (!validarSenha()) return

    print("Informe o número da conta: ")
    val conta = readln()

    if (conta.any { !it.isDigit() }) {
        println("Conta inválida")
        return
    }

    print("Qual o valor da transferência? ")
    val valor = readln().toFloat()

    if (valor <= 0 || valor > saldo) {
        println("Operação não autorizada")
    } else {
        saldo -= valor
        extrato.add("Transferência de R$ $valor para conta $conta")
        println("Transferência realizada com sucesso!")
    }
}

fun sair() {
    print("Você deseja sair? (S/N) ")
    val confirma = readln().uppercase()

    when (confirma) {
        "S" -> {
            println("$nomeUsuario, foi um prazer ter você por aqui!")
            exitProcess(0)
        }
        "N" -> return
        else -> sair()
    }
}

