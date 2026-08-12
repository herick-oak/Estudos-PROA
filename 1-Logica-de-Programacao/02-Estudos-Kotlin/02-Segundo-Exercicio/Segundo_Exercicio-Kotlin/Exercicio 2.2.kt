fun main() {
//    2. Faça um programa que leia um valor informado pelo usuário
//    e diga se o valor informado é positivo, negativo ou zero.

    print("Digite um valor aleatorio: ")
    var numero = readln().toInt()

    if (numero >= 1){
        print("Esse numero é positivo!!!")

    } else if(numero == 0){
        print("Esse numero é Zero!!")

    } else{
        print("O numero informado é negativo")
    }

}