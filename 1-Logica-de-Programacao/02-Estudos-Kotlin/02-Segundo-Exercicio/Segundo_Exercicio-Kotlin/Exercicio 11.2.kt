fun main() {
    println("Calculadora Simples")

    // Leitura dos 2 valores inteiros (sem validação de faixa, conforme enunciado)
    print("Digite o primeiro numero: ")
    val n1 = readln().toInt()

    print("Digite o segundo numero: ")
    val n2 = readln().toInt()

    // Menu de operações
    println("\nOperações disponíveis:")
    println("1 - Adição")
    println("2 - Subtração")
    println("3 - Divisão")
    println("4 - Multiplicação")

    print("Digite o codigo da operação (1, 2, 3 ou 4): ")
    val opcao = readln().toInt()

    // Cálculo e exibição do resultado
    when (opcao) {
        1 -> {
            val resultado = n1 + n2
            println("Resultado: $n1 + $n2 = $resultado")
        }
        2 -> {
            val resultado = n1 - n2
            println("Resultado: $n1 - $n2 = $resultado")
        }
        3 -> {
            if (n2 != 0) {
                val resultado = n1 / n2
                println("Resultado: $n1 / $n2 = $resultado")
            } else {
                println("Erro: Divisão por zero não é permitida!")
            }
        }
        4 -> {
            val resultado = n1 * n2
            println("Resultado: $n1 * $n2 = $resultado")
        }
        else -> {
            println("Opção inválida! Escolha 1, 2, 3 ou 4.")
        }
    }
}