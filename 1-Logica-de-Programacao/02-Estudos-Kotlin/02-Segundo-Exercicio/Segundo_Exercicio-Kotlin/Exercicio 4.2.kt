fun main() {
    print("Digite o primeiro numero: ")
    val n1 = readln().toInt()
    print("Digite o segundo numero: ")
    val n2 = readln().toInt()
    print("Digite o terceiro numero: ")
    val n3 = readln().toInt()

    val soma: Int

    if (n1 > n2 && n1 > n3) {
        if (n2 > n3) {
            soma = n1 + n2
        } else {
            soma = n1 + n3
        }
    } else if (n2 > n1 && n2 > n3) {
        if (n1 > n3) {
            soma = n2 + n1
        } else {
            soma = n2 + n3
        }
    } else {
        if (n1 > n2) {
            soma = n3 + n1
        } else {
            soma = n3 + n2
        }
    }

    print("A soma dos dois maiores valores é: ${soma}")
}