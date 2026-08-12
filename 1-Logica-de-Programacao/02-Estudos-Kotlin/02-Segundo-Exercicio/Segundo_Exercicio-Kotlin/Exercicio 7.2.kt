fun main() {
//    7. Faça um programa que leia 6 números que o usuário vai informar.
//    Todos os números lidos com valor inferior a 72 devem ser somados.
//    Escreva o valor final da soma efetuada e também todos valores que o usuário informou.

    print("Informe o primeiro valor: ")
    var n1 = readln().toInt()
    print("Informe o primeiro valor: ")
    var n2 = readln().toInt()
    print("Informe o primeiro valor: ")
    var n3 = readln().toInt()
    print("Informe o primeiro valor: ")
    var n4 = readln().toInt()
    print("Informe o primeiro valor: ")
    var n5 = readln().toInt()
    print("Informe o primeiro valor: ")
    var n6 = readln().toInt()

    var soma = 0

    if (n1 < 72) {
        soma += n1
    }
    if (n2 < 72) {
        soma += n2
    }
    if (n3 < 72) {
        soma += n3
    }
    if (n4 < 72) {
        soma += n4
    }
    if (n5 < 72) {
        soma += n5
    }
    if (n6 < 72) {
        soma += n6
    }

    println("Os valores informados foram ${n1},${n2},${n3},${n4},${n5},${n6}")
    println("As soma dos valores foi ${soma}")

}