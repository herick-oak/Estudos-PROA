programa {
    funcao inicio() {
        // 10 - Escreva um programa em que o usuário informe 10 valores e escreva 
        // quantos desses valores lidos estão entre os números 24 e 42 
        // (incluindo os valores 24 e 42) e quantos deles estão fora deste intervalo.
        
        inteiro valor, contador
        inteiro dentro = 0, fora = 0

        escreva("Usando enquanto (outra execução)\n")
        
        dentro = 0
        fora = 0
        contador = 1
        
        enquanto(contador <= 10) {
            escreva("Digite o ", contador, "º valor: ")
            leia(valor)
            
            se(valor >= 24 e valor <= 42) {
                dentro = dentro + 1
            } senao {
                fora = fora + 1
            }
            
            contador = contador + 1
        }
        
        escreva("Resultados \n")
        escreva("Valores DENTRO do intervalo [24, 42]: ", dentro, "\n")
        escreva("Valores FORA do intervalo [24, 42]: ", fora, "\n")
        
       
    }
}