package myJavaTraining.projects.surpriseGenerator;

import java.util.Random;

public class FortuneCookie implements ISurprise {
	//fields  
	private String message;
	private static String[] quotes = {
			"\"Don't cry because it's over, smile because it happened.\" - Dr. Seuss",
			"\"Be yourself. Everyone else is already taken.\" - Oscar Wilde",
			"\"You only live once, but if you do it right, once is enough.\" - Mae West",
			"\"Be the change that you wish to see in the world.\" - Mahatma Gandhi",
			"\"In three words I can sum up everything I've learned about life: it goes on.\" - Robert Frost",
			"\"No one can make you feel inferior without your consent.\" - Eleanor Roosevelt",
			"\"If you tell the truth, you don't have to remember anything.\" - Mark Twain",
			"\"A friend is someone who knows all about you and still loves you.\" - Elbert Hubbard",
			"\"Always forgive your enemies; nothing annoys them so much.\" - Oscar Wilde",
			"\"Live as if you were to die tomorrow. Learn as if you were to live forever.\" - Mahatma Gandhi",
			"\"To live is the rarest thing in the world. Most people exist, that is all.\" - Oscar Wilde",
			"\"Without music, life would be a mistake.\" - Friedrich Nietzsche",
			"\"Life is what happens to us while we are making other plans.\" - Allen Saunders",
			"\"Winter's not like summer.\" - Traian Basescu",
			"\"We are all in the gutter, but some of us are looking at the stars. \" - Oscar Wilde",
			"\"I have not failed. I've just found 10,000 ways that won't work.\" - Thomas A. Edison",
			"\"A day without sunshine is like, you know, night.\" - Steve Martin",
			"\"Love all, trust a few, do wrong to none.\" - William Shakespeare",
			"\"If you judge people, you have no time to love them.\" - Mother Teresa",
			"\"It is never too late to be what you might have been.\" - George Eliot"};

	//constructor
	private FortuneCookie(String message) {
		this.message = message;
	}

	@Override
	public void enjoy() {
		System.out.println("Hey! Check this out, the cookie has a hidden message inside: \n\t" + this.message);
	}

	public static FortuneCookie generate() {
		Random random = new Random();
		int cookie = random.nextInt(20);

		FortuneCookie cookieSurprise = new FortuneCookie(quotes[cookie]);
		return cookieSurprise;
	}

}
