programa {
    funcao inicio() {
        // 8 - Ler um valor N e imprimir todos os valores inteiros entre 1 (inclusive) e N (inclusive).
        // Considere que o N será sempre maior que ZERO.
        // N é um valor informado pelo usuário
        
        inteiro n, contador
        
        escreva("IMPRESSÃO DE NÚMEROS DE 1 ATÉ N \n")
        escreva("Digite um valor N (maior que zero): ")
        leia(n)
        
        enquanto(n <= 0) {
            escreva("Valor inválido! Digite um número maior que zero: ")
            leia(n)
        }
        
        escreva("Números de 1 até ", n, ":\n")
        
        escreva("Usando enquanto\n")
        contador = 1
        enquanto(contador <= n) {
            escreva(contador, " ")
            contador = contador + 1
        }  
        
    }
}