ChangeLog
=========

Version 3.0
-----------
- (RC.3) Nuevos paramtros, metodos y testeo correctos (asegurado 100% de las luneas y branches cubiertos)
- (B.19) Se corren los test y pasan todos (se logra 100% de lineas y branches)
- (B.18) Se modifica la clase PlayerCharacterTest para testear la nueva funcionalidad
- (B.17) Modificacion de la AbstractMagicCharacter y sus subclases, nuevo parametro y metodos equals() y hashCode)() sobreescritos
- (B.16) Testeo del nuevo parametro maxMana de la clase AbstractMagicCharacter
- (RC.2) Nuevos parametros, funcionalidades y testing correctos (asegurado 100% de las lineas y branches cubiertos)
- (B.15) Se corren los test y pasan todos (se logra 100% de las lineas y branches)
- (B.14) Se modifica test waitTurnTest, se cambio el tiempo de espera para que pase un turno de 900ms a 1200ms
- (B.13) Se modifca el metodo equip() en playerCharacter para lograr lo que se pide en el enunciado (con double dispatch)
- (B.12) Modificacion del test equipWeaponTest de la clase PlayerCharacterTest
- (B.11) Se corren los test y pasan todos (se logra 100% de las lineas y branches)
- (B.10) Moficacion de la clase Staff, se incluye el parametro magicDamage, y se sobreescriben los metodos equals() y hashCode()
- (B.9) Testeo de nuevos parametros de Staff (magicDamage), se arreglan errores del testeo
- (RC.1) Nuevos parametros y testing correctos (asegurado 100% de lineas y branches cubiertos)
- (B.8) Se corren los test y pasan todos (se logra 100% de las lineas y branches)
- (B.7) Modificacion clase Enmey, se agrega el parametro damage, junto con su metodo para obtenerlo
- (B.6) Testeo de nuevo parametro de Enemy(damage)
- (B.5) Se corren los test y se pasan todos (se logra 100% de las lineas y branches)
- (B.4) Agregacion de los nuevos parametros al contructor de las sublases de AbstractCharacter y los metodos equals() y hashCode
- (B.3) Modificacion clase AbstractCharacter, se agregan parametros life,defense junto con sus metodos para obtenerlos
- (B.2) Modificacion de la clase EnemyTest, se eliminan todos los enemigos excepto 1 pues no influyen en el testing
- (B.1) Testeo de nuevos parametros de AbstractCharacter y sus subclases(life,defense)

Version 2.0
-----------
- (RC.2) Jerarquia y testing corregidos (asegurado 100% de lineas y branches cubiertos)
- (B.22) Modificacion clase PlayerCharacterTest, se agregan assert para cubrir todas las branches del metodo equals()
- (B.21) Modificacion clase PlayerCharacterTest, se agregan nuevas subclases de PlayerCharacter
- (B.20) Modificacion clase EnemyTest, se agregan assert para cubrir todas las branches del metodo equals()
- (B.19) Modificacion clase EnemyTest, se agregan nuevas instancias de Enemy
- (B.18) Modificacion clase WeaponTest, se añaden nuevos assert para cubir todas las branches del metodo equals()
- (B.17) Modificacion clase WeaponTest, se añaden nuevas subclases de Weapon
- (B.16) Prueba de los test en PlayerCharacterTest, EnemyTest y WeaponTest y todos pasan
- (B.15) Modificacion inicializacion de parametro equippedWeapon en PlayerCharacter (se usa un arama de tipo NULL)
- (B.14) Eliminacion AbstractCharacterTest por solo ser un ahorro de codigo (no una herencia real)
- (B.13) Revision AbstractCharacterTest
- (RC.1) Jerarquia corregida y acorde con los principios SOLID (falta testing)
- (B.12) Creacion de los constructores (llamando al contructor de la super clase)
- (B.11) Creacion de clases para cada tipo de Weapon (por necesidad en el futuro)
- (B.10) Creacion clases AbstractCommonCharacter y AbstractMagicCharacter para agrupar las clases anteriores
- (B.9) Creacion de clases para cada tipo de PlayerCharacter (por necesidad en el futuro)
- (B.8) Cambio de visibilidad de la variable scheduledExecutor y del metodo addToQueue (por el cambio anterior)
- (B.7) Implementacion del metodo waitTurn en PlayerCharacter y Enemy (se resuelve falla de OPP)
- (B.6) Transformacion del metodo waitTurn en AbstractCharacter en un metodo abstracto 
- (B.5) Revision clase AbstractCharacter (se detecta incumplimineto de OPP)
- (B.4) Se comentan lineas que ocupaban estos metodos en los test para dejar que el problema compile
- (B.3) Creacion de los metodos equip() y getEquippedWeapon() (copia de los anteriores) en PlayerCharacter
- (B.2) Eliminacion  metodos equip() y getEquippedWeapon() de AbstractCharacter y ICharacter (se soluciona falla de ISP)
- (B.1) Revision clase AbstractCharacter y ICharacter (se detecta incumplimiento de ISP)

Version 1.0
-----------
- (RC.1) Implemented missing tests
- (B.5) Updated License
- (B.4) Implementation and testing of Enemy class (ensured 100% branch coverage)
- (B.3) Created .gitignore
- (B.2) Implementation of most base elements of the model
- (B.1) Created project

A note on the version naming
----------------------------
- B.n: Version ``x.y`` _beta x_, alternative to ``x.y-b.n``.
  For example: ``v1.0-b.3``.
- RC.n: Release candidate x, alternative to ``x.y-rc.n``.
  For example: ``v1.0-rc.2``.