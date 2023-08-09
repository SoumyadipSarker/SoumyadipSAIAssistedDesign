import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import MorseCodeConverter.DefaultMorseCodeConverter;
public class DefaultMorseCodeConverterTest {
    @Test
    public void testTextToMorse() {
        assertEquals(".... . .-.. .-.. --- --..-- / .-- --- .-. .-.. -.. -.-.--",
                DefaultMorseCodeConverter.convertTextToMorse("Hello, world!"));

        assertEquals(".- / -... --- -..- / --- ..-. / .--. .-. . - - -.-- / -- --- .-. ... . / -.-. --- -.. . .-.-.-",
                DefaultMorseCodeConverter.convertTextToMorse("A box of pretty Morse code."));
        assertEquals("--..-- ..--.. -.-.-- ..--.. -.-.-- --..-- / .. / --..-- ..--.. -.-.-- ..--.. -.-.--",
                DefaultMorseCodeConverter.convertTextToMorse(",?!?!, I    ,?!?!"));

    }

    @Test
    public void testMorseToText() {
        assertEquals("HELLO, WORLD!",
                DefaultMorseCodeConverter.convertMorseToText(".... . .-.. .-.. --- --..-- / .-- --- .-. .-.. -.. -.-.--"));

        assertEquals("A BOX OF PRETTY MORSE CODE.",
                DefaultMorseCodeConverter.convertMorseToText(".- / -... --- -..- / --- ..-. / .--. .-. . - - -.-- / -- --- .-. ... . / -.-. --- -.. . .-.-.-"));
        assertEquals(",?!?!, I ,?!?!",
                DefaultMorseCodeConverter.convertMorseToText("--..-- ..--.. -.-.-- ..--.. -.-.-- --..-- / .. / --..-- ..--.. -.-.-- ..--.. -.-.--"));
    }

    @Test
    public void testMultiLineTextToMorse() {
        String inputText = "Hello, world!\nA box of pretty Morse code.\n,?!?!, I    ,?!?!";
        String expectedMorse = ".... . .-.. .-.. --- --..-- / .-- --- .-. .-.. -.. -.-.--\n"
                + ".- / -... --- -..- .--. .. .- -.-. - / -- --- .-. ... . / ..-. --- .-. / - .... .. ... .-.-.-\n"
                + "-.-.-. ...-..- / .. - / / / / -.-.-. ...-..- / .. - / / / /";
        assertEquals(expectedMorse, DefaultMorseCodeConverter.convertTextToMorse(inputText));
    }

    @Test
    public void testMultiLineMorseToText() {
        String inputMorse = ".... . .-.. .-.. --- --..-- / .-- --- .-. .-.. -.. -.-.--\n"
                + ".- / -... --- -..- .--. .. .- -.-. - / -- --- .-. ... . / ..-. --- .-. / - .... .. ... .-.-.-\n"
                + "-.-.-. ...-..- / .. - / / / / -.-.-. ...-..- / .. - / / / /";
        String expectedText = "HELLO, WORLD!\n"
                + "A BOX OF PRETTY MORSE CODE.\n"
                + ",?!?!, I    ,?!?!";
        assertEquals(expectedText, DefaultMorseCodeConverter.convertMorseToText(inputMorse));
    }
}
