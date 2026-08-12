programa {
  funcao inicio() {
    // 8. Escreva um programa que calcule a média de quatro números informados pelo usuário, mas somente se esses números forem maiores que 0 e menores que 10. No final, se a média for maior que cinco o usuário receberá uma mensagem "Você passou no teste". Em qualquer outra situação, ele receberá uma mensagem de "tente novamente"
    
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

    inteiro soma = 0

    se(n1 > 0 e n1 < 10){
      soma = soma + n1
    }

    se(n2 > 0 e n2 < 10){
      soma = soma + n2
    }

    se(n3 > 0 e n3 < 10){
      soma = soma + n3
    }

    se(n4 > 0 e n4 < 10){
      soma = soma + n4
    }

    real media = soma / 4

    se(media >= 5){
      escreva("Você passou no teste, a media final foi ", media)
    }
    senao{
      escreva("Tente novamente, sua media final foi ", media , ". Cara você é muito burro, como você conseguiu tirar essa nota.")
    }


  }
}
