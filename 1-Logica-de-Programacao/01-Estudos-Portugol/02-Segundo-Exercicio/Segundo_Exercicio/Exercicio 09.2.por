programa {
  funcao inicio() {
    // 9. Escreva um programa para ler o ano de nascimento de uma pessoa e escrever uma mensagem que diga se ela poderá ou não votar este ano (não é necessário considerar o mês em que ela nasceu).
    
    escreva("Vamos ver se você pode votar, escreva o ano em que você nasceu: ")
    inteiro ano 
    leia(ano)

    inteiro resultado = 2026 - ano

    se(resultado >= 18){
      escreva("Você é de maior meow, pode votar :) ")
      
    }
    senao{
      escreva("Você é de menor meow, não pode votar")
    }

    



  }
}
