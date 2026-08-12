programa {
  funcao inicio() {

  //Escreva um programa para ler 2 valores inteiros informados pelo usuário e uma das seguintes operações a serem executadas (codificada da seguinte forma: 1. Adição, 2. Subtração, 3. Divisão, 4. Multiplicação).
//O programa deve calcular e escrever o resultado dessa operação sobre os dois valores lidos. 
//Observação: Considere que só serão lidos os valores 1, 2, 3 ou 4 para as operações
    escreva("Digite a opção: ")
    inteiro opcao 
    leia(opcao)

    se(opcao == 1){
      adicao()
    }
    se(opcao == 2){
      subtracao()
    }
    se(opcao == 3){
      divisao()
    }
    se(opcao == 4){
      multiplicacao()
    }
    se(opcao > 4){
      escreva("Valor invalido, digite novamente")
    }

  }
  
  funcao adicao(){
    escreva("Calculo de adição\n")
    escreva("Digite o primeiro valor:")
    inteiro v1
    leia(v1)
    escreva("Digite o segundo valor:")
    inteiro v2
    leia(v2)

    inteiro adicao = v1 + v2

    escreva("O resultado da sua conta é: ",adicao)

  }

  funcao subtracao(){
    escreva("Calculo de subtração\n")
    escreva("Digite o primeiro valor:")
    inteiro v1
    leia(v1)
    escreva("Digite o segundo valor:")
    inteiro v2
    leia(v2)

    inteiro subtracao = v1 - v2

    escreva("O resultado da sua conta é: ",subtracao)

  }

  funcao divisao(){
    escreva("Calculo de divisão\n")
    escreva("Digite o primeiro valor:")
    inteiro v1
    leia(v1)
    escreva("Digite o segundo valor:")
    inteiro v2
    leia(v2)

    real divisao = v1 / v2

    escreva("O resultado da sua conta é: ",divisao)

  }

  funcao multiplicacao(){
    escreva("Calculo de multiplicação\n")
    escreva("Digite o primeiro valor:")
    inteiro v1
    leia(v1)
    escreva("Digite o segundo valor:")
    inteiro v2
    leia(v2)

    real multiplicacao = v1 * v2

    escreva("O resultado da sua conta é: ",multiplicacao)

  }



}
