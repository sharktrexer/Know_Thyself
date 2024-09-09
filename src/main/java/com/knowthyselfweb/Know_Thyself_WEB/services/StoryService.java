package com.knowthyselfweb.Know_Thyself_WEB.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.knowtheyselfweb.Know_Thyself_WEB.models.*;

@Service
public class StoryService {

	
	public ArrayList<Scenario> getStory() {
		
		return new ArrayList<>(Arrays.asList( 
				
		new Scenario(
				"1", 
				"You are a cop and witness someone who is currently jaywalking across a road. "
				+ "Your rookie partner is off getting donuts. What do you do?", 
				Arrays.asList(
						
						new Option(
								"Ignore.",
								"1a"
								),
						new Option(
								"Approach.",
								"1b"
								),
						new Option(
								"Yell at them.",
								"1c"
								)
						)
				), 
		new Scenario(
				"1a", 
				"You decide not to engage the jaywalker directly, and instead: ", 
				Arrays.asList(
						
						new Option(
								"Go on your way.",
								"2",
								Arrays.asList("unpunished"),
								Alignment.TrueNeutral,
								"You pretend like you saw nothing and decide to go get your rookie and go out for chili dogs."
								),
						new Option(
								"Get your Rookie partner to deal with them.",
								"2",
								Arrays.asList("punished"),
								Alignment.NeutralEvil,
								"You fetch your rookie ordering some donuts to go deal with the jaywalker. "
								+ "While he does, you enjoy a delicious snack."
								),
						new Option(
								"Decide it is easier to call in a fake crime than deal with the jaywalker",
								"2",
								Arrays.asList("fake_crime", "unpunished"),
								Alignment.ChaoticEvil,
								"You call in that there's a greasy streaker running around and that you are in hot pursuit, "
								+ "despite no such event occuring."
								)
						)
				),
		new Scenario(
				"1b", 
				"You walk towards the jaywalker and grab his attention to: ", 
				Arrays.asList(
						
						new Option(
								"Persuade them to volunteer at the understaffed police bakesale this upcoming weekend.",
								"2",
								Arrays.asList("helpful", "unpunished"),
								Alignment.LawfulGood,
								"The jaywalker walks away confused but happy that they didn't have to pay a fine."
								),
						new Option(
								"Notify them they are breaking a law and give out a fine",
								"2",
								Arrays.asList("punished"),
								Alignment.LawfulNeutral,
								"The jaywalker pays the fine with a dismal expression and mumbles"
								+ " \"guess the kids aren't eating tonight...\""
								),
						new Option(
								"Use this opportunity to blackmail the jaywalker to bribe you with money or been fined heavily.",
								"2",
								Arrays.asList("unpunished"),
								Alignment.LawfulEvil,
								"The jaywalker accepts your terms, flashing a dissident look before walking away. "
								+ "Who cares though? You just made $400!"
								)
						)
				),
		new Scenario(
				"1c", 
				"You choose to yell: ", 
				Arrays.asList(
						
						new Option(
								"\"Don't do that, you could get in an accident!\"",
								"2",
								Arrays.asList("unpunished"),
								Alignment.NeutralGood,
								"The jaywalker scoffs and continues his behavior."
								),
						new Option(
								"\"You better pick up some trash before you finish crossing or else you will be fined!\"",
								"2",
								Arrays.asList("kinda", "unpunished"),
								Alignment.ChaoticGood,
								"The jaywalker shoots a frightened look at you, picks up a nearby discarded soda can, "
								+ "and makes sure that you see them throwing the can away."
								),
						new Option(
								"(Lie) \"Watch out, there is a car coming!\"",
								"2",
								Arrays.asList("unpunished"),
								Alignment.ChaoticNeutral,
								"Now frightened, the jaywalker dives towards the sidewalk to save themselves. The dive injures them. "
								+ "Upon closer inspection, they realize there were no cars at all. \nThey shoot you a furious look."
								+ "It also seems a small family walking past witness this all occur. You ovehear their conversation,"
								+ "\"Daddy? Why did the cop scare that man?\" \nThe dad responds, \"Because pumpkin, some cops are just really mean.\""
								)
						)
				),
		new Scenario(
				"2", 
				"Satisfied with the way you dealt with the situation, you head back to the Office to do paperwork. "
				+ "However, after getting back, the Chief calls you in for an important conversation.\n"
				+ "He apparently was fully aware of this jaywalker situation and has something to say…", 
				Arrays.asList(
						
						new Option(
								Arrays.asList("punished"),
								"2a",
								false
								),
						new Option(
								Arrays.asList("unpunished"),
								"2b",
								false
								)
						)
				),
		new Scenario(
				"2a", 
				"The Chief says \"I have been made aware about a jaywalker that has aptly dealt with. "
				+ "Well done, you did a great job! How do you feel?\"", 
				Arrays.asList(
						
						new Option(
								"\"I feel good about what I did!\"",
								"3a",
								Arrays.asList("rewarded"),
								Alignment.LawfulNeutral,
								"The Chief responds \"You should! I'll give you a nice bonus to your next paycheck. "
								+ "Remember, every ticket you dole out is money that keeps the city safer and our pockets fuller!\""
								),
						new Option(
								"\"I wonder why they felt the need to jaywalk…?\"",
								"3a",
								Arrays.asList("wonder"),
								Alignment.TrueNeutral,
								"The Chief responds \"I don't pay you to ask stupid questions. "
								+ "If you want answers then you should have gone to college. \n"
								+ "But you didn't! You're here at my station, now go do your job before you don't have one!\""
								),
						new Option(
								"\"I don't feel good about it, the fine seemed a bit much.\"",
								"3b",
								Arrays.asList("questioning"),
								Alignment.NeutralGood,
								"\"Let me tell you a story\" the Chief begins, \"When I was a kid I jaywalked all the time."
								+ "Until one day...\" \n\"One day what?\" you question. \n\"I STOPPED BECAUSE IT IS A CRIME. "
								+ "I don't need any criminal sympathizers in my precinct. You're suspended until you can think like a real cop!\""
								)
						)
				),
		new Scenario(
				"2b", 
				"The Chief says \"I have been made aware about a jaywalker that has gone without punishment. "
				+ "This is completely unacceptable! You have a duty as a cop, so why did you not uphold the law!?\"", 
				Arrays.asList(
						
						new Option(
								"\"It just didn't seem like a big enough deal.\"",
								"3b",
								Arrays.asList("no_big_deal"),
								Alignment.ChaoticNeutral,
								"\"Not a big ENOUGH DEAL?!\" the Chief exclaims. \"Is it not a big deal when a surgeon replaces "
								+ "someones heart with a foot?! You're a cop! Cops give tickets! \nIf you don't give out tickets "
								+ "then you're not a cop! You're suspended until you're a cop again!\""
								),
						new Option(
								"\"I didn't see anyone, what are you talking about?\"",
								"3b",
								Arrays.asList("lie"),
								Alignment.NeutralEvil,
								"\"Too blind to do your job?!\" The Chief exclaims. \"You're suspended until you get an eye exam!\""
								),
						new Option(
								"\"It was my rookie's fault, shouldn't you be talking to him?\"",
								"3a",
								Arrays.asList("blame"),
								Alignment.LawfulEvil,
								"\"That darn rookie!\" the Chief exclaims. \"He doesn't know his butt from his kneecaps. "
								+ "I'll have a talk with him later...\""
								),
						new Option(
								"(Lie) \"I was busy with something else MUCH more important that a jaywalker!\"",
								"3a",
								null,
								Alignment.ChaoticEvil,
								Arrays.asList("fake_crime"),
								"You explain there was a greasy streaker that escaped from the retirement home. \n"
								+ "\"Ancient Acres?\" the Chief inquires.\n"
								+ "\"That's the one!\" you reply, further weaving your web of deceit.\n"
								+ "\"I put my mom in that home, they're gonne get slapped with the heaftiest lawsuit this side of Leaky Lake.\" "
								+ "The Chief proclaims. \"What happened to the streaker?\"\n"
								+ "\"He got away.\" you state haphazardly.\n"
								+ "\"Don't worry about it officer. Those slippery old people get quicker every year.\""
								),
						new Option(
								"\"I actually gave the jaywalker a good alternative punishment.\"",
								"3a",
								null,
								Alignment.LawfulGood,
								Arrays.asList("helpful"), 
								"The Chief replies, \"I would have preferred you gave them a fine but "
								+ "the less time I got to stand in front of the oven the better. Mighty fine insight officer.\""
								),
						new Option(
								"\"What do you mean? I made him pick up some trash, is that not enough!?\"",
								"3b",
								null,
								Alignment.ChaoticGood,
								Arrays.asList("kinda"),
								"\"You think recycling an empty can of cola is going to pay for our donuts?! "
								+ "We can buy eight weeks worth of donuts for the station with just one fine!\"\n"
								+ "Since you don't understand the importantance that tickets have on keeping this station running, you're officially suspended!"
								)
						)
				),
		new Scenario(
				"3a", 
				"You are dismissed.\n"
				+ "Feeling a little worried, you decide to spend the rest of the workday on paperwork. \n"
				+ "After a while, you're just about done with your paperwork, and the time to relax is almost in sight!", 
				Arrays.asList(
						
						new Option(
								null,
								"job1",
								false
								)
						)
				),
		new Scenario(
				"3b", 
				"You have fallen out of the good graces of the Chief and are now suspended. \n"
				+ "Without any abiity to challenge what is happening, you slump out of the office and start your walk home...\n"
				+ "Noticing a cop car driving by, you're saddened at the thought of the donut famine fast approaching.", 
				Arrays.asList(
						new Option(
								null,
								"fired1",
								false
								)
						)
				),
		new Scenario(
				"job1", 
				"A coworker approaches you and offers to join them on an outing to go drinking with the team.\n"
				+ "You still have a little bit of paperwork to finish however. What do you do?", 
				Arrays.asList(
						
						new Option(
								"Accept.",
								"job1a"
								),
						new Option(
								"Refuse.",
								"job1b"
								),
						new Option(
								"Offer something else",
								"job1c"
								)
						)
				),
		new Scenario(
				"fired1", 
				"On your journey back you pass by a bank and "
				+ "see someone frantically running out of the building holding bags of money.\n"
				+ "Since you were suspended and not fired, you still have your gun... What do you do?\r\n", 
				Arrays.asList(
						
						new Option(
								"Shoot.",
								"fired1a"
								),
						new Option(
								"Approach.",
								"fired1b"
								),
						new Option(
								"Don't get involved.",
								"fired1c"
								)
						)
				),
		new Scenario(
				"job1a", 
				"You accept the offer!", 
				Arrays.asList(
						
						new Option(
								"\"Sure, can't turn down a good time with the team!\"",
								"party_end",  
								null,
								Alignment.NeutralGood,
								"\"Haha\" the coworker chuckles, \"If you feel that way about it you're buying! See you at the bar.\""
								),
						new Option(
								"\"As long as there is free booze involved, I'm in.\"",
								"party_end", 
								null,
								Alignment.TrueNeutral,
								"\"There will be!\" the coworker explains, \"Officer Billy got promoted today so he's buying us all a round!\""
								),
						new Option(
								"\"Absolutely, the rookie can finish the rest of my paperwork.\"",
								"party_end", 
								null,
								Alignment.LawfulEvil,
								"You take your remaining paperwork and plop it on a rookie's desk. Already knee deep in paperwork, the rookie sighs. \n"
								+ "You notice a small tear shed from their eye. That's not your problem though!"
								),
						new Option(
								"\"Damn right! I deserve a reward for busting that Jaywalker!\"",
								"party_end", 
								null,
								Alignment.LawfulNeutral,
								Arrays.asList("rewarded"),
								"\"Well,\" the coworker responds, \"Well, Billy was able to bust a whole drug ring so he probably deserves it a little more... \n"
								+ "But hey, kudos all around! Hope to see that kind of energy at the party.\""
								)
						)
				),
		new Scenario(
				"job1b", 
				"You refuse the offer.", 
				Arrays.asList(
						
						new Option(
								"\"No thanks, I'm staying late to finish up on my paperwork.\"",
								"work_end", 
								null,
								Alignment.LawfulGood,
								"\"Well,\" the coworker responds, \"If you are able to finish early, you know where to find us!\""
								),
						new Option(
								"\"No, I have better things to do than party.\"",
								"work_end", 
								null,
								Alignment.LawfulNeutral,
								"\"Ok...\" the coworker continues, \"If you start getting vertigo way up there on your high horse, we'll be at the bar.\""
								),
						new Option(
								"\"Hahahaha, you're serious? I am NOT drinking with you guys.\"",
								"home_end", 
								null,
								Alignment.NeutralEvil,
								"\"Well excuse me for asking.\" the officer says, taken aback. \"I know who's getting the lemon jelly donut tomorrow...\""
								),
						new Option(
								"\"Nope, I just finished off my report regarding my rookie's incompetence today. "
								+ "I'm going home early after a job well done! \"",
								"home_end", 
								null,
								Alignment.LawfulEvil,
								Arrays.asList("blame"),
								"\"Alright,\" the coworker warns, \"Just be sure to check your coffee for spit tomorrow morning...\""
								)
						)
				),
		new Scenario(
				"job1c", 
				"You bring up something else: ", 
				Arrays.asList(
						
						new Option(
								"\"Why wait until the bar?\" Pull out your \"water\" bottle and offer it.",
								"party_end", 
								null,
								Alignment.ChaoticGood,
								"\"Snagged that from evidence, did ya?\" the coworker smirks, \"Alright, you're driving though.\""
								+ "They take a considerable gulp." 
								),
						new Option(
								"\"How about we go bust some kids for drug use by the movie theater?\"",
								"party_end", 
								null,
								Alignment.ChaoticNeutral,
								"\"I know which place you're talking about,\" the coworker begins, \"We can do that on the way.\""
								),
						new Option(
								"\"I'm thinking of raiding the fridge after everyone leaves. You want in?\"",
								"work_raid_end", 
								null, 
								Alignment.ChaoticEvil,
								"\"I'm good.\" the coworker quickly answers. \"Just don't touch the ham and cheese sandwhich in the door. That one's mine.\""
								),
						new Option(
								"\"Ok, but answer this question for me. Why would someone ever jaywalk with cops nearby?\"",
								"home_ponder_end", 
								null,
								Alignment.TrueNeutral,
								Arrays.asList("wonder"),
								"\"I don't know hoss,\" the coworker says, befuddled. \"Sometimes people just do dumb stuff. "
								+ "Like respond to a party invitation by asking completetely unrelated questions about jaywalkers.\"\n"
								+ "Now uncomfortable, the coworker walks away."
								)
						)
				),
		new Scenario(
				"fired1a", 
				"You ready your gun: ", 
				Arrays.asList(
						
						new Option(
								"Shoot to warn.",
								"party_end_rehire", 
								null, 
								Alignment.ChaoticGood,
								"As the thief runs out of the building you shoot the sidewalk besides them. "
								+ "\"I don't miss twice!\" you shout, \"You better drop that dough!\" The thief puts his hands up. \n"
								+ "Some of the cops from your station witness this and bring you back to the Chief to be reinstated.\n"
								+ "Congrats! you are a cop again. You know what that calls for..." 
								),
						new Option(
								"Shoot to injure",
								"home_end",
								null,
								Alignment.LawfulNeutral,
								"Without warning you shoot the thief in the leg, making them collapse, \"OW!\" the thief yells \n"
								+ "\"You could have told me to stop, I didn't know you had a gun!\" The money flies everywhere, \n"
								+ "creating a beautiful shower of green. Some of the cops from your station arrive and are a bit upset they have to \n"
								+ "go around picking up every dollar bill. Amidst the chaos you decide it would be best just to go home..."
								),
						new Option(
								"Shoot to kill",
								"arrested_end",
								null,
								Alignment.LawfulEvil,
								"You shoot the thief brutally. As they lay dying, they say \"I was just doing this... to feed my kids...\" \n"
								+ "People are appalled yet grateful. Some of the cops from your station arrive and quickly put you in cuffs. \n"
								+ "\"You know you were supposed to turn in your gun when you're suspended right?\" one of the cops say.\n"
								+ "You are escorted to jail, charged with manslaughter."
								),
						new Option(
								"Shoot the money. Now it's a BIG deal.",
								"home_end",
								null,
								Alignment.ChaoticNeutral,
								Arrays.asList("no_big_deal"),
								"The money flies everywhere, now shredded and useless. The thief won't be thieving anything anymore! \n"
								+ "\"What the hell?!\" the thief shouts. \"You could have just told me to stop. What a waste!\" \n"
								+ "You decide it would be best to run back home before anyone notices what you did..."
								)
						)
				),
		new Scenario(
				"fired1b", 
				"You approach the thief to: ", 
				Arrays.asList(
						
						new Option(
								"Inform them how to best get away, bestowing your cop knowledge. "
								+ "You're not a cop anymore so who cares?",
								"home_end",
								null,
								Alignment.ChaoticNeutral,
								"You approach the thief letting them know you have some information to share that could benefit them.\n"
								+ "\"Wow\" the thief remarks, \"Thanks for the intel. Here, have some dough, my treat!\"\n"
								+ "You pocket the dough and quickly head home to avoid any suspicion. Hopefully nobody saw this take place..." 
								),
						new Option(
								"Heroically catch the thief! ",
								"party_end_rehire",
								null,
								Alignment.LawfulGood,
								"You trip the thief as they try passing you. After they fall you launch yourself on top of them to ensure they \n"
								+ "can't wriggle away. \"Get off of me!\" the thief exclaims. \"You smell!\"\n"
								+ "Despite the smear campaign on your personal hygiene, you keep the thief in place until cops from your station arrive.\n"
								+ "After arresting the thief, the cops congratulate you and decide you deserve your job back! They take you \n"
								+ "to the station as well and convince the Chief to reinstate you as a police officer. Now that you are \n"
								+ "a cop again, this calls for celebration!"
								),
						new Option(
								"Incapacitate them and get away with pocketing some of the dough.",
								"arrested_end",
								null,
								Alignment.NeutralEvil,
								"You swiftly take down the thief with your cop powers and stuff your pockets with as much money as possible.\n"
								+ "Unfortunately, due to your greed, you take slightly too long and the cops show up on the scene. \n"
								+ "\"Put your hands up!\" one of the cops shout. \n"
								+ "\"Oh hey, it's you.\" the other cop interjects. \"Weren't you fired today? The Chief is gonna love to see this.\n"
								+ "You're going to jail, buddy.\""
								),
						new Option(
								"Converse with them. Surely they have a reason for doing this like that jaywalker could have.",
								"home_ponder_end",
								null,
								Alignment.NeutralGood,
								Arrays.asList("questioning"),
								"You approach the thief, asking if you could have a word with them. The thief responds with a cordial fist in your face.\n"
								+ "\"Don't you know better than to ask burglars dumb questions while they are burgaling?\" they say with a laugh and run away.\n"
								+ "A mother and her child witness this interaction. \n"
								+ "\"Mom?\" the kid asks \"Why did that crying person ask the burglar a question?\"\n"
								+ "\"Well you see Timmy,\" the mother responds, \"Some people just don't have any common sense.\""
								+ "With your hurt ego, you decide to run back home \"not crying.\""
								)
						)
				),
		new Scenario(
				"fired1c", 
				"You don't directly deal with the thief because: ", 
				Arrays.asList(
						
						new Option(
								"You don't want to risk your life, you already got suspended today.",
								"home_end",
								null,
								Alignment.TrueNeutral,
								"Whatever happens is none of your business after all. As you walk home you notice a lot of cops cars passing \n"
								+ "by towards the scene. Glad they are not you!"
								),
						new Option(
								"Perhaps the thief will use that money better than the original owners would have.",
								"home_end",
								null,
								Alignment.NeutralGood,
								"You head home, finding a lucky $20 on the sidewalk on your way there! However the thief from earlier finds and stops you.\n"
								+ "\"Hey!\" they shout. \"That's mine!\"\n"
								+ "You hand over the bill with a smile, knowing that they will probably spend it better than you would've anyways. \n"
								+ "You continue on your way, content with your actions."
								),
						new Option(
								"You can take the opportunity to call the news and report the incompetence of the police station that suspended you.",
								"home_news_end",
								null,
								Alignment.ChaoticEvil,
								"*Click!* \"Hello, this is Sarah from XOF news, what can we do for you today?\" \n"
								+ "You inform them of the situtation, making note that \"Even though there was a cop nearby (you), nobody stopped the thief!\""
								+ "\"Wow, the cops here really are incompetent! May I have a name for your submission?\"\n"
								+ "\"Anonymous\" you say with an evil grin.\n"
								+ "\"OK!\" Sarah says. \"Let's hope the cops start doing their job soon.\"\n"
								+ "\"Yeah\" you respond, hanging up. Feeling"
								),
						new Option(
								"You're blind, you don't see nothing. You dial the number for your local Optometrist and continue on your way.",
								"home_end",
								null,
								Alignment.NeutralEvil,
								Arrays.asList("lie"),
								"*Click* \"Good afternoon, this is Optometryology, we help you see for a minimal fee! What can I do for you?\"\n"
								+ "You respond, \"I would like to schedule an eye exam. I am having trouble caring about things lately.\"\n"
								+ "\"Oh, the classic deflecting responsiblity by feigning blindess? We can't help you stop caring but we \n"
								+ "can get you some nice prescription sunglasses, so you can roll your eyes without your superior getting wise.\"\n"
								+ "\"That sounds great,\" you respond. \"Thanks. I will come in tomorrow.\"\n"
								+ "\"Sounds great, 'see' you then!\"\n"
								+ "You hang up the phone and head home."
								)
						)
				),
		new Scenario(
				"home_end", 
				"You arrive at your house. It is not much but it is a great place of relaxation, which you desperately needed. \n"
				+ "Your husband/wife/kid(s)/dog/goldfish are happy that you're home!", 
				null
				),
		new Scenario(
				"home_news_end", 
				"You get home and immediately turn your TV on to the XOF news channel. The headline today: \"Our cops suck! We need better ones!\"\n"
				+ "The reporter covers an interview with the police Chief. \"I didn't even know this was happening until 2 minutes ago!\" the Chief explains.\n"
				+ "\"How can we expect our cops to do a go job when the Chief doesn't know what is going on!?\" the reporter rhetorically asks."
				+ "You laugh at the Chief's humiliation. That's what they get for firing you!", 
				null
				),
		new Scenario(
				"party_end_rehire", 
				"Your favorite coworker takes you out for drinks to celebrate the world record for quickest suspension \n"
				+ "reconsideration from the Chief ever! You then head home after a healthy and socially acceptable amount of drinking.\n"
				+ "What a day!", 
				null
				),
		new Scenario(
				"party_end", 
				"Your have a good time with your coworkers at the bar and head home after a healthy and socially acceptable amount of drinking.\n"
				+ "What a day!", 
				null
				),
		new Scenario(
				"work_end", 
				"You stay in the station late into the night, filing your files and stamping your documents. Your coworkers file out of the station \n"
				+ "one by one until you are the only one remaining. You know that people have probably left food in the fridge that will go bad overnight,\n"
				+ "but, being a good samaritan, you decide not to raid the fridge. The food is not yours after all. Your eyes are getting heavy, so heavy \n"
				+ "that they have closed hours ago. You fall into a deep sleep at your desk.", 
				null
				),
		new Scenario(
				"home_ponder_end", 
				"As you arrive home, you move to your couch and sit down. You begin pondering the meaning of life and the point of everything as \n"
				+ "you stare past the eviction and rent passed due notices on your coffee table. You don't understand why you should need to pay them. \n"
				+ "Nobody ever tells you when you ask...", 
				null
				),
		new Scenario(
				"work_raid_end", 
				"You stay in the station, waiting for everyone to leave. As the last person exists the building your eyes lock onto the breakroom fridge. \n"
				+ "Whatever is in there is yours now by right of conquest.\n"
				+ "Sandwiches, cookies, someone even left behind some sushi! You feel a bit like a raccoon eating all this food, but you quickly get\n"
				+ "over it. After all, the food is delicious! As the contents of the fridge wanes, so does your conciousness. You pass out at the break \n"
				+ "room's lunch table, content with your feast.", 
				null
				),
		new Scenario(
				"arrested_end", 
				"This morning you were a cop, but a series of non-coplike descisions has lead you to the life of a prisoner. It smells bad here...", 
				null
				),
		
		new Scenario(
				"Tie Breaker!!!!!!", 
				"While asleep, the images of the twists and turns of your day manifest into a very vivid dream. \n"
				+ "You're walking through the police office and notice the rookie getting chewed out by the Chief. \n"
				+ "The rookie makes eye contact with you, his eyes filled with fear. "
				+ "In this dream, only a few options feel like the right thing to do…\n", 
				Arrays.asList(
						
						new Option(
								"March into the office and defend your rookie.",
								"",
								null,
								Alignment.LawfulGood,
								Arrays.asList("tie_LG"),
								"Your dream abruptly ends. You feel confident and content with your choice."
								),
						new Option(
								"Wait until after to console the rookie.",
								"",
								null,
								Alignment.NeutralGood,
								Arrays.asList("tie_NG"),
								"Your dream abruptly ends. You feel content with your choice."
								),
						new Option(
								"(Lie) Come into the office and tell the Chief that his kid needs an emergency pickup from school. \n\t"
								+ "While the Chief tries handling that, escape with the rookie.",
								"",
								null,
								Alignment.ChaoticGood,
								Arrays.asList("tie_CG"),
								"Your dream abruptly ends. You feel justified and content with your choice."
								),
						new Option(
								"Wait until after to warn rookie to be more careful next time.",
								"",
								null,
								Alignment.LawfulNeutral,
								Arrays.asList("tie_LN"),
								"Your dream abruptly ends. You feel confident with your choice."
								),
						new Option(
								"Offer a weak smile and continue with your day. You think about how awkward it will be working with them tomorrow.",
								"",
								null,
								Alignment.TrueNeutral,
								Arrays.asList("tie_TN"),
								"Your dream abruptly ends. You feel alright with your choice."
								),
						new Option(
								"You take advantage of the preoccupied Chief to get away with taking an early lunch.",
								"",
								null,
								Alignment.ChaoticNeutral,
								Arrays.asList("tie_CN"),
								"Your dream abruptly ends. You feel justified with your choice."
								),
						new Option(
								"Enter the office and put in your two cents on what else the rookie failed to do.",
								"",
								null,
								Alignment.LawfulEvil,
								Arrays.asList("tie_LE"),
								"Your dream abruptly ends. You feel confident and happy with your choice."
								),
						new Option(
								"Clearly mouth to the rookie: \"you're so going to get fired\" ",
								"",
								null,
								Alignment.NeutralEvil,
								Arrays.asList("tie_NE"),
								"Your dream abruptly ends. You feel happy with your choice."
								),
						new Option(
								"You take advantage of the rookie being scolded and pass a rumor around to your coworkers "
								+ "that what he did was really embarrassing.",
								"",
								null,
								Alignment.ChaoticEvil,
								Arrays.asList("tie_CE"),
								"Your dream abruptly ends. You feel justfied and happy with your choice."
								)
						)
				)
		
		));
	}
	
}
