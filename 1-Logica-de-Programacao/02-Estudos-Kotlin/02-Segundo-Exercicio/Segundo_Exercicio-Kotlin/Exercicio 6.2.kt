fun main() {
//    6. Faça um programa que receba quatro valores informados pelo usuário,
//    mas informe somente o primeiro, o último e o maior de todos eles
//    (considere que todos os números informados serão diferentes)

    print("Informe o primeiro numero: ")
    var num1 = readln().toInt()
    print("Informe o segundo numero: ")
    var num2 = readln().toInt()
    print("Informe o terceiro numero: ")
    var num3 = readln().toInt()
    print("Informe o quarto numero: ")
    var num4 = readln().toInt()
    var maior: Int

    if (num1 > num2 && num1 > num3 && num1 > num4) {
        maior = num1
    }
    else if (num2 > num3 && num2 > num4 && num2 > num1) {
        maior = num2
    }
    else if (num3 > num4 && num3 > num2 && num3 > num1) {
        maior = num3
    } else{
        maior = num4
    }

    println("O primeiro numero informado foi ${num1}")
    println("O ultimo numero informado foi ${num4}")
    println("O maior numero informado foi ${maior}")

}