fun main() {

    //1 - Estudantes.
    // Crie um programa onde o usuário possa cadastrar estudantes sem limites,
    // e, em seguida, Se o usuário digitar "PARE" o programa deve exibir a quantidade
    // de estudantes cadastrados e a lista com cada um deles.

    val estudantes = mutableListOf<String>()

    while (true) {

        println("Digite o nome do aluno(a):")
        val estu = readln()
        estudantes.add(estu)

        println("Digite [PARE] para encerrar ou qualquer coisa para continuar:")
        val opcao = readln().lowercase()

        if (opcao == "pare") {
            break
        }
    }

    println("\nQuantidade de estudantes cadastrados: ${estudantes.size}")
    println("Lista de estudantes:")

    for (aluno in estudantes) {
        println("- $aluno")
    }
}
