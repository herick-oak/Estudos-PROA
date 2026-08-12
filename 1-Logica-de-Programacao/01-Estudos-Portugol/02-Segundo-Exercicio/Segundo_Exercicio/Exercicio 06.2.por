programa {
  funcao inicio() {
    // 6. Faça um programa que receba quatro valores informados pelo usuário, mas informe somente o primeiro, o último e o maior de todos eles (considere que todos os números informados serão diferentes)
    
    escreva("Digite o primeiro valor: ")
    inteiro n1
    leia(n1)
    escreva("Digite o segundo valor: ")
    inteiro n2
    leia(n2)
    escreva("Digite o terceiro valor: ")
    inteiro n3
    leia(n3)
    escreva("Digite o quarto valor: ")
    inteiro n4
    leia(n4)

    inteiro maior = n1

    se(n2 > maior) {
      maior = n2
    }

    se(n3 > maior) {
      maior = n3
    }

    se(n4 > maior) {
      maior = n4
    }
    escreva("\n")
    escreva("Resultados do programa\n")
    escreva("\n")
    escreva("Primeiro valor: " +  n1 + "\n")
    escreva("Último valor: " +  n4 + "\n")
    escreva("Maior valor: " + maior + "\n")

  }
}
