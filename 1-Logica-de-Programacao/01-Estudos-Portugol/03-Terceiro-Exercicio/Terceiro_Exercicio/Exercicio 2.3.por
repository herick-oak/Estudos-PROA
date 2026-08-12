programa {
  funcao inicio() {
// 2 - Escreva um algoritmo para ler 2 valores informados pelo usuário e enquanto o segundo valor informado for igual ou menor que ZERO, deve ser lido um novo valor, mas para a mesma variável. Ou seja, para o segundo valor não pode ser aceito o valor zero nem um valor negativo. 
// O seu programa deve imprimir o resultado da divisão do primeiro valor lido pelo segundo valor e exibir o resultado ao usuário
    
    escreva("Digite o primeiro valor: ")
    real n1 
    leia(n1)
    escreva("Digite o segundo valor: ")
    real n2
    leia(n2)


    enquanto(n2 <= 0){

      escreva("Valor invalido, Digite novamente\n")
      escreva("Digite o segundo valor: ")
      leia(n2)

    }

    real divisao = n1 / n2

    escreva("O resultado do calculo foi: ", divisao)
   

  }
}
