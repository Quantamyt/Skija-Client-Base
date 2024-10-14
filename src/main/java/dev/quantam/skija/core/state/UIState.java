package dev.quantam.skija.core.state;

import java.util.Stack;

/**
 * UIState is a utility class that manages OpenGL state preservation.
 * It allows saving and restoring of various OpenGL states to ensure
 * that rendering operations do not interfere with each other.
 *
 * @author quantamyt
 *
 * This code is released under the Creative Commons Attribution 4.0 International License (CC BY 4.0).
 * You are free to share and adapt this code, provided appropriate credit is given to the original author.
 * For more details, visit: <a href="https://creativecommons.org/licenses/by/4.0/deed.en">Creative Commons</a>
 */
public class UIState {

    // Stack to manage multiple UI states
    private static final Stack<State> stateStack = new Stack<>();

    /**
     * Backs up the current OpenGL state and pushes it onto the stack.
     */
    public static void backup() {
        State currentState = new State();
        currentState.backupCurrentState();
        stateStack.push(currentState);
    }

    /**
     * Restores the most recent OpenGL state from the stack.
     */
    public static void restore() {
        if (!stateStack.isEmpty()) {
            State previousState = stateStack.pop();
            previousState.restorePreviousState();
        }
    }
}
