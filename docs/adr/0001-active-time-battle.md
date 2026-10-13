# Active Time Battle instead of round-based turns

Battles use Final Fantasy-style Active Time Battle (ATB): each combatant's gauge fills in real time at a rate set by their Speed, and they act when it's full. We chose it for the Final Fantasy feel, over Dragon Quest-style rounds, which are simpler to build and fit touch input more naturally. To keep touch play forgiving, the slice runs in Wait mode (time stops while a Command menu is open).

## Consequences

- Battle logic advances by an explicit time step (`update(delta)`) and never reads a wall clock, so unit tests can drive it with synthetic time.
- Switching to rounds later would mean rewriting the Battle flow, not just tuning numbers.
