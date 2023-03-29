package com.lasantae;

import com.lasantae.views.TUI;

public class Main {
    public static void main(String[] args) {
        /*
         *  TODO: if there's any system arguments, use the password generator's TUI. Use GUI otherwise.
         */

        if (args.length > 0) {
            TUI.launch(args);
            return;
        }


    }
}
