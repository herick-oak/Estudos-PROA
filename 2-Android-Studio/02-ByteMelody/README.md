# 🎵 ByteMelody

Aplicativo Android desenvolvido em **Kotlin** com **Jetpack Compose** para estudar **integração de sons** no Android. Utilizando o `MediaPlayer`, o app reproduz um som com controle de reprodução e liberação adequada de recursos.

---

## 📌 Sobre o projeto

O **ByteMelody** é uma atividade focada no estudo de integração de áudio no Android. O app possui uma interface simples com um botão de reprodução que, ao ser pressionado, toca um som — e, caso o som já esteja tocando, ele é reiniciado do começo.

Além da reprodução, o projeto aplica boas práticas de ciclo de vida do `MediaPlayer`, como o uso de `remember` para não recriar o player a cada recomposição e `DisposableEffect` para liberar o recurso quando o componente sai da tela, evitando vazamento de memória.

---

## ✨ Funcionalidades

- ▶️ **Reprodução de som**: toque único reproduz o áudio via `MediaPlayer`;
- 🔄 **Reinício inteligente**: se o som já estiver tocando, ele é reiniciado do começo (`pause` + `seekTo(0)` + `start`);
- 🧹 **Liberação de recursos**: o `MediaPlayer` é liberado ao sair da tela (`DisposableEffect`), evitando memory leaks;
- 🖼️ **Interface visual**: layout limpo com header, imagem de destaque, título e botão de ação;
- 📱 **Edge-to-edge**: visual imersivo com `enableEdgeToEdge()`.

---

## 🛠️ Tecnologias e bibliotecas

- **[Kotlin](https://kotlinlang.org/)** — linguagem oficial do desenvolvimento Android;
- **[Jetpack Compose](https://developer.android.com/compose)** — toolkit moderno de UI declarativa;
- **[Material 3](https://m3.material.io/)** — componentes e estilo visual;
- **[MediaPlayer](https://developer.android.com/reference/android/media/MediaPlayer)** — API nativa do Android para reprodução de áudio;
- **[Android Studio](https://developer.android.com/studio)** — IDE utilizada no desenvolvimento.

---

## 🗂️ Estrutura do projeto

```
app/src/main/
├── java/com/example/myapplication/
│   ├── ui/theme/         # Tema do app (MyApplicationTheme)
│   ├── MainActivity.kt   # Ponto de entrada (Scaffold + edge-to-edge)
│   └── telaInicial.kt    # Tela principal com o MediaPlayer (TelaInicial)
└── res/
    ├── raw/              # Arquivo de áudio (sons_ratinho)
    └── drawable/         # Imagens da interface
```

---

## 📱 Como funciona

1. `LocalContext.current` fornece o contexto necessário para criar o `MediaPlayer`;
2. `remember { MediaPlayer.create(context, R.raw.sons_ratinho) }` cria o player **uma única vez**, mantendo-o entre recomposições;
3. Ao pressionar o botão de reprodução:
   - se o som estiver tocando, ele é pausado e retorna ao início (`seekTo(0)`);
   - em seguida, a reprodução é iniciada com `start()`;
4. Quando o componente sai da tela, o `DisposableEffect` chama `release()`, liberando os recursos do sistema.

---

## ▶️ Como executar

1. Clone o repositório: `git clone <url-do-seu-repositorio>`;
2. Abra o projeto no **Android Studio**;
3. Aguarde a sincronização do Gradle;
4. Execute o app em um **emulador** ou **dispositivo físico** (▶️ Run).

---

## 🎯 Conceitos praticados

- ✔️ Integração de áudio com `MediaPlayer` (`create`, `start`, `pause`, `seekTo`, `release`);
- ✔️ Recursos de áudio em `res/raw` (`R.raw`);
- ✔️ Acesso ao contexto do Android no Compose (`LocalContext`);
- ✔️ Ciclo de vida e boas práticas (`remember` + `DisposableEffect`);
- ✔️ UI declarativa com Jetpack Compose (`Column`, `Surface`, `Button`, `Spacer`);
- ✔️ Componentes Material 3 com formas e sombras personalizadas;
- ✔️ Recursos de strings (`stringResource`, `R.string`);
- ✔️ Estrutura com `Scaffold` e visual edge-to-edge.

---

> 🎧 Dica: adicione novos sons na pasta `res/raw` e troque o recurso em `MediaPlayer.create()` para testar outros áudios.