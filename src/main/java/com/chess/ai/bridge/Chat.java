package com.chess.ai.bridge;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;




public class Chat {




    public static String getMove(String boardStateString, String color){
         String SYSTEM_PROMPT= String.format("""
 Act as a chess player bot. Your responsibility is to generate the moves based on the given board state. \s
                  The board state is provided in (PROMPT) in the following format: \s
                  [ { piece: ROOK, position: A8 }, { piece: KNIGHT, position: B8 } ] \s
                  Here, the piece in lowercase represents white, and the piece in uppercase represents black. \s
                  The position represents the position of the piece on the board. \s
                  You are playing as %s. Analyze the board and return your move in the following format: \s
                 
                  ### Move Format:
                  - `'source-position destination-position'` (e.g., `'c1 c3'`). \s
                 
                  ### Special Game Options:
                  - Return **CHECK** or **CHECKMATE** along with a move (e.g., `'e2 e4 CHECK'` or `'d5 d8 CHECKMATE'`). \s
                  - Return **DRAW** or **LOSE** alone without any move (e.g., `'DRAW'` or `'LOSE'`). \s
                  - Return **EXIT** alone to end the game (e.g., `'EXIT'`). \s
                 
                  ### STRICT RULES:
                  - Do **not** return any additional text, explanations, or formatting. \s
                  - Only return one of the exact outputs mentioned above. \s
                 
                  ### OUTPUT FORMAT:
                  1. `'source-position destination-position'` (e.g., `'a1 a3'`) \s
                  2. `'source-position destination-position CHECK'` (e.g., `'e2 e4 CHECK'`) \s
                  3. `'source-position destination-position CHECKMATE'` (e.g., `'d5 d8 CHECKMATE'`) \s
                  4. `'DRAW'` \s
                  5. `'LOSE'` \s
                  6. `'EXIT'` \s
                 
                  Nothing else should be included in the response.
                 
            
""",color);




        String model = "llama3.2";
        String fullResponse = "";

        try {
            // Set up an HTTP POST request
            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Create request JSON
            JSONObject requestJson = new JSONObject();
            requestJson.put("model", model);
            requestJson.put("prompt", boardStateString);
            requestJson.put("stream", false);
            requestJson.put("system", SYSTEM_PROMPT);

            // Send request
            try (OutputStream os = conn.getOutputStream()) {
                os.write(requestJson.toString().getBytes());
            }

            // Get response
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String responseLine = br.readLine();
                JSONObject responseJson = new JSONObject(responseLine);
                fullResponse = responseJson.getString("response");
            }


//            System.out.println(fullResponse);
            return fullResponse;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
