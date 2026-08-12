programa {
  funcao inicio() {
    // 4 - Faça um algoritmo que calcule e escreva a média aritmética dos números inteiros entre 15 (inclusive) e 100 (inclusive).
    inteiro contador = 15
    inteiro soma = 0
    inteiro quantidade = 0

    enquanto(contador <= 100){
      quantidade = quantidade + 1
      soma = soma + contador
      contador++

    }

    real media = soma / quantidade

    escreva("Resolução do Exercicio\n")
    escreva("O resultado da soma é: ", soma , "\n")
    escreva("O resultado da quantidade é: ", quantidade,"\n")
    escreva("O resolução da media é: ", media,"\n")
    
  }
}
