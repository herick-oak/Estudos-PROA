programa {
  funcao inicio() {
    // 2. Faça um programa que leia um valor informado pelo usuário e diga se o valor informado é positivo, negativo ou zero.
    inteiro numero_usuario
    escreva("Digite um valor, irei informar se é negativo ou positivo: ")
    leia(numero_usuario)

    se(numero_usuario >= 1){
      escreva("O valor informado é positivo: " + numero_usuario )

    }
    senao{
      escreva("O valor informado é negativo: " + numero_usuario )
    }
  }
}
