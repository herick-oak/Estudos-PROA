programa {
  funcao inicio() {
    // 10. Tendo como entrada a altura e o gênero designado ao nascer (codificado da seguinte forma: 1: feminino - 2: masculino - ) de uma pessoa, construa um programa que calcule e imprima seu peso ideal, utilizando as seguintes fórmulas.

    // homem: (72 * h) - 58
    // mulheres: (62.1 * h) - 44.7
    // Altura = h (ná formula acima)

    escreva("Selecione o gênero\n")
    escreva("1 == feminino\n")
    escreva("2 == masculino\n")

    inteiro opcao 
    leia(opcao)

    se(opcao == 1) {
      feminino()
    } 
    senao se(opcao == 2) {
      masculino()
    }
    senao {
      escreva("Opção inválida!")
    }


  }
    funcao masculino(){
      escreva("Digite a sua altura: ")
      real altura
      leia(altura)

      real peso = (72 * altura) - 58

      escreva("O peso ideal para o sexo masculino é: ", peso)

    }

    funcao feminino(){
      escreva("Digite a sua altura: ")
      real altura
      leia(altura)

      real peso = (62.1 * altura) - 44.7

      escreva("O peso ideal para o sexo feminino é: ", peso)

    }
}
