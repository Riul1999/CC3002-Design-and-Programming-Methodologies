package com.github.cc3002.finalreality.gui.handlers.AliveHandlers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class was created to group the AliveEnemyHandler and the AlivePlayerCharacterHandler because the
 * behavior of both handler is the same out of the class.
 *
 * @author Ignacio Slater Muñoz.
 * @author Rodrigo Urrea Loyola
 */
public abstract class AliveAbstractCharacterHandler implements PropertyChangeListener {

    @Override
    public abstract void propertyChange(PropertyChangeEvent evt);
}
