programa {
  funcao inicio() {
    inteiro opcao 
    escreva("Selecione a opção abaixo\n")
    escreva("1 == Retangulo\n")
    escreva("2 == Quadrado\n")
    escreva("3 == Losangolo\n")
    escreva("4 == Trapezio\n")
    escreva("5 == Paralelogramo\n")
    escreva("6 == Triangulo\n")
    escreva("7 == Circulo\n")

    leia(opcao)
    
    se(opcao == 1 ){
      retangulo()
    }
    senao se(opcao == 2){
      quadrado()
    }

    senao se(opcao == 3){
      losango()
    }
    senao se(opcao == 4){
      trapezio()
    }
    senao se(opcao == 5){
      paralelogramo()
    }
    senao se(opcao == 6 ){
      triangulo()

    }
    senao se(opcao == 7){
      circulo()

    }
    senao{
      escreva("Opção invalida, finalizando o codigo")
    }

  }

  funcao retangulo(){
    escreva("Calculo do Retangulo\n")
    real base
    real altura
    escreva("Digite a base: ")
    leia(base)
    escreva("Digite a altura: ")
    leia(altura)

    real area = base * altura

    escreva("Área do retângulo: ", area)

  }

  funcao quadrado(){
    escreva("Calculo do Quadrado\n")
    real lado
    escreva("Digite um valor para lado: ")
    leia(lado)
    real area = lado * lado
    escreva("A area do quadrado é: ", area)

  }

  funcao losango(){
    escreva("Calculo do losango\n")
    escreva("Digite a diagonal maior: ")
    real diagonal_maior
    leia(diagonal_maior)
    escreva("Digite a diagonal menor: ")
    real diagonal_menor
    leia(diagonal_menor)
    real area = (diagonal_maior * diagonal_menor) / 2
    escreva("A area do losango é: ", area)

  }

  funcao trapezio(){
    escreva("Calculo do Trapezio\n")
    escreva("Digite a base maior: ")
    real base_maior
    leia(base_maior)
    escreva("Digite a base menor: ")
    real base_menor
    leia(base_menor)
    escreva("Digite a h: ")
    real h
    leia(h)

    real area = (base_maior + base_menor) * h / 2
    escreva("A area do trapezio é: ", area)

  }

  funcao paralelogramo(){
    escreva("Calculo do Paralelogramo\n")
    real base
    real altura
    escreva("Digite a base: ")
    leia(base)
    escreva("Digite a altura: ")
    leia(altura)

    real area = base * altura

    escreva("Área do paralelogramo: ", area)


  }

  funcao triangulo(){
    escreva("Calculo do Triangulo\n")
    real base
    real altura
    escreva("Digite a base: ")
    leia(base)
    escreva("Digite a altura: ")
    leia(altura)

    real area = (base * altura) / 2

    escreva("Área do triangulo: ", area)

  }

  funcao circulo(){
    escreva("Calculo do Circulo\n")
    real pi = 3.14
    escreva("Digite o valor de r: ")
    real r 
    leia(r)

    real area = pi * (r * r)

    escreva("Área do circulo: ", area)


  }
}
