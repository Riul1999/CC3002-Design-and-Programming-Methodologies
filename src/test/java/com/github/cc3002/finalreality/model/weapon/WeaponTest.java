package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponTest {

  private static final String AXE_NAME = "Test Axe";
  private static final String STAFF_NAME = "Test Staff";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int SPEED = 10;

  private Axe testAxe;
  private Staff testStaff;
  private Sword testSword;
  private Bow testBow;
  private Knife testKnife;

  /**
   * SetUp method
   * Creates 5 weapons (each one of one type), with a name, damage and speed
   */
  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
    testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    testBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void constructorTest() {

    var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    var expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
    var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
    var noWeapon = new Object();
    var weapon = new Weapon(AXE_NAME,DAMAGE,SPEED,WeaponType.NULLWEAPON);

    assertEquals(testAxe,testAxe);
    assertEquals(testBow,testBow);
    assertEquals(testKnife,testKnife);
    assertEquals(testStaff,testStaff);
    assertEquals(testSword,testSword);

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());

    assertNotEquals(testAxe,noWeapon);
    assertNotEquals(noWeapon.hashCode(),testAxe.hashCode());
    assertNotEquals(testBow,noWeapon);
    assertNotEquals(noWeapon.hashCode(),testBow.hashCode());
    assertNotEquals(testStaff,noWeapon);
    assertNotEquals(noWeapon.hashCode(),testStaff.hashCode());
    assertNotEquals(testSword,noWeapon);
    assertNotEquals(noWeapon.hashCode(),testSword.hashCode());
    assertNotEquals(testKnife,noWeapon);
    assertNotEquals(noWeapon.hashCode(),testKnife.hashCode());

    assertNotEquals(expectedAxe, new Axe("War Axe",DAMAGE,SPEED));
    assertNotEquals(expectedAxe, new Axe(AXE_NAME,DAMAGE+1,SPEED));
    assertNotEquals(expectedAxe, new Axe(AXE_NAME,DAMAGE,SPEED+1));
    assertNotEquals(expectedAxe,weapon);
    assertNotEquals(expectedAxe.hashCode(), new Axe("War Axe",DAMAGE,SPEED).hashCode());
    assertNotEquals(expectedAxe.hashCode(), new Axe(AXE_NAME,DAMAGE+1,SPEED).hashCode());
    assertNotEquals(expectedAxe.hashCode(), new Axe(AXE_NAME,DAMAGE,SPEED+1).hashCode());
    assertNotEquals(expectedAxe.hashCode(),weapon.hashCode());

    assertNotEquals(expectedBow, new Bow("War Bow",DAMAGE,SPEED));
    assertNotEquals(expectedBow, new Bow(BOW_NAME,DAMAGE+1,SPEED));
    assertNotEquals(expectedBow, new Bow(BOW_NAME,DAMAGE,SPEED+1));
    assertNotEquals(expectedBow,weapon);
    assertNotEquals(expectedBow.hashCode(), new Bow("War Bow",DAMAGE,SPEED).hashCode());
    assertNotEquals(expectedBow.hashCode(), new Bow(BOW_NAME,DAMAGE+1,SPEED).hashCode());
    assertNotEquals(expectedBow.hashCode(), new Bow(BOW_NAME,DAMAGE,SPEED+1).hashCode());
    assertNotEquals(expectedBow.hashCode(),weapon.hashCode());

    assertNotEquals(expectedStaff, new Staff("War Staff",DAMAGE,SPEED));
    assertNotEquals(expectedStaff, new Staff(STAFF_NAME,DAMAGE+1,SPEED));
    assertNotEquals(expectedStaff, new Staff(STAFF_NAME,DAMAGE,SPEED+1));
    assertNotEquals(expectedStaff,weapon);
    assertNotEquals(expectedStaff.hashCode(), new Staff("War Staff",DAMAGE,SPEED).hashCode());
    assertNotEquals(expectedStaff.hashCode(), new Staff(STAFF_NAME,DAMAGE+1,SPEED).hashCode());
    assertNotEquals(expectedStaff.hashCode(), new Staff(STAFF_NAME,DAMAGE,SPEED+1).hashCode());
    assertNotEquals(expectedStaff.hashCode(),weapon.hashCode());

    assertNotEquals(expectedSword, new Sword("War Sword",DAMAGE,SPEED));
    assertNotEquals(expectedSword, new Sword(SWORD_NAME,DAMAGE+1,SPEED));
    assertNotEquals(expectedSword, new Sword(SWORD_NAME,DAMAGE,SPEED+1));
    assertNotEquals(expectedSword,weapon);
    assertNotEquals(expectedSword.hashCode(), new Sword("War Sword",DAMAGE,SPEED).hashCode());
    assertNotEquals(expectedSword.hashCode(), new Sword(SWORD_NAME,DAMAGE+1,SPEED).hashCode());
    assertNotEquals(expectedSword.hashCode(), new Sword(SWORD_NAME,DAMAGE,SPEED+1).hashCode());
    assertNotEquals(expectedSword.hashCode(),weapon.hashCode());

    assertNotEquals(expectedKnife, new Knife("War Knife",DAMAGE,SPEED));
    assertNotEquals(expectedKnife, new Knife(KNIFE_NAME,DAMAGE+1,SPEED));
    assertNotEquals(expectedKnife, new Knife(KNIFE_NAME,DAMAGE,SPEED+1));
    assertNotEquals(expectedKnife,weapon);
    assertNotEquals(expectedKnife.hashCode(), new Knife("War Knife",DAMAGE,SPEED).hashCode());
    assertNotEquals(expectedKnife.hashCode(), new Knife(KNIFE_NAME,DAMAGE+1,SPEED).hashCode());
    assertNotEquals(expectedKnife.hashCode(), new Knife(KNIFE_NAME,DAMAGE,SPEED+1).hashCode());
    assertNotEquals(expectedKnife.hashCode(),weapon.hashCode());
  }
}