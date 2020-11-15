package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.Assertions;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AbstractCharacterTest {

    protected BlockingQueue<ICharacter> turns;
    protected IWeapon testWeapon;

    /**
     * Do a basic SetUp for all the tests
     */
    protected void abstractCharacterBasicSetUp() {
        turns = new LinkedBlockingQueue<>();
        testWeapon = new Axe("Test", 15, 10);
    }

    /**
     * method to check the behavior of waitTurn
     * @param character The test character
     */
    protected void abstractCharacterWaitTurn(ICharacter character) {
        Assertions.assertTrue(turns.isEmpty());
        character.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(character, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks that the equals method works properly.
     * @param expectedCharacter Same ICharacter
     * @param testEqualCharacter Test ICharacter
     * @param differentClassCharacter Different object ICharacter
     * @param differentName Different name ICharacter
     * @param differentLifePoints Different life points ICharacter
     * @param differentDefense  Different defense ICharacter
     */
    protected static void abstractCharacterCheckConstruction(final ICharacter expectedCharacter,
                                                             final ICharacter testEqualCharacter,
                                                             final ICharacter differentClassCharacter,
                                                             final ICharacter differentName,
                                                             final ICharacter differentLifePoints,
                                                             final ICharacter differentDefense) {
        assertEquals(expectedCharacter,testEqualCharacter);
        assertEquals(testEqualCharacter.hashCode(),expectedCharacter.hashCode());

        assertNotEquals(testEqualCharacter, differentClassCharacter);
        assertNotEquals(testEqualCharacter.hashCode(),differentClassCharacter.hashCode());

        assertNotEquals(testEqualCharacter,differentName);
        assertNotEquals(testEqualCharacter.hashCode(),differentName.hashCode());

        assertNotEquals(testEqualCharacter,differentLifePoints);
        assertNotEquals(testEqualCharacter.hashCode(),differentLifePoints.hashCode());

        assertNotEquals(testEqualCharacter,differentDefense);
        assertNotEquals(testEqualCharacter.hashCode(),differentDefense.hashCode());

    }

}
