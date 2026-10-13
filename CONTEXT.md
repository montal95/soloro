# Soloro

A 2D RPG in the Final Fantasy / Dragon Quest tradition: the player leads a Party across the Field and fights Enemies in Active Time Battles.

## Language

### Party

**Party**:
The group of characters the player controls. Always one Party, even when it has a single member.
_Avoid_: Team, group

**Party Member**:
One character in the Party.
_Avoid_: Hero, character, player, PC

### Exploration

**Field**:
The map the Party walks around on outside of Battle.
_Avoid_: Overworld, world map, level

**Encounter**:
The moment walking on the Field triggers a Battle at random, with no Enemy visible beforehand.
_Avoid_: Random battle, fight

**Encounter Tile**:
A Field tile where steps count toward the next Encounter. Steps on other tiles are safe.
_Avoid_: Danger zone, grass (as a game term)

**Encounter Table**:
A Field's weighted list of the Enemy Groups an Encounter there can start.
_Avoid_: Spawn table, monster list

**Healing Spring**:
A Field tile that restores the Party's HP when stepped on.
_Avoid_: Inn, save point, heal tile

### Battle

**Battle**:
A fight between the Party and Enemies. It ends in Victory, Defeat, or a successful Flee.
_Avoid_: Combat, fight, encounter

**Enemy**:
A hostile combatant the Party fights in Battle.
_Avoid_: Monster, mob, foe

**Enemy Group**:
The Enemies faced together in one Battle: one to three Enemies of a single type.
_Avoid_: Formation, party (for Enemies)

**Active Time Battle (ATB)**:
The Battle system in which each combatant's ATB Gauge fills in real time, and a combatant may act once its gauge is full.
_Avoid_: Turn-based, rounds

**ATB Gauge**:
A combatant's readiness meter. It fills at a rate set by Speed and empties after they act.
_Avoid_: Timer, turn meter

**Wait Mode**:
The ATB setting in which time stops while the player is choosing a Command.
_Avoid_: Pause

**Command**:
An action a Party Member is told to take when their ATB Gauge is full, such as Fight or Flee.
_Avoid_: Move, action, skill

**Knocked Out (KO)**:
The state of a Party Member at 0 HP. They can't act, but the state isn't permanent.
_Avoid_: Dead, fainted, fallen

**Felled**:
The state of an Enemy at 0 HP. It's removed from the Battle.
_Avoid_: Defeated (clashes with Defeat), slain, killed, dead

**Fight**:
The Command to attack an Enemy.
_Avoid_: Attack

**Flee**:
The Command to try to escape the Battle and return to the Field.
_Avoid_: Run, escape

**Victory**:
The end of a Battle when every Enemy in the Enemy Group is Felled. The Party returns to the Field.

**Defeat**:
The end of a Battle when every Party Member is Knocked Out. Leads to Game Over.

**Game Over**:
The screen shown after a Defeat. It returns the player to the Title.

### Stats

**HP**:
How much damage a combatant can take. At 0, a Party Member is Knocked Out.
_Avoid_: Health, hit points, life

**Attack**:
How hard a combatant hits with Fight.
_Avoid_: Strength, power

**Defense**:
How much a combatant reduces the damage they take.
_Avoid_: Armor, vitality

**Speed**:
How fast a combatant's ATB Gauge fills. It also affects the chance that a Flee succeeds.
_Avoid_: Agility, quickness

### Flow

**Title**:
The opening screen, where play starts.
_Avoid_: Main menu, start screen
