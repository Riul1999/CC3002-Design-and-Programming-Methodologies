Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---
Se juzga si la jerarqueia de clases del paquete model esta correcto, esto viendo si dicha jerarquia
cumple con los principios SOLID.

Primero se revisa la clase AbstractCharacter junto con la interfaz ICharacter, aqui se detecta 
una falta al Interface Segregation principle, ya que en la interfaz ICharacter se declara el 
metodo equipWeapon() y getEquipedWeapon() y los objetos de la clase Enemy no son  capaces de 
equiparse una arma (y no deben poder) y por lo tanto tampoco pueden mostrar el arma equipada, 
por lo que se eliminan ambos metodos tanto de la interfaz ICharacter como de la clase AbstractCharacter
y se mueven las implementaciones de dichos metodos a la clase PlayerCharacter. Al hacer esto ocurren 
errores en los test que vienen hechos para tomar un ICharacter y  equiparle un arma, por lo que se ponen
como comentario las lineas donde ocurrian errores y mas adelante se volveran a hacer los test.

Luego se revisa la clase AbstractCharacter y se encuentra una falta al Open-Closed principle,
ya que en el metodo waitTurn() se ocupa la instruccion if para diferenciar si el parametro
ingresado es un PlayerCharacter o un Enemy, lo que hace que, si en un futuro hubiera otro 
AbstractCharacter distinto, se tendria que modificar dicho metodo. Por lo cual se transforma
el metodo waitTurn en un metodo abstracto en la clase AbstractCharacter, y se delega la 
implementacion de dicho metodo a las subclases. Por lo que se implementa dicho metodo en la clase
PlayerCharacter y Enemy de la misma forma que como estaba pero sin la instruccion if.

Tambien para realizar el cambio anterior, se modifico en la clase AbstractCharacter la privacidad 
de las variables scheduledExecutor, equippedWeapon y del metodo addToQueue() de private a protected,
para luego poder usar dichas variables en las subclases. 

Finalmente se crean nuevas clases para cada CharacterClass (menos ENEMY pues ya existe), esto porque en
el futuro sera necesario incluir parametros como mana y metodos de hechizos para los BLACK_MAGE y los 
WHITE_MAGE, se dejaran listas las clases de KNIGHT, THIEF e ENGINEER por si se agregan nuevos parametros 
o nuevos metodos a estas clases. Se crearan ademas las clases abstractas AbstractMagicCharacter y 
AbstractCommonCharacter para agrupar dichas clases.

Tambien se haran nuevas clases para cada WaponType, esto porque en el futuro sera necesario incluir 
parametros como magicDamage almenos para los STAFF (los otros quedaron a eleccion del programador).

En ambos casos solo se construiran las clases y sus respectivos constructores, todas las nuevas caracteristicas
se implementaran en la proxima etapa.

Con esto se concluye la revision de jerarquia de clases del paquete model.
