package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.uglytrivia.Game;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SomeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Mock
	private Random random;

	@Before
	public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
	}

	@Test
	public void systemTest() throws Exception {
        // GIVEN
	    when(random.nextInt(anyInt())).thenReturn(1, 0, 3, 1, 3, 5, 1, 8, 3, 1, 1, 0, 3, 7, 0, 8, 4, 4, 0, 5, 0, 7, 2, 7, 0, 7, 0, 8, 3, 5, 4, 6, 0, 3, 4, 3, 0, 0, 3, 7, 0, 4, 3, 6, 1, 8, 0, 3);

	    // WHEN
        GameRunner.runGame(random);

        // THEN
        assertThat(outContent.toString()).isEqualTo("Chet was added\r\n" +
                                                    "They are player number 1\r\n" +
                                                    "Pat was added\r\n" +
                                                    "They are player number 2\r\n" +
                                                    "Sue was added\r\n" +
                                                    "They are player number 3\r\n" +
                                                    "Chet is the current player\r\n" +
                                                    "They have rolled a 2\r\n" +
                                                    "Chet's new location is 2\r\n" +
                                                    "The category is Sports\r\n" +
                                                    "Sports Question 0\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Chet now has 1 Gold Coins.\r\n" +
                                                    "Pat is the current player\r\n" +
                                                    "They have rolled a 4\r\n" +
                                                    "Pat's new location is 4\r\n" +
                                                    "The category is Pop\r\n" +
                                                    "Pop Question 0\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Pat now has 1 Gold Coins.\r\n" +
                                                    "Sue is the current player\r\n" +
                                                    "They have rolled a 4\r\n" +
                                                    "Sue's new location is 4\r\n" +
                                                    "The category is Pop\r\n" +
                                                    "Pop Question 1\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Sue now has 1 Gold Coins.\r\n" +
                                                    "Chet is the current player\r\n" +
                                                    "They have rolled a 2\r\n" +
                                                    "Chet's new location is 4\r\n" +
                                                    "The category is Pop\r\n" +
                                                    "Pop Question 2\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Chet now has 2 Gold Coins.\r\n" +
                                                    "Pat is the current player\r\n" +
                                                    "They have rolled a 4\r\n" +
                                                    "Pat's new location is 8\r\n" +
                                                    "The category is Pop\r\n" +
                                                    "Pop Question 3\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Pat now has 2 Gold Coins.\r\n" +
                                                    "Sue is the current player\r\n" +
                                                    "They have rolled a 2\r\n" +
                                                    "Sue's new location is 6\r\n" +
                                                    "The category is Sports\r\n" +
                                                    "Sports Question 1\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Sue now has 2 Gold Coins.\r\n" +
                                                    "Chet is the current player\r\n" +
                                                    "They have rolled a 4\r\n" +
                                                    "Chet's new location is 8\r\n" +
                                                    "The category is Pop\r\n" +
                                                    "Pop Question 4\r\n" +
                                                    "Question was incorrectly answered\r\n" +
                                                    "Chet was sent to the penalty box\r\n" +
                                                    "Pat is the current player\r\n" +
                                                    "They have rolled a 1\r\n" +
                                                    "Pat's new location is 9\r\n" +
                                                    "The category is Science\r\n" +
                                                    "Science Question 0\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Pat now has 3 Gold Coins.\r\n" +
                                                    "Sue is the current player\r\n" +
                                                    "They have rolled a 5\r\n" +
                                                    "Sue's new location is 11\r\n" +
                                                    "The category is Rock\r\n" +
                                                    "Rock Question 0\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Sue now has 3 Gold Coins.\r\n" +
                                                    "Chet is the current player\r\n" +
                                                    "They have rolled a 1\r\n" +
                                                    "Chet is getting out of the penalty box\r\n" +
                                                    "Chet's new location is 9\r\n" +
                                                    "The category is Science\r\n" +
                                                    "Science Question 1\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Chet now has 3 Gold Coins.\r\n" +
                                                    "Pat is the current player\r\n" +
                                                    "They have rolled a 1\r\n" +
                                                    "Pat's new location is 10\r\n" +
                                                    "The category is Sports\r\n" +
                                                    "Sports Question 2\r\n" +
                                                    "Question was incorrectly answered\r\n" +
                                                    "Pat was sent to the penalty box\r\n" +
                                                    "Sue is the current player\r\n" +
                                                    "They have rolled a 3\r\n" +
                                                    "Sue's new location is 2\r\n" +
                                                    "The category is Sports\r\n" +
                                                    "Sports Question 3\r\n" +
                                                    "Question was incorrectly answered\r\n" +
                                                    "Sue was sent to the penalty box\r\n" +
                                                    "Chet is the current player\r\n" +
                                                    "They have rolled a 1\r\n" +
                                                    "Chet is getting out of the penalty box\r\n" +
                                                    "Chet's new location is 10\r\n" +
                                                    "The category is Sports\r\n" +
                                                    "Sports Question 4\r\n" +
                                                    "Question was incorrectly answered\r\n" +
                                                    "Chet was sent to the penalty box\r\n" +
                                                    "Pat is the current player\r\n" +
                                                    "They have rolled a 1\r\n" +
                                                    "Pat is getting out of the penalty box\r\n" +
                                                    "Pat's new location is 11\r\n" +
                                                    "The category is Rock\r\n" +
                                                    "Rock Question 1\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Pat now has 4 Gold Coins.\r\n" +
                                                    "Sue is the current player\r\n" +
                                                    "They have rolled a 4\r\n" +
                                                    "Sue is not getting out of the penalty box\r\n" +
                                                    "Chet is the current player\r\n" +
                                                    "They have rolled a 5\r\n" +
                                                    "Chet is getting out of the penalty box\r\n" +
                                                    "Chet's new location is 3\r\n" +
                                                    "The category is Rock\r\n" +
                                                    "Rock Question 2\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Chet now has 4 Gold Coins.\r\n" +
                                                    "Pat is the current player\r\n" +
                                                    "They have rolled a 1\r\n" +
                                                    "Pat is getting out of the penalty box\r\n" +
                                                    "Pat's new location is 0\r\n" +
                                                    "The category is Pop\r\n" +
                                                    "Pop Question 5\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Pat now has 5 Gold Coins.\r\n" +
                                                    "Sue is the current player\r\n" +
                                                    "They have rolled a 5\r\n" +
                                                    "Sue is getting out of the penalty box\r\n" +
                                                    "Sue's new location is 7\r\n" +
                                                    "The category is Rock\r\n" +
                                                    "Rock Question 3\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Sue now has 4 Gold Coins.\r\n" +
                                                    "Chet is the current player\r\n" +
                                                    "They have rolled a 1\r\n" +
                                                    "Chet is getting out of the penalty box\r\n" +
                                                    "Chet's new location is 4\r\n" +
                                                    "The category is Pop\r\n" +
                                                    "Pop Question 6\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Chet now has 5 Gold Coins.\r\n" +
                                                    "Pat is the current player\r\n" +
                                                    "They have rolled a 4\r\n" +
                                                    "Pat is not getting out of the penalty box\r\n" +
                                                    "Question was incorrectly answered\r\n" +
                                                    "Pat was sent to the penalty box\r\n" +
                                                    "Sue is the current player\r\n" +
                                                    "They have rolled a 1\r\n" +
                                                    "Sue is getting out of the penalty box\r\n" +
                                                    "Sue's new location is 8\r\n" +
                                                    "The category is Pop\r\n" +
                                                    "Pop Question 7\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Sue now has 5 Gold Coins.\r\n" +
                                                    "Chet is the current player\r\n" +
                                                    "They have rolled a 4\r\n" +
                                                    "Chet is not getting out of the penalty box\r\n" +
                                                    "Pat is the current player\r\n" +
                                                    "They have rolled a 2\r\n" +
                                                    "Pat is not getting out of the penalty box\r\n" +
                                                    "Sue is the current player\r\n" +
                                                    "They have rolled a 1\r\n" +
                                                    "Sue is getting out of the penalty box\r\n" +
                                                    "Sue's new location is 9\r\n" +
                                                    "The category is Science\r\n" +
                                                    "Science Question 2\r\n" +
                                                    "Answer was correct!!!!\r\n" +
                                                    "Sue now has 6 Gold Coins.\r\n");
    }
}
