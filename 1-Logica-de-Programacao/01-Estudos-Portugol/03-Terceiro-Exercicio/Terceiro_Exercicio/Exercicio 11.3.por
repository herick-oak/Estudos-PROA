programa {
    funcao inicio() {
        inteiro n, i, resultado
        
        escreva("Digite um número para ver sua tabuada: ")
        leia(n)
        
        enquanto (n <= 0) {
            escreva("Por favor, digite um número maior que 0: ")
            leia(n)
        }
        
        escreva("TABUADA DO ", n, "\n")
        
        i = 1
        enquanto (i <= 10) {
            resultado = n * i
            escreva(n, " x ", i, " = ", resultado, "\n")
            i = i + 1
        }
        
    }
}