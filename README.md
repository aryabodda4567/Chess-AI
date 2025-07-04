# Chess Game with AI Integration

## About the Project

This is a Java-based chess game that allows players to play against an AI opponent. The AI opponent is powered by the Llama 3.2 model, integrated via Ollama. Originally designed for AI vs. AI mode, the game can be modified to support human vs. human or human vs. AI gameplay.

## Features

- **AI Integration**: Utilizes the Llama 3.2 model via Ollama for AI-based gameplay.
- **Multiple Gameplay Modes**: The game can be played in AI vs. AI, human vs. human, or human vs. AI mode.
- **No External Dependencies**: The game operates without requiring additional external packages or dependencies.
- **Model Customization**: You can change the AI model by modifying the configuration in the `Chat.java` file.

## Installation and Setup

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/aryabodda4567/Chess-AI.git 
    ```
2. **(Optional) Configure the AI Model**:  
   The game uses the Llama 3.2 model through Ollama to generate AI moves. The configuration for the Llama model is located in the `Chat.java` file. To change the model, simply modify the settings within this file.

## How It Works

- The game board and chess logic are implemented in Java.
- When it is the AI's turn, the current board state is serialized and sent to the Llama 3.2 model (using Ollama's API).
- The AI model returns a move, which is parsed and applied to the board.
- The game supports special options such as draw, resign, and checkmate detection.

## Configuring Gameplay Modes

The game is initially set up for AI vs. AI mode. If you'd like to change the gameplay mode, you can adjust the methods in the `Main.java` file. The game can be configured for:

- **AI vs. AI**
- **Human vs. AI**
- **Human vs. Human**

Simply modify the game loop in `Main.java` to switch between these modes.

## License

MIT

---
