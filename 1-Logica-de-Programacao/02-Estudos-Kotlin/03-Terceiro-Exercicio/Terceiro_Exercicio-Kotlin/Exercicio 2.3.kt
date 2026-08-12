fun main() {
    // Exercicio 2

    print("Digite o primeiro valor: ")
    var n1 = readln().toInt()
    print("Digite o segundo valor: ")
    var n2 = readln().toInt()

    while (n2 <= 0){
        print("Numero invalido, digite novamente: ")
        n2 = readln().toInt()
    }

    var divisao = n1 / n2

    print("O resultado da divisão de ${n1} e ${n2} foi ${divisao}")

}