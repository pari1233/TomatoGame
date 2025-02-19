package engine;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import javax.imageio.ImageIO;

public class GameServer {

    public Game getRandomGame() {
        String tomatoapi = "https://marcconrad.com/uob/tomato/api.php?out=csv&base64=yes";
        String dataraw = readUrl(tomatoapi);

        if (dataraw == null) {
            // Error occurred while fetching data
            return null;
        }

        String[] data = dataraw.split(",");

        byte[] decodeImg = Base64.getDecoder().decode(data[0]);
        ByteArrayInputStream quest = new ByteArrayInputStream(decodeImg);

        int solution = Integer.parseInt(data[1]);

        try {
            BufferedImage img = ImageIO.read(quest);
            return new Game(img, solution);
        } catch (IOException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    private String readUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            InputStream inputStream = url.openStream();

            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
