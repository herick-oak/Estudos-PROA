fun main() {
    //8 - Ler um valor N e imprimir todos os valores inteiros entre 1 (inclusive)
// e N (inclusive). Considere que o N será sempre maior que ZERO.
    //N  é um valor informado pelo usuário


    print("Informe o primeiro numero: ")
    var n1 = readln().toInt()

    while(n1 <= 0){
        println("Digite novamente!")
        print("Informe o primeiro numero: ")
        n1 = readln().toInt()

    }

    var contador = 1


    while (contador <= n1){
        println(contador)
        contador++

    }


}