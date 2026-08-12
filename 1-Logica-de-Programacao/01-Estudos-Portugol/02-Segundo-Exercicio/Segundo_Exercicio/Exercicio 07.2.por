programa {
  funcao inicio() {

    // 7. Faça um programa que leia 6 números que o usuário vai informar. Todos os números lidos com valor inferior a 72 devem ser somados. Escreva o valor final da soma efetuada e também todos valores que o usuário informou.  
    
    escreva("Digite o primeiro numero: ")
    inteiro n1 
    leia(n1)
    escreva("Digite o segundo numero: ")
    inteiro n2 
    leia(n2)
    escreva("Digite o terceiro numero: ")
    inteiro n3
    leia(n3)
    escreva("Digite o quarto numero: ")
    inteiro n4 
    leia(n4)
    escreva("Digite o quinto numero: ")
    inteiro n5 
    leia(n5)
    escreva("Digite o sexto numero: ")
    inteiro n6
    leia(n6)


    inteiro soma = 0

    se(n1 < 72){
      soma = soma + n1
    }

    se(n2 < 72){
      soma = soma + n2
    }
    se(n3 < 72){
      soma = soma + n3
    }
    se(n4 < 72){
      soma = soma + n4
    }
    se(n5 < 72){
      soma = soma + n5
    }
    se(n6 < 72){
      soma = soma + n6
    }


    escreva("-------------------------------\n")
    escreva("O resultado das somas é: "+ soma)







  }
}
