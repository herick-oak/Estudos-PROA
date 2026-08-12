fun main() {
    // Exercicio 9

    print("Digite seu ano de nascimento: ")
    var nasc = readln().toInt()
    var calc = 2026 - nasc

    if (calc >= 16){
        println("Você pode votar este ano. ")

    } else{
        println("Idade insuficiente")
    }


}