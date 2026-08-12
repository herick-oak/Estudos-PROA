fun main() {
    val pet = Bichinho("BiBi")

    var nome = pet.nome

    tela(nome)

    println(" ")
    println(" ")

    print("Escolha a opção para interagir com seu bichinho: ")
    var opcao = readln().toInt()


    // Fiz essa gambiarra no while, porque o exemplo do professor usava while(true)
    // , não queria passar uma sensação de ctrl c e ctrl v

    while(opcao != 999) {

        when(opcao) {
            1 -> pet.brincar()
            2 -> pet.comer()
            3 -> pet.dormir()
            4 -> pet.status()
        }

        if (opcao > 4 && opcao < 999) {
            println("Opção invalida, tente novamente")
        } else if(opcao > 999){
            println("Opção invalida, tente novamente")
        } else if(opcao < 1){
            println("Opção invalida, tente novamente")
        }

        Thread.sleep(2000)
        tela(nome)
        print("Escolha a opção para interagir com seu bichinho: ")
        opcao = readln().toInt()

    }



}


class Bichinho(
    var nome: String,
    var fome: Int = 0,
    var felicidade: Int = 100,
    var energia: Int = 100
){
    fun comer() {
        fome -= 10
        if (fome < 0) fome = 0
        println("$nome está comendo")
    }

    fun brincar() {
        felicidade += 10
        energia -= 10
        println("$nome está brincando")
    }

    fun dormir() {
        energia += 20
        println("$nome está dormindo")
    }

    fun status() {
        println(" ")
        println("Status de $nome:")
        println("Fome: $fome")
        println("Felicidade: $felicidade")
        println("Energia: $energia")
        println(" ")
    }

}

fun tela(nome: String){
    var pet = nome

    println(" ")
    println("Interaja com o ${pet}")
    println(" ")
    println("Para brincar digite [01]")
    println("Para comer digite   [02]")
    println("Para dormir digite  [03]")
    println("Para status digite  [04]")
    println("Para acabar digite  [999]")
    println(" ")
}
