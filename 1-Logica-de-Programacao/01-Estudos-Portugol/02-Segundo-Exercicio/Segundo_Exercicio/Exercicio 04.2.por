programa {
  funcao inicio() {
    
    // 4. Faça um programa que leia 3 valores informados pelo usuário (considere que não serão informados valores iguais) e escrever a soma dos 2 maiores.

    escreva("Escreva o primeiro valor: ")
    inteiro n1 
    leia(n1)

    escreva("Escreva o segundo valor: ")
    inteiro n2
    leia(n2)

    escreva("Escreva o terceiro valor: ")
    inteiro n3
    leia(n3)

    inteiro somaTotal = n1 + n2 + n3
    inteiro menor

    se (n1 < n2 e n1 < n3){
      menor = n1 
    }
    senao se (n2 < n1 e n2 < n3){
      menor = n2
    }
    senao{
      menor = n3
    }

    inteiro resultado = somaTotal - menor
    escreva("A soma dos dois maiores é: " + resultado)
  }
}