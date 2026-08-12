# 🎲 EscolhaAleatoria

Aplicativo Android desenvolvido em **Kotlin** com **Jetpack Compose** que sorteia aleatoriamente opções de uma lista — cada uma com nome e imagem. Uma atividade de tema livre e divertido para praticar desenvolvimento mobile.

---

## 📌 Sobre o projeto

O **EscolhaAleatoria** é um app onde o usuário pode sortear coisas aleatórias a partir de uma lista personalizável. Com uma interface simples e intuitiva, o app exibe a opção sorteada em um card com nome + imagem e permite sortear novamente quantas vezes quiser.

O projeto foi desenvolvido no **Android Studio** como uma atividade de tema livre, com o objetivo de praticar UI declarativa, navegação entre telas e gerenciamento de estado com Jetpack Compose.

---

## ✨ Funcionalidades

- 🏠 **Tela inicial**: apresenta o app com título, imagem de destaque, descrição e botão de acesso ao sorteio;
- 🎲 **Sorteio aleatório**: sorteia uma opção da lista a cada clique, usando `random()`;
- 🖼️ **Opções com imagem**: cada opção sorteada exibe seu nome e sua imagem em um card arredondado;
- 🔄 **Sortear novamente**: realize novos sorteios sem sair da tela;
- 🧭 **Navegação**: navegação entre a tela inicial e a tela de sorteio com Navigation Compose.

---

## 🛠️ Tecnologias e bibliotecas

- **[Kotlin](https://kotlinlang.org/)** — linguagem oficial do desenvolvimento Android;
- **[Jetpack Compose](https://developer.android.com/compose)** — toolkit moderno de UI declarativa;
- **[Material 3](https://m3.material.io/)** — componentes e estilo visual;
- **[Navigation Compose](https://developer.android.com/jetpack/compose/navigation)** — navegação entre telas;
- **[Android Studio](https://developer.android.com/studio)** — IDE utilizada no desenvolvimento.

---

## 🗂️ Estrutura do projeto

```
app/src/main/java/com/example/myapplication/
├── ui/theme/         # Tema do app (MyApplicationTheme)
├── MainActivity.kt   # Ponto de entrada e navegação (NavHost)
├── sorteio.kt        # Tela de sorteio (TelaSorteio)
└── telaInicial.kt    # Tela inicial (MinhaTelaInicial)
```

---

## 📱 Como funciona

1. A **tela inicial** exibe o título do app, uma imagem de destaque, a descrição e o botão **"Ir para Sorteio"**;
2. Ao entrar na **tela de sorteio**, uma opção é sorteada aleatoriamente da lista (`listaOpcoes.random()`);
3. A opção sorteada é exibida com **nome** e **imagem** em um card arredondado com sombra;
4. Pelos botões, o usuário pode **"Sortear novamente"** ou voltar para a **"Tela Inicial"**.

> 💡 A lista de opções (nomes e imagens) pode ser facilmente personalizada na variável `listaOpcoes`, no arquivo `sorteio.kt`.

---

## ▶️ Como executar

1. Clone o repositório: `git clone <url-do-seu-repositorio>`;
2. Abra o projeto no **Android Studio**;
3. Aguarde a sincronização do Gradle;
4. Execute o app em um **emulador** ou **dispositivo físico** (▶️ Run).

---

## 🎯 Conceitos praticados

- ✔️ UI declarativa com Jetpack Compose (composables, `Modifier`, `Column`, `Box`);
- ✔️ Gerenciamento de estado com `remember` e `mutableStateOf`;
- ✔️ Navegação entre telas (`NavHost`, `composable`, `rememberNavController`);
- ✔️ Data classes (`OpcaoSorteio`);
- ✔️ Recursos de imagem (`painterResource`, `R.drawable`);
- ✔️ Recursos de strings (`stringResource`, `R.string`);
- ✔️ Componentes do Material 3 (`Button`, `Surface`, `Text`);
- ✔️ Layouts personalizados (cantos arredondados, sombras, espaçamentos);
- ✔️ Previews de interface (`@Preview`).

---
