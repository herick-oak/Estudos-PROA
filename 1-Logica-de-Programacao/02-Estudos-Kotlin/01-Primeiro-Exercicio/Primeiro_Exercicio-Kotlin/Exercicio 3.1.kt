fun main() {
//    Escreva um programa em que o usuário informe o seu nome e em seguida o programa perguntará a idade do usuário. Agora o programa deve exibir a mensagem "Olá, [NomeDoUsuario], sua idade é [idade]".

    print("Digite seu nome: ")
    var usuario = readln()
    print("Digite sua idade: ")
    var idade = readln().toInt()

    print("Olá, ${usuario}, sua idade é ${idade}")

}