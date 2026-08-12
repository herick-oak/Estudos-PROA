fun retangulo(){
    println("--Calculo do Retangulo--")
    print("Entre com o a base: ")
    val base = readln().toDouble()
    print("Entre com a altura: ")
    val altura = readln().toDouble()
    val soma = base * altura
    return println("O resultado da base: ${base} e altura: ${altura} é ${soma} ")
}

fun quadrado(){
    println("--Calculo do Retangulo--")
    print("Entre com o lado: ")
    val lado = readln().toDouble()
    val soma = lado * lado
    return println("O resultado do quadrado é ${soma} ")

}

fun losango(){
    println("--Calculo do Losango--")
    print("Entre com a diagonalmaior: ")
    val diagonalmaior  = readln().toDouble()
    print("Entre com a diagonalmenor: ")
    val diagonalmenor  = readln().toDouble()
    val calculo = (diagonalmaior * diagonalmenor) / 2
    return println("O resultado da diagonalmaior ${diagonalmaior} e diagonalmenor: ${diagonalmenor} é ${calculo} ")

}

fun trapezio(){
    println("--Calculo do Trapezio--")
    print("Entre com a base maior: ")
    val diagonalmaior  = readln().toDouble()
    print("Entre com a base menor: ")
    val diagonalmenor  = readln().toDouble()
    print("Entre com H: ")
    val h = readln().toDouble()
    val calculo = (diagonalmaior + diagonalmenor) * h / 2
    return println("O resultado da diagonalmaior ${diagonalmaior} e diagonalmenor: ${diagonalmenor} é ${calculo} ")

}

fun paralelogramo(){
    println("--Calculo do paralelogramo--")
    print("Entre com o a base: ")
    val base = readln().toDouble()
    print("Entre com a altura: ")
    val altura = readln().toDouble()
    val soma = base * altura
    return println("O resultado da base: ${base} e altura: ${altura} é ${soma} ")

}

fun triangulo(){
    println("--Calculo do Triangulo--")
    print("Entre com a base: ")
    val diagonalmaior  = readln().toDouble()
    print("Entre com a altura: ")
    val diagonalmenor  = readln().toDouble()
    val calculo = (diagonalmaior * diagonalmenor) / 2
    return println("O resultado da base: ${diagonalmaior} e altura: ${diagonalmenor} é ${calculo} ")

}

fun circulo(){
    println("--Calculo do Circulo--")
    val pi = 3.14
    print("Entre com R: ")
    val r = readln().toDouble()
    val calculo = pi * (r*2)
    return println("O resultado do circulo: ${calculo} ")

}

fun opcoes(){
    println("--Calculo do opcoes--")
    println("1 - retangulo ")
    println("2 - quadrado ")
    println("3 - losango ")
    println("4 - trapezio ")
    println("5 - paralelogramo ")
    println("6 - triangulo ")
    println("7 - circulo ")

    print("Digite a opção: ")
    val opcoes = readln().toInt()

    when (opcoes) {
        1 -> retangulo()
        2 -> quadrado()
        3 -> losango()
        4 -> trapezio()
        5 -> paralelogramo()
        6 -> triangulo()
        7 -> circulo()
        else -> println("Digite uma opcao valida")
    }
}



fun main() {
    opcoes()
}