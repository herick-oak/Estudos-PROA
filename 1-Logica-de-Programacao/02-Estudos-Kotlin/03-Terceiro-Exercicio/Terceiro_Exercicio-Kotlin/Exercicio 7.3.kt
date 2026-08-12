fun main() {
    //7 - Escreva um algoritmo para ler as notas de avaliações de um aluno,
// calcule e imprima a média (simples) desse aluno.
// Só devem ser aceitos valores válidos durante a leitura (0 a 10) para cada nota.
// São 6 notas ao total.
//Caso o valor informado para qualquer uma das notas esteja fora do limite estabelecido
// , deve ser solicitado um novo valor ao usuário.

    var soma = 0.0
    var contador = 0

    while (contador < 6){
        print("Digite a ${contador+1} nota: ")
        var nota = readln().toDouble()
        if (nota > 0 && nota < 10){
            soma += nota
            println("Nota adicionada com sucesso!")
            contador++
        } else {
            println("Numero invalido, Digite novamente!")
        }

    }

    var media = soma / 6

    print("A media final do aluno é ${media}")
}