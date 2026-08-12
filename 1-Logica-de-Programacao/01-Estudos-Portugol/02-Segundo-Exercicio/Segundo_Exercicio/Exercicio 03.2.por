programa {
  funcao inicio() {
    // 3. Faça um programa para ler 3 valores (considere que não serão informados valores iguais) e escrever o maior deles.

    escreva("Escreva o primeiro valor: ")
    inteiro v1
    leia(v1)
    escreva("Escreva o segundo valor: ")
    inteiro v2
    leia(v2)
    escreva("Escreva o terceiro valor: ")
    inteiro v3
    leia(v3)

    se(v1 > v2){
      escreva("v1 é maior v2")
    }
    senao se(v2 > v3){
      escreva("v2 é maior v3")
    }
     senao{
      escreva("v3 é maior que todos")
    }
    
  }
}
