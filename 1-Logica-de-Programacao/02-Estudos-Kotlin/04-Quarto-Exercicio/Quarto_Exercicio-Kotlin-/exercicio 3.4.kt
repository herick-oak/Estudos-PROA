fun main() {
    //Vamos criar uma lista de compras.
//Crie uma array de frutas, exiba-a ao usuário e, em seguida,
// peça ao usuário para digitar o nome de uma das frutas.
//Caso a fruta esteja no array, remova-a e exiba a mensagem "Fruta foi retirada da lista".
//Peça novamente para o usuário digitar o nome de uma fruta para ser removida.
//Sempre que o usuário procurar por uma fruta que não está no array exiba
// a mensagem "Fruta indisponível no nosso mercado".
//Quando o array não possuir mais itens dentro de si,
// escreva "Lista de compras finalizada".

    val frutas = mutableListOf("Maçã", "Banana", "Laranja", "Uva", "Manga")

    println("Lista de compras:")
    println(frutas)

    while (true) {

        println("\nDigite o nome de uma fruta para remover:")
        val frutaDigitada = readln().lowercase()

        val frutaEncontrada = frutas.find { it.lowercase() == frutaDigitada }

        if (frutaEncontrada != null) {
            frutas.remove(frutaEncontrada)
            println("Fruta foi retirada da lista")
        } else {
            println("Fruta indisponível no nosso mercado")
        }

        println("Lista atual: $frutas")

        // Aqui controlamos o fim sem usar isEmpty()
        if (frutas.size == 0) {
            println("\nLista de compras finalizada")
            break
        }
    }
}