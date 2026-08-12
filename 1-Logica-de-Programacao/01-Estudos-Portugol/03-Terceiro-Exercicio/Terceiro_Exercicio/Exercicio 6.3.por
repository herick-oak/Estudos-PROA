programa {
    funcao inicio() {
        // 6 - Escreva um programa para ler 2 notas de um aluno, calcular e imprimir a média final. 
        // Considere que a nota de aprovação é 9,5. Logo após escrever a mensagem 
        // "Calcular a média de outro aluno Sim/Não?" e solicitar um resposta. 
        // Se a resposta for "S", o programa deve ser executado novamente, 
        // caso contrário deve ser encerrado exibindo a quantidade de alunos aprovados.
        
        inteiro aprovados = 0
        cadeia opcao = "S"
        real nota1, nota2, mediaAluno
        
        enquanto(opcao == "S" ou opcao == "s") {
            escreva("Digite a primeira nota: ")
            leia(nota1)
            escreva("Digite a segunda nota: ")
            leia(nota2)
            
            mediaAluno = (nota1 + nota2) / 2
            escreva("Média do aluno: ", mediaAluno, "\n")
            
            se(mediaAluno >= 9.5) {
                aprovados = aprovados + 1
                escreva("Aluno aprovado!\n")
            } senao {
                escreva("Aluno reprovado!\n")
            }
            
            escreva("\nCalcular a média de outro aluno? (S/N): ")
            leia(opcao)
            
        }
        
        escreva("Total de alunos aprovados: ", aprovados, "\n")
    }
}
