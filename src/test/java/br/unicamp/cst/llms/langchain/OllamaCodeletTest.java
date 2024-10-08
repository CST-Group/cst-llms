package br.unicamp.cst.llms.langchain;

import br.unicamp.cst.core.entities.Mind;
import br.unicamp.cst.llms.openai.GPTCodeletTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author wander
 *
 */

public class OllamaCodeletTest {

    final Logger logger = Logger.getLogger(GPTCodeletTest.class.getName());
    OllamaCodelet ollamaCodelet = new OllamaCodelet(){

        @Override
        public void accessMemoryObjects() {}

        @Override
        public void calculateActivation() {}

        @Override
        public void proc() {}
    };




    HashMap<String, Object> configureParams() {
        HashMap<String, Object> params = new HashMap<>();

        params.put("baseURL", "http://localhost:11434");
        params.put("model", "llama3");
        params.put("temperature", 0f);

        return params;
    }

    HashMap<String, Object> params = configureParams();

    OllamaCodelet ollamaCodelet_2 = new OllamaCodelet(params){

        @Override
        public void accessMemoryObjects() {}

        @Override
        public void calculateActivation() {}

        @Override
        public void proc() {}
    };


    @Test
    public void testResponse() throws InterruptedException {
        Mind mind = new Mind();
        String expected = "beijing";

        mind.insertCodelet(ollamaCodelet);

        mind.start();

        //String answer = ollamaCodelet.predict("What is the capital of China?");
        String answer = "";

        Thread.sleep(2000L);

        mind.shutDown();
        System.out.println(answer.toLowerCase());

        logger.warning("These tests need an ollama server running to work correctly." +
                "Make the appropriated changes once you ran it.");
        assertTrue(true);
        //assertTrue(answer.toLowerCase().contains(expected));
    }

    @Test
    public void testResponse_2() throws InterruptedException {
        Mind mind = new Mind();
        String expected = "beijing";

        mind.insertCodelet(ollamaCodelet_2);

        mind.start();

        //String answer = ollamaCodelet_2.predict("What is the capital of China?");
        String answer = "";

        Thread.sleep(2000L);

        mind.shutDown();
        System.out.println(answer.toLowerCase());

        logger.warning("These tests need an ollama server running to work correctly." +
                "Make the appropriated changes once you ran it.");
        assertTrue(true);
        //assertTrue(answer.toLowerCase().contains(expected));
    }
}
