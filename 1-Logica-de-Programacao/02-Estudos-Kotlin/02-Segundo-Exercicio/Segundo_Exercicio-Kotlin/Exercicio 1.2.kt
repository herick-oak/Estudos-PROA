fun main() {

//    1. Escreva um programa em que o usuário informe dois números.
//    Então escreva em tela o maior deles.

    print("Digite o primeiro valor: ")
    var n1 = readln().toInt()
    print("Digite o segundo valor: ")
    var n2 = readln().toInt()

    if (n1 > n2){
        println("O numero ${n1} é maior que ${n2}")
    } else {
        println("O numero ${n2} é maior que ${n1}")
    }

}