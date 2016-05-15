package com.example;

import java.util.Random;

public class JokeSmith {
    private String[] jokes = {
            "Surely every car is a people carrier?,",
            "What's the difference between a 'hippo' and a 'Zippo'? One is really heavy, the other is a little lighter",
            "If I could take just one thing to a desert island I probably wouldn't go",
            "I've decided to sell my Hoover... well, it was just collecting dust.",
            "Red sky at night. Shepherd's delight. Blue sky at night. Day",
            "I took part in the sun tanning Olympics - I just got Bronze.",
            "Crime in multi-storey car parks. That is wrong on so many different levels.",
            "I've just been on a once-in-a-lifetime holiday. I'll tell you what, never again.",
            "Hedgehogs - why can't they just share the hedge?",
            "To the people who've got iPhones: you just bought one, you didn't invent it!",
            "I've been reading the news about there being a civil war in Madagascar. Well, I've seen it six times and there isn't."
    };
    public String getJoke(){
        int idx = new Random().nextInt(jokes.length);
        return jokes[idx];
    }


}
