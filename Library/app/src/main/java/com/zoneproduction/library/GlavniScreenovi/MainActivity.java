package com.zoneproduction.library.GlavniScreenovi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zoneproduction.library.DodatniProgrami.Quote;
import com.zoneproduction.library.DodatniProgrami.QuoteGenerator;
import com.zoneproduction.library.DodatniProgrami.QuoteTAXD;
import com.zoneproduction.library.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button logInReader, logInWriter, logInGuest;
    TextView signUp, quoteOfDay;
    String[] quotes = {"Man - a being in search of meaning - Plato","The purpose of our lives is to be happy! — Dalai Lama","Life is what happens when you’re busy making other plans! — John Lennon", "Get busy living or get busy dying. — Stephen King","You only live once, but if you do it right, once is enough. — Mae West", "Many of life’s failures are people who did not realize how close they were to success when they gave up.– Thomas A. Edison", "“If you want to live a happy life, tie it to a goal, not to people or things.“ – Albert Einstein", "“Never let the fear of striking out keep you from playing the game!“ – Babe Ruth", "“Money and success don’t change people; they merely amplify what is already there!“ — Will Smith", "“Your time is limited, so don’t waste it living someone else’s life. Don’t be trapped by dogma – which is living with the results of other people’s thinking.“ – Steve Jobs", "“Not how long, but how well you have lived is the main thing.“ — Seneca", "“If life were predictable it would cease to be life, and be without flavor.“ – Eleanor Roosevelt", "“The whole secret of a successful life is to find out what is one’s destiny to do, and then do it.“ – Henry Ford", "“In order to write about life first you must live it.”– Ernest Hemingway", "“The big lesson in life, baby, is never be scared of anyone or anything.”– Frank Sinatra", "“Sing like no one’s listening, love like you’ve never been hurt, dance like nobody’s watching, and live like it’s heaven on earth.” – (Attributed to various sources)", "“Curiosity about life in all of its aspects, I think, is still the secret of great creative people.” – Leo Burnett", "“Life is not a problem to be solved, but a reality to be experienced.”– Soren Kierkegaard", "“The unexamined life is not worth living.” — Socrates", "“The way I see it, if you want the rainbow, you gotta put up with the rain.” —Dolly Parton", "“Do all the good you can, for all the people you can, in all the ways you can, as long as you can.” — Hillary Clinton (inspired by John Wesley quote)", "“Don’t settle for what life gives you; make life better and build something.” — Ashton Kutcher", "“Everybody wants to be famous, but nobody wants to do the work. I live by that. You grind hard so you can play hard. At the end of the day, you put all the work in, and eventually it’ll pay off. It could be in a year, it could be in 30 years. Eventually, your hard work will pay off.” — Kevin Hart", "“Everything negative – pressure, challenges – is all an opportunity for me to rise.” — Kobe Bryant", "“I like criticism. It makes you strong.” — LeBron James", "“You never really learn much from hearing yourself speak.” ― George Clooney", "“Life imposes things on you that you can’t control, but you still have the choice of how you’re going to live through this.” — Celine Dion", "“Life is never easy. There is work to be done and obligations to be met – obligations to truth, to justice, and to liberty.” — John F. Kennedy (JFK Quotes)", "“Live for each second without hesitation.” — Elton John", "“Life is like riding a bicycle. To keep your balance, you must keep moving.” — Albert Einstein", "“Life is really simple, but men insist on making it complicated.” — Confucius", "“Life is a succession of lessons which must be lived to be understood.” — Helen Keller", "“Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. And the only way to do great work is to love what you do. If you haven’t found it yet, keep looking. Don’t settle. As with all matters of the heart, you’ll know when you find it.” — Steve Jobs", "“My mama always said, life is like a box of chocolates. You never know what you’re gonna get.” — Forrest Gump (Forrest Gump Quotes)", "“Watch your thoughts; they become words. Watch your words; they become actions. Watch your actions; they become habits. Watch your habits; they become character. Watch your character; it becomes your destiny.”— Lao-Tze", "“When we do the best we can, we never know what miracle is wrought in our life or the life of another.” — Helen Keller", "“The healthiest response to life is joy.” — Deepak Chopra", "“Life is like a coin. You can spend it any way you wish, but you only spend it once.” — Lillian Dickson", "“The best portion of a good man’s life is his little nameless, unencumbered acts of kindness and of love.” — Wordsworth", "“In three words I can sum up everything I’ve learned about life: It goes on.” ― Robert Frost", "“Life is ten percent what happens to you and ninety percent how you respond to it.” — Charles Swindoll", "“Keep calm and carry on.” — Winston Churchill", "“Maybe that’s what life is… a wink of the eye and winking stars.” — Jack Kerouac", "“Life is a flower of which love is the honey.” — Victor Hugo", "“Keep smiling, because life is a beautiful thing and there’s so much to smile about.” — Marilyn Monroe", "“Health is the greatest gift, contentment the greatest wealth, faithfulness the best relationship.” — Buddha", "“You have brains in your head. You have feet in your shoes. You can steer yourself any direction you choose.” — Dr. Seuss", "“Good friends, good books, and a sleepy conscience: this is the ideal life.” — Mark Twain", "“Life would be tragic if it weren’t funny.” — Stephen Hawking", "“Live in the sunshine, swim the sea, drink the wild air.” — Ralph Waldo Emerson", "“The greatest pleasure of life is love.” — Euripides", "“Life is what we make it, always has been, always will be.” — Grandma Moses", "“Life’s tragedy is that we get old too soon and wise too late.” — Benjamin Franklin", "“Life is about making an impact, not making an income.” — Kevin Kruse", "“I’ve missed more than 9000 shots in my career. I’ve lost almost 300 games. 26 times I’ve been trusted to take the game winning shot and missed. I’ve failed over and over and over again in my life. And that is why I succeed.” – Michael Jordan", "“Every strike brings me closer to the next home run.” – Babe Ruth", "“The two most important days in your life are the day you are born and the day you find out why.” – Mark Twain", "“Life shrinks or expands in proportion to one’s courage.” – Anais Nin", "“When I was 5 years old, my mother always told me that happiness was the key to life.  When I went to school, they asked me what I wanted to be when I grew up.  I wrote down ‘happy’.  They told me I didn’t understand the assignment, and I told them they didn’t understand life.” – John Lennon", "“Too many of us are not living our dreams because we are living our fears.” – Les Brown", "“I believe every human has a finite number of heartbeats. I don’t intend to waste any of mine.” —Neil Armstrong ", "“Live as if you were to die tomorrow. Learn as if you were to live forever.” —Mahatma Gandhi", "“If you live long enough, you’ll make mistakes. But if you learn from them, you’ll be a better person.” —Bill Clinton", "“Life is short, and it is here to be lived.” —Kate Winslet ", "“The longer I live, the more beautiful life becomes.” —Frank Lloyd Wright", "“Every moment is a fresh beginning.” —T.S. Eliot", "“When you cease to dream you cease to live.” —Malcolm Forbes", "“If you spend your whole life waiting for the storm, you’ll never enjoy the sunshine.” —Morris West", "“Don’t cry because it’s over, smile because it happened.” —Dr. Seuss ", "“If you can do what you do best and be happy, you’re further along in life than most people.” —Leonardo DiCaprio", "“We should remember that just as a positive outlook on life can promote good health, so can everyday acts of kindness.” —Hillary Clinton", "“Don’t limit yourself. Many people limit themselves to what they think they can do. You can go as far as your mind lets you. What you believe, remember, you can achieve.” —Mary Kay Ash ", "“It is our choices that show what we truly are, far more than our abilities.” —J. K. Rowling", "“If you’re not stubborn, you’ll give up on experiments too soon. And if you’re not flexible, you’ll pound your head against the wall and you won’t see a different solution to a problem you’re trying to solve.” —Jeff Bezos", "“The best way to predict your future is to create it.” — Abraham Lincoln", "“You must expect great things of yourself before you can do them.” —Michael Jordan", "“Identity is a prison you can never escape, but the way to redeem your past is not to run from it, but to try to understand it, and use it as a foundation to grow.” —Jay-Z", "“There are no mistakes, only opportunities.” —Tina Fey", "“It takes 20 years to build a reputation and five minutes to ruin it. If you think about that, you’ll do things differently.” —Warren Buffett", "“As you grow older, you will discover that you have two hands, one for helping yourself, the other for helping others.” —Audrey Hepburn", "“Sometimes you can’t see yourself clearly until you see yourself through the eyes of others.” —Ellen DeGeneres", "“You must not lose faith in humanity. Humanity is an ocean; if a few drops of the ocean are dirty, the ocean does not become dirty.” —Mahatma Gandhi ", "“All life is an experiment. The more experiments you make, the better.” – Ralph Waldo Emerson", "“Here’s to the crazy ones, the misfits, the rebels, the troublemakers, the round pegs in the square holes … the ones who see things differently — they’re not fond of rules … You can quote them, disagree with them, glorify or vilify them, but the only thing you can’t do is ignore them because they change things … They push the human race forward, and while some may see them as the crazy ones, we see genius …” – Steve Jobs", "“It had long since come to my attention that people of accomplishment rarely sat back and let things happen to them. They went out and happened to things.” – Leonardo Da Vinci", "“Throughout life people will make you mad, disrespect you and treat you bad. Let God deal with the things they do, cause hate in your heart will consume you too.” — Will Smith", "“Do not dwell in the past, do not dream of the future, concentrate the mind on the present moment.”– Buddha", "“Life is a dream for the wise, a game for the fool, a comedy for the rich, a tragedy for the poor.” – Sholom Aleichem", "“If you love life, don’t waste time, for time is what life is made up of.” – Bruce Lee", "When one door closes, another opens; but we often look so long and so regretfully upon the closed door that we do not see the one that has opened for us. – Alexander Graham Bell", "“Never take life seriously. Nobody gets out alive anyway.” — Anonymous", "“Be happy for this moment. This moment is your life.” – Omar Khayyam", "“Happiness is the feeling that power increases — that resistance is being overcome.” — Friedrich Nietzsche", "“I have learned to seek my happiness by limiting my desires, rather than in attempting to satisfy them.” — John Stuart Mill", "“The secret of happiness, you see is not found in seeking more, but in developing the capacity to enjoy less.”-Socrates", "“The more man meditates upon good thoughts, the better will be his world and the world at large.” — Confucius", "“The greatest blessings of mankind are within us and within our reach. A wise man is content with his lot, whatever it may be, without wishing for what he has not.”— Seneca", "“Happiness is like a butterfly; the more you chase it, the more it will elude you, but if you turn your attention to other things, it will come and sit softly on your shoulder.” — Henry David Thoreau", "“When it is obvious that goals can’t be reached, don’t adjust the goals, but adjust the action steps.” — Confucius", "“There may be people who have more talent than you, but there’s no excuse for anyone to work harder than you do – and I believe that.” — Derek Jeter"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logInReader = findViewById(R.id.LogInReader);
        logInWriter = findViewById(R.id.LogInWriter);
        logInGuest = findViewById(R.id.ContinueAsGuest);
        signUp = findViewById(R.id.SignUp);
        quoteOfDay = findViewById(R.id.quoteOfTheDay);

        logInWriter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, LogInWriter.class);
                startActivity(i);
                finish();

            }
        });

        logInReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, LogInReader.class);
                startActivity(i);
                finish();

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
                finish();

            }
        });

        logInGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, HomeScreenGuest.class);
                startActivity(i);
                finish();

            }
        });



        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        int day = (LocalDate.parse(formatter.format(date), fmt).getDayOfYear());
        while(day > 100){
            day -= 100;
        }


        //Mora se popraviti način kako će metoda dolaziti do Quote-a
        //quoteOfDay.setText("Tko rano rani jelena grabi");
        QuoteGenerator generator = new QuoteGenerator(quotes);
        quoteOfDay.setText(generator.getQuote(day));

    }

}