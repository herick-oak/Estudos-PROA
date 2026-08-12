fun main() {
    // 6 - Escreva um programa para ler 2 notas de um aluno,
// calcular e imprimir a média final. Considere que a nota de aprovação é 9,5.
// Logo após escrever a mensagem "Calcular a média de outro aluno Sim/Não?" e solicitar um resposta.
// Se a resposta for "S", o programa deve ser executado novamente,
// caso contrário deve ser encerrado exibindo a quantidade de alunos aprovados.


    print("Informe o primeiro numero: ")
    var n1 = readln().toDouble()
    print("Informe o segundo numero: ")
    var n2 = readln().toDouble()
    var contador = 0

    var media = (n1+n2)/2

    if (media >= 9.5){
        println("Aluno Aprovado!")
        contador += 1
    } else{
        println("Aluno reprovado!")
    }

    println("Calcular a média de outro aluno Sim/Não?")
    var opcao = readln().lowercase()


    while(opcao[0] == 's'){// como o "s" e um Char. ele tem que ser colocado em aspas simples

        print("Informe o primeiro numero: ")
        n1 = readln().toDouble()
        print("Informe o segundo numero: ")
        n2 = readln().toDouble()

        media = (n1+n2)/2

        if (media >= 9.5){
            println("Aluno Aprovado!")
            contador += 1
        } else{
            println("Aluno reprovado!")
        }

        println("Calcular a média de outro aluno Sim/Não?")
        opcao = readln().lowercase()


    }


    print("Quantidade de alunos aprovados é ${contador}")


}