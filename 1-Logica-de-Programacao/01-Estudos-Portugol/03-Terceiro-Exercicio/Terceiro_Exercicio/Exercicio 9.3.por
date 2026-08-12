programa {
    funcao inicio() {
        // 9 - Escreva um algoritmo para imprimir os 10 primeiros números inteiros maiores que 100.
        
        inteiro contador, numero
        
        escreva("10 PRIMEIROS NÚMEROS INTEIROS MAIORES QUE 100\n")

        escreva("Usando enquanto\n")
        contador = 1
        numero = 101
        
        enquanto(contador <= 10) {
            escreva(numero, " ")
            numero = numero + 1
            contador = contador + 1
        }

    }
}
