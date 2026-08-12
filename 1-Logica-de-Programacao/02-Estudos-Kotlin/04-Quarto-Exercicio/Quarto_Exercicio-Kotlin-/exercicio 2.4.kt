fun main() {
    //2 - Planetas
//Crie uma array de planetas que inclua "Terra", "Marte", "Plutão", "Vênus", "Júpiter", "Saturno"  e,
// em seguida, peça ao usuário para digitar o nome de um planeta.
//Verifique se o planeta que o usuário informou está na array e informe ao usuário.

    val planetas = listOf("terra", "marte", "plutão", "vênus", "júpiter", "saturno")

    print("Digite o nome do planeta: ")
    val usuario = readln().lowercase()

    if (usuario in planetas) {
        println("O planeta está na lista!")
    } else {
        println("O planeta NÃO está na lista!")
    }
}
