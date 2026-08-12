programa {
  funcao inicio() {
        // 7 - Escreva um algoritmo para ler as notas de avaliações de um aluno,
        // calcule e imprima a média (simples) desse aluno. Só devem ser aceitos 
        // valores válidos durante a leitura (0 a 10) para cada nota. São 6 notas ao total.
        // Caso o valor informado para qualquer uma das notas esteja fora do limite 
        // estabelecido, deve ser solicitado um novo valor ao usuário.
        
        real nota, soma = 0
        inteiro contador = 1
        
        escreva("Cálculo da Média de 6 Notas\n")
        escreva("Notas válidas: apenas valores entre 0 e 10\n")
        
        enquanto(contador <= 6) {
            escreva("Digite a ", contador, "ª nota: ")
            leia(nota)
            
            enquanto(nota < 0 ou nota > 10) {
                escreva("Nota inválida! Digite um valor entre 0 e 10: ")
                leia(nota)
            }
            
            soma = soma + nota
            contador = contador + 1
        }
        

        real media = soma / 6
        escreva("Resultado\n")
        escreva("Média final: ", media, "\n")
        
    }
}



