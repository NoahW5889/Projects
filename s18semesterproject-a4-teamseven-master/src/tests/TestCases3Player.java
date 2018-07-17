package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import code.Board;
import code.Person;

public class TestCases3Player {

	Board board = new Board("src/GameWords.txt");	//Create/links board to this class, sends in file to read for codeNames
	String filename = "src/GameWords.txt";	//Used in testing to show where to find file for codeNames
	
	//Long list of all codeNames to assure they were read and put in list correctly
	String[] file = {"AFRICA","AGENT","AIR","ALIEN","ALPS","AMAZON","AMB"
			+ "ULANCE","AMERICA","ANGEL","ANTARCTICA","APPLE","ARM","ATLANTIS"
			,"AUSTRALIA","AZTEC","BACK","BALL","BAND","BANK","BAR","BARK","BAT"
			,"BATTERY","BEACH","BEAR","BEAT","BED","BEIJING","BELL","BELT","BERLIN"
			,"BERMUDA","BERRY","BILL","BLOCK","BOARD","BOLT","BOMB","BOND","BOOM"
			,"BOOT","BOTTLE","BOW","BOX","BRIDGE","BRUSH","BUCK","BUFFALO","BUG"
			,"BUGLE","BUTTON","CALF","CANADA","CAP","CAPITAL","CAR","CARD","CARROT"
			,"CASINO","CAST","CAT","CELL","CENTAUR","CENTER","CHAIR","CHANGE","CHARGE"
			,"CHECK","CHEST","CHICK","CHINA","CHOCOLATE","CHURCH","CIRCLE","CLIFF"
			,"CLOAK","CLUB","CODE","COLD","COMIC","COMPOUND","CONCERT","CONDUCTOR"
			,"CONTRACT","COOK","COPPER","COTTON","COURT","COVER","CRANE","CRASH"
			,"CRICKET","CROSS","CROWN","CYCLE","CZECH","DANCE","DATE","DAY","DEATH"
			,"DECK","DEGREE","DIAMOND","DICE","DINOSAUR","DISEASE","DOCTOR","DOG"
			,"DRAFT","DRAGON","DRESS","DRILL","DROP","DUCK","DWARF","EAGLE","EGYPT"
			,"EMBASSY","ENGINE","ENGLAND","EUROPE","EYE","FACE","FAIR","FALL","FAN"
			,"FENCE","FIELD","FIGHTER","FIGURE","FILE","FILM","FIRE","FISH","FLUTE"
			,"FLY","FOOT","FORCE","FOREST","FORK","FRANCE","GAME","GAS","GENIUS"
			,"GERMANY","GHOST","GIANT","GLASS","GLOVE","GOLD","GRACE","GRASS","GREECE"
			,"GREEN","GROUND","HAM","HAND","HAWK","HEAD","HEART","HELICOPTER","HIMALAYAS"
			,"HOLE","HOLLYWOOD","HONEY","HOOD","HOOK","HORN","HORSE","HORSESHOE","HOSPITAL"
			,"HOTEL","ICE","ICE CREAM","INDIA","IRON","IVORY","JACK","JAM","JET","JUPITER"
			,"KANGAROO","KETCHUP","KEY","KID","KING","KIWI","KNIFE","KNIGHT","LAB","LAP"
			,"LASER","LAWYER","LEAD","LEMON","LEPRECHAUN","LIFE","LIGHT","LIMOUSINE","LINE"
			,"LINK","LION","LITTER","LOCH NESS","LOCK","LOG","LONDON","LUCK","MAIL","MAMMOTH"
			,"MAPLE","MARBLE","MARCH","MASS","MATCH","MERCURY","MEXICO","MICROSCOPE"
			,"MILLIONAIRE","MINE","MINT","MISSILE","MODEL","MOLE","MOON","MOSCOW","MOUNT"
			,"MOUSE","MOUTH","MUG","NAIL","NEEDLE","NET","NEW YORK","NIGHT","NINJA","NOTE"
			,"NOVEL","NURSE","NUT","OCTOPUS","OIL","OLIVE","OLYMPUS","OPERA","ORANGE","ORGAN"
			,"PALM","PAN","PANTS","PAPER","PARACHUTE","PARK","PART","PASS","PASTE","PENGUIN"
			,"PHOENIX","PIANO","PIE","PILOT","PIN","PIPE","PIRATE","PISTOL","PIT","PITCH","PLANE"
			,"PLASTIC","PLATE","PLATYPUS","PLAY","PLOT","POINT","POISON","POLE","POLICE","POOL"
			,"PORT","POST","POUND","PRESS","PRINCESS","PUMPKIN","PUPIL","PYRAMID","QUEEN","RABBIT"
			,"RACKET","RAY","REVOLUTION","RING","ROBIN","ROBOT","ROCK","ROME","ROOT","ROSE"
			,"ROULETTE","ROUND","ROW","RULER","SATELLITE","SATURN","SCALE","SCHOOL","SCIENTIST"
			,"SCORPION","SCREEN","SCUBA DIVER","SEAL","SERVER","SHADOW","SHAKESPEARE","SHARK"
			,"SHIP","SHOE","SHOP","SHOT","SINK","SKYSCRAPER","SLIP","SLUG","SMUGGLER","SNOW"
			,"SNOWMAN","SOCK","SOLDIER","SOUL","SOUND","SPACE","SPELL","SPIDER","SPIKE","SPINE"
			,"SPOT","SPRING","SPY","SQUARE","STADIUM","STAFF","STAR","STATE","STICK","STOCK"
			,"STRAW","STREAM","STRIKE","STRING","SUB","SUIT","SUPERHERO","SWING","SWITCH","TABLE"
			,"TABLET","TAG","TAIL","TAP","TEACHER","TELESCOPE","TEMPLE","THEATER","THIEF","THUMB"
			,"TICK","TIE","TIME","TOKYO","TOOTH","TORCH","TOWER","TRACK","TRAIN","TRIANGLE","TRIP"
			,"TRUNK","TUBE","TURKEY","UNDERTAKER","UNICORN","VACUUM","VAN","VET","WAKE","WALL"
			,"WAR","WASHER","WASHINGTON","WATCH","WATER","WAVE","WEB","WELL","WHALE","WHIP","WIND"
			,"WITCH","WORM","YARD","area","book","business","case","child","company","country"
			,"day","eye","fact","family","government","group","hand","home","job","life","lot"
			,"man","money","month","mother","Mr","night","number","part","people","place"
			,"point","problem","program","question","right","room","school","state","story"
			,"student","study","system","thing","time","water","way","week","woman","word"
			,"work","world","year"};
	ArrayList<String> codeNames = new ArrayList<String>();	//used in testing to store codeNames
	int bluPos = 0;	//used to hold blue agent position
	int redPos = 0;	//used to hold red agent position
	int grePos = 0;	//used to hold green agent position
	int assPos = 0;	//used to hold assassin position
	int ass2Pos = 0;	//used to hold second assassin position
	int byPos = 0;	//used to hold bystander position
	int playerCnt=0;
	
	/*Creates arrayList to compare to readCSVFile in Board class
	 * @param x 	holds String[] list to add into ArrayList<String>
	 * @return ArrayList<String> of codeNames
	 */
	public ArrayList<String> createArrayList(String[] x) {
		for(int i=0;i<x.length;i++	) {
			codeNames.add(x[i]);
		}
		return codeNames;
	}

	/*
	 * used to test if any nulls are in board.list
	 * @param selected	String list holding selected codeNames
	 * @return false if the list has a null in it
	 * @return true if the list is null free
	 */
	public boolean noNull(String[] selected) {	
		for(int i=0;i<board.getList().length;i++) {
			if(board.getList()[i]==null||board.getList()[i].equals(null)||board.getList()[i].trim().isEmpty())
				return false;
		}
		return true;
	}

	
	/*
	 * assures there are no repeated codeNames in board.list
	 * @param input	holds String list of codeNames
	 * @return false if there is a repeated codeName
	 * @return true	if there are no repeated codeNames
	 */
	public boolean noDoubles(String[] input) {	
		for(int i=0;i<board.getList().length;i++) {
			String check = board.getList()[i];
			for(int q=0;q<board.getList().length;q++) {
				if(board.getList()[q].equals(check)&&q!=i)
					return false;
			}
		}
		return true;
	}
	
	/*
	 * assures the correct team size for string entered ex. "red" should equal 9
	 * @param x	holds string of requested team size
	 * @return size of requested team
	 */
	public int teamSize(String x) {	
		int size = 0;
		for(int i=0;i<board.getMainBoard().size();i++) {
			if(x.equalsIgnoreCase(board.getMainBoard().get(i).getTeam()))
				size++;
			}
		return size;
	}
	
	/*
	 * assures the board was shuffled, compares original to after shuffle board
	 * @param original holds original order of board.mainBoard selected codeNames list
	 * @return false if shuffle() method did not shuffle/randomize list
	 * @return true if shuffle() method did shuffle/randomize list
	 */
	public boolean shuffleSuccess() {	
		ArrayList<Person> original = board.getMainBoard();
		board.startGame();
		if(original.toString()==(board.getMainBoard().toString()))
			return false;
		else
			return true;
	}
	
	/*
	 *gets position of a blue agent for testing 
	 * @param sets bluPos to hold position of a blue agent
	 */
	public void bluePosition() {	//
		for(int i=0;i<board.getMainBoard().size();i++) {
			if(board.getMainBoard().get(i).getTeam()=="blue"&&board.getMainBoard().get(i).getRevealed()==false)
				bluPos=i;
		}
	}
	
	/*
	 *gets position of a red agent for testing 
	 * @param sets redPos to hold position of a red agent
	 */
	public void redPosition() {
		for(int i=0;i<board.getMainBoard().size();i++) {
			if(board.getMainBoard().get(i).getTeam()=="red"&&board.getMainBoard().get(i).getRevealed()==false)
				redPos=i;
		}
	}
	
	/*
	 *gets position of a green agent for testing 
	 * @param sets grePos to hold position of a green agent
	 */
	public void grePosition() {
		for(int i=0;i<board.getMainBoard().size();i++) {
			if(board.getMainBoard().get(i).getTeam()=="green"&&board.getMainBoard().get(i).getRevealed()==false)
				grePos=i;
		}
	}
	
	/*
	 *gets position of a assassin for testing 
	 * @param sets assPos to hold position of a assassin
	 */
	public void assassinPosition() {
		for(int i=0;i<board.getMainBoard().size();i++) {
			if(board.getMainBoard().get(i).getTeam()=="assassin"&&i!=ass2Pos)
				assPos=i;
		}
	}
	
	/*
	 *gets position of a second assassin for testing 
	 * @param sets ass2Pos to hold position of a second assassin
	 */
	public void assassin2Position() {
		for(int i=0;i<board.getMainBoard().size();i++) {
			if(board.getMainBoard().get(i).getTeam()=="assassin"&&i!=assPos)
				ass2Pos=i;
		}
	}
	
	/*
	 *gets position of a bystander for testing 
	 * @param sets byPos to hold position of a bystander
	 */
	public void bystanderPosition() {
		for(int i=0;i<board.getMainBoard().size();i++) {
			if(board.getMainBoard().get(i).getTeam()=="bystander"&&board.getMainBoard().get(i).getRevealed()==false)
				byPos=i;
		}
	}

	@Test
	public void testStartGame() {	//tests that the game sets up correctly
		ArrayList<String> codeNames = new ArrayList<String>();	//new ArrayList to set original unshuffled codeNames to
		codeNames.addAll(board.getCodeNames());	//sets new ArrayList to original unshuffled CodeNames
		board.playerSet(3);
		board.startGame();	//calls startGame() method
		assertNotEquals(codeNames, board.getCodeNames());	//Makes sure the codeNames ArrayList got shuffled
		assertEquals(board.getMainBoard().size(),25);	//Makes sure board size is 25
		assertEquals(board.getTurn(),"menu");	//Makes sure starting menu opens
	}
	
	@Test
	public void testCreateList(){	//tests to make sure the list was created and filled successfully
		assertTrue(board.getList().length==25); //Tests to make sure list has selected 25 names
		board.createList();// Must create list before test for noNull
		assertTrue(noNull(board.getList()));// Testing to make sure there are no nulls in list
		assertTrue(noDoubles(board.getList()));// Assures there are no repeated codeNames
	}
	
	@Test
	public void testFillBoard() {	//tests the fillBoard method to make sure it is filled/created correctly
		board.createList();// Must create list before test for noNull
		board.fillBoard(); // Fills board with persons
		assertTrue(board.getMainBoard().size()==25); //Testing Board Size (5x5=25)
		
	}
	
	@Test
	public void testShuffle() {	//tests the shuffle method, makes sure the board gets randomized
		board.createList();// Must create list before test for shuffle
		board.fillBoard(); // Fills board with persons
		assertTrue(shuffleSuccess()); //makes sure the board got shuffled
	}
	
	@Test
	public void testReadCSVFile(){	//tests readCSVFile to ensure the file filled with codeNames was put into a list
		assertEquals(board.readCSVFile(filename),createArrayList(file)); // Tests of Code Names file was read correctly
	}

	@Test
	public void testChoose() {	//tests the choose method to make sure the proper response is return based upon choice
		board.createList();// Must create list before test for noNull
		board.fillBoard(); // Fills board with persons
		board.setCurGuessCnt(0);
		board.setMaxGuessCnt(3);
		board.playerSet(3);
		
		assertEquals(board.choose(null),"Invalid Entry. Empty. Try Again."); //enters null as a choice
		assertEquals(board.choose(""),"Invalid Entry. Empty. Try Again.");	//enters empty string as choice
		assertEquals(board.choose("  "),"Invalid Entry. Empty. Try Again.");	//enters spaces as choice
		
		redPosition();	//gets position of red agent for testing
		bluePosition();	//gets position of blue agent for testing
		grePosition();	//gets position of green agent for testing
		bystanderPosition();	//gets position of bystander for testing
		board.setTurn("red");	//sets turn to red team
		assertEquals(board.choose(board.getMainBoard().get(redPos).getCodeName()),"Correct Guess. Still Red Teams Turn.");	//tests red turn choosing red agent
		assertEquals(board.choose(board.getMainBoard().get(bluPos).getCodeName()),"Incorrect Guess. Blue SpyMasters Turn.");	//tests red turn choosing blue agent
		board.setTurn("red");	//sets turn to red team
		assertEquals(board.choose(board.getMainBoard().get(grePos).getCodeName()),"Incorrect Guess. Blue SpyMasters Turn.");	//tests red turn choosing green agent
		board.setTurn("red");	//sets turn to red team
		assertEquals(board.choose(board.getMainBoard().get(byPos).getCodeName()),"Incorrect Guess. Blue SpyMasters Turn.");	//tests red turn choosing bysatnder
		assertEquals(board.getTurn(),"Buffer");	//tests making sure incorrect guess changed turns
		
		
		redPosition();	//gets position of red agent for testing
		bluePosition();	//gets position of blue agent for testing
		grePosition();	//gets position of green agent for testing
		bystanderPosition();	//gets position of bystander for testing
		board.setTurn("blue");	//sets turn to blue team
		assertEquals(board.choose(board.getMainBoard().get(bluPos).getCodeName()),"Correct Guess! Still Blue Teams Turn.");	//tests blue turn choosing red agent
		assertEquals(board.choose(board.getMainBoard().get(redPos).getCodeName()),"Incorrect Guess. Green SpyMasters Turn.");	//tests blue turn choosing blue agent
		board.setTurn("blue");	//sets turn to red team
		assertEquals(board.choose(board.getMainBoard().get(grePos).getCodeName()),"Incorrect Guess. Green SpyMasters Turn.");	//tests blue turn choosing green agent
		board.setTurn("blue");	//sets turn to red team
		assertEquals(board.choose(board.getMainBoard().get(byPos).getCodeName()),"Incorrect Guess. Green SpyMasters Turn.");	//tests blue turn choosing bystander
		assertEquals(board.getTurn(),"Buffer");	//tests making sure incorrect guess changed turns
		
		redPosition();	//gets position of red agent for testing
		bluePosition();	//gets position of blue agent for testing
		grePosition();	//gets position of green agent for testing
		bystanderPosition();	//gets position of bystander for testing
		board.setTurn("green");	//sets turn to green team
		assertEquals(board.choose(board.getMainBoard().get(grePos).getCodeName()),"Correct Guess! Still Green Teams Turn.");	//tests green turn choosing red agent
		assertEquals(board.choose(board.getMainBoard().get(bluPos).getCodeName()),"Incorrect Guess. Red SpyMasters Turn.");	//tests green turn choosing blue agent
		board.setTurn("green");	//sets turn to red team
		assertEquals(board.choose(board.getMainBoard().get(redPos).getCodeName()),"Incorrect Guess. Red SpyMasters Turn.");	//tests green turn choosing green agent
		board.setTurn("green");	//sets turn to red team
		assertEquals(board.choose(board.getMainBoard().get(byPos).getCodeName()),"Incorrect Guess. Red SpyMasters Turn.");	//tests green turn choosing bystander
		assertEquals(board.getTurn(),"Buffer");	//tests making sure incorrect guess changed turns

		grePosition();
		board.setTurn("blue");
		assertEquals(board.choose(board.getMainBoard().get(grePos).getCodeName()),"Incorrect Guess. Green SpyMasters Turn.");
		redPosition();
		board.setTurn("green");
		assertEquals(board.choose(board.getMainBoard().get(redPos).getCodeName()),"Incorrect Guess. Red SpyMasters Turn.");
		
		
		board.playerSet(3);
		board.setTurn("red");	//sets turn to red team
		assassin2Position();
		assertEquals(board.choose(board.getMainBoard().get(ass2Pos).getCodeName()),"Assassin chosen by Red Team! Red Team Eliminated!");	//tests blue choosing assasssin
		
		assassinPosition();
		board.getMainBoard().get(assPos).setRevealed(false);
		board.getMainBoard().get(ass2Pos).setRevealed(false);
		board.setTurn("blue");	//sets turn to blue team
		assertEquals(board.choose(board.getMainBoard().get(assPos).getCodeName()),"Assassin chosen by Blue Team! Blue Team Eliminated!");	//tests blue choosing assasssin
		
		grePosition();
		redPosition();
		board.setTurn("green");
		assertEquals(board.choose(board.getMainBoard().get(redPos).getCodeName()),"Incorrect Guess. Blue SpyMasters Turn.");
		grePosition();
		board.setTurn("red");
		assertEquals(board.choose(board.getMainBoard().get(grePos).getCodeName()),"Incorrect Guess. Green SpyMasters Turn.");
		
		board.playerSet(3);
		board.setTurn("blue");	//sets turn to blue team
		assassin2Position();
		assertEquals(board.choose(board.getMainBoard().get(ass2Pos).getCodeName()),"Assassin chosen by Blue Team! Blue Team Eliminated!");	//tests blue choosing assasssin
		
		assassinPosition();
		board.getMainBoard().get(assPos).setRevealed(false);
		board.getMainBoard().get(ass2Pos).setRevealed(false);
		board.setTurn("green");	//sets turn to green team
		assertEquals(board.choose(board.getMainBoard().get(assPos).getCodeName()),"Assassin chosen by Green Team! Green Team Eliminated!");	//tests blue choosing assasssin
		
		redPosition();
		board.setTurn("blue");
		assertEquals(board.choose(board.getMainBoard().get(redPos).getCodeName()),"Incorrect Guess. Red SpyMasters Turn.");
		grePosition();
		board.setTurn("red");
		assertEquals(board.choose(board.getMainBoard().get(grePos).getCodeName()),"Incorrect Guess. Green SpyMasters Turn.");
		
		board.playerSet(3);
		board.setTurn("green");	//sets turn to green team
		assassin2Position();
		assertEquals(board.choose(board.getMainBoard().get(ass2Pos).getCodeName()),"Assassin chosen by Green Team! Green Team Eliminated!");	//tests blue choosing assasssin
		
		board.playerSet(3); //player set 3
		assassinPosition(); //sets assPos to assassin Position
		assassin2Position(); //sets ass2Pos to assassin Position
		board.setTurn("red");//set turn to red
		board.choose(board.getMainBoard().get(assPos).getCodeName()); //red choose assassin
		board.setTurn("green");//set turn to green
		board.choose(board.getMainBoard().get(ass2Pos).getCodeName()); //green choose assassin
		assertEquals(board.isWinner(),"Game Has Been Won By Blue Team"); //correct winner
		
		board.playerSet(3);//player set 3
		assassinPosition();//sets assPos to assassin Position
		assassin2Position();//sets ass2Pos to assassin Position
		board.setTurn("green");//set turn to green
		board.choose(board.getMainBoard().get(assPos).getCodeName()); //green choose assassin
		board.setTurn("blue");//set turn to blue
		board.choose(board.getMainBoard().get(ass2Pos).getCodeName()); //blue choose assassin
		assertEquals(board.isWinner(),"Game Has Been Won By Red Team"); //correct winner
		
		board.playerSet(3); //player set 3
		assassinPosition();//sets assPos to assassin Position
		assassin2Position();//sets ass2Pos to assassin Position
		board.setTurn("red");//set turn to red
		board.choose(board.getMainBoard().get(assPos).getCodeName()); //red choose assassin
		board.setTurn("blue");//set turn to blue
		board.choose(board.getMainBoard().get(ass2Pos).getCodeName()); //blue choose assassin
		assertEquals(board.isWinner(),"Game Has Been Won By Green Team"); //correct winner
		
		board.playerSet(3);//player set 3
		assertEquals(board.isWinner(),"Game Has Not Been Won"); // no winner
	}
	
	@Test
	public void testPersonClass() {
		Person test = new Person("test codeName", "test team");	//creates new person using person class and sets name and team
		assertEquals(test.getCodeName(),"test codeName");	//tests that codeName was set correctly
		assertEquals(test.getTeam(),"test team");	//tests that team was set correctly
		assertFalse(test.getRevealed());	//tests that revealed status is false
		test.setRevealed(true);	//sets revealed status to true
		assertTrue(test.getRevealed());	//tests that revealed status is now true
		Person test2 = new Person(null,null);	//creates new person with both nulls to ensure no crashes
		assertEquals(test2.getCodeName(),null);	//assures no crashes with null as codeName
		assertEquals(test2.getTeam(),null);	//assures no crashes with null as team
		assertFalse(test2.getRevealed());	//tests that reveal status is false
		test2.setRevealed(true);	//sets reveal status to true
		assertTrue(test2.getRevealed());	//tests that reveal status is true
	}
	
	@Test
	public void testAssassinPressed() {	//tests when assassin is pressed
		board.playerSet(3);
		board.setTurn("red");	//changes turn to red
		assertEquals(board.assassPressed(),"Assassin chosen by Red Team! Red Team Eliminated!");	//tests when assassin is chosen by red team
		board.setTurn("blue");	//changes turn to blue
		assertEquals(board.assassPressed(),"Assassin chosen by Blue Team! Blue Team Eliminated!");	//tests when assassin is chosen by blue team
		board.setTurn("green");	//changes turn to blue
		assertEquals(board.assassPressed(),"Assassin chosen by Green Team! Green Team Eliminated!");	//tests when assassin is chosen by blue team
	}
	
	@Test
	public void testTeamSize() {	//tests to make sure there are the correct number of agents per team along with bystanders and assassins
		board.playerSet(3);
		assertEquals(6,teamSize("red")); //assures 6 red agents
		assertEquals(5,teamSize("blue")); //assures 5 blue agents
		assertEquals(5,teamSize("green")); //assures 5 green agents
		assertEquals(7,teamSize("bystander")); //assures 7 bystanders 
		assertEquals(2,teamSize("assassin")); //assures 2 assassin
	}
}
