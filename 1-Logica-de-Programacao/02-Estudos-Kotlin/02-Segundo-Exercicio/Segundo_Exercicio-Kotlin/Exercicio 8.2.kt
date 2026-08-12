fun main() {
    // Exercicio 8

    print("Entre com primeiro numero: ")
    var n1 = readln().toDouble()
    print("Entre com segundo numero: ")
    var n2 = readln().toDouble()
    print("Entre com terceiro numero: ")
    var n3 = readln().toDouble()
    print("Entre com quarto numero: ")
    var n4 = readln().toDouble()

    var soma = 0.0


    if (n1 > 0 && n1 < 10 ){
        soma += n1
    }
    if (n2 > 0 && n2 < 10 ){
        soma += n2
    }
    if (n3 > 0 && n3 < 10 ){
        soma += n3
    }
    if (n4 > 0 && n4 < 10 ){
        soma += n4
    }

    var media = (soma / 4)

    if (media >= 5){
        println("Você passou no teste.")

    }else{
        println("Tente novamente.")
    }


//    println("A soma é ${soma}")
//    println("A media é ${media}")

}