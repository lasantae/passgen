package com.lasantae;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.lasantae.gui.controllers.PassgenController;
import com.lasantae.gui.views.PassgenPanel;
import com.lasantae.views.tui.PassgenTUI;

public class Main {
    public static void main(String[] args) {
        /*
         *  TODO: if there's any system arguments, use the password generator's TUI. Use GUI otherwise.
         */

        if (args.length > 0) {
            PassgenTUI.launch(args);
            return;
        }

        PassgenPanel view = new PassgenPanel();
        PassgenController controller = new PassgenController(view);
        controller.show();
    }
}
