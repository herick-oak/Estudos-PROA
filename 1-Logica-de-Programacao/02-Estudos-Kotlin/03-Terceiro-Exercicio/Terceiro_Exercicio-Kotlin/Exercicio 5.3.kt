fun main() {
    // Exercicio 5

    print("Digite o primeiro numero: ")
    var n1 = readln().toInt()
    print("Digite o segundo numero: ")
    var n2 = readln().toInt()

    while (n1 > n2){

        println("Numero invalido, digite um numero superior que ${n1}")
        print("Digite o segundo numero: ")
        n2 = readln().toInt()

    }

    var soma = n1 + n2
    var media = soma / 2

    print("A media da soma do numero ${soma} é ${media}")


}