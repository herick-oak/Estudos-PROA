programa {
  funcao inicio() {

    // 1. Escreva um programa em que o usuário informe dois números. Então escreva em tela o maior deles.

    escreva("Insira o primeiro numero: ")
    inteiro n1
    leia(n1)
    escreva("Insira o segundo numero: ")
    inteiro n2
    leia(n2)


    se(n1 > n2) {
      escreva("O numero " + n1 +" e maior que " + n2 )
    }
    senao{
      escreva("O numero " + n2 +" e maior que " + n1 )
    }
  }
}


