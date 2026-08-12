fun main() {
    //10 - Escreva um programa em que o usuário informe 10 valores e escreva quantos
// desses valores lidos estão entre os números 24 e 42 (incluindo os valores 24 e 42)
// e quantos deles estão fora deste intervalo.

    var contador = 0
    var between = 0
    var out = 0

    while (contador < 10){
        print("Digite o ${contador+1} numero: ")
        var n = readln().toInt()
        if (n >= 24 && n <= 42){
            between += 1
        } else{
            out += 1
        }

        contador++
    }

    Thread.sleep(1000)

    println("Os valores entre 24 e 42 foram: $between")
    println("Os valores fora do range foram: $out")

}