programa {
  funcao inicio() {
    // 5 - Faça um algoritmo que calcule e escreva a média aritmética dos dois números inteiros informados pelo usuário 
    // e todos os números inteiros entre eles. Considere que o primeiro sempre será menor que o segundo.
    
    inteiro v1, v2
    real media
    
    escreva("Digite o primeiro numero: ")
    leia(v1) 
    
    escreva("Digite o segundo numero (maior que o primeiro): ")
    leia(v2)

    enquanto(v2 <= v1) {
      escreva("Numero invalido! Digite um numero maior que ", v1, ": ")
      leia(v2)
    }

    inteiro soma = 0
    inteiro contador = 0
    inteiro numeroAtual
    
    numeroAtual = v1
    enquanto(numeroAtual <= v2) {
      soma = soma + numeroAtual
      contador = contador + 1
      numeroAtual = numeroAtual + 1
    }
    
    media = soma / contador
    
    escreva("Resultados\n")
    escreva("Quantidade de números: ", contador, "\n")
    escreva("Soma dos números: ", soma, "\n")
    escreva("Média aritmética: ", media, "\n")
    

  }
}