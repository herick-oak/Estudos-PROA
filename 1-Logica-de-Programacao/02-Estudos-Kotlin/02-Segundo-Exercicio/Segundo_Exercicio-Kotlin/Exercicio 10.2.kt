fun masculino(){
    print("Insira sua altura: ")
    var h = readln().toDouble()
    var soma = (72.7 * h ) - 58
    print("Seu peso ideal é ${soma}")
}

fun feminino(){
    print("Insira sua altura: ")
    var h = readln().toDouble()
    var soma = (62.1 * h ) - 44.7
    print("Seu peso ideal é ${soma}")
}



fun main() {
    // Exercicio 10

    println("Calculadora de peso ideal.")
    println("Digite == 1 para calculara o Masculino")
    println("Digite == 2 para calculara o Feminino")
    print("Digite a opção: ")
    var opcao = readln().toInt()

    when(opcao){
        1 -> masculino()
        2 -> feminino()
        else -> print("Numero invalido, tente novamente.")
    }
}
