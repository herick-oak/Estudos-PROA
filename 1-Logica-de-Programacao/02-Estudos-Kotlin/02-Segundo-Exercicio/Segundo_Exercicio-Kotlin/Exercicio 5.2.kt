fun main() {
//    5.  Faça um programa que leia 6 valores informados pelo usuário, calcule
//    , exiba os números informados e escreva a média aritmética desses valores lidos.

    print("Digite o primeiro valor: ")
    var n1 = readln().toInt()
    print("Digite o segundo valor: ")
    var n2 = readln().toInt()
    print("Digite o terceiro valor: ")
    var n3 = readln().toInt()
    print("Digite o quarto valor: ")
    var n4 = readln().toInt()
    print("Digite o quinto valor: ")
    var n5 = readln().toInt()
    print("Digite o sexto valor: ")
    var n6 = readln().toInt()

    var media = (n1 + n2 + n3 + n4 + n5 + n6) / 6

    println("Números informados: ${n1}, ${n2}, ${n3}, ${n4}, ${n5}, ${n6}")
    print("O resultado da media é ${media}")


}