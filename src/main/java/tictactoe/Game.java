/*
 *    Copyright  2023
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package tictactoe;

import java.util.Random;

public class Game {

    public void play() {
        System.out.println("Use the following mapping table to specify " +
                "a cell using numbers from 1 to 9: ");
        dataPrinter.pringMappingTable();
        final GameTable gameTable = new GameTable();


        if (new Random().nextBoolean()) {
            computerMove.make(gameTable);
            dataPrinter.pringMappingTable(gameTable);
        }
        while (true) {
            userMove.make(gameTable);
            dataPrinter.pringMappingTable(gameTable);
            if (winnerVerifier.isUserWin(gameTable)) {
                System.out.println("You Win!");
                break;
            }
            if (drawVerifier.isDraw(gameTable)) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            computerMove.make(gameTable);
            dataPrinter.pringMappingTable(gameTable);
            if (winnerVerifier.isComputerWin(gameTable)) {
                System.out.println("Computer Win!");
                break;
            }
            if (drawVerifier.isDraw(gameTable)) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            System.out.println("GAME OVER");
        }
    }
}
