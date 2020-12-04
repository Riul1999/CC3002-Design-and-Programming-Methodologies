ChangeLog
=========
Version 6.0
-----------
- (B.13) Se agrega el paramtro changues a la clase AbstractCharacter y se agrega el firePropertyChangue a los metodos recieveDamage y attack
- (B.12) Se crean las clases AliveHandler, TurnBeginHandler y TurnFinishHandler para hacerle saber al GameController cuando ocurren estas situaciones
- (B.11) Se transforman los metodos equipWeapon y charactersAttack a metodos estaticos pues no requieren de una instancia GameController ya que reciben los objetos
- (B.10) tambien se cambian los metodos de get...Info a solo get...  y se modifcan dichos metodos para que devuelvan un objeto de la clase ...
- (B.9) Se escriben las documentaciones de los nuevos metodos y se modifican los metodos equipWeapon y charactersAttack para que reciban personajes en vez de indices
- (B.8) Se implementa el metodo charactersAttack en GameController para que uno de los personajes del jugador ataque o sea atacado por un enemigo
- (B.7) Se implementa el metodo equipWeapon en GameController para equipar un arma del inventario a uno de los personajes del jugador
- (B.6) Se implementan los metodos getPlayerInfo, getEnemyInfo, getWeaponInfo en GameController para obtener las informacion de dichos objetos
- (B.5) Se corren los test y se logra 97% de lineas y 90% de branches
- (B.4) Se implementa metodo toString en los personajes y las armas
- (B.3) Se crean test para implementar la neuva funcionalidad toString de los peronsajes y las armas
- (B.2) En el constructor se incializan arreglos de personajes, enemigos y armas, por el momento todas por defecto
- (B.1) Se implementa la clase GameController que se encargara del manejo de un juego

Version 5.0
-----------
- (B.26) Se corren todos los test y se logra un 97% de lineas y 90% de branches (no se puede lograr 100% por las clases abstractas)
- (B.25) Se crean paquetes commonCharacter y magicCharacter en el paquete player para ordenar el proyecto
- (B.24) Creacion de las interfaces ICommonCharacter e IMagicCharacter que extienden IPlayerCharacter
- (B.23) Modificacion de la clase PlayerCharacter, se transforma en clase abstracta y se nombra AbstractPlayerCharacter
- (B.22) Cambio de AbstractWeapon por IWeapon en todo el proyecto, se revisan todas las clases
- (B.21) Creacion Interfaz IPlayerCharacter que extiende ICharacter (para no tener problemas de tipo)
- (B.20) Implementacion de checkeo de arma en el metodo checkConstruction
- (B.19) Se checkean todos los test de la clase PlayerCharacterTest
- (B.18) Se implementa en la clase PlayerCharacter la incializacion de equippedWeapon como una Hand
- (B.17) Se crea constructor que no recibe parametros, todas las Hands son iguales
- (B.16) Se crea la clase Hand, para darle esta arma a los PlayerCharacter al momento de crearlos (arma por defecto)
- (B.15) Se cambia los tipos de los parametros y metodos de la clase de int a Integer
- (B.14) Modificacion de la clase Weapon, se cambia a clase abstracta con nombre AbstractWeapon
- (B.13) Se Crea interfaz IWeapon para agrupar las Weapons, se enuncian los metodos de Weapon en ella
- (B.12) Se modifican metodos equals y hashCode en las subclases y se implementa herencia en los metodos 
- (B.11) Se modifican metodos equals y hashCode para tomar en cuenta la clase Weapon y el getClass
- (B.10) Se elimina parametro type y metodo getClass de Weapon
- (B.9) Refactor constructor Weapon para no requerir que se ingrese el parametro type
- (B.8) Se elimina enumeracion WeaponType
- (B.7) Se corren los test waiTurn y checkConstruction y salen aprobados
- (B.6) Se implementan los test aprovechando la herencia en dichas clases
- (B.5) Se hace que las clases EnemyTest y PlayerCharacterTest extiendan esta clase
- (B.4) Se implementan los metodos AbstractCharacterCheckConstruction, WaitTurn y BasicSetUp
- (B.3) Creacion clase AbstractCharacterTest para poder agrupar funcionalidades de los test
- (B.2) Modificacion de los metodos equals y hashCode para agregar CLASE.class y se ocupa herencia en el metodo
- (B.1) Eliminacion de enumeracion para los Character, eliminacion del metodo getClass y modificacion de los constructores de las clases

Version 4.0
-----------
- (RC.1) Nuevas funcionaliades implementadas y se asegura 100% de lineas y branches cubiertas
- (B.13) Se corren los test y se asegura el 100% de lineas y branches cubiertas
- (B.12) Se implementa la nueva funcionalidad de equipWeapon(), para hacerlo se agrega la branch a los metodos definidos en cada clase jugador, esto a ojos del programador queda mejor que renombrar los ya existentes y crear un metodo cobertor para implmentar la nueva funcionalidad
- (B.11) Testeo de agregar alive() como condicion para equip(), el metodo no debe hacer nada si alive() es false
- (B.10) Se corren los test y se asegura el 100% de lineas y branches cubiertas
- (B.9) Se implementa la nueva funcionalidad de attack, para hacerlo se decide modificar el metodo ya existe, esto porque solo se le agregara una branch, en vez renombrarlo y crear un nuevo metodo que implemente esto, que a ojos del programador quedaria peor
- (B.8) Testeo de agregar alive() como condicion para attack, el metodo no debe hacer nada si alive() es false
- (B.7) Se corren los test y se asegura el 100% de lineas y branches cubiertas
- (B.6) Se declara el metodo en la interfaz ICharacter y se implementa el metodo en la clase AbstractCharacter
- (B.5) Testo de nueva funcionalidad vivo(), que indice si el ICharacter sigue vivo, este test se hara tanto en PlayerCharacterTest como en EnemyTest
- (B.4) Se corren los test y se asegura el 100% de lineas y branches cubiertas
- (B.3) Se descubre una incongruencia entre el tipo de los parametros de los objetos y se normalizan todos los parametros numericos al tipo Integer
- (B.2) Se crea el metodo en la clase abstracta AbstractCharacter y se ve la necesidad de crear un metodo getDamage() para los playerCharacter
- (B.1) Testeo de nueva funcionalidad ataque, que recibe 2 AbstractCharacter y debe disminuir la vida del segundo, este se hace tanto en Player como Enemy Test, se asumira que solo un PlayerCharacter puede atacar a un Enemy y viceversa, no se pueden atacar entre ellos.

Version 3.0
-----------
- (RC.3) Nuevos parametros, metodos y testeo correctos (asegurado 100% de las lineas y branches cubiertos)
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

Version 6.0
-----------
- (B.1) Se crea la clase GameController que representa al controlador del juego, que lo maneja y manupula

Version 5.0
-----------
- (B.26) Se corren todos los test y se logra un 97% de lineas y 90% de branches (no se puede lograr 100% por las clases abstractas)
- (B.25) Se crean paquetes commonCharacter y magicCharacter en el paquete player para ordenar el proyecto
- (B.24) Creacion de las interfaces ICommonCharacter e IMagicCharacter que extienden IPlayerCharacter
- (B.23) Modificacion de la clase PlayerCharacter, se transforma en clase abstracta y se nombra AbstractPlayerCharacter
- (B.22) Cambio de AbstractWeapon por IWeapon en todo el proyecto, se revisan todas las clases
- (B.21) Creacion Interfaz IPlayerCharacter que extiende ICharacter (para no tener problemas de tipo)
- (B.20) Implementacion de checkeo de arma en el metodo checkConstruction
- (B.19) Se checkean todos los test de la clase PlayerCharacterTest
- (B.18) Se implementa en la clase PlayerCharacter la incializacion de equippedWeapon como una Hand
- (B.17) Se crea constructor que no recibe parametros, todas las Hands son iguales
- (B.16) Se crea la clase Hand, para darle esta arma a los PlayerCharacter al momento de crearlos (arma por defecto)
- (B.15) Se cambia los tipos de los parametros y metodos de la clase de int a Integer
- (B.14) Modificacion de la clase Weapon, se cambia a clase abstracta con nombre AbstractWeapon
- (B.13) Se Crea interfaz IWeapon para agrupar las Weapons, se enuncian los metodos de Weapon en ella
- (B.12) Se modifican metodos equals y hashCode en las subclases y se implementa herencia en los metodos 
- (B.11) Se modifican metodos equals y hashCode para tomar en cuenta la clase Weapon y el getClass
- (B.10) Se elimina parametro type y metodo getClass de Weapon
- (B.9) Refactor constructor Weapon para no requerir que se ingrese el parametro type
- (B.8) Se elimina enumeracion WeaponType
- (B.7) Se corren los test waiTurn y checkConstruction y salen aprobados
- (B.6) Se implementan los test aprovechando la herencia en dichas clases
- (B.5) Se hace que las clases EnemyTest y PlayerCharacterTest extiendan esta clase
- (B.4) Se implementan los metodos AbstractCharacterCheckConstruction, WaitTurn y BasicSetUp
- (B.3) Creacion clase AbstractCharacterTest para poder agrupar funcionalidades de los test
- (B.2) Modificacion de los metodos equals y hashCode para agregar CLASE.class y se ocupa herencia en el metodo
- (B.1) Eliminacion de enumeracion para los Character, eliminacion del metodo getClass y modificacion de los constructores de las clases

Version 4.0
-----------
- (RC.1) Nuevas funcionaliades implementadas y se asegura 100% de lineas y branches cubiertas
- (B.13) Se corren los test y se asegura el 100% de lineas y branches cubiertas
- (B.12) Se implementa la nueva funcionalidad de equipWeapon(), para hacerlo se agrega la branch a los metodos definidos en cada clase jugador, esto a ojos del programador queda mejor que renombrar los ya existentes y crear un metodo cobertor para implmentar la nueva funcionalidad
- (B.11) Testeo de agregar alive() como condicion para equip(), el metodo no debe hacer nada si alive() es false
- (B.10) Se corren los test y se asegura el 100% de lineas y branches cubiertas
- (B.9) Se implementa la nueva funcionalidad de attack, para hacerlo se decide modificar el metodo ya existe, esto porque solo se le agregara una branch, en vez renombrarlo y crear un nuevo metodo que implemente esto, que a ojos del programador quedaria peor
- (B.8) Testeo de agregar alive() como condicion para attack, el metodo no debe hacer nada si alive() es false
- (B.7) Se corren los test y se asegura el 100% de lineas y branches cubiertas
- (B.6) Se declara el metodo en la interfaz ICharacter y se implementa el metodo en la clase AbstractCharacter
- (B.5) Testo de nueva funcionalidad vivo(), que indice si el ICharacter sigue vivo, este test se hara tanto en PlayerCharacterTest como en EnemyTest
- (B.4) Se corren los test y se asegura el 100% de lineas y branches cubiertas
- (B.3) Se descubre una incongruencia entre el tipo de los parametros de los objetos y se normalizan todos los parametros numericos al tipo Integer
- (B.2) Se crea el metodo en la clase abstracta AbstractCharacter y se ve la necesidad de crear un metodo getDamage() para los playerCharacter
- (B.1) Testeo de nueva funcionalidad ataque, que recibe 2 AbstractCharacter y debe disminuir la vida del segundo, este se hace tanto en Player como Enemy Test, se asumira que solo un PlayerCharacter puede atacar a un Enemy y viceversa, no se pueden atacar entre ellos.

Version 3.0
-----------
- (RC.3) Nuevos parametros, metodos y testeo correctos (asegurado 100% de las lineas y branches cubiertos)
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