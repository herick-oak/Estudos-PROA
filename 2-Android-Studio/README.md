# 📱 Android Studio

Repositório central dos meus estudos de **desenvolvimento mobile** com **Android Studio**, parte do curso **PROA**. Aqui eu aplico, na prática, toda a lógica de programação construída na etapa anterior — agora criando aplicativos Android reais com **Kotlin** e **Jetpack Compose**.

---

## 📌 Sobre o projeto

Este espaço reúne meus primeiros projetos de desenvolvimento mobile. Ele representa a evolução natural dos meus estudos: depois de consolidar os fundamentos da lógica (veja o repositório de **Lógica de Programação**), passei a aplicar esse conhecimento na construção de interfaces e aplicativos Android.

Cada app foi desenvolvido como uma atividade proposta pelo meu professor, explorando diferentes recursos do ecossistema Android — de navegação entre telas até integração de sons.

---

## 🗂️ Estrutura do repositório

| Repositório | Descrição | Conceitos principais |
| --- | --- | --- |
| 📁 [01-EscolhaAleatoria](./01-EscolhaAleatoria) | 🎲 App de sorteio aleatório com nome + imagem | Navigation Compose, estado, listas e data classes |
| 📁 [02-ByteMelody](./02-ByteMelody) | 🎵 App de reprodução de sons | MediaPlayer, ciclo de vida, DisposableEffect |

---

## 📚 Jornada de aprendizado

### 🎲 01-EscolhaAleatoria
- UI declarativa com Jetpack Compose;
- Navegação entre telas (`NavHost`, `rememberNavController`);
- Gerenciamento de estado (`remember`, `mutableStateOf`);
- Listas de objetos com data classes e recursos de imagem (`R.drawable`).

### 🎵 02-ByteMelody
- Integração de áudio com `MediaPlayer` (`create`, `start`, `pause`, `seekTo`, `release`);
- Ciclo de vida e boas práticas (`remember` + `DisposableEffect`);
- Recursos de áudio em `res/raw`;
- Estrutura com `Scaffold` e visual edge-to-edge.

---

## 🔄 Do console para o mobile

Uma das partes mais interessantes dessa fase é ver como os conceitos que eu já dominava no console ganham vida em uma interface:

| Conceito | Kotlin (console) | Kotlin (Android/Compose) |
| --- | --- | --- |
| Ponto de entrada | `fun main()` | `onCreate()` + `setContent {}` |
| Saída de dados | `println()` | `Text()` |
| Interação do usuário | `readln()` | `Button` / toques na tela |
| Estado | variáveis comuns | `mutableStateOf` + `remember` |
| Fluxo do programa | sequencial | declarativo e reativo |

---

## 🛠️ Tecnologias utilizadas

- **[Kotlin](https://kotlinlang.org/)** — linguagem oficial do desenvolvimento Android;
- **[Jetpack Compose](https://developer.android.com/compose)** — toolkit moderno de UI declarativa;
- **[Material 3](https://m3.material.io/)** — componentes e estilo visual;
- **[Navigation Compose](https://developer.android.com/jetpack/compose/navigation)** — navegação entre telas;
- **[MediaPlayer](https://developer.android.com/reference/android/media/MediaPlayer)** — reprodução de áudio nativa;
- **[Android Studio](https://developer.android.com/studio)** — IDE utilizada em todos os projetos.

---

## 🎯 Objetivos

- ✔️ Construir aplicativos Android reais, do layout à lógica;
- ✔️ Dominar a UI declarativa com Jetpack Compose;
- ✔️ Entender o ciclo de vida de componentes mobile;
- ✔️ Integrar recursos nativos (imagens, sons e strings);
- ✔️ Preparar terreno para projetos mobile mais complexos.

---

Desenvolvido como parte dos estudos de desenvolvimento mobile no curso PROA.
