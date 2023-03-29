package com.lasantae.gui.controllers;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JPanel;

import com.lasantae.gui.views.PassgenPanel;
import com.lasantae.gui.views.PassphraseOptionsPanel;

import password.generator.data.Wordlist;
import password.generator.generators.PassphraseGenerator;
import password.generator.generators.PassphraseGenerator.Cases;
import password.generator.generators.PasswordGenerator;

public class PassgenController {
	private PassgenPanel view;
	
	private PassphraseGenerator passphraseGenerator;
	private final Wordlist WORDLIST = Wordlist.instantiate(new File("./resources/wordlists/eff_long_wordlist.txt"));
	
	private PasswordGenerator passwordGenerator;
	
	
	public PassgenController(PassgenPanel view) {
		super();
		this.view = view;
		this.passphraseGenerator = new PassphraseGenerator();
		this.passwordGenerator = new PasswordGenerator();
		
		view.addPassphrasePanelListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout) view.getPnlOptions().getLayout();
				JPanel panel = view.getPnlOptions();
				
				String PANEL_IDENTIFIER_IN_USE = "pnlPassphraseOptions";
				layout.show(panel, PANEL_IDENTIFIER_IN_USE);
				view.setPanelIdentifierInUse(PANEL_IDENTIFIER_IN_USE);
			}
		});
		
		view.addPasswordPanelListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout) view.getPnlOptions().getLayout();
				JPanel panel = view.getPnlOptions();
				
				String PANEL_IDENTIFIER_IN_USE = "pnlPasswordOptions";
				layout.show(panel, PANEL_IDENTIFIER_IN_USE);
				view.setPanelIdentifierInUse(PANEL_IDENTIFIER_IN_USE);
			}
		});
		
		view.addGenerateButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String PANEL_IDENTIFIER_IN_USE = view.getPanelIdentifierInUse();
				
				switch (PANEL_IDENTIFIER_IN_USE) {
					case "pnlPassphraseOptions" -> {
						PassphraseOptionsPanel panel = view.getPnlPassphraseOptions();
						int words = (int) panel.getSpinnerWordAmount().getValue(); 
						String delimiter = panel.getTextFieldDelimiter().getText();
					
						PassphraseGenerator.Cases c = Cases.TITLE_CASE;	
						if (panel.getRdbtnLowercase().isSelected()) c = Cases.LOWERCASE;
						else if (panel.getRdbtnUppercase().isSelected()) c = Cases.UPPERCASE;
						
						String passphrase = PassphraseGenerator.getPassphrase(WORDLIST, words, delimiter, c);
						view.setLblPassword(passphrase);
						
					}
					case "pnlPasswordOptions" -> {
					
					}
				}
				
			}
		});
	}
	
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view.getFrmPassgen().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
