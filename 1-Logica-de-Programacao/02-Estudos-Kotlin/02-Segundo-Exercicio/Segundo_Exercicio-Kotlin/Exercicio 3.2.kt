fun main() {
//    3. Faça um programa para ler 3 valores
//    (considere que não serão informados valores iguais) e escrever o maior deles.

    print("Digite o primeiro numero: ")
    var n1 = readln().toInt()
    print("Digite o segundo numero: ")
    var n2 = readln().toInt()
    print("Digite o terceiro numero: ")
    var n3 = readln().toInt()


    if (n1 > n2 && n1 > n3) {
        print("${n1} é maior")
    } else if (n2 > n1 && n2 > n3) {
        print("${n2} é maior")
    } else {
        print("${n3} é maior")
    }
}