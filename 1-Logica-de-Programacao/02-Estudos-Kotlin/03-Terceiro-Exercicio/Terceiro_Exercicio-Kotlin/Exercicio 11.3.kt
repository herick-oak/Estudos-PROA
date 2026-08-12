fun main() {
    //11 - Escreva um programa para imprimir todas as tabuadas de 1 a N.
// N será informado pelo usuário.

    print("Digite qual a tabuada desejada: ")
    var tab = readln().toInt()
    for (i in 1..tab) {
        println("Executando a tabudada do ${i}")
        for (j in 1..10) {
            println("${i} x ${j} = ${j*i}")
            Thread.sleep(100)
        }

    }
}