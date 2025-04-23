/**
 * Effect.java
 * by Yifei Bao (baoyifei@bu.edu), Tingxuan Tang (tttttx@bu.edu)
 * 11/5/2024
 * 
 * This interface defines the effect of behavior in the game.
 * It contains the effect method that applies the effect to the target.
 */

package interfaces;

import creature.Creature;

public interface Effect {
    public void effect(Creature target);
}
