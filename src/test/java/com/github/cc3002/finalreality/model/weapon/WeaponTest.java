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
  private static final int MAGIC_DAMAGE = 25;

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
    testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED, MAGIC_DAMAGE);
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
    var expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED, MAGIC_DAMAGE);
    var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
    var noWeapon = new Object();

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

    assertNotEquals(testAxe, new Axe("War Axe",DAMAGE,SPEED));
    assertNotEquals(testAxe, new Axe(AXE_NAME,DAMAGE+1,SPEED));
    assertNotEquals(testAxe, new Axe(AXE_NAME,DAMAGE,SPEED+1));
    assertNotEquals(testAxe,new Sword(AXE_NAME,DAMAGE,SPEED));
    assertNotEquals(testAxe.hashCode(), new Axe("War Axe",DAMAGE,SPEED).hashCode());
    assertNotEquals(testAxe .hashCode(), new Axe(AXE_NAME,DAMAGE+1,SPEED).hashCode());
    assertNotEquals(testAxe.hashCode(), new Axe(AXE_NAME,DAMAGE,SPEED+1).hashCode());
    assertNotEquals(testAxe.hashCode(),new Sword(AXE_NAME,DAMAGE,SPEED).hashCode());

    assertNotEquals(testBow, new Bow("War Bow",DAMAGE,SPEED));
    assertNotEquals(testBow, new Bow(BOW_NAME,DAMAGE+1,SPEED));
    assertNotEquals(testBow, new Bow(BOW_NAME,DAMAGE,SPEED+1));
    assertNotEquals(testBow,new Sword(BOW_NAME,DAMAGE,SPEED));
    assertNotEquals(testBow.hashCode(), new Bow("War Bow",DAMAGE,SPEED).hashCode());
    assertNotEquals(testBow.hashCode(), new Bow(BOW_NAME,DAMAGE+1,SPEED).hashCode());
    assertNotEquals(testBow.hashCode(), new Bow(BOW_NAME,DAMAGE,SPEED+1).hashCode());
    assertNotEquals(testBow.hashCode(),new Sword(BOW_NAME,DAMAGE,SPEED).hashCode());

    assertNotEquals(testStaff, new Staff("War Staff",DAMAGE,SPEED,MAGIC_DAMAGE));
    assertNotEquals(testStaff, new Staff(STAFF_NAME,DAMAGE+1,SPEED,MAGIC_DAMAGE));
    assertNotEquals(testStaff, new Staff(STAFF_NAME,DAMAGE,SPEED+1,MAGIC_DAMAGE));
    assertNotEquals(testStaff, new Staff(STAFF_NAME,DAMAGE,SPEED,MAGIC_DAMAGE+1));
    assertNotEquals(testStaff.hashCode(), new Staff("War Staff",DAMAGE,SPEED,MAGIC_DAMAGE).hashCode());
    assertNotEquals(testStaff.hashCode(), new Staff(STAFF_NAME,DAMAGE+1,SPEED,MAGIC_DAMAGE).hashCode());
    assertNotEquals(testStaff.hashCode(), new Staff(STAFF_NAME,DAMAGE,SPEED+1,MAGIC_DAMAGE).hashCode());
    assertNotEquals(testStaff.hashCode(), new Staff(STAFF_NAME,DAMAGE,SPEED,MAGIC_DAMAGE+1).hashCode());

    assertNotEquals(testSword, new Sword("War Sword",DAMAGE,SPEED));
    assertNotEquals(testSword, new Sword(SWORD_NAME,DAMAGE+1,SPEED));
    assertNotEquals(testSword, new Sword(SWORD_NAME,DAMAGE,SPEED+1));
    assertNotEquals(testSword,new Knife(SWORD_NAME,DAMAGE,SPEED));
    assertNotEquals(testSword.hashCode(), new Sword("War Sword",DAMAGE,SPEED).hashCode());
    assertNotEquals(testSword.hashCode(), new Sword(SWORD_NAME,DAMAGE+1,SPEED).hashCode());
    assertNotEquals(testSword.hashCode(), new Sword(SWORD_NAME,DAMAGE,SPEED+1).hashCode());
    assertNotEquals(testSword.hashCode(),new Knife(SWORD_NAME,DAMAGE,SPEED).hashCode());

    assertNotEquals(testKnife, new Knife("War Knife",DAMAGE,SPEED));
    assertNotEquals(testKnife, new Knife(KNIFE_NAME,DAMAGE+1,SPEED));
    assertNotEquals(testKnife, new Knife(KNIFE_NAME,DAMAGE,SPEED+1));
    assertNotEquals(testKnife,new Sword(KNIFE_NAME,DAMAGE,SPEED));
    assertNotEquals(testKnife.hashCode(), new Knife("War Knife",DAMAGE,SPEED).hashCode());
    assertNotEquals(testKnife.hashCode(), new Knife(KNIFE_NAME,DAMAGE+1,SPEED).hashCode());
    assertNotEquals(testKnife.hashCode(), new Knife(KNIFE_NAME,DAMAGE,SPEED+1).hashCode());
    assertNotEquals(testKnife.hashCode(),new Sword(KNIFE_NAME,DAMAGE,SPEED).hashCode());
  }

  /**
   * Checks that the class toString method works properly.
   */
  @Test
  public void toStringTest(){

    String expectedAxe = "Name: Test Axe,Damage: 15,Weight: 10,Class: Axe";
    String expectedBow = "Name: Test Bow,Damage: 15,Weight: 10,Class: Bow";
    String expectedKnife = "Name: Test Knife,Damage: 15,Weight: 10,Class: Knife";
    String expectedSword = "Name: Test Sword,Damage: 15,Weight: 10,Class: Sword";
    String expectedStaff = "Name: Test Staff,Damage: 15,Weight: 10,MagicDamage: 25,Class: Staff";

    assertEquals(expectedAxe,testAxe.toString());
    assertEquals(expectedBow,testBow.toString());
    assertEquals(expectedKnife,testKnife.toString());
    assertEquals(expectedSword,testSword.toString());
    assertEquals(expectedStaff,testStaff.toString());
  }
}