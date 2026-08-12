programa
{
    funcao erro()
    {
        escreva("Opcao invalida!\n")
    }

    funcao logico validarSenha()
    {
        inteiro senha
        escreva("Senha: ")
        leia(senha)

        se (senha == 3589) {
            retorne verdadeiro
        } senao {
            escreva("Senha incorreta!\n")
            retorne falso
        }
    }

    funcao inicio()
    {
        cadeia nomeUsuario
        real saldo = 150.00
        logico rodando = verdadeiro
        inteiro opcao
        real valor
        inteiro conta

        escreva("Digite seu nome: ")
        leia(nomeUsuario)
        escreva("Olá ", nomeUsuario, " é um prazer ter você por aqui!\n")

        enquanto (rodando)
        {
            escreva("\n=== MENU ===\n")
            escreva("1. Saldo\n")
            escreva("2. Extrato\n")
            escreva("3. Saque\n")
            escreva("4. Deposito\n")
            escreva("5. Transferencia\n")
            escreva("6. Sair\n")
            escreva("Opcao: ")
            leia(opcao)

            escolha (opcao)
            {
                caso 1:
                    se (validarSenha()) {
                        escreva("Saldo atual: R$", saldo, "\n")
                    }
                    pare

                caso 2:
                    se (validarSenha()) {
                        escreva("\n=== EXTRATO ===\n")
                        escreva("Saldo atual: R$", saldo, "\n")
                        escreva("- Mercado: R$ 45.90\n")
                        escreva("- Deposito recebido: R$ 120.00\n")
                        escreva("- Farmacia: R$ 32.50\n")
                        escreva("- Cinema: R$ 25.00\n")
                    }
                    pare

                caso 3:
                    se (validarSenha()) {
                        escreva("Valor do saque: ")
                        leia(valor)

                        se (valor <= 0 ou valor > saldo) {
                            escreva("Operação não autorizada.\n")
                        } senao {
                            saldo = saldo - valor
                            escreva("Saque realizado com sucesso!\n")
                            escreva("Novo saldo: R$", saldo, "\n")
                        }
                    }
                    pare

                caso 4:
                    escreva("Valor do deposito: ")
                    leia(valor)

                    se (valor <= 0) {
                        escreva("Operação não autorizada.\n")
                    } senao {
                        saldo = saldo + valor
                        escreva("Deposito realizado com sucesso!\n")
                        escreva("Novo saldo: R$", saldo, "\n")
                    }
                    pare

                caso 5:
                    se (validarSenha()) {
                        escreva("Numero da conta destino: ")
                        leia(conta)

                        se (conta <= 0) {
                            escreva("Operação não autorizada.\n")
                        } senao {
                            escreva("Valor da transferencia: ")
                            leia(valor)

                            se (valor <= 0 ou valor > saldo) {
                                escreva("Operação não autorizada.\n")
                            } senao {
                                saldo = saldo - valor
                                escreva("Transferencia realizada com sucesso!\n")
                                escreva("Novo saldo: R$", saldo, "\n")
                            }
                        }
                    }
                    pare

                caso 6:
                    escreva(nomeUsuario, ", foi um prazer ter você por aqui!\n")
                    rodando = falso
                    pare

                caso contrario:
                    erro()
            }
        }
    }
}
